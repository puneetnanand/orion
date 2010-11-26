package orion.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import orion.core.models.util.HibernateUtil;

import java.io.IOException;
import java.util.Date;

public class UserRegistrationController{

    protected final Log logger = LogFactory.getLog(getClass());

    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        logger.info(this.getClass() + " - handleRequest()");
        
        try {
        	
    		HibernateUtil.getSessionFactory();
	    	if (request.getParameter("action").equals("showForm") & request.getMethod().equals("GET")) {
	            return new ModelAndView("new-user-registeration.jsp");
	    	}
	    	else if (request.getParameter("action").equals("submitForm") & request.getMethod().equals("POST")) {
	    		logger.info("User registration request received with the following parameters: " + request.getParameter("user"));
	            return new ModelAndView("new-user-registeration.jsp");
	    	}
	    	else {
	            return new ModelAndView("invalid-page.jsp");  		
	    	}
	    	
        } catch (NullPointerException nPE) {
        	logger.warn("Null pointer exception occured in " + this.getClass() + ". Action might be not set. Returning invalid page", nPE);
            return new ModelAndView("invalid-page.jsp");
        }
    	
    }

}