
//RealtimeDITest.java
package com.nt.test;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.EmployeeOperationController;
import com.nt.model.Employee;



public class EmployeeRegistrationTest {

	public static void main(String[] args) {
		//read input values from enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter  Employee name::");
		String name=sc.next();
		System.out.println("Enter Employee  desg::");
		String  desg=sc.next();
		System.out.println("Enter Employee salary::");
		double sal=sc.nextDouble();
		
		
		//create Employee class object
		Employee emp=new Employee();
		emp.setEName(name); emp.setDesg(desg);
		emp.setSalary(sal);
		
		
		//create IOC container
		ClassPathXmlApplicationContext ctx=
				new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		
		//get Cotroller class object from  the IOC container  (dependency lookup)
		EmployeeOperationController controller=
				  ctx.getBean("empController",EmployeeOperationController.class);
		
		//invoke the b.method
		try {
			String resultMsg=controller.processCustomer(emp);
			System.out.println(resultMsg);
		}//try
		catch(SQLException se) {
			if(se.getErrorCode()==12899)  //SQLError code
			    System.out.println("Problem with colum size");
			else {
				System.out.println("One or another Db problem");
			}
		}
		catch(Exception e) {
			System.out.println("non Db problem");
		}
		
		//close the IOC container
		  ctx.close();
		

	}//main

}//class

