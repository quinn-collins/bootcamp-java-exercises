package com.techelevator;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

public class KataRomanNumeralsTest {
	KataRomanNumerals roman;
	
	@Before
	public void setup() {
		roman = new KataRomanNumerals();
	}
	
	@Test
	public void one_is_i() {
		String result = roman.numeralToRoman(1);
		Assert.assertEquals("I", result);
	}
	
	@Test 
	public void two_is_ii() {
		String result = roman.numeralToRoman(2);
		Assert.assertEquals("II", result);
	}
	
	@Test 
	public void four_is_iv() {
		String result = roman.numeralToRoman(4);
		Assert.assertEquals("IV", result);
	}
	
	@Test 
	public void six_is_vi() {
		String result = roman.numeralToRoman(6);
		Assert.assertEquals("VI", result);
	}
	
	@Test 
	public void seven_is_vii() {
		String result = roman.numeralToRoman(7);
		Assert.assertEquals("VII", result);
	}
	
	@Test 
	public void nine_is_ix() {
		String result = roman.numeralToRoman(9);
		Assert.assertEquals("IX", result);
	}
	
	@Test 
	public void one_thousand_is_m() {
		String result = roman.numeralToRoman(1000);
		Assert.assertEquals("M", result);
	}
	
	@Test 
	public void two_thousand_is_mm() {
		String result = roman.numeralToRoman(2000);
		Assert.assertEquals("MM", result);
	}
	
	@Test 
	public void one_thousand_nine_hundred_is_mcm() {
		String result = roman.numeralToRoman(1900);
		Assert.assertEquals("MCM", result);
	}
	
	@Test 
	public void fifteen_hundred_is_md() {
		String result = roman.numeralToRoman(1500);
		Assert.assertEquals("MD", result);
	}
	
	@Test 
	public void eighteen_hundred_is_mdccc() {
		String result = roman.numeralToRoman(1800);
		Assert.assertEquals("MDCCC", result);
	}
	
	@Test
	public void one_hundred_is_c() {
		String result = roman.numeralToRoman(100);
		Assert.assertEquals("C", result);
	}
	
	@Test 
	public void fifty_is_l() {
		String result = roman.numeralToRoman(50);
		Assert.assertEquals("L", result);
	}
	
	@Test 
	public void nine_hundred_and_fifty_is_mcml() {
		String result = roman.numeralToRoman(1950);
		Assert.assertEquals("MCML", result);
	}
	
	@Test 
	public void hundred_ten_is_cx() {
		String result = roman.numeralToRoman(110);
		Assert.assertEquals("CX", result);
	}
	
	@Test
	public void m_is_one_thousand() {
		int result = roman.romanToNumeral("M");
		Assert.assertEquals(1000, result);
	}
	
	@Test
	public void md_is_one_thousand_five_hundred() {
		int result = roman.romanToNumeral("MD");
		Assert.assertEquals(1500, result);
	}
	
	@Test
	public void dm_is_nine_hundred() {
		int result = roman.romanToNumeral("CM"); 
		Assert.assertEquals(900, result);
	}
	
	
	
}
