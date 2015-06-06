import java.util.ArrayList;

public class Game {

	MainWindow frame;
	Deck gameDeck;
	ArrayList<Card> playerCards = new ArrayList<Card>();
	ArrayList<Card> dealerCards = new ArrayList<Card>();
	boolean gameOver = false;
	double amount = 1000;
	double betSize;
	int total = 0;
	int dTotal = 0;

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

		updatePlayerTotal();
		updateDealerTotal();
		checkForBust();
	}

	public void dealPlayer() {
		Card newCard = gameDeck.getRandomCardRemoveToo();
		playerCards.add(newCard);
		frame.placePlayerCard(playerCards.size(),
				getFileName(playerCards.get(playerCards.size() - 1)));
		updatePlayerTotal();
		checkForBust();
	}

	public void dealDealer() {
		Card newCard = gameDeck.getRandomCardRemoveToo();
		dealerCards.add(newCard);
		frame.placeDealerCard(dealerCards.size(),
				getFileName(dealerCards.get(dealerCards.size() - 1)));
		updateDealerTotal();
	}

	public void stand() {
		frame.dTotalAmt.setText("" + dTotal);
		frame.placeDealerCard(2, getFileName(dealerCards.get(1)));
		checkForDealerBust();
		new Thread() {
			public void run() {
				while (!gameOver) {
					System.out.println(!gameOver);
					dealDealer();
					frame.dTotalAmt.setText("" + dTotal);
					checkForDealerBust();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	public void gameOver() {
		gameOver = true;
		frame.gameOver();
		checkWinner();
	}

	public void checkWinner() {
		if (dTotal > 21 || (total > dTotal && total <= 21)) {
			addMoney(betSize * 2);
		}
	}

	public void addMoney(double amt) {
		amount += amt;
		frame.amtL.setText(amount + "");
	}

	public void removeMoney(double amt) {
		amount -= amt;
		frame.amtL.setText(amount + "");
	}

	public void reset() {
		gameDeck.generateNewDeck();
		playerCards.clear();
		dealerCards.clear();
		betSize = 0;
		gameOver = false;
		total = 0;
		dTotal = 0;
	}

	public void checkForDealerBust() {
		if (dTotal == 21) {
			frame.infoL.setText("Dealer Got Blackjack");
			gameOver();
		} else if (dTotal > 21) {
			frame.infoL.setText("Dealer Busted");
			gameOver();
		} else if (dTotal > total) {
			frame.infoL.setText("Dealer Won");
			gameOver();
		} else if (dTotal == total && dTotal >= 16) {
			frame.infoL.setText("Push");
			gameOver();
		}
	}

	public void checkForBust() {
		if (total == 21) {
			gameOver();
			frame.infoL.setText("You Got 21!");
		} else if (total > 21) {
			gameOver();
			frame.infoL.setText("Bust");
		}
	}

	public int blackjackVal(Card card) {
		if (card.getPointVal() == 1) {
			return 11;
		} else if (card.getPointVal() > 10) {
			return 10;
		} else {
			return card.getPointVal();
		}
	}

	public void updatePlayerTotal() {
		int tempTotal = 0;
		int aces = 0;
		for (int i = 0; i < playerCards.size(); i++) {
			tempTotal += blackjackVal(playerCards.get(i));
			if (playerCards.get(i).getFaceVal().equalsIgnoreCase("ace")) {
				aces++;
				tempTotal -= 11;
			}
		}
		total = tempTotal;
		if (aces == 1) {
			if (tempTotal + 11 > 21)
				total += 1;
			else if (tempTotal + 11 == 21)
				total += 11;
			else
				total += 11;
		} else if (aces == 2) {
			if (tempTotal + 12 >= 21)
				total += 2;
			else
				total += 12;
		} else if (aces == 3) {
			if (tempTotal + 13 >= 21)
				total += 3;
			else
				total += 13;
		} else if (aces == 4) {
			if (tempTotal + 14 >= 21)
				total += 4;
			else
				total += 14;
		}
		frame.totalAmt.setText("" + total);
	}

	public void updateDealerTotal() {
		int tempTotal = 0;
		int aces = 0;
		for (int i = 0; i < dealerCards.size(); i++) {
			tempTotal += blackjackVal(dealerCards.get(i));
			if (dealerCards.get(i).getFaceVal().equalsIgnoreCase("ace")) {
				aces++;
				tempTotal -= 11;
			}
		}
		dTotal = tempTotal;
		if (aces == 1) {
			if (tempTotal + 11 > 21) 
				dTotal += 1;
			 else if (tempTotal + 11 == 21) 
				dTotal += 11;
			 else 
				dTotal += 11;
		} else if (aces == 2) {
			if (tempTotal + 12 >= 21) 
				dTotal += 2;
			 else 
				dTotal += 12;
		} else if (aces == 3) {
			if (tempTotal + 13 >= 21) 
				dTotal += 3;
			else 
				dTotal += 13;
		} else if (aces == 4) {
			if (tempTotal + 14 >= 21) 
				dTotal += 4;
			 else 
				dTotal += 14;
		}
		
	}

	public String getFileName(Card card) {
		String suit = card.getSuit().substring(0, 1).toLowerCase();
		String number = faceValToNum(card);
		return suit + number + ".png";
	}

	public String faceValToNum(Card card) {
		if (card.getFaceVal().equalsIgnoreCase("ace")) {
			return "1";
		} else if (card.getFaceVal().equalsIgnoreCase("two")) {
			return "2";
		} else if (card.getFaceVal().equalsIgnoreCase("three")) {
			return "3";
		} else if (card.getFaceVal().equalsIgnoreCase("four")) {
			return "4";
		} else if (card.getFaceVal().equalsIgnoreCase("five")) {
			return "5";
		} else if (card.getFaceVal().equalsIgnoreCase("six")) {
			return "6";
		} else if (card.getFaceVal().equalsIgnoreCase("seven")) {
			return "7";
		} else if (card.getFaceVal().equalsIgnoreCase("eight")) {
			return "8";
		} else if (card.getFaceVal().equalsIgnoreCase("nine")) {
			return "9";
		} else if (card.getFaceVal().equalsIgnoreCase("ten")) {
			return "10";
		} else if (card.getFaceVal().equalsIgnoreCase("jack")) {
			return "j";
		} else if (card.getFaceVal().equalsIgnoreCase("queen")) {
			return "q";
		} else if (card.getFaceVal().equalsIgnoreCase("king")) {
			return "k";
		} else {
			return null;
		}
	}

}
