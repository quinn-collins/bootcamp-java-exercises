package com.techelevator.projects.model.jdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JDBCDepartmentDAOIntegrationTest {
	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO dao;
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
		String sqlInsertDepartment = "INSERT INTO department (department_id, name) " 
									+ "VALUES (5, 'Department Of Spring')";
		jdbctemplate = new JdbcTemplate(dataSource);
		jdbctemplate.update(sqlInsertDepartment);
		dao = new JDBCDepartmentDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void can_get_all_departments() {
		List<Department> departments = new ArrayList<>();
		boolean foundDepartment = false;
		departments = dao.getAllDepartments();
		for(Department department : departments) {
			if(department.getName().equals("Department Of Spring")) {
				foundDepartment = true;
			}
		}
		Assert.assertTrue(foundDepartment);
	}
	
	@Test
	public void can_search_departments_by_name() {
		List<Department> departments = new ArrayList<>();
		boolean foundDepartment = false;
		departments = dao.searchDepartmentsByName("Department Of Spring");
		for(Department department : departments) {
			if(department.getName().equals("Department Of Spring")) {
				foundDepartment = true;
			}
			else {
				
			}
		}
		Assert.assertTrue(foundDepartment);
		Assert.assertNotNull(foundDepartment);
	}
	
	@Test
	public void can_update_department_name() {
		
		dao.updateDepartmentName(5L, "Department");
		String sqlFindDepartmentName = "SELECT department_id, name FROM department WHERE department_id = 5";
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlFindDepartmentName);
		results.next();
		Assert.assertEquals("Department", results.getString("name"));
	}
	
	
	
	
	
	
}
