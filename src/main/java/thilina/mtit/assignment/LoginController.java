package thilina.mtit.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import thilina.spring.service.UserSession;

@Controller
public class LoginController {

	@Autowired
	private UserSession user;
	
	@RequestMapping(value = "/changepassword" ,method=RequestMethod.GET)
	public String changePassword()
	{
		ModelAndView model = new ModelAndView();
		model.addObject("status",user.getMessage());
		return "resetpassword";
	}
	
	@RequestMapping(value = "/" ,method=RequestMethod.GET)
	public String login()
	{
		ModelAndView model = new ModelAndView();
		model.addObject("status",user.getMessage());
		return "login";
	}
	
	@RequestMapping(value="/signup",method=RequestMethod.GET)
	public String signup()
	{
		return "signup";
	}
}
