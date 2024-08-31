
//CustomerDAOImpl.java(DAO Impl class)
package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String  EMPLOYEE_INFO_INSERT_QUERY="INSERT INTO SPRING_EMPLOYEE_INFO VALUES(CNO_SEQ1.NEXTVAL,?,?,?,?,?)";
	@Autowired
	private  DataSource ds;

	@Override
	public int insert(Employee emp) throws Exception{
		int count=0;
		try(Connection con=ds.getConnection();
			  PreparedStatement ps=con.prepareStatement(EMPLOYEE_INFO_INSERT_QUERY);	
				){
			//set values to query params
			ps.setString(1, emp.getEName());
			ps.setString(2, emp.getDesg());
			ps.setDouble(3, emp.getSalary());
			ps.setDouble(4, emp.getGrossSalary());
			ps.setDouble(5, emp.getNetSalary());
			//execute the SQL Query
			count=ps.executeUpdate();
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			throw se;  //exception rethrowing for exception propagation
			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e; //exception rethrowing for exception propagation
			
		}
		
		return count;
	}//method

}//class

