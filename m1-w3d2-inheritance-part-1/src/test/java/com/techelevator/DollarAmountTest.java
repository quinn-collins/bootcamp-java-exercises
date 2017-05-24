package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DollarAmountTest {
	DollarAmount dollar;
	
	@Before
	public void setup() {
		dollar = new DollarAmount(10, 50);

	}
	
	@Test
	public void cents_test() {
		Assert.assertEquals(50, dollar.getCents());
	}
	@Test
	public void dollar_test() {
		Assert.assertEquals(10,  dollar.getDollars());
	}
	@Test
	public void total_amount_is_greater_than_amount_to_compare() {
		DollarAmount amountToCompare = new DollarAmount(500);
		Assert.assertTrue(dollar.isGreaterThan(amountToCompare));
	}
	@Test
	public void total_amount_less_than_amount_to_compare() {
		DollarAmount amountToCompare = new DollarAmount(1051);
		Assert.assertFalse(dollar.isGreaterThan(amountToCompare));
	}
	@Test
	public void total_amount_in_cents_is_greater_or_equal_total_amount() {
		DollarAmount amountToCompare = new DollarAmount(1049);
		Assert.assertTrue(dollar.isGreaterThanOrEqualTo(amountToCompare));
	}
	@Test
	public void total_amount_in_cents_is_less_than_or_equal_to_compare() {
		DollarAmount amountToCompare = new DollarAmount(1051);
		Assert.assertFalse(dollar.isGreaterThanOrEqualTo(amountToCompare));
	}
	@Test
	public void total_amount_in_cents_less_than_amount_to_compare() {
		DollarAmount amountToCompare = new DollarAmount(1051);
		Assert.assertTrue(dollar.isLessThan(amountToCompare));
	}
	@Test
	public void total_amount_in_cents_less_to_compare_false() {
		DollarAmount amountToCompare = new DollarAmount(1049);
		Assert.assertFalse(dollar.isLessThan(amountToCompare));
	}
	@Test
	public void total_amount_in_cents_less_than_or_equal_to_amount_to_compare() {
		DollarAmount amountToCompare = new DollarAmount(1051);
		Assert.assertTrue(dollar.isLessThanOrEqualTo(amountToCompare));
	}
	@Test
	public void total_amount_in_cents_less_than_or_equal_to_compare_false() {
		DollarAmount amountToCompare = new DollarAmount(1049);
		Assert.assertFalse(dollar.isLessThanOrEqualTo(amountToCompare));
	}
	@Test
	public void return_negative_false() {
		Assert.assertFalse(dollar.isNegative());
	}
	@Test
	public void return_negative_true() {
		DollarAmount negativeDollar = new DollarAmount(-1);
		Assert.assertTrue(negativeDollar.isNegative());
	}
	@Test
	public void return_dollar_amount_minus() {
		DollarAmount amountMinus = new DollarAmount(50);
		Assert.assertEquals(new DollarAmount(1000), dollar.minus(amountMinus));
	}
	@Test
	public void return_dollar_amount_plus() {
		DollarAmount amountPlus = new DollarAmount(50);
		Assert.assertEquals(new DollarAmount(1100),  dollar.plus(amountPlus));
	}
	@Test
	public void if_true_return_1() {
		DollarAmount amountToCompare = new DollarAmount(1049);
		Assert.assertEquals(1,  dollar.compareTo(amountToCompare));
	}
	@Test
	public void else_if_true_return_negative_1() {
		DollarAmount amountToCompare = new DollarAmount(1051);
		Assert.assertEquals(-1,  dollar.compareTo(amountToCompare));
	}
	@Test
	public void else_true_return_0() {
		DollarAmount amountToCompare = new DollarAmount(1050);
		Assert.assertEquals(0,  dollar.compareTo(amountToCompare));
	}
	@Test
	public void equal_object() {
		Assert.assertTrue(new DollarAmount(1000).equals(new DollarAmount(1000)));
		Assert.assertFalse(new DollarAmount(1000).equals(new DollarAmount(500)));
		Assert.assertFalse(new DollarAmount(1000).equals(null));
		Assert.assertFalse(new DollarAmount(1000).equals(new String()));
	}
	@Test
	public void override_hash_1050() {
		Assert.assertNotEquals(0, new DollarAmount(1000).hashCode());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
}
