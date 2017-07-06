package com.techelevator.model;

import java.util.List;

public interface WeatherDao {
	public List<Weather> getAllWeather();
	public List<Weather> getWeatherByParkCode(String parkCode);
}
