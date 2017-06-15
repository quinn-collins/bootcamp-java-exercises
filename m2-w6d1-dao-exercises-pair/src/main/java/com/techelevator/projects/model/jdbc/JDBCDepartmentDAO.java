package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;
import com.techelevator.projects.model.Project;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		ArrayList<Department> departments = new ArrayList<>();
		String sqlGetAllDepartments = "SELECT name, department_id FROM department";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllDepartments);
		while (results.next()){
			Department theDepartment = mapRowToDepartment(results);
			departments.add(theDepartment);
		}
		return departments;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		ArrayList<Department> departments = new ArrayList<>();
		String sqlSearchAllDepartmentsByName = "SELECT department_id, name FROM department WHERE name = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchAllDepartmentsByName, nameSearch);
		while (results.next()){
			Department theDepartment = mapRowToDepartment(results);
			departments.add(theDepartment);
		}
		return departments;
	}

	@Override
	public void updateDepartmentName(Long departmentId, String departmentName) {
		String sqlUpdateDepartmentName = "UPDATE Department SET ? WHERE ?";
		jdbcTemplate.update(sqlUpdateDepartmentName, departmentName, departmentId);
	}

	@Override
	public Department createDepartment(String departmentName) {
		Department theDept = new Department();
		String sqlCreateDeparment = "INSERT INTO department (department_id, name) VALUES (?,?)";
		jdbcTemplate.update(sqlCreateDeparment, theDept.getId(), departmentName);
		theDept.setId(getNextDepartmentId());
	    return theDept;
	}

	private Long getNextDepartmentId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new department id");
		}
	}

	@Override
	public Department getDepartmentById(Long id) {
		Department department = new Department();
		String sqlGetDepartmentbyID = "SELECT department_id, name FROM department WHERE department_id = ?";
		SqlRowSet departmentName = jdbcTemplate.queryForRowSet(sqlGetDepartmentbyID, id);
		if(departmentName.next()) {
			department = mapRowToDepartment(departmentName);
		}
		return department;
		
	}
	
	private Department mapRowToDepartment(SqlRowSet results) {
		Department theDepartment = new Department();
		theDepartment.setId(results.getLong("department_id"));
		theDepartment.setName(results.getString("name"));
		return theDepartment;
	}

}
