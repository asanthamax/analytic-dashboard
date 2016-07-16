package org.spring.dao;

import com.mongodb.DBCollection;
import com.mongodb.MongoException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.util.List;
import java.util.Map;

/**
 * Created by asantha on 6/15/16.
 */
@Configurable
@Repository
public class UsersDaoImpl implements UsersDao {

    Log log = LogFactory.getLog(UsersDaoImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    private static String COLLECTION = "Users";

    @Override
    public void addUser(Users user) {

        try{

            if(!mongoTemplate.collectionExists(COLLECTION)){

                mongoTemplate.createCollection(COLLECTION);
            }
            mongoTemplate.insert(user,COLLECTION);

        }catch(MongoException e){

            log.error("Error in MongoDB :"+e.getMessage());

        }catch(Exception e){

            log.error("Error!"+e.getMessage());
        }
    }

    @Override
    public List<Users> listUsers(Map<String, Object> map) {
        return null;
    }

    @Override
    public Users getUser(Map<String, Object> map) {
        return null;
    }

    @Override
    public void updateUser(Users user) {

    }

    @Override
    public void deleteUser(Users user) {

    }
}
