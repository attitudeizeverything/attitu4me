package com.yoho.controller;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yoho.request.Employees;

@RestController
public class Controller {
	private static final Logger logger = Logger.getLogger(Controller.class);

	
	@RequestMapping(value="/",method=RequestMethod.POST,headers="Accept=application/json")
    public String saveEmployee(@RequestBody Employees employee) {
        logger.info("Saving the Employee. Data : "+employee);
        if(employee.getId() == 0){ // if employee id is 0 then creating the employee other updating the employee
           System.out.println(employee.getAge());
        	// employeeService.createEmployee(employee);
        } else {
            //employeeService.updateEmployee(employee);
        }
        return "success";
        //return new ModelAndView("redirect:getAllEmployees");
    }
}
