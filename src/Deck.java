import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	ArrayList<Card> cards = new ArrayList<Card>();

	public Deck() {
		generateNewDeck();
	}

	public void generateNewDeck() {
		cards.clear();
		for (int i = 0; i < 52; i++) {
			cards.add(new Card(i));
		}
		shuffle();
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public void removeCard(int cardType) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getCardType() == cardType) {
				cards.remove(i);
				break;
			}
		}
	}
	
	public void removeCardIgnoreSuit(String cardName){
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getCardNameIgnoreSuit().equalsIgnoreCase(cardName)) {
				cards.remove(i);
				break;
			}
		}
	}

	public void changeCard(int cardTypeToBeChanged, int newCardType) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getCardType() == cardTypeToBeChanged) {
				cards.get(i).setCardType(newCardType);
				break;
			}
		}
	}

	public Card getCard(int cardType) {
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getCardType() == cardType) {
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
		removeCard(temp.getCardType());
		return temp;
	}

	public void printDeck() {
		for (Card card : cards) {
			System.out.println(card);
		}
	}
}
