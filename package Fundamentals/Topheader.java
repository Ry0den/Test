package Kofi_Co_Fundamentals;

import javax.swing.*;
import java.awt.*;

public class Topheader extends JPanel {
	
	CardLayout cardLayout = new CardLayout();
	JPanel cardPanel = new JPanel(cardLayout);
	JButton backbutton = new JButton();
	JButton backbuttonarrow = new JButton();
	ImportedFonts IMPFonts = new ImportedFonts();

	public void Topheadercomps() {
		IMPFonts.Fonts();		
		this.setLayout(null);
		this.setBounds(0, 0, 700, 70);
		this.setBackground(Color.WHITE);
		
		backbutton.setOpaque(false);
		backbutton.setContentAreaFilled(false);
		backbutton.setBorderPainted(false);
		backbutton.setFocusable(false);
		backbutton.setText("<");
		backbutton.setFont(new Font("Advent Pro", Font.PLAIN, 45));
		backbutton.setBounds(30, 40, 60, 30);
		this.add(backbutton);
		
		backbutton.addActionListener(e -> cardLayout.show(cardPanel, "menu"));
		}
	
	public JButton getBackButton() {
		return backbutton;
	}
	
	public void setCardLayout(CardLayout layout, JPanel panel) {
		this.cardLayout = layout;
		this.cardPanel = panel;
	}
}