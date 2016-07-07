package org.csv.bulkimport;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Upload CSV to MongoDB.
 */
public class CSVStore {

    private CSVIterator iterator;
    private Mongo m;
    private DB db;
    private DBCollection coll;
    private String fileName;
    public CSVStore(String filename) throws IOException {
        this.iterator = new CSVIterator(filename);
        setDatabaseParameters();
        this.fileName = filename;
    }

    public void setDatabaseParameters() {
        try {
            this.m = new Mongo( "localhost" , 27017 );
        }
        catch (UnknownHostException e) {
            System.out.println("Could not connect to localhost");
            System.exit(1);
        }
        this.db = m.getDB("analytic_db");
        this.coll = db.getCollection("frauddata");
    }

    public void insertObjects(Map<String,ArrayList<String>> collectionGroupings) throws IOException {
        HashMap<String,Integer> mappings = this.getHeaderMappings();
        Double numVal;
        String strVal;

        while (iterator.hasNext()) {
            String[] record = iterator.next();
            BasicDBObject doc = new BasicDBObject();
            for (String key : collectionGroupings.keySet()) {
                ArrayList<String> fieldSet = collectionGroupings.get( key );
                if (fieldSet.size() == 1) {
                    int field = mappings.get(fieldSet.get(0));
                    if (field >= record.length) {
                        System.out.println("Encountered blank line in file on line: " + this.iterator.getLineNumber());
                        strVal = " ";
                    } else {
                        strVal = record[field].trim();
                    }
                    try {
                        numVal = Double.parseDouble(strVal);
                        doc.put(fieldSet.get(0).replace(" ","-"), numVal);
                    }  catch (NumberFormatException nfe) {
                        doc.put(fieldSet.get(0).replace(" ","-"), strVal);
                    }
                } else {
                    // Insert each sub document based on grouping
                    BasicDBObject subDoc = new BasicDBObject();
                    for (int i = 0; i < fieldSet.size(); i++) {
                        int field = mappings.get(fieldSet.get(i));
                        if (field >= record.length) {
                            System.out.println("Encountered blank line in file: " + this.iterator.getLineNumber());
                            strVal = " ";
                        } else {
                            strVal = record[field].trim();
                        }
                        try {
                            numVal = Double.parseDouble(strVal);
                            subDoc.put(fieldSet.get(i).replace(" ","-"), numVal);
                        }  catch (NumberFormatException nfe) {
                            subDoc.put(fieldSet.get(i).replace(" ","-"), strVal);
                        }
                    }
                    doc.put(key, subDoc);
                }
            }
            doc.put("fileName",fileName);
            coll.insert(doc);
        }
        this.iterator.close();
    }

    public Map<String,ArrayList<String>> determineGrouping() {
        String[] fields = iterator.getFields();
    	/* For starters, we'll check for commonalities in field names and
    	 * use that as an aggregation basis. Naive, but serves the purpose.
    	 */
        Map<String,Integer> allWords = new HashMap<String,Integer>();
        Map<Integer,String> mappings = new HashMap<Integer,String>();

        // Fill word map
        for (String s : fields) {
            for (String n : s.split(" ")) {
                if (!n.isEmpty()) {
                    if (allWords.get(n) != null) {
                        int cur = allWords.get(n);
                        allWords.put(n, cur+1);
                    } else {
                        allWords.put(n, 1);
                    }
                }
            }
        }

        int index = 0;
        int mapIndex = 0;
        int size = fields.length;
        String curWord = "";

        // Perform grouping
        while (index < size) {
            String curStr[] = fields[index].split(" ");
            int len = curStr.length;
            int i = 0;
            while (i < len) {
                if (allWords.get(curStr[i]) != null) {
                    mappings.put(index, curStr[i]);
                }
                i += 1;
            }
            index += 1;
        }

        // Create grouping echelon
        Map<String,ArrayList<String>> retMap = new HashMap<String,ArrayList<String>>();
        for (int i = 0; i < size; i++) {
            if (!retMap.containsKey(mappings.get(i))) {
                retMap.put(mappings.get(i).trim(), new ArrayList<String> ());
            }
            retMap.get(mappings.get(i).trim()).add(fields[i].trim());
        }
        return retMap;
    }

    private HashMap<String,Integer> getHeaderMappings() {
        HashMap<String,Integer> mapping = new HashMap<String,Integer> ();
        String [] fields = iterator.getFields();
        for (int i = 0; i < fields.length; i++) {
            mapping.put(fields[i].trim(), i);
        }
        return mapping;
    }

}
