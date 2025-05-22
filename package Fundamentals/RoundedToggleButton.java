package Kofi_Co_Fundamentals;

import java.awt.*;
import javax.swing.JToggleButton;

public class RoundedToggleButton extends JToggleButton {
	    public RoundedToggleButton(int w, int h, String text) {
	        super(text);
	        setFocusPainted(false);
	        setContentAreaFilled(false);
	        setBorderPainted(false);
	        setOpaque(false);
	        Dimension fixedSize = new Dimension(w, h);
	        setPreferredSize(fixedSize);
	        setMinimumSize(fixedSize);
	        setMaximumSize(fixedSize);
	        setSize(fixedSize);

	        setFont(new Font("Poppins", Font.BOLD, 14));
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g.create();
	        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	        if (isSelected()) {
	            g2.setColor(new Color(0x5e3219));
	            setForeground(Color.white);
	        } else {
	            g2.setColor(new Color(200, 200, 200));
	            setForeground(Color.BLACK);
	        }

	        int cornerRadius = 30;
	        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

	        FontMetrics fm = g2.getFontMetrics();
	        int x = (getWidth() - fm.stringWidth(getText())) / 2;
	        int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;

	        g2.setColor(getForeground());
	        g2.drawString(getText(), x, y);

	        g2.dispose();
	    }
	}