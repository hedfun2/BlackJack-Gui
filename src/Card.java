public class Card {

	private int pointVal;
	private String suit;
	private String faceVal;

	public Card(String faceVal, String suit) {
		this.suit = suit;
		this.faceVal = faceVal;
		setValue();
	}

	private void setValue(){
		if(faceVal.equalsIgnoreCase("ace")){
			pointVal = 1;
		}else if(faceVal.equalsIgnoreCase("two")){
			pointVal = 2;
		}else if(faceVal.equalsIgnoreCase("three")){
			pointVal = 3;
		}else if(faceVal.equalsIgnoreCase("four")){
			pointVal = 4;
		}else if(faceVal.equalsIgnoreCase("five")){
			pointVal = 5;
		}else if(faceVal.equalsIgnoreCase("six")){
			pointVal = 6;
		}else if(faceVal.equalsIgnoreCase("seven")){
			pointVal = 7;
		}else if(faceVal.equalsIgnoreCase("eight")){
			pointVal = 8;
		}else if(faceVal.equalsIgnoreCase("nine")){
			pointVal = 9;
		}else if(faceVal.equalsIgnoreCase("ten")){
			pointVal = 10;
		}else if(faceVal.equalsIgnoreCase("jack")){
			pointVal = 11;
		}else if(faceVal.equalsIgnoreCase("queen")){
			pointVal = 12;
		}else if(faceVal.equalsIgnoreCase("king")){
			pointVal = 13;
		}else{
			pointVal = 0;
		}
	}
	
	public String getCardName() {
		return faceVal + " of " + suit;
	}

	public int getPointVal() {
		return pointVal;
	}

	public void setPointVal(int pointVal) {
		this.pointVal = pointVal;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getFaceVal() {
		return faceVal;
	}

	public void setFaceVal(String faceVal) {
		this.faceVal = faceVal;
	}

	public String toString() {
		return getCardName();
	}

}
