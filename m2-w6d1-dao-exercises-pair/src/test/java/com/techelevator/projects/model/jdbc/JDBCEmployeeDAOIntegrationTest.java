package com.techelevator.projects.model.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Employee;

import org.junit.Assert;

public class JDBCEmployeeDAOIntegrationTest {
	private static SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO dao;
	private JdbcTemplate jdbctemplate;

	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	@Before
	public void setup() {
		String sqlInsertProject = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) " +
									"VALUES (13, 3, 'Quinn', 'Collins', '1992-11-28', 'M', '2017-05-08')";
		jdbctemplate = new JdbcTemplate(dataSource);
		jdbctemplate.update(sqlInsertProject);
		String sqlInsertProject2 = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) " +
				"VALUES (14, 3, 'Robert', 'Sattelly', '1988-08-12', 'M', '2017-05-08')";
		jdbctemplate.update(sqlInsertProject2);
		dao = new JDBCEmployeeDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void can_get_all_employees() {
		String sqlGetAllEmployee = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date " +
									"FROM employee";
		int x = jdbctemplate.queryForList(sqlGetAllEmployee).size();
		Assert.assertEquals(x, dao.getAllEmployees().size());
	}
	
	@Test
	public void can_search_employees_by_name() {
		List<Employee> employees = new ArrayList<>();
		String resultsName = "";
		String searchName = "";
		String sqlSearchEmployeesByName = "SELECT department_id, first_name, last_name, birth_date, gender, hire_date" 
				 + " FROM employee WHERE first_name = 'Quinn' AND last_name = 'Collins'";
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlSearchEmployeesByName);
		while(results.next()) {
			resultsName = results.getString("first_name");
		}
		employees = dao.searchEmployeesByName("Quinn", "Collins");
		for(Employee employee : employees) {
			searchName = employee.getFirstName();
		}
		Assert.assertEquals(resultsName, searchName);
		
	}
	
	@Test
	public void can_get_employees_by_department_id() {
		List<Employee> employees = new ArrayList<>();
		String resultsName = "";
		String searchName = "";
		String sqlGetEmployeesByDepartmentId = "SELECT department_id, first_name, last_name, birth_date, gender, hire_date" 
				 + " FROM employee WHERE department_id = '3'";
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlGetEmployeesByDepartmentId);
		while(results.next()) {
			if(results.getString("first_name").equals("Quinn")) {
				resultsName = results.getString("first_name");
			}
		}
		employees = dao.getEmployeesByDepartmentId(3);
		for(Employee employee : employees) {
			if(employee.getFirstName().equals("Quinn")) {
				searchName = employee.getFirstName();
			}
		}
		Assert.assertEquals(searchName, resultsName);
	}
	
	@Test
	public void can_get_employees_without_projects() {
		List<Employee> employees = new ArrayList<>();
		String resultsName = "";
		String searchName = "";
	String sqlGetEmployeesWithoutProjects = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, gender, hire_date" 
			 + " FROM employee LEFT JOIN project_employee ON project_employee.employee_id = employee.employee_id"
			 + " WHERE project_employee.employee_id IS NULL OR project_employee.project_id IS NULL";
	SqlRowSet results = jdbctemplate.queryForRowSet(sqlGetEmployeesWithoutProjects);
	while(results.next()) {
		if(results.getString("first_name").equals("Quinn")) {
			resultsName = results.getString("first_name");
		}
	}
	employees = dao.getEmployeesWithoutProjects();
	for(Employee employee : employees) {
		if(employee.getFirstName().equals("Quinn")) {
			searchName = employee.getFirstName();
		}
	}
	
	Assert.assertEquals(resultsName, searchName);
	}
	
	
	
	
	
	
	
	
	
	
	
}