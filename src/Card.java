public class Card {

	private int value;
	private String suit;
	private String faceVal;

	public Card(String faceVal, String suit) {
		this.suit = suit;
		this.faceVal = faceVal;
		setValue();
	}

	private void setValue(){
		if(faceVal.equalsIgnoreCase("ace")){
			value = 1;
		}else if(faceVal.equalsIgnoreCase("two")){
			value = 2;
		}else if(faceVal.equalsIgnoreCase("three")){
			value = 3;
		}else if(faceVal.equalsIgnoreCase("four")){
			value = 4;
		}else if(faceVal.equalsIgnoreCase("five")){
			value = 5;
		}else if(faceVal.equalsIgnoreCase("six")){
			value = 6;
		}else if(faceVal.equalsIgnoreCase("seven")){
			value = 7;
		}else if(faceVal.equalsIgnoreCase("eight")){
			value = 8;
		}else if(faceVal.equalsIgnoreCase("nine")){
			value = 9;
		}else if(faceVal.equalsIgnoreCase("ten")){
			value = 10;
		}else if(faceVal.equalsIgnoreCase("jack")){
			value = 11;
		}else if(faceVal.equalsIgnoreCase("queen")){
			value = 12;
		}else if(faceVal.equalsIgnoreCase("king")){
			value = 13;
		}else{
			value = 0;
		}
	}
	
	public String getCardName() {
		return faceVal + " of " + suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
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
