package climateactionposter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClimateActionPoster extends JFrame {

    private int points = 0;
    private int trees = 0;

    private JLabel pointsLabel;
    private JLabel treesLabel;

    private final Color darkGreen = new Color(15, 75, 55);
    private final Color lightGreen = new Color(225, 247, 225);
    private final Color skyBlue = new Color(190, 230, 250);

    public ClimateActionPoster() {

        setTitle("SDG 13 - Climate Action");
        setSize(900, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel main = new JPanel(new BorderLayout(12, 12));
        main.setBackground(lightGreen);
        main.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        // HEADER
        JPanel header = new JPanel(new GridLayout(3, 1, 4, 4));
        header.setBackground(darkGreen);
        header.setBorder(BorderFactory.createEmptyBorder(12, 10, 12, 10));

        JLabel sdg = new JLabel(
                "UNITED NATIONS  |  SUSTAINABLE DEVELOPMENT GOAL 13",
                SwingConstants.CENTER);
        sdg.setFont(new Font("Arial", Font.BOLD, 14));
        sdg.setForeground(Color.YELLOW);

        JLabel title = new JLabel(
                "CLIMATE ACTION", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel(
                "PROTECT OUR PLANET • PROTECT OUR FUTURE",
                SwingConstants.CENTER);
        subtitle.setFont(new Font("Arial", Font.BOLD, 16));
        subtitle.setForeground(new Color(190, 255, 210));

        header.add(sdg);
        header.add(title);
        header.add(subtitle);

        // EARTH ILLUSTRATION
        JPanel earthPanel = new JPanel(new BorderLayout(5, 5));
        earthPanel.setBackground(skyBlue);
        earthPanel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JLabel earth = new JLabel(
                "🌍  🌳  ☀️  🌱  🌎",
                SwingConstants.CENTER);
        earth.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 42));

        JLabel slogan = new JLabel(
                "SMALL ACTIONS. BIG IMPACT.",
                SwingConstants.CENTER);
        slogan.setFont(new Font("Arial", Font.BOLD, 23));
        slogan.setForeground(darkGreen);

        JLabel description = new JLabel(
                "Together, let's build a greener tomorrow!",
                SwingConstants.CENTER);
        description.setFont(new Font("Arial", Font.PLAIN, 16));
        description.setForeground(new Color(35, 80, 100));

        JPanel earthText = new JPanel(new GridLayout(2, 1, 3, 3));
        earthText.setBackground(skyBlue);
        earthText.add(slogan);
        earthText.add(description);

        earthPanel.add(earth, BorderLayout.CENTER);
        earthPanel.add(earthText, BorderLayout.SOUTH);

        // ACTION CARDS
        JPanel cards = new JPanel(new GridLayout(2, 2, 12, 12));
        cards.setBackground(lightGreen);

        cards.add(createCard(
                "🌳 PLANT MORE TREES",
                "Grow green spaces.",
                "Protect our forests.",
                new Color(40, 145, 80)));

        cards.add(createCard(
                "⚡ SAVE ENERGY",
                "Switch off unused lights.",
                "Choose clean energy.",
                new Color(40, 120, 200)));

        cards.add(createCard(
                "♻ REDUCE PLASTIC",
                "Use reusable bags.",
                "Recycle whenever possible.",
                new Color(225, 130, 35)));

        cards.add(createCard(
                "💧 SAVE WATER",
                "Avoid wasting water.",
                "Keep rivers and lakes clean.",
                new Color(20, 145, 160)));

        // BUTTONS
        JButton pledgeButton = createButton(
                "💚 TAKE THE CLIMATE PLEDGE",
                darkGreen);

        JButton quizButton = createButton(
                "🧠 PLAY CLIMATE QUIZ",
                new Color(235, 170, 40));

        JButton treeButton = createButton(
                "🌱 PLANT A VIRTUAL TREE",
                new Color(40, 140, 75));

        JButton tipsButton = createButton(
                "🌎 EXPLORE GREEN TIPS",
                new Color(50, 115, 180));

        pledgeButton.addActionListener(e -> takePledge());
        quizButton.addActionListener(e -> playQuiz());
        treeButton.addActionListener(e -> plantTree());
        tipsButton.addActionListener(e -> showTips());

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBackground(lightGreen);
        buttonPanel.add(pledgeButton);
        buttonPanel.add(quizButton);
        buttonPanel.add(treeButton);
        buttonPanel.add(tipsButton);

        // SCORE PANEL
        JPanel scorePanel = new JPanel(new GridLayout(1, 2, 10, 5));
        scorePanel.setBackground(lightGreen);

        pointsLabel = new JLabel(
                "🏆 POINTS: 0", SwingConstants.CENTER);
        pointsLabel.setFont(new Font("Arial", Font.BOLD, 17));
        pointsLabel.setForeground(darkGreen);

        treesLabel = new JLabel(
                "🌳 TREES: 0", SwingConstants.CENTER);
        treesLabel.setFont(new Font("Arial", Font.BOLD, 17));
        treesLabel.setForeground(darkGreen);

        scorePanel.add(pointsLabel);
        scorePanel.add(treesLabel);

        JPanel bottom = new JPanel(new BorderLayout(8, 8));
        bottom.setBackground(lightGreen);
        bottom.add(buttonPanel, BorderLayout.CENTER);
        bottom.add(scorePanel, BorderLayout.SOUTH);

        // LAYOUT
        JPanel center = new JPanel(new BorderLayout(12, 12));
        center.setBackground(lightGreen);
        center.add(earthPanel, BorderLayout.NORTH);
        center.add(cards, BorderLayout.CENTER);

        main.add(header, BorderLayout.NORTH);
        main.add(center, BorderLayout.CENTER);
        main.add(bottom, BorderLayout.SOUTH);

        setContentPane(main);
    }

    private JPanel createCard(
            String heading, String line1, String line2, Color color) {

        JPanel card = new JPanel(new GridLayout(3, 1, 5, 5));
        card.setBackground(Color.WHITE);

        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(color, 3),
                BorderFactory.createEmptyBorder(12, 8, 12, 8)));

        JLabel title = new JLabel(heading, SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 17));
        title.setForeground(color);

        JLabel text1 = new JLabel(line1, SwingConstants.CENTER);
        text1.setFont(new Font("Arial", Font.PLAIN, 15));
        text1.setForeground(new Color(45, 65, 55));

        JLabel text2 = new JLabel(line2, SwingConstants.CENTER);
        text2.setFont(new Font("Arial", Font.PLAIN, 15));
        text2.setForeground(new Color(45, 65, 55));

        card.add(title);
        card.add(text1);
        card.add(text2);

        return card;
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(250, 48));
        return button;
    }

    private void takePledge() {
        int answer = JOptionPane.showConfirmDialog(
                this,
                "I pledge to protect nature, save energy,\n"
                + "reduce waste and care for our planet.\n\n"
                + "Do you accept the Climate Action Pledge?",
                "Climate Action Pledge",
                JOptionPane.YES_NO_OPTION);

        if (answer == JOptionPane.YES_OPTION) {
            points += 10;
            updateScore();

            JOptionPane.showMessageDialog(
                    this,
                    "Thank you, Climate Hero! 🌍\n"
                    + "You earned 10 points!",
                    "Pledge Accepted",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void plantTree() {
        trees++;
        points += 5;
        updateScore();

        JOptionPane.showMessageDialog(
                this,
                "🌳 Wonderful!\n"
                + "Your virtual forest is growing!\n"
                + "Trees planted: " + trees,
                "Plant a Tree",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void playQuiz() {
        String[] options = {
            "Plant more trees",
            "Waste electricity",
            "Throw plastic into rivers"
        };

        int answer = JOptionPane.showOptionDialog(
                this,
                "Which action helps fight climate change?",
                "Climate Quiz",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (answer == 0) {
            points += 5;
            updateScore();

            JOptionPane.showMessageDialog(
                    this,
                    "Correct answer! 🌱\nYou earned 5 points!");
        } else if (answer >= 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Not quite! Planting trees helps protect our planet.");
        }
    }

    private void showTips() {
        JOptionPane.showMessageDialog(
                this,
                "🌍 FIVE WAYS TO PROTECT OUR PLANET\n\n"
                + "🌳 Plant and protect trees.\n"
                + "⚡ Switch off unused lights.\n"
                + "♻ Reduce, reuse and recycle.\n"
                + "💧 Save water every day.\n"
                + "🚲 Walk, cycle or use public transport.",
                "Green Tips",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateScore() {
        pointsLabel.setText("🏆 POINTS: " + points);
        treesLabel.setText("🌳 TREES: " + trees);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ClimateActionPoster().setVisible(true);
        });
    }
}
