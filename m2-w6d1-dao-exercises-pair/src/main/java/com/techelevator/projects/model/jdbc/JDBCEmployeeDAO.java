package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlGetAllEmployees = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date" 
										 + " FROM employee";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetAllEmployees);
		while (result.next()){
			Employee employee = mapRowToEmployee(result);
			employees.add(employee);
		}
		return employees;
	}


	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlSearchEmployeesByName = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date" 
				 + " FROM employee WHERE first_name = ? AND last_name = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchEmployeesByName, firstNameSearch, lastNameSearch);
		while(results.next()){
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlGetEmployeesByDepartmentId = "SELECT employee_id, department_id, first_name, last_name, birth_date, gender, hire_date" 
				 + " FROM employee WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesByDepartmentId, id);
		while(results.next()){
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlGetEmployeesWithoutProjects = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, gender, hire_date" 
				 + " FROM employee LEFT JOIN project_employee ON project_employee.employee_id = employee.employee_id"
				 + " WHERE project_employee.employee_id IS NULL OR project_employee.project_id IS NULL";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesWithoutProjects);
		while(results.next()){
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		ArrayList<Employee> employees = new ArrayList<>();
		String sqlGetEmployeesBYProjectId = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, gender, hire_date" 
				 + " FROM employee JOIN project_employee ON project_employee.employee_id = employee.employee_id"
				 + " WHERE project_employee.project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesBYProjectId, projectId);
		while(results.next()){
			Employee employee = mapRowToEmployee(results);
			employees.add(employee);
		}
		return employees;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String sqlChangeEmployeeDepartment = "UPDATE employee " +
										     "SET department_id = ? " +
											 "WHERE employee_id = ?";
		jdbcTemplate.update(sqlChangeEmployeeDepartment, departmentId, employeeId );
		
	}
	
	private Employee mapRowToEmployee(SqlRowSet result) {
		Employee employee = new Employee();
		employee.setId(result.getLong("employee_id"));
		employee.setDepartmentId(result.getLong("department_id"));
		employee.setFirstName(result.getString("first_name"));
		employee.setLastName(result.getString("last_name"));
		employee.setBirthDay(result.getDate("birth_date").toLocalDate());
		employee.setGender(result.getString("gender").charAt(0));
		employee.setHireDate(result.getDate("hire_date").toLocalDate());
		
				
		return employee;
	}

}
