package com.techelevator.projects.model.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;


import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {
		ArrayList<Project> projects = new ArrayList<>();
		String sqlGetAllActiveProjects = "Select project_id, name, to_date, from_date FROM project WHERE end_date IS NULL OR end_date > 2017-06-13";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllActiveProjects);
		while(results.next()){
			Project theProject = mapRowToProject(results);
			projects.add(theProject);
		}
		return projects;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sqlRemoveEmployeeFromProject = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";
		jdbcTemplate.update(sqlRemoveEmployeeFromProject, projectId, employeeId);
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sqlAddEmployeeFromProject = "INSERT INTO project_employee (projectId , employeeId) VALUES (?,?)";
		jdbcTemplate.update(sqlAddEmployeeFromProject, projectId, employeeId);
	}
	private Project mapRowToProject(SqlRowSet results) {
		Project theProject = new Project();
		theProject.setId(results.getLong("id"));
		theProject.setName(results.getString("name"));
		theProject.setStartDate(results.getDate("startDate").toLocalDate());
		theProject.setEndDate(results.getDate("startDate").toLocalDate());
		return theProject;
	}

}
