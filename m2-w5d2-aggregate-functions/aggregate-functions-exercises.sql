-- The following queries utilize the "world" database.
-- Write queries for the following problems. 
-- Notes:
--   GNP is expressed in units of one million US Dollars
--   The value immediately after the problem statement is the expected number 
--   of rows that should be returned by the query.

-- 1. The name and state plus population of all cities in states that border Ohio 
-- (i.e. cities located in Pennsylvania, West Virginia, Kentucky, Indiana, and 
-- Michigan).  
-- The name and state should be returned as a single column called 
-- name_and_state and should contain values such as ‘Detroit, Michigan’.  
-- The results should be ordered alphabetically by state name and then by city 
-- name. 
-- (19 rows)
SELECT (name || ', ' || district) as name_and_state, population FROM City
WHERE district IN ('Pennsylvania', 'West Virginia', 'Kentucky', 'Indiana', 'Michigan')
ORDER BY district, name;

-- 2. The name, country code, and region of all countries in Africa.  The name and
-- country code should be returned as a single column named country_and_code 
-- and should contain values such as ‘Angola (AGO)’ 
-- (58 rows)
SELECT (name || '(' || code || ')') AS name_and_code, region
FROM country
WHERE continent='Africa';

-- 3. The per capita GNP (i.e. GNP multipled by 1000000 then divided by population) of all countries in the 
-- world sorted from highest to lowest. Recall: GNP is express in units of one million US Dollars 
-- (highest per capita GNP in world: 37459.26)
SELECT (gnp*1000000/population) as per_capita_gnp
FROM country
ORDER BY per_capita_gnp;

-- 4. The average life expectancy of countries in South America.
-- (average life expectancy in South America: 70.9461)
SELECT AVG(lifeexpectancy) FROM country WHERE continent='South America';

-- 5. The sum of the population of all cities in California.
-- (total population of all cities in California: 16716706)
SELECT district, SUM(population) AS "sum_population" FROM city
WHERE district='California'
GROUP BY district;


-- 6. The sum of the population of all cities in China.
-- (total population of all cities in China: 175953614)
SELECT country.name, sum(city.population) as total_population FROM city, country WHERE countrycode='CHN' AND country.name = 'China' GROUP BY country.name;

-- 7. The maximum population of all countries in the world.
-- (largest country population in world: 1277558000)
SELECT name, population
FROM country
WHERE population = (
    SELECT MAX(population) AS max_population
    FROM country
);

-- 8. The maximum population of all cities in the world.
-- (largest city population in world: 10500000)
SELECT name, population
FROM city
WHERE population = (
        SELECT MAX(population) as max_population FROM city
);

-- 9. The maximum population of all cities in Australia.
-- (largest city population in Australia: 3276207)
SELECT name, population
FROM city
WHERE population = (
        SELECT max(population)
        FROM city
        WHERE countrycode = 'AUS'
        );
  

-- 10. The minimum population of all countries in the world.
-- (smallest_country_population in world: 50)
SELECT name, population
FROM country
WHERE population = (
        SELECT min(population) as min_population
        FROM country
        WHERE  population IS NOT NULL AND population > 0
        );

-- 11. The average population of cities in the United States.
-- (avgerage city population in USA: 286955.3795)
SELECT d.name, avg(c.population)
FROM city AS c
JOIN country AS d ON c.countrycode = d.code
WHERE countrycode='USA'
GROUP BY d.name;
        

-- 12. The average population of cities in China.
-- (average city population in China: 484720.6997 approx.)
SELECT country.name, cast(avg(city.population)as int)
FROM city
JOIN country ON countrycode = code
WHERE countrycode = 'CHN'
GROUP BY country.name;

-- 13. The surface area of each continent ordered from highest to lowest.
-- (largest continental surface area: 31881000, "Asia")
SELECT continent, cast(sum(surfacearea)as int) as "sum_surface_area"
FROM country
GROUP BY continent
ORDER BY sum_surface_area DESC;


-- 14. The highest population density (population divided by surface area) of all 
-- countries in the world. 
-- (highest population density in world: 26277.7777)
SELECT name, (population/surfacearea) AS population_density
FROM country
ORDER BY population_density DESC
LIMIT 1;


-- 15. The population density and life expectancy of the top ten countries with the 
-- highest life expectancies in descending order. 
-- (highest life expectancies in world: 83.5, 166.6666, "Andorra")
SELECT name, (population/surfacearea) AS population_density, lifeexpectancy
FROM country
WHERE lifeexpectancy IS NOT NULL
ORDER BY lifeexpectancy DESC
LIMIT 10;

-- 16. The difference between the previous and current GNP of all the countries in 
-- the world ordered by the absolute value of the difference. Display both 
-- difference and absolute difference.
-- (smallest difference: 1.00, 1.00, "Ecuador")
SELECT name, (gnp - gnpold) as difference_in_gnp ,ABS(gnp - gnpold) as abs_difference_in_gnp
FROM country
WHERE gnp IS NOT NULL AND gnpold IS NOT NULL
ORDER BY abs_difference_in_gnp;

-- 17. The average population of cities in each country (hint: use city.countrycode)
-- ordered from highest to lowest.
-- (highest avg population: 4017733.0000, "SGP")
SELECT AVG(population) as avg_population, countrycode
FROM city
GROUP BY countrycode
ORDER BY avg_population DESC;
	
-- 18. The count of cities in each state in the USA, ordered by state name.
-- (45 rows)
SELECT district AS name_of_state, COUNT(name) as number_of_cities
FROM city
WHERE countrycode='USA'
GROUP BY district
ORDER BY district;

-- 19. The count of countries on each continent, ordered from highest to lowest.
-- (highest count: 58, "Africa")
SELECT continent, COUNT(name) AS number_of_countries
FROM country
GROUP BY continent
ORDER BY number_of_countries DESC
	
-- 20. The count of cities in each country ordered from highest to lowest.
-- (largest number of  cities ib a country: 363, "CHN")
SELECT countrycode, COUNT(name) AS number_of_cities_in_each_country
FROM city
GROUP BY countrycode
ORDER BY number_of_cities_in_each_country DESC;
	
-- 21. The population of the largest city in each country ordered from highest to 
-- lowest.
-- (largest city population in world: 10500000, "IND")
SELECT MAX(population) as max_population, countrycode
FROM city
GROUP BY countrycode
ORDER BY max_population DESC;

-- 22. The average, minimum, and maximum non-null life expectancy of each continent 
-- ordered from lowest to highest average life expectancy. 
-- (lowest average life expectancy: 52.5719, 37.2, 76.8, "Africa")

SELECT continent, AVG(lifeexpectancy) AS avg_life, MIN(lifeexpectancy) as min_life, MAX(lifeexpectancy) AS max_life
FROM country
WHERE lifeexpectancy IS NOT NULL
GROUP BY continent
ORDER BY avg_life;

