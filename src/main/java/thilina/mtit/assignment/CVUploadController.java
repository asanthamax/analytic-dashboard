package thilina.mtit.assignment;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CVUploadController {

	@RequestMapping(value="/uploadcv",method=RequestMethod.GET)
	public String uploadCV()
	{
		return "uploadcv";
	}
}
