package Kofi_Co_Fundamentals;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class SetUpOptionsPanel {
	public ArrayList<RoundedToggleButton[]> optionGroups = new ArrayList<>(); 	
	public ArrayList<JLabel[]> priceLabel = new ArrayList<>(); 	
	
	public JPanel setupOptionsPanel(int row, int col, int w, int h, int width, int count, String[] pic, String[] bLabel, String[] sizePrice) {
	    Font bFont = new Font("Poppins SemiBold", Font.PLAIN, 17);
	    Font pFont = new Font("Open Sans", Font.PLAIN, 14);
	
	    RoundedToggleButton[] groupB = new RoundedToggleButton[count];
	    JLabel[] groupL = new JLabel[count];
	
	    JPanel gridPanel = new JPanel(new GridLayout(row, col, 10, 0));
	    gridPanel.setOpaque(false);
	    gridPanel.setMaximumSize(new Dimension(width, Integer.MAX_VALUE));
	
	    ButtonGroup groupBtn = new ButtonGroup();
	    
	    for (int i = 0; i < count; i++) {
	        JPanel wrapperPanel = new JPanel();
	        wrapperPanel.setLayout(new BoxLayout(wrapperPanel, BoxLayout.Y_AXIS));
	        wrapperPanel.setOpaque(false);
	
	        String labelB = bLabel[i];
	        String labelP = sizePrice[i];
	        String picIm = pic[i];
	
	        ImageIcon image = new ImageIcon(picIm);
	        JLabel img = new JLabel(image);
	
	        JLabel price = new JLabel();
	        if (labelP == null || labelP.trim().isEmpty()) {
	            price.setText(""); // no price
	        } else {
	            price.setText("₱" + labelP);
	        }
	
	        RoundedToggleButton button = new RoundedToggleButton(w, h, labelB);
	        button.setFont(bFont);
	        price.setFont(pFont);
	
	        img.setAlignmentX(Component.CENTER_ALIGNMENT);
	        button.setAlignmentX(Component.CENTER_ALIGNMENT);
	        price.setAlignmentX(Component.CENTER_ALIGNMENT);
	
	        if (labelB == null || labelB.trim().isEmpty()) {
	            button.setVisible(false);
	            img.setVisible(false);
	            price.setVisible(false);
	        } else {
	            groupBtn.add(button);
	        }
	
	        wrapperPanel.add(img);
	        wrapperPanel.add(Box.createVerticalStrut(5));
	        wrapperPanel.add(button);
	        wrapperPanel.add(Box.createVerticalStrut(5));
	        wrapperPanel.add(price);
	
	        gridPanel.add(wrapperPanel);
	
	        groupB[i] = button;
	        groupL[i] = price;
	    }
	
	    optionGroups.add(groupB);
	    priceLabel.add(groupL);
	
	    return gridPanel;
	}
}