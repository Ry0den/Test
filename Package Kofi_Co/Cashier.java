package Kofi_Co;

import javax.swing.*;
import java.awt.*;
import Kofi_Co_Fundamentals.*;

public class Cashier extends JFrame {
	JPanel MainPanel = new JPanel();
	JPanel ContentPanel = new JPanel();
	JLabel KofiLabel = new JLabel();
	JLabel TotalLabel = new JLabel();
	JLabel ChangeLabel = new JLabel();
	JLabel total = new JLabel();
	JLabel cost = new JLabel();
	JLabel changelabel = new JLabel();
	JLabel change = new JLabel();
	JLabel ReceiptNo = new JLabel();
	JLabel PaymentAm = new JLabel();
	JTextField receipt = new RoundedJtextfield(5);
	JTextField amountField = new RoundedJtextfield(10);
	private JTextField activeField;
	double totalAmount = 0.00;
	ImportedFonts IMPFonts = new ImportedFonts();

	Cashier() {
		CashierFrame();
		CashierComponents();
		updateReceiptWithTotal();
	}

	public void CashierFrame() {
		IMPFonts.Fonts();

		ImageIcon KofiIcon = new ImageIcon("Kofi.png");
		setTitle("Kofi Co. | Cashier");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(KofiIcon.getImage());

		add(MainPanel);
		setVisible(true);
	}

	public void CashierComponents() {
		IMPFonts.Fonts();

		MainPanel.setBackground(Color.WHITE);
		MainPanel.setLayout(null);

		KofiLabel.setText("K. Co");
		KofiLabel.setForeground(new Color(0x5e3219));
		KofiLabel.setFont(new Font("Gugi", Font.BOLD, 50));
		KofiLabel.setBounds(30, 30, 180, 60);
		MainPanel.add(KofiLabel);

		total.setText("Total:");
		total.setFont(new Font("Poppins Regular", Font.PLAIN, 30));
		total.setBounds(260, 100, 250, 30);
		total.setForeground(Color.BLACK);
		MainPanel.add(total);

		changelabel.setText("Change:");
		changelabel.setFont(new Font("Poppins Regular", Font.PLAIN, 30));
		changelabel.setBounds(260, 144, 200, 35);
		changelabel.setForeground(Color.BLACK);
		MainPanel.add(changelabel);

		change.setText("0.00");
		change.setFont(new Font("Poppins Regular", Font.PLAIN, 30));
		change.setBounds(390, 146, 100, 30);
		change.setForeground(Color.BLACK);
		MainPanel.add(change);

		ReceiptNo.setText("Receipt No.");
		ReceiptNo.setFont(new Font("Poppins Regular", Font.PLAIN, 30));
		ReceiptNo.setBounds(30, 144, 170, 30);
		ReceiptNo.setForeground(Color.BLACK);
		MainPanel.add(ReceiptNo);

		PaymentAm.setText("Amount");
		PaymentAm.setFont(new Font("Poppins Regular", Font.PLAIN, 30));
		PaymentAm.setBounds(30, 244, 190, 30);
		PaymentAm.setForeground(Color.BLACK);
		MainPanel.add(PaymentAm);

		receipt.setFont(new Font("Poppins Regular", Font.PLAIN, 30));
		receipt.setBounds(30, 179, 200, 45);
		receipt.setHorizontalAlignment(JTextField.CENTER);
		receipt.setEditable(false);
		receipt.setFocusable(true);
		receipt.setForeground(Color.BLACK);
		receipt.setBackground(new Color(0xE7E5E5));
		receipt.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		receipt.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				setActiveField(receipt);
			}
		});
		MainPanel.add(receipt);

		amountField.setFont(new Font("Poppins Regular", Font.PLAIN, 30));
		amountField.setBounds(30, 275, 200, 45);
		amountField.setHorizontalAlignment(JTextField.CENTER);
		amountField.setEditable(false);
		amountField.setForeground(Color.BLACK);
		amountField.setFocusable(true);
		amountField.setBackground(new Color(0xE7E5E5));
		amountField.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
						BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		amountField.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				setActiveField(amountField);
			}
		});
		MainPanel.add(amountField);

		setActiveField(amountField);

		JPanel padPanel = new JPanel(new GridLayout(4, 3, 5, 5));
		padPanel.setBounds(230, 200, 250, 180);
		padPanel.setBackground(Color.WHITE);
		MainPanel.add(padPanel);

		String[] buttons = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "C", "0", "X" };

		for (String label : buttons) {
			JButton btn = new JButton(label);
			btn.setFont(new Font("Poppins Regular", Font.PLAIN, 20));
			btn.setOpaque(false);
			btn.setForeground(Color.BLACK);
			btn.setContentAreaFilled(false);
			btn.setBorderPainted(false);
			btn.setFocusable(false);
			btn.addActionListener(e -> handleInput(label));
			padPanel.add(btn);
		}

		JButton confirmButton = new RoundedButton();
		confirmButton.setFocusable(false);
		confirmButton.setBorderPainted(false);
		confirmButton.setText("Confirm");
		confirmButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		confirmButton.setBounds(340, 400, 120, 45);
		confirmButton.setBackground(new Color(0x5e3219));
		confirmButton.setForeground(Color.WHITE);
		confirmButton.addActionListener(e -> {
			try {
				String receiptText = receipt.getText().trim();
				if (receiptText.isEmpty()) {
					JOptionPane.showMessageDialog(this, "Please enter a receipt number!", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				double amount = Double.parseDouble(amountField.getText());
				double change = amount - totalAmount;
				if (change >= 0) {
					this.change.setText(String.format("%.2f", change));
					total.setText(String.format("Total: %.2f", totalAmount));
				} else {
					JOptionPane.showMessageDialog(this, "Insufficient payment amount!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Please enter a valid payment amount!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		MainPanel.add(confirmButton);

		MainPanel.setVisible(true);
		revalidate();
		repaint();
	}

	private void setActiveField(JTextField field) {
		activeField = field;
		receipt.setBackground(field == receipt ? new Color(0xD0D0D0) : new Color(0xE7E5E5));
		amountField.setBackground(field == amountField ? new Color(0xD0D0D0) : new Color(0xE7E5E5));
	}

	private void updateReceiptWithTotal() {
		receipt.setText("");
		if (receipt.getText().equals("002")) {
			totalAmount = 240.00;
		} else if (receipt.getText().equals("001")) {
			totalAmount = 85.50;
		}
		total.setText(String.format("Total: %.2f", totalAmount));
	}

	public void handleInput(String input) {
		if (activeField == null) {
			setActiveField(amountField);
		}

		String current = activeField.getText();
		
		switch (input) {
			case "C":
				activeField.setText("");
				break;
			case "X":
				if (!current.isEmpty()) {
					current = current.substring(0, current.length() - 1);
					activeField.setText(current);
				}
				break;
			default:
				if (input.matches("[0-9]")) {
					int maxLength = (activeField == receipt) ? 3 : 7;
					if (current.length() < maxLength) {
						current += input;
						activeField.setText(current);
						if (activeField == receipt && current.equals("002")) {
							totalAmount = 240.00;
							total.setText(String.format("Total: %.2f", totalAmount));
						} else if (activeField == receipt && current.equals("001")) {
							totalAmount = 85.50;
							total.setText(String.format("Total: %.2f", totalAmount));
						}
					}
				}
				break;
		}
	}

	public void setTotal(double amount) {
		totalAmount = 85.50;
		cost.setText(String.format("%.2f", 85.50));
		updateReceiptWithTotal();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new Cashier());
	}
}