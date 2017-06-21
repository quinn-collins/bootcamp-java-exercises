package com.techelevator.model;

import java.time.LocalDate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCReservationDAO extends ReservationDAO {
	private JdbcTemplate jdbctemplate;
	
	public JDBCReservationDAO(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	


@Override
public void setReservation() {
	// TODO Auto-generated method stub
	
}

public int getConfirmationId(int siteChoiceInt, String reservationName, LocalDate arrivalChoiceDate, LocalDate departureChoiceDate) {
	String sqlInsertNewReservation = "INSERT INTO reservation (site_id, name, from_date, to_date) VALUES (?, ?, ?, ?)";
	jdbctemplate.update(sqlInsertNewReservation, siteChoiceInt, reservationName, arrivalChoiceDate , departureChoiceDate);
	
	String sqlGetLastReservation = "SELECT reservation_id, site_id, name, from_date, to_date, create_date FROM reservation WHERE name = ? ORDER By create_date";
	SqlRowSet results = jdbctemplate.queryForRowSet(sqlGetLastReservation, reservationName);
	results.next();
	int confirmationId = results.getInt("reservation_id");
	return confirmationId;
}

private Reservation mapToGetReservation(SqlRowSet results) {
	Reservation theReservation = new Reservation();
	theReservation.setReservation_id(results.getLong("reservation_id"));
	theReservation.setSite_id(results.getLong("site_id"));
	theReservation.setName(results.getString("name"));
	theReservation.setFrom_date(results.getDate("from_date").toLocalDate());
	theReservation.setTo_date(results.getDate("to_date").toLocalDate());
	theReservation.setCreate_date(results.getDate("create_date").toLocalDate());
	return theReservation;
}

}
