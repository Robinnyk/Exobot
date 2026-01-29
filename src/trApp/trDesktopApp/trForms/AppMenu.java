package trApp.trDesktopApp.trForms;

import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import trApp.trDesktopApp.trCustomControl.PatButton;
import trInfrastructure.AppConfig;


public class AppMenu extends JPanel {
    private final List<PatButton> menuItems = new ArrayList<>();
    private final JPanel buttonsPanel = new JPanel();

    public AppMenu() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(250, getHeight()));

        try {
            Image logo = ImageIO.read(AppConfig.getImgMain());
            logo = logo.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            add(new JLabel(new ImageIcon(logo)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        add(buttonsPanel);

        add(Box.createVerticalGlue());
        add(new JLabel(" ──❰ 🤖 ❱── EXOBOT"));
    }

    public void addMenuItem(PatButton button) {
        menuItems.add(button);
        buttonsPanel.add(button);
        buttonsPanel.revalidate();
        buttonsPanel.repaint();
    }

    public List<PatButton> getMenuItems() {
        return menuItems;
    }
}
