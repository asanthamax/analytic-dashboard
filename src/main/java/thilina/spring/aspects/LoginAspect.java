package thilina.spring.aspects;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import thilina.mtit.assignment.HomeController;
import thilina.mtit.assignment.LoginController;
import thilina.spring.service.UserSession;

@Aspect
public class LoginAspect {

	MongoTemplate mongoTemplate;
	private static Log log = LogFactory.getLog(LoginAspect.class);
	@Autowired
	private UserSession user;
	
	@After("execution(* thilina.spring.dao.ApplicantDao.logAuthenticate(..)) && args(userName,password)")
	public void beforeLog(JoinPoint joinPoint,String userName,String password)
	{
		if(joinPoint.toString()=="true")
		{
			try {
				BasicDBObject query = new BasicDBObject();
				String lastUpdated="";
				query.put("username", userName);
				query.put("password", password);
				DBCollection collection = mongoTemplate.getCollection("Applicant");
				DBCursor cursor = collection.find(query);
				while(cursor.hasNext())
				{
					lastUpdated = cursor.next().get("lastupdate").toString(); 
				}
				DateFormat df = new SimpleDateFormat("Y-m-d");
				Date lastRenewDate = df.parse(lastUpdated);
				Date currentDate = df.parse(df.format(new Date()));
				Period period = new Period(lastRenewDate.getTime(),currentDate.getTime());
				int days = period.getDays();
				if(days > 15)
				{
					LoginController login = new LoginController();
					user.setMessage("Your Password Expired please renew it!!!");
					login.changePassword();
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				log.error("Date Parse Error :"+e.getMessage());
			}
		}
	}
	
	@Before("execution(* thilina.spring.dao.ApplicantDao.logAuthenticate(..))")
	public void beforeAuthenticate(JoinPoint joinPoint)
	{
		String userID = user.getUserID();
		if(userID!="")
		{
			HomeController controller = new HomeController();
			controller.home();
		}
	}
	
	@Before("execution(* thilina.mtit.assignment.*.*(..))")
	public void beforeRedirect(JoinPoint joinPoint)
	{
		if(user.getUserID()=="")
		{
			HomeController controller =new HomeController();
			controller.home();
		}
	}
	

}
