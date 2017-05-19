package com.techelevator;

public class FruitTree {
	private String typeOfFruit;
	private int piecesOfFruitLeft;
	
	public String getTypeOfFruit() {
		return typeOfFruit;
	}
	
	public int getPiecesOfFruitLeft() {
		return piecesOfFruitLeft;
	}
	
	public boolean pickFruit(int numberOfPiecesToRemove) {
		if (piecesOfFruitLeft == 0) {
			return false;
		}
		else {
			if(numberOfPiecesToRemove <= piecesOfFruitLeft){
				piecesOfFruitLeft -= numberOfPiecesToRemove;
				return true;
			}
			else{
				piecesOfFruitLeft = 0;
				return true;
			}
			
		}
	}
	
	public FruitTree(String typeOfFruit, int startingPiecesOfFruit) {
		this.typeOfFruit = typeOfFruit;
		piecesOfFruitLeft = startingPiecesOfFruit;
	}
}
