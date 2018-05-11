package com.hpark12.ajax;

import com.hpark12.delegate.LoginController;
import com.hpark12.util.logUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/* Request helper specifically for AJAX requests */
class AjaxRequestHelper {

    static String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logUtil.log.info("Im in AjaxHelper");

        switch (request.getRequestURI()) {
            case "/Expense_Reimbursement_System/html/insertRequest.ajax":
                return AjaxMethods.insertRequest(request, response);

            case "/Expense_Reimbursement_System/html/viewPending.ajax":
                return AjaxMethods.viewPending(request);

            case "/Expense_Reimbursement_System/html/viewApproved.ajax":
                return AjaxMethods.viewApproved(request);

            case "/Expense_Reimbursement_System/html/approveRequest.ajax":
                return AjaxMethods.approveRequest(request);

            case "/Expense_Reimbursement_System/html/viewAllPending.ajax":
                return AjaxMethods.viewAllPending(request);

            case "/Expense_Reimbursement_System/html/viewAllApproved.ajax":
                return AjaxMethods.viewAllApproved(request);

            case "/Expense_Reimbursement_System/html/viewAllEmployees.ajax":
                return AjaxMethods.viewAll();

            case "com.hpark12.delegate.LoginController":
                return LoginController.logout(request, response);

            default:
                return "/html/404.html";
        }
    }
}
//            case "/gothamReimbursement/html/logout.ajax":
//                    return LoginController.logout(request);