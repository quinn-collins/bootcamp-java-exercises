# Test Driven Development Exercises

Learning how to develop software using TDD is often accomplished while practicing Katas. 
[KataCatalogue](http://codingdojo.org/cgi-bin/index.pl?KataCatalogue) has a number of different kata exercises.

<<<<<<< HEAD
Work on your own to solve the following exercises while using the TDD approach.

## Kata Roman Numerals

### Step 1

The Romans were a clever bunch. They conquered most of Europe and ruled it for hundreds of years.  One thing they never discovered  was the number zero. This made writing and dating extensive histories of their exploits 
slightly more challenging, but the system of numbers they came up with is still in use today. For example the BBC uses Roman numerals to date their programes.

The Romans wrote numbers using letters - I, V, X, L, C, D, M. (notice these letters have lots of straight lines and are hence easy to hack into stone tablets)

The Kata says you should write a function to convert from normal numbers to Roman Numerals: eg

*Sample Output*
```
1 ---> I
10 --> X
7 ---> VII
```

There is no need to be able to convert numbers larger than about 3000. (The Romans themselves didn't tend to go any higher)

Note that you can't write numerals like "IM" for 999. Wikipedia says: Modern Roman numerals ... are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero. To see this in practice, consider the ... example of 1990. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII.

**Clues**
- what are the best data structures for storing all the numeral letters? (I, V, D, M etc)

[How Roman Numerals Work](http://www.novaroma.org/via_romana/numbers.html)

### Step 2

Write a function to convert in the other direction from Roman Numeral to digit.
=======
Work with a partner to solve the following exercises while using the TDD approach.

## Kata String Calculator

Create a simple String Calculator with a method `int add(String numbers)`.

### Step 1

    The method can take 0, 1, or 2 numbers and will return their sum. For an empty string it will return 0.

*Sample Output*
```
"" -> returns 0
"1" -> returns 1
"1,2" -> returns 3
```

**Hint** Begin with the simplest test case using an empty string and move to 1 then 2 numbers.

### Step 2

    Allow the add method to handle an unknown amount of numbers.

*Sample Output*
```
"1,5,7" -> returns 13
```

### Step 3

    Allow the add method to handle new lines between numbers (instead of commas)
    
*Sample Output*
```
"1\n2,3" -> returns 6
"3\n5\n2,4" -> returns 14 
```

The input `"1,\n"` is not valid. A comma will not end on the line. You do not need to code for it.

### Step 4 (Bonus)

    Support different delimters. To change a delimiter, the beginning of the string will contain a separate line that looks like "//[delimeter]\n[numbers...]"
    
*Sample Output*
```
//;\n1;2" -> returns 3
//!\n4!9" -> returns 13
```
>>>>>>> dc2d9dec116b48f441e251a9d9cb8b364ceadbe4
