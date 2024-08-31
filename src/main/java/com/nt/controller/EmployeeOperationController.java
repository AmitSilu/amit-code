package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;



@Controller("empController")
public class EmployeeOperationController {
	@Autowired
	private IEmployeeService  empService;
	
	public   String processCustomer(Employee empl)throws Exception{
		//use service
		String result=empService.registerEmployee(empl);
		
		return   result;
		
	}

}
