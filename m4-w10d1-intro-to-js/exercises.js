function sumDouble(num1, num2) {
  var sum = num1 + num2;

  if(num1 === num2) {
    return sum * 2;
  }
  else {
    return sum;
  }
}﻿

function hasTeen(x, y, z) {
  if((x > 12 && x < 20) || (y > 12 && y < 20) || (z > 12 && z <20)) {
    return true;
  }
  else {
    return false;
  }
}

function lastDigit(x, y) {
  if(x%10==y%10) {
    return true;
  }
  else {
    return false;
  }
}

function seeColor(colorString) {
  if(colorString.substring(0,3)=="red") {
    return "red";
  }
  else if(colorString.substring(0,4)=="blue") {
    return "blue";
  }
  else {
    return "";
  }
}

function middleThree(str) {
  return str.substring(str.length/2-1, str.length/2+2);
}

function frontAgain(str) {
  if(str.substring(0,2)==str.substring(str.length - 2)) {
    return true;
  }
  else {
    return false;
  }
}

function alarmClock(num, vacation) {
  if(vacation) {
    if(num > 0 && num < 6) {
      return "10:00";
    }
    else {
      return "off";
    }
  }
  else {
    if(num > 0 && num < 6) {
      return "7:00";
    }
    else {
      return "10:00";
    }
  }
}

function makeMiddle(intArray) {
  var results = [];
  if(intArray.length%2==0 && intArray.length>1) {
    results.push(intArray[intArray.length/2-1])
    results.push(intArray[intArray.length/2])
  }
  return results;
}

//tried with for each and it broke everything, need to learn syntax of for each
function oddOnly(intArray) {
  var results = [];
  for(var i = 0; i < intArray.length; i++) {
    if(intArray[i]%2==0) {}
    else {
      results.push(intArray[i]);
    }
  }
  return results;
}

//probably could put together first and third for loops
function weave(firstArray, secondArray) {
   firstLength = firstArray.length;
   secondLength = secondArray.length;
   var results = [];

   if(firstLength <= secondLength) {
     for(var i = 0; i < firstArray.length; i++) {
       results.push(firstArray[i]);
       results.push(secondArray[i]);
     }
     for(var i = firstArray.length; i < secondArray.length; i++) {
       results.push(secondArray[i]);
     }
   }
   else {
     for(var i = 0; i < secondArray.length; i++) {
       results.push(firstArray[i]);
       results.push(secondArray[i]);
     }
     for(var i = secondArray.length; i < firstArray.length; i++) {
       results.push(firstArray[i]);
     }
   }
   return results;
}

function cigarParty(cigars, weekend) {
  if(weekend) {
    if(cigars>39) {
      return true;
    }
  }
  else {
    if(cigars>39&&cigars<61){
      return true;
    }
  }
  return false;
}

function stringSplosion(str) {
  var result = "";
  for(var i = 0; i <= str.length; i++) {
    result += str.substring(0,i);
  }
  return result;
}

function fizzBuzz(num) {
  if(num % 5 == 0 && num % 3 == 0) {
    return "FizzBuzz";
  }
  else if(num%5==0) {
    return "Buzz";
  }
  else if(num%3==0) {
    return "Fizz";
  }
  else {
    return num;
  }
}

function countValues(numArray) {
  var results = {};
  for(var i = 0; i < numArray.length; i++) {
    var currentNum = numArray[i];
    var currentCount = results[currentNum];

    if(currentCount === undefined) {
      currentCount = 1;
    }
    else {
      currentCount++;
    }

    results[currentNum] = currentCount;
  }
  return results;
}

function reverseArray(numArray) {
  var result = [];
  for(var i = 0; i < numArray.length; i++) {
    var currentNum = numArray[i];
    result[numArray.length - (i+1)] = currentNum;
  }
  return result;
}
