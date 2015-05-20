import java.util.ArrayList;

public class Game {

	MainWindow frame;
	Deck gameDeck;
	ArrayList<Card> playerCards = new ArrayList<Card>();
	ArrayList<Card> dealerCards = new ArrayList<Card>();
	boolean started = false;
	double amount = 1000;

	public Game(MainWindow frame) {
		this.frame = frame;
		gameDeck = new Deck();
	}

	public void firstDeal() {
		playerCards.add(gameDeck.getRandomCardRemoveToo());
		playerCards.add(gameDeck.getRandomCardRemoveToo());
		dealerCards.add(gameDeck.getRandomCardRemoveToo());
		dealerCards.add(gameDeck.getRandomCardRemoveToo());

		frame.placePlayerCard(1, getFileName(playerCards.get(0)));
		frame.placePlayerCard(2, getFileName(playerCards.get(1)));

		frame.placeDealerCard(1, getFileName(dealerCards.get(0)));
		frame.placeDealerCard(2, "b2fv.png");

		setPlayerTotal();
		checkWinner();
	}

	public void deal() {
		Card newCard = gameDeck.getRandomCardRemoveToo();
		playerCards.add(newCard);
		setPlayerTotal();
		checkWinner();
	}

	public void stand() {
		setDealerTotal();
		int total = Integer.parseInt(frame.totalAmt.getText());
		frame.placeDealerCard(2, getFileName(dealerCards.get(1)));
		int dTotal = Integer.parseInt(frame.dTotalAmt.getText());
		new Thread() {
			public void run() {
				if(Integer.parseInt(frame.dTotalAmt.getText()) == 21){
					a
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public void checkWinner() {
		if (Integer.parseInt(frame.totalAmt.getText()) == 21) {
			frame.gameOver();
			frame.infoL.setText("You Got 21!");
		} else if (Integer.parseInt(frame.totalAmt.getText()) > 21) {
			frame.gameOver();
			frame.infoL.setText("Bust");
		}
	}

	public void setPlayerTotal() {
		int total = 0;
		for (int i = 0; i < playerCards.size(); i++) {
			total += playerCards.get(i).getCardValue();
		}
		frame.totalAmt.setText("" + total);
	}

	public void setDealerTotal() {
		int total = 0;
		for (int i = 0; i < dealerCards.size(); i++) {
			total += dealerCards.get(i).getCardValue();
		}
		frame.dTotalAmt.setText("" + total);
	}

	public String getFileName(Card card) {
		String suit = card.getSuit().substring(0, 1).toLowerCase();
		String number = getCardLetter(card);
		// System.out.println(number + "   " + suit);
		return suit + number + ".png";
	}

	public String getCardLetter(Card card) {
		if (card.getCardNameIgnoreSuit().equalsIgnoreCase("ace")) {
			return "1";
		} else if (card.getCardNameIgnoreSuit().equalsIgnoreCase("two")) {
			return "2";
		} else if (card.getCardNameIgnoreSuit().equalsIgnoreCase("three")) {
			return "3";
		} else if (card.getCardNameIgnoreSuit().equalsIgnoreCase("four")) {
			return "4";
		} else if (card.getCardNameIgnoreSuit().equalsIgnoreCase("five")) {
			return "5";
		} else if (card.getCardNameIgnoreSuit().equalsIgnoreCase("six")) {
			return "6";
		} else if (card.getCardNameIgnoreSuit().equalsIgnoreCase("seven")) {
			return "7";
		} else if (card.getCardNameIgnoreSuit().equalsIgnoreCase("eight")) {
			return "8";
		} else if (card.getCardNameIgnoreSuit().equalsIgnoreCase("nine")) {
			return "9";
		} else if (card.getCardNameIgnoreSuit().equalsIgnoreCase("ten")) {
			return "10";
		} else if (card.getCardNameIgnoreSuit().equalsIgnoreCase("jack")) {
			return "j";
		} else if (card.getCardNameIgnoreSuit().equalsIgnoreCase("queen")) {
			return "q";
		} else if (card.getCardNameIgnoreSuit().equalsIgnoreCase("king")) {
			return "k";
		} else {
			return null;
		}
	}
}
