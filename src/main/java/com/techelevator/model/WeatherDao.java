package com.techelevator.model;

import java.util.List;

public interface WeatherDao {
	public List<Weather> getAllWeather();
	public Weather getWeatherByParkCode(String parkCode);
}
