package org.analytic.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChangePasswordController {

    @RequestMapping(value = "/graphical", method = RequestMethod.GET)
    public String changePassword() {

        return "resetpassword";
    }
}
