
public class Card {
	
	int cardType;
	String cardName;
	
	public Card(){
		
	}
	
	public Card(int cardType){
		this.cardType = cardType;
		cardName = CardTypes.getCardName(cardType);
	}
	
	public void setCardType(int cardType){
		this.cardType = cardType;
	}
	
	public int getCardType(){
		return cardType;
	}
	
	public String getSuit(){
		return cardName.substring(cardName.indexOf("of ") + 3);
	}
	
	public int getCardValue(){
		if(getCardNameIgnoreSuit().equalsIgnoreCase("ace")){
			return 1;
		}else if(getCardNameIgnoreSuit().equalsIgnoreCase("two")){
			return 2;
		}else if(getCardNameIgnoreSuit().equalsIgnoreCase("three")){
			return 3;
		}else if(getCardNameIgnoreSuit().equalsIgnoreCase("four")){
			return 4;
		}else if(getCardNameIgnoreSuit().equalsIgnoreCase("five")){
			return 5;
		}else if(getCardNameIgnoreSuit().equalsIgnoreCase("six")){
			return 6;
		}else if(getCardNameIgnoreSuit().equalsIgnoreCase("seven")){
			return 7;
		}else if(getCardNameIgnoreSuit().equalsIgnoreCase("eight")){
			return 8;
		}else if(getCardNameIgnoreSuit().equalsIgnoreCase("nine")){
			return 9;
		}else if(getCardNameIgnoreSuit().equalsIgnoreCase("ten")){
			return 10;
		}else if(getCardNameIgnoreSuit().equalsIgnoreCase("jack")){
			return 10;
		}else if(getCardNameIgnoreSuit().equalsIgnoreCase("queen")){
			return 10;
		}else if(getCardNameIgnoreSuit().equalsIgnoreCase("king")){
			return 10;
		}else{
			return 0;
		}
	}
	
	public String getCardNameIgnoreSuit(){
		return cardName.substring(0, cardName.indexOf(' '));
	}
	
	public String getCardName(){
		return cardName;
	}
	
	public String toString(){
		return cardName;
	}
	
}
