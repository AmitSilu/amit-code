
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;



@Service("empService")
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private IEmployeeDAO empDAO;

	@Override
	public String registerEmployee(Employee empl) throws Exception {
		double grossSalary=empl.getSalary()+empl.getSalary()*0.4;
		double netSalary=grossSalary-(grossSalary*0.2);
		
	    		// set finalamount to Model class object
		empl.setGrossSalary(grossSalary);
		empl.setNetSalary(netSalary);
		//use DAO
		int count=empDAO.insert(empl);
		return count==0?"Customer registration failed":"Employee Registered having Salary::"+empl.getSalary()+"Gross Salary::"+grossSalary+"Net Salary::"+netSalary;
	}

}
