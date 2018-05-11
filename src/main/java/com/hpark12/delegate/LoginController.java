package com.hpark12.delegate;

import com.hpark12.reimbursementModel.User;
import com.hpark12.reimbursementService.ReimbursementService;
import com.hpark12.util.logUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController {
    public static String login(HttpServletRequest req) {

        logUtil.log.info("inside logincontroller");
        if (req.getMethod().equals("GET")) {
            return "welcome.html";
        }

        String userEmail = req.getParameter("inputEmail");
        String userPassword = req.getParameter("inputPassword");

        User user = ReimbursementService.loginUser(userEmail, userPassword);
        logUtil.log.info(user);

        if (user == null) {
            return "welcome.html";
        } else {

        }  //Session management
        req.getSession().setAttribute("currentUser", user);
        return "home.do";
    }

    public static String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("currentUser");
        response.sendRedirect(request.getContextPath() + "html/welcome.html");
        return null;
    }
}