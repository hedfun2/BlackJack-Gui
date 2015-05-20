
public class CardTypes {

	public static final int ACE_OF_SPADES = 0;
	public static final int AEC_OF_HEARTS = 1;
	public static final int ACE_OF_DIAMONDS = 2;
	public static final int ACE_OF_CLUBS = 3;
	public static final int TWO_OF_SPADES = 4;
	public static final int TWO_OF_HEARTS = 5;
	public static final int TWO_OF_DIAMONDS = 6;
	public static final int TWO_OF_CLUBS = 7;
	public static final int THREE_OF_SPADES = 8;
	public static final int THREE_OF_HEARTS = 9;
	public static final int THREE_OF_DIAMONDS = 10;
	public static final int THREE_OF_CLUBS = 11;
	public static final int FOUR_OF_SPADES = 12;
	public static final int FOUR_OF_HEARTS = 13;
	public static final int FOUR_OF_DIAMONDS = 14;
	public static final int FOUR_OF_CLUBS = 15;
	public static final int FIVE_OF_SPADES = 16;
	public static final int FIVE_OF_HEARTS = 17;
	public static final int FIVE_OF_DIAMONDS = 18;
	public static final int FIVE_OF_CLUBS = 19;
	public static final int SIX_OF_SPADES = 20;
	public static final int SIX_OF_HEARTS = 21;
	public static final int SIX_OF_DIAMONDS = 22;
	public static final int SIX_OF_CLUBS = 23;
	public static final int SEVEN_OF_SPADES = 24;
	public static final int SEVEN_OF_HEARTS = 25;
	public static final int SEVEN_OF_DIAMONDS = 26;
	public static final int SEVEN_OF_CLUBS = 27;
	public static final int EIGHT_OF_SPADES = 28;
	public static final int EIGHT_OF_HEARTS = 29;
	public static final int EIGHT_OF_DIAMONDS = 30;
	public static final int EIGHT_OF_CLUBS = 31;
	public static final int NINE_OF_SPADES = 32;
	public static final int NINE_OF_HEARTS = 33;
	public static final int NINE_OF_DIAMONDS = 34;
	public static final int NINE_OF_CLUBS = 35;
	public static final int TEN_OF_SPADES = 36;
	public static final int TEN_OF_HEARTS = 37;
	public static final int TEN_OF_DIAMONDS = 38;
	public static final int TEN_OF_CLUBS = 39;
	public static final int JACK_OF_SPADES = 40;
	public static final int JACK_OF_HEARTS = 41;
	public static final int JACK_OF_DIAMONDS = 42;
	public static final int JACK_OF_CLUBS = 43;
	public static final int QUEEN_OF_SPADES = 44;
	public static final int QUEEN_OF_HEARTS = 45;
	public static final int QUEEN_OF_DIAMONDS = 46;
	public static final int QUEEN_OF_CLUBS = 47;
	public static final int KING_OF_SPADES = 48;
	public static final int KING_OF_HEARTS = 49;
	public static final int KING_OF_DIAMONDS = 50;
	public static final int KING_OF_CLUBS = 51;
	public static final int JOKER = 52;
	
	public static String getCardName(int cardType){
		if(cardType == 0)
			return "Ace of Spades";
		else if(cardType == 1)
			return "Ace of Hearts";
		else if(cardType == 2)
			return "Ace of Diamonds";
		else if(cardType == 3)
			return "Ace of Clubs";
		else if(cardType == 4)
			return "Two of Spades";
		else if(cardType == 5)
			return "Two of Hearts";
		else if(cardType == 6)
			return "Two of Diamonds";
		else if(cardType == 7)
			return "Two of Clubs";
		else if(cardType == 8)
			return "Three of Spades";
		else if(cardType == 9)
			return "Three of Hearts";
		else if(cardType == 10)
			return "Three of Diamonds";
		else if(cardType == 11)
			return "Three of Clubs";
		else if(cardType == 12)
			return "Four of Spades";
		else if(cardType == 13)
			return "Four of Hearts";
		else if(cardType == 14)
			return "Four of Diamonds";
		else if(cardType == 15)
			return "Four of Clubs";
		else if(cardType == 16)
			return "Five of Spades";
		else if(cardType == 17)
			return "Five of Hearts";
		else if(cardType == 18)
			return "Five of Diamonds";
		else if(cardType == 19)
			return "Five of Clubs";
		else if(cardType == 20)
			return "Six of Spades";
		else if(cardType == 21)
			return "Six of Hearts";
		else if(cardType == 22)
			return "Six of Diamonds";
		else if(cardType == 23)
			return "Six of Clubs";
		else if(cardType == 24)
			return "Seven of Spades";
		else if(cardType == 25)
			return "Seven of Hearts";
		else if(cardType == 26)
			return "Seven of Diamonds";
		else if(cardType == 27)
			return "Seven of Clubs";
		else if(cardType == 28)
			return "Eight of Spades";
		else if(cardType == 29)
			return "Eight of Hearts";
		else if(cardType == 30)
			return "Eight of Diamonds";
		else if(cardType == 31)
			return "Eight of Clubs";
		else if(cardType == 32)
			return "Nine of Spades";
		else if(cardType == 33)
			return "Nine of Hearts";
		else if(cardType == 34)
			return "Nine of Diamonds";
		else if(cardType == 35)
			return "Nine of Clubs";
		else if(cardType == 36)
			return "Ten of Spades";
		else if(cardType == 37)
			return "Ten of Hearts";
		else if(cardType == 38)
			return "Ten of Diamonds";
		else if(cardType == 39)
			return "Ten of Clubs";
		else if(cardType == 40)
			return "Jack of Spades";
		else if(cardType == 41)
			return "Jack of Hearts";
		else if(cardType == 42)
			return "Jack of Diamonds";
		else if(cardType == 43)
			return "Jack of Clubs";
		else if(cardType == 44)
			return "Queen of Spades";
		else if(cardType == 45)
			return "Queen of Hearts";
		else if(cardType == 46)
			return "Queen of Diamonds";
		else if(cardType == 47)
			return "Queen of Clubs";
		else if(cardType == 48)
			return "King of Spades";
		else if(cardType == 49)
			return "King of Hearts";
		else if(cardType == 50)
			return "King of Diamonds";
		else if(cardType == 51)
			return "King of Clubs";
		else if(cardType == 52)
			return "Joker";
		else
			return "Error";
		
	}
	
	
	
}
