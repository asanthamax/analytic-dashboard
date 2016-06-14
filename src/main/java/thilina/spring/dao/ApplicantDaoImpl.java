package thilina.spring.dao;

import java.net.StandardProtocolFamily;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;


import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import thilina.spring.bean.Applicant;
import thilina.spring.service.UserSession;

public class ApplicantDaoImpl implements ApplicantDao{

	private static final String COLLECTION = "Applicant";
	private static Log logger = LogFactory.getLog(ApplicantDaoImpl.class);
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	UserSession userSession;
	@Override
	public void create(Applicant applicant) throws NullPointerException {
		
		if(applicant != null)
		{
			this.mongoTemplate.insert(applicant, COLLECTION);
			logger.info("Applicant Details inserted successfully");
		}
		else{
			logger.error("Error : applicant cannot be null");
			throw new NullPointerException("Applicant details cannot be empty");
		}
	}

	@Override
	public void update(Applicant applicant) throws NullPointerException{
		// TODO Auto-generated method stub
		if(applicant != null)
		{
			this.mongoTemplate.save(applicant, COLLECTION);
		}
		else{
			throw new NullPointerException("Applicant details updated successfully");
		}
	}

	@Override
	public boolean deleteById(String Id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Applicant findById(String Id) throws NullPointerException{
		// TODO Auto-generated method stub
		Applicant applicant = this.mongoTemplate.findById(Id,Applicant.class);
		if(applicant!=null)
		{
			logger.info("Applicant found!!!");
		}
		else{
			logger.error("Invalid Applicant found nothing!!!");
			throw new NullPointerException("No Applicant found");
		}
		return applicant;
	}

	@Override
	public List<Applicant> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean logAuthenticate(String userName, String Password) {
		// TODO Auto-generated method stub
		BasicDBObject query = new BasicDBObject();
		query.put("username", userName);
		query.put("password", Password);
		DBCollection collection=this.mongoTemplate.getCollection(COLLECTION);
		DBCursor cursor = collection.find(query);
		if(cursor != null)
		{
			while(cursor.hasNext())
			{
				userSession.setUserID(cursor.next().get("userId").toString());
				userSession.setUserName(cursor.next().get("username").toString());
			}
			return true;
		}
		else{
			userSession.setMessage("Invaild User Name or Password!!!");
			return false;
		}
	}

	

}
