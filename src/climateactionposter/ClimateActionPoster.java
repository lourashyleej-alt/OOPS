package climateactionposter;

import javax.swing.*;
import java.awt.*;

public class ClimateActionPoster extends JFrame {

    public ClimateActionPoster() {
        setTitle("SDG 13 - Climate Action");
        setSize(1050, 780);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(new Color(245, 240, 230));

        // TOP BANNER
        JPanel topBanner = new JPanel(new BorderLayout());
        topBanner.setBackground(new Color(19, 69, 53));
        topBanner.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));
        JLabel title = new JLabel("SDG 13 CLIMATE ACTION", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI Black", Font.BOLD, 38));
        title.setForeground(Color.WHITE);
        JLabel subTitle = new JLabel("Take Urgent Action to Combat Climate Change", SwingConstants.CENTER);
        subTitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subTitle.setForeground(new Color(220, 220, 220));
        subTitle.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));
        topBanner.add(title, BorderLayout.CENTER);
        topBanner.add(subTitle, BorderLayout.SOUTH);

        // CENTER TEXT
        JPanel centerLabelPanel = new JPanel(new BorderLayout());
        centerLabelPanel.setBackground(new Color(245, 240, 230));
        centerLabelPanel.setBorder(BorderFactory.createEmptyBorder(25, 20, 15, 20));
        JLabel goalText = new JLabel("<html><center>Goal 13: Strengthen resilience and adaptive capacity to<br>climate-related hazards and natural disasters</center></html>", SwingConstants.CENTER);
        goalText.setFont(new Font("Segoe UI", Font.BOLD, 16));
        goalText.setForeground(new Color(19, 69, 53));
        centerLabelPanel.add(goalText, BorderLayout.CENTER);

        // 3 CARDS
        JPanel cardsPanel = new JPanel(new GridLayout(1, 3, 25, 0));
        cardsPanel.setBackground(new Color(245, 240, 230));
        cardsPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));
        cardsPanel.add(createPremiumCard("Reduce\nEmissions", "Lower carbon footprint through sustainable energy, efficient transport, and low-emission practices.", 0));
        cardsPanel.add(createPremiumCard("Plant Trees", "Restore forests and green spaces to absorb CO2 and protect biodiversity.", 1));
        cardsPanel.add(createPremiumCard("Recycle", "Promote circular economy by reusing materials and reducing waste.", 2));

        JPanel middleWrapper = new JPanel(new BorderLayout());
        middleWrapper.setBackground(new Color(245, 240, 230));
        middleWrapper.add(centerLabelPanel, BorderLayout.NORTH);
        middleWrapper.add(cardsPanel, BorderLayout.CENTER);

        // WHY IT MATTERS
        JPanel whyPanel = new JPanel(new BorderLayout());
        whyPanel.setBackground(new Color(245, 240, 230));
        whyPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1,0,0,0,new Color(200,200,200)),
            BorderFactory.createEmptyBorder(20,30,20,30)
        ));
        JLabel whyTitle = new JLabel("Why It Matters:");
        whyTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        whyTitle.setForeground(new Color(19, 69, 53));
        JTextArea whyText = new JTextArea("Climate change impacts communities worldwide — increasing extreme weather, rising sea levels, and loss of ecosystems. Immediate action is critical to secure a sustainable future for all.");
        whyText.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        whyText.setLineWrap(true);
        whyText.setWrapStyleWord(true);
        whyText.setEditable(false);
        whyText.setOpaque(false);
        whyPanel.add(whyTitle, BorderLayout.NORTH);
        whyPanel.add(whyText, BorderLayout.CENTER);

        // FOOTER
        JPanel footer = new JPanel(new BorderLayout());
        footer.setBackground(new Color(19, 69, 53));
        footer.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        JLabel leftFoot = new JLabel("United Nations Sustainable Development Goal 13");
        leftFoot.setForeground(Color.WHITE);
        leftFoot.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        JLabel rightFoot = new JLabel("Act Now • Measure • Reduce • Restore • Advocate");
        rightFoot.setForeground(Color.WHITE);
        rightFoot.setFont(new Font("Segoe UI", Font.BOLD, 12));
        footer.add(leftFoot, BorderLayout.WEST);
        footer.add(rightFoot, BorderLayout.EAST);

        main.add(topBanner, BorderLayout.NORTH);
        main.add(middleWrapper, BorderLayout.CENTER);
        main.add(whyPanel, BorderLayout.SOUTH);
        
        JPanel root = new JPanel(new BorderLayout());
        root.add(main, BorderLayout.CENTER);
        root.add(footer, BorderLayout.SOUTH);
        add(root);
    }

    private JPanel createPremiumCard(String title, String desc, int type) {
        JPanel card = new JPanel(new BorderLayout(10,10)) {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(0,0,0,20));
                g2.fillRoundRect(4, 4, getWidth()-8, getHeight()-8, 20, 20);
                g2.setColor(Color.WHITE);
                g2.fillRoundRect(0, 0, getWidth()-4, getHeight()-4, 20, 20);
            }
        };
        card.setOpaque(false);
        card.setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20));

        // ICON - Drawn with shapes, no unicode
        JPanel iconPanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D)g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(19, 69, 53));
                g2.fillOval(10, 5, 100, 100);
                g2.setColor(Color.WHITE);
                g2.setStroke(new BasicStroke(3));
                
                if(type==0){ // CO2
                    g2.setFont(new Font("Segoe UI", Font.BOLD, 20));
                    g2.drawString("CO2", 35, 68);
                    g2.drawLine(45, 35, 45, 50);
                    g2.drawLine(35, 42, 45, 50);
                    g2.drawLine(55, 42, 45, 50);
                } else if(type==1){ // TREE
                    g2.fillRect(56, 70, 8, 18);
                    g2.fillOval(40, 30, 40, 35);
                    g2.setColor(new Color(19, 69, 53));
                    g2.fillOval(45, 35, 30, 25);
                    g2.setColor(Color.WHITE);
                    g2.fillOval(50, 40, 20, 15);
                } else { // RECYCLE ARROWS
                    g2.drawArc(35, 30, 50, 30, 0, 220);
                    g2.drawLine(75, 40, 85, 45);
                    g2.drawLine(75, 40, 70, 52);
                    g2.drawArc(35, 35, 50, 50, 210, 220);
                    g2.drawLine(45, 75, 35, 70);
                    g2.drawLine(45, 75, 50, 63);
                }
            }
        };
        iconPanel.setPreferredSize(new Dimension(120, 120));
        iconPanel.setOpaque(false);

        JLabel titleLabel = new JLabel("<html><center>" + title.replace("\n", "<br>") + "</center></html>", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(new Color(19, 69, 53));

        JTextArea descArea = new JTextArea(desc);
        descArea.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        descArea.setEditable(false);
        descArea.setOpaque(false);
        descArea.setForeground(Color.DARK_GRAY);

        JPanel center = new JPanel(new BorderLayout());
        center.setOpaque(false);
        center.add(iconPanel, BorderLayout.NORTH);
        center.add(titleLabel, BorderLayout.CENTER);
        center.add(descArea, BorderLayout.SOUTH);

        card.add(center, BorderLayout.CENTER);
        return card;
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); } catch(Exception ignored){}
        SwingUtilities.invokeLater(() -> new ClimateActionPoster().setVisible(true));
    }
}