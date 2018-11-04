package com.services.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.services.model.Add;
import com.services.model.AddResponse;
import com.services.model.Calculator;
import com.services.model.EmployeeDtls;
import com.services.service.dao.EmployeeDetailsDAO;

@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
@Service("EmployeeDetailsService")
public class EmployeeDetailsService {

	@Autowired
	@Qualifier("EmployeeDetailsDAO")
	private EmployeeDetailsDAO employeeDetailsDAO;

	public EmployeeDtls getEmployeeDtls(String employeeId) throws Exception {
		System.out.println("Inside getEmployeeDtls ");
		EmployeeDtls employeeDtls = new EmployeeDtls();
		try {
			employeeDtls = employeeDetailsDAO.getEmployeeDtls(employeeId);
		} catch (Exception ex) {
			System.out.println("Exception occured::"+ex.getMessage());
			throw ex;
		}
		return employeeDtls;
	}

	public EmployeeDtls updateEmployeeDtls(String employeeId) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("Inside updateEmployeeDtls ");
		EmployeeDtls employeeDtls = new EmployeeDtls();
		try {
			employeeDtls = employeeDetailsDAO.updateEmployeeDtls(employeeId);
		} catch (Exception ex) {
			System.out.println("Exception occured::"+ex.getMessage());
			throw ex;
		}
		return employeeDtls;
	}
	
	public AddResponse addNumbers(int intA, int intB) {
		// TODO Auto-generated method stub
		Add add = new Add();
		add.setIntA(intA);
		add.setIntB(intB);
		Calculator cal = new Calculator();
		AddResponse addResponse =  cal.getCalculatorSoap().add(add);
		System.out.println(addResponse.getAddResult());
		return addResponse;
	}
}
