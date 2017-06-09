-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)
INSERT INTO city (id, name, countrycode, district, population)
VALUES ('4080', 'Smallville', 'USA', 'Kansas', '45001');
-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.
INSERT INTO countrylanguage (language, countrycode, isofficial, percentage)
VALUES ('Kryptonese', 'USA',false, 0.0001)
-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change 
-- the appropriate record accordingly.
UPDATE countrylanguage
SET language = 'Krypto-babble'
WHERE language = 'Kryptonese';

-- 4. Set the US captial to Smallville, Kansas in the country table.
UPDATE country
SET capital = 4080
WHERE code = 'USA'
-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
        -- Did not succeed because it violated foreign key constraint "country_capital_fkey" on table "country"
DELETE 
FROM city                       
WHERE name = 'Smallville'

-- 6. Return the US captial to Washington.
UPDATE country
SET capital = 3813
WHERE code = 'USA'
-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)
DELETE 
FROM city
WHERE name = 'Smallville'
-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)
BEGIN TRANSACTION;

UPDATE countrylanguage
SET isofficial = NOT isofficial
FROM country
WHERE country.code = countrylanguage.countrycode AND country.indepyear BETWEEN 1800 AND 1972

COMMIT

-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)
SELECT population
FROM city
where population < 1000

UPDATE city
SET population = population / 1000
WHERE population > 1
 
-- 10. Assuming a country's surfacearea is expressed in miles, convert it to 
-- meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)

SELECT *
FROM country, countrylanguage
WHERE countrylanguage.language = 'French' AND countrylanguage.percentage > 20




SELECT *
FROM countrylanguage


SELECT *
FROM city
WHERE name = 