package com.services.service.dao;

import com.services.model.EmployeeDtls;

public interface EmployeeDetailsDAO {

	public EmployeeDtls getEmployeeDtls(String employeeId) throws Exception;

	public EmployeeDtls updateEmployeeDtls(String employeeId) throws Exception;

}
