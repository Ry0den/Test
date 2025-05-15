package Kofi_Co_Fundamentals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BackButton extends JButton {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private String previousPage;
    private JPanel headerPanel;

    public BackButton() {

        headerPanel = new JPanel(null);
        headerPanel.setBackground(Color.YELLOW);
        headerPanel.setBounds(0, 0, 700, 70);

        setText("<");
        setFont(new Font("Advent Pro", Font.PLAIN, 45));
        setBounds(30, 40, 60, 30);
        setFocusable(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setForeground(Color.BLACK);

        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                setForeground(Color.GRAY);
            }
            public void mouseExited(MouseEvent e) {
                setForeground(Color.BLACK);
            }
        });

        headerPanel.add(this);
    }

    public JPanel getHeaderPanel() {
        return headerPanel;
    }

    public void setNavigation(CardLayout layout, JPanel panel, String previousPage) {
        this.cardLayout = layout;
        this.cardPanel = panel;
        this.previousPage = previousPage;
        addActionListener(e -> cardLayout.show(cardPanel, previousPage));
    }
} 