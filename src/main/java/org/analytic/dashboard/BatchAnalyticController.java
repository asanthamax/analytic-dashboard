package org.analytic.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BatchAnalyticController {

	@RequestMapping(value="/batch_analytic",method=RequestMethod.GET)
	public String uploadCV()
	{
		return "batch_analytic";
	}
}
