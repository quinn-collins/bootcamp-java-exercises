package com.techelevator.projects.model.jdbc;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

;

public class JDBCProjectDAOIntegrationTest {
	private static final String TEST_PROJECT = "PeaceMaker";
	private static SingleConnectionDataSource dataSource;
	private JDBCProjectDAO dao;
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
		String sqlInsertProject = "INSERT INTO project (project_id, name, from_date, to_date) " +
									"VALUES (7, ?, '2007-12-31', '2018-6-15')";
		jdbctemplate = new JdbcTemplate(dataSource);
		jdbctemplate.update(sqlInsertProject, TEST_PROJECT);
		dao = new JDBCProjectDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@Test
	public void returns_all_active_projects() {
		//Arrange
		boolean projectExists = false;
		//Act
		for(Project project : dao.getAllActiveProjects()) {
			String test = project.getName();
			if(test.equals("PeaceMaker")) {
				projectExists = true;
			}
		}
		//Assert
		Assert.assertTrue(projectExists);
		
	}
	
	@Test
	public void we_can_remove_employee_from_project() {
		String sqlInsertProject = "SELECT project_id, employee_id FROM project_employee";
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlInsertProject);
		results.next();
		long employeeId = results.getLong("employee_id");
		long projectId = results.getLong("project_id");
		dao.removeEmployeeFromProject(projectId, employeeId);
		String sqlInsertProject2 = "SELECT project_id, employee_id FROM project_employee WHERE project_id = ? AND employee_id = ?";
		SqlRowSet results2 = jdbctemplate.queryForRowSet(sqlInsertProject2, projectId, employeeId);
		Assert.assertFalse(results2.next());
		
	}
	
	@Test
	public void we_can_add_employee_to_project() {
		dao.addEmployeeToProject(5L, 1L);
		String sqlInsertProject = "SELECT project_id, employee_id FROM project_employee WHERE project_id = 5 AND employee_id = 1";
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlInsertProject);
		Assert.assertTrue(results.next());
		
	}

	
}
