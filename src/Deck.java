import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> cards = new ArrayList<Card>();

	public Deck() {
		generateNewDeck();
	}

	public void generateNewDeck() {
		cards.clear();
		for (int i = 1; i <= 13; i++) {
			for (int j = 0; j < 4; j++) {
				if (j % 4 == 0) {
					cards.add(new Card(findFaceValFromNumber(i), "Spades"));
				} else if (j % 4 == 1) {
					cards.add(new Card(findFaceValFromNumber(i), "Clubs"));
				} else if (j % 4 == 2) {
					cards.add(new Card(findFaceValFromNumber(i), "Hearts"));
				} else if (j % 4 == 3) {
					cards.add(new Card(findFaceValFromNumber(i), "Diamonds"));
				}
			}
		}
		shuffle();
	}

	private String findFaceValFromNumber(int number) {
		if (number == 1) {
			return "Ace";
		} else if (number == 2) {
			return "Two";
		} else if (number == 3) {
			return "Three";
		} else if (number == 4) {
			return "Four";
		} else if (number == 5) {
			return "Five";
		} else if (number == 6) {
			return "Six";
		} else if (number == 7) {
			return "Seven";
		} else if (number == 8) {
			return "Eight";
		} else if (number == 9) {
			return "Nine";
		} else if (number == 10) {
			return "Ten";
		} else if (number == 11) {
			return "Jack";
		} else if (number == 12) {
			return "Queen";
		} else if (number == 13) {
			return "King";
		}
		return null;
	}
	
	public void shuffle() {
		ArrayList<Card> shuffledDeck = new ArrayList<Card>();
		for (int i = 0; i < cards.size(); i++) {
			int rdmIndex = (int) (Math.random() * cards.size());
			shuffledDeck.add(cards.get(rdmIndex));
			cards.remove(rdmIndex);
		}
		
		for (int k = 0; k < shuffledDeck.size(); k++) {
			cards.add(shuffledDeck.get(k));
		}

	}

	public void removeCard(String faceVal, String suit) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getFaceVal().equalsIgnoreCase(faceVal)
					&& cards.get(i).getSuit().equalsIgnoreCase(suit)) {
				cards.remove(i);
				break;
			}
		}
	}

	public Card getCard(String faceVal, String suit) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getFaceVal().equalsIgnoreCase(faceVal)
					&& cards.get(i).getSuit().equalsIgnoreCase(suit)) {
				return cards.get(i);
			}
		}
		return null;
	}

	public Card getRandomCard() {
		return cards.get((int) (Math.random() * cards.size()));
	}

	public Card getRandomCardRemoveToo() {
		Card temp = cards.get((int) (Math.random() * cards.size()));
		removeCard(temp.getFaceVal(), temp.getSuit());
		return temp;
	}

	public Card[] getCardArray() {
		Card[] temp = new Card[cards.size()];
		for (int i = 0; i < cards.size(); i++) {
			temp[i] = cards.get(i);
		}
		return temp;
	}

	public void printDeck() {
		for (Card card : cards) {
			System.out.println(card);
		}
	}
}
