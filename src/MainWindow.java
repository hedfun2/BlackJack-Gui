import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class MainWindow extends JFrame implements ActionListener {

	JLabel slot1;
	JLabel slot2;
	JLabel slot3;
	JLabel slot4;
	JLabel slot5;
	JLabel slot6;
	JLabel dSlot6;
	JLabel dSlot5;
	JLabel dSlot4;
	JLabel dSlot3;
	JLabel dSlot2;
	JLabel dSlot1;
	JLabel totalL;
	JLabel dTotal;
	JLabel infoL;
	JLabel dTotalAmt;
	JLabel totalAmt;	
	JButton hitB;
	JButton standB;
	JLabel balanceL;
	JButton betB;
	JLabel amtL;
	JTextField betTF;
	JButton resetB;
	Color textColor = new Color(230, 230, 230);
	Color backgroundColor = new Color(51, 51, 51);
	Color componentColor = new Color(102, 102, 102);
	Game game;

	public MainWindow() {
		initComponents();
		game = new Game(this);
	}

	public void placePlayerCard(int slot, String fileName) {
		if (slot == 1) {
			slot1.setIcon(new ImageIcon("images/" + fileName));
		} else if (slot == 2) {
			slot2.setIcon(new ImageIcon("images/" + fileName));
		} else if (slot == 3) {
			slot3.setIcon(new ImageIcon("images/" + fileName));
		} else if (slot == 4) {
			slot4.setIcon(new ImageIcon("images/" + fileName));
		} else if (slot == 5) {
			slot5.setIcon(new ImageIcon("images/" + fileName));
		} else if (slot == 6) {
			slot6.setIcon(new ImageIcon("images/" + fileName));
		}
	}

	public void placeDealerCard(int slot, String fileName) {
		if (slot == 1) {
			dSlot1.setIcon(new ImageIcon("images/" + fileName));
		} else if (slot == 2) {
			dSlot2.setIcon(new ImageIcon("images/" + fileName));
		} else if (slot == 3) {
			dSlot3.setIcon(new ImageIcon("images/" + fileName));
		} else if (slot == 4) {
			dSlot4.setIcon(new ImageIcon("images/" + fileName));
		} else if (slot == 5) {
			dSlot5.setIcon(new ImageIcon("images/" + fileName));
		} else if (slot == 6) {
			dSlot6.setIcon(new ImageIcon("images/" + fileName));
		}
	}

	public void gameOver() {
		hitB.setEnabled(false);
		standB.setEnabled(false);
		betB.setEnabled(false);
		resetB.setEnabled(true);
	}

	public void reset(){
		hitB.setEnabled(false);
		standB.setEnabled(false);
		betB.setEnabled(true);
		resetB.setEnabled(false);
		infoL.setText("Place bet to start");
		dTotalAmt.setText("");
		totalAmt.setText("");
		betTF.setEnabled(true);
		slot1.setIcon(null);
		slot2.setIcon(null);
		slot3.setIcon(null);
		slot4.setIcon(null);
		slot5.setIcon(null);
		slot6.setIcon(null);
		dSlot6.setIcon(null);
		dSlot5.setIcon(null);
		dSlot4.setIcon(null);
		dSlot3.setIcon(null);
		dSlot2.setIcon(null);
		dSlot1.setIcon(null);
	}
	
	public boolean isRealBet() {
		try {
			Double.parseDouble(betTF.getText());
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == betB) {
			if (!isRealBet()) {
				infoL.setText("Enter A Number");
				return;
			}
			if (Double.parseDouble(betTF.getText()) > game.amount) {
				infoL.setText("Not Enough Money");
				return;
			}
			hitB.setEnabled(true);
			standB.setEnabled(true);
			betB.setEnabled(false);
			game.betSize = Double.parseDouble(betTF.getText());
			game.amount -= game.betSize;
			amtL.setText(game.amount + "");
			betTF.setEnabled(false);
			infoL.setText("");
			game.firstDeal();
		} else if (e.getSource() == hitB) {
			game.dealPlayer();
		} else if (e.getSource() == standB) {
			game.stand();
		} else if(e.getSource() == resetB){
			reset();
			game.reset();
		}

	}

	public void initComponents() {
		JPanel contentPane;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(backgroundColor);
		setVisible(true);
		slot1 = new JLabel("");
		slot2 = new JLabel("");
		slot3 = new JLabel("");
		slot4 = new JLabel("");
		slot5 = new JLabel("");
		slot6 = new JLabel("");
		dSlot6 = new JLabel("");
		dSlot5 = new JLabel("");
		dSlot4 = new JLabel("");
		dSlot3 = new JLabel("");
		dSlot2 = new JLabel("");
		dSlot1 = new JLabel("");

		infoL = new JLabel("Place bet to start");
		totalL = new JLabel("Total:");
		dTotal = new JLabel("Total:");
		hitB = new JButton("Hit");
		standB = new JButton("Stand");
		balanceL = new JLabel("Balance: ");
		betB = new JButton("Bet");
		amtL = new JLabel("1000.0");
		betTF = new JTextField("");
		resetB = new JButton("Reset");
		totalAmt = new JLabel("");
		dTotalAmt = new JLabel("");
		resetB.setEnabled(false);

		hitB.setEnabled(false);
		standB.setEnabled(false);
		
		hitB.setBorder(null);
		standB.setBorder(null);
		betTF.setBorder(null);
		betB.setBorder(null);
		resetB.setBorder(null);

		hitB.addActionListener(this);
		standB.addActionListener(this);
		betB.addActionListener(this);
		resetB.addActionListener(this);

		hitB.setBackground(componentColor);
		hitB.setForeground(textColor);
		standB.setBackground(componentColor);
		standB.setForeground(textColor);
		totalL.setForeground(textColor);
		dTotal.setForeground(textColor);
		infoL.setForeground(textColor);
		balanceL.setForeground(textColor);
		betB.setBackground(componentColor);
		betB.setForeground(textColor);
		amtL.setForeground(textColor);
		betTF.setBackground(componentColor);
		betTF.setForeground(textColor);
		totalAmt.setForeground(textColor);
		dTotalAmt.setForeground(textColor);
		resetB.setBackground(componentColor);
		resetB.setForeground(textColor);

		totalL.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 24));
		dTotal.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 24));
		hitB.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		resetB.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		standB.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		infoL.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 12));
		balanceL.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		betB.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		amtL.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		totalAmt.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		dTotalAmt.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		betTF.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 18));
		betTF.setColumns(10);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(149)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(betB, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(betTF, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(resetB, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(dSlot1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(dSlot2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(dSlot3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(dSlot4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(2)
							.addComponent(dSlot5, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(dSlot6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(hitB, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(standB, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(infoL, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(dTotal, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(balanceL, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(dTotalAmt, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
								.addComponent(amtL, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(totalL, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(slot1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(slot2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(slot3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(slot4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addGap(2)
									.addComponent(slot5, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(slot6, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
								.addComponent(totalAmt, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE))))
					.addGap(180))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(dSlot1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(dSlot2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(dSlot3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(dSlot4, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(dSlot5, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(dSlot6, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(dTotal, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(dTotalAmt, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(balanceL, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(amtL, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(betB, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(betTF, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(resetB, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(hitB, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(standB, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(infoL, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(totalL, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(totalAmt, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(slot2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addComponent(slot3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
									.addComponent(slot5, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addComponent(slot1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
							.addComponent(slot6, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(slot4, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
