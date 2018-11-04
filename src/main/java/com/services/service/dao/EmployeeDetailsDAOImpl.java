package com.services.service.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.client.MongoCollection;
import com.services.model.EmployeeDtls;
import com.services.repositories.EmployeeDetailsRepository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;

@Repository("EmployeeDetailsDAO")
public class EmployeeDetailsDAOImpl implements EmployeeDetailsDAO {

	/*@Autowired
	MongoTemplate mongoTemplate;*/
	@Autowired
	MongoOperations mongoOperations;

	public EmployeeDtls getEmployeeDtls(String employeeId) throws Exception {
		// TODO Auto-generated method stub
		EmployeeDtls employeeDtls1 = new EmployeeDtls();
		List<EmployeeDtls> employeeDtlsList = null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("employeeNm").is("Test"+employeeId));
			//employeeDtls1 = mongoTemplate.findOne(query, EmployeeDtls.class);
			employeeDtlsList = mongoOperations.find(query, EmployeeDtls.class);
			System.out.println(mongoOperations.getCollectionNames());
			System.out.println("employeeDtlsList::::"+employeeDtlsList.get(0));
			//System.out.println(employeeDtls1.getEmployeeId());
		} catch (Exception ex) {
			throw ex;
		}
		return employeeDtlsList.get(0);
	}

	@Override
	public EmployeeDtls updateEmployeeDtls(String employeeId) throws Exception {
		// TODO Auto-generated method stub
		EmployeeDtls employeeDtls = new EmployeeDtls();
		List<EmployeeDtls> employeeDtlsList = null;
		try {
			employeeDtls.setEmployeeId(employeeId);
			employeeDtls.setEmployeeNm("Test"+employeeId);
			employeeDtls.setLocation("Chicago");
			employeeDtls.setMailAddress(employeeId+"@"+"test.com");
			mongoOperations.save(employeeDtls);
			Query query = new Query();
			query.addCriteria(Criteria.where("employeeNm").is("Test"+employeeId));
			//employeeDtls = mongoTemplate.findOne(query, EmployeeDtls.class);
			employeeDtlsList = mongoOperations.find(query, EmployeeDtls.class);
			System.out.println(mongoOperations.getCollectionNames());
			//System.out.println(employeeDtls.getEmployeeId());
		} catch (Exception ex) {
			throw ex;
		}
		return employeeDtlsList.get(0);
	}
}
