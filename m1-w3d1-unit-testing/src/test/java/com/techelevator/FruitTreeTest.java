package com.techelevator;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class FruitTreeTest {
	private FruitTree myTree;
	@Before
	public void setup() {
		// Arrange
		myTree = new FruitTree("Apples", 10);
	}
	
	@Test
	public void tree_correctly_returns_type_of_fruit() {
		// Act
		String typeOfFruit = myTree.getTypeOfFruit();
		// Assert
		Assert.assertEquals("Apples", typeOfFruit);
	}
	
	@Test
	public void tree_returns_correct_number_of_fruits_after_initialization(){
		// Act
		int fruitCount = myTree.getPiecesOfFruitLeft();
		// Assert
		Assert.assertEquals(10, fruitCount);
	}
	
	@Test
	public void can_pick_fruit() {
		// Act
		boolean success = myTree.pickFruit(5);
		// Assert
		Assert.assertTrue("I should be able to pick 5 apples", success);
		Assert.assertEquals(5, myTree.getPiecesOfFruitLeft());
		
	}
	
	@Test
	public void can_not_pick_more_fruit_than_the_tree_has() {
		// Act
		boolean success = myTree.pickFruit(15);
		// Assert
		Assert.assertFalse("I shouldn't be able to pick more fruit than the tree has", success);
		Assert.assertEquals(10, myTree.getPiecesOfFruitLeft());
	}
	
}
