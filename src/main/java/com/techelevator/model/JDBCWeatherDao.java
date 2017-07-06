package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.Weather;



public class JDBCWeatherDao implements WeatherDao {
	
	

		private JdbcTemplate jdbcTemplate;
		
		public JDBCWeatherDao(DataSource dataSource){
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}

		@Override
		public List<Weather> getAllWeather() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Weather> getWeatherByParkCode(String parkCode) {
			List<Weather> weatherByParkCode = new ArrayList<Weather>();
			String sqlGetWeatherByParkCode = "SELECT * FROM Weather JOIN park ON park.parkCode = weather.parkCode WHERE park.parkCode = ? ORDER BY park.parkName";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetWeatherByParkCode, parkCode);
			while(results.next()){
				Weather weather = mapRowToWeather(results);
				weatherByParkCode.add(weather);
			}
				
			return weatherByParkCode;
		}
		
		private Weather mapRowToWeather(SqlRowSet results){
			Weather weather;
			weather = new Weather();
			weather.setParkCode(results.getString("parkCode"));
			weather.setFiveDayForecastValue(results.getInt("fiveDayForecastValue"));
			weather.setLow(results.getInt("low"));
			weather.setHigh(results.getInt("high"));
			weather.setForecast(results.getString("high"));
			return weather;
		}
}
