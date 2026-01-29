package trApp.trDesktopApp.trForms;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import trApp.trDesktopApp.trCustomControl.PatButton;
import trInfrastructure.AppMSG;

public class AppStart extends JFrame {
    AppMenu   pnlMenu = new AppMenu();
    JPanel    pnlMain = new PExoTrooper();

    public AppStart(String tilteApp) {
        initComponents(tilteApp);

        PatButton btnExo    = new PatButton("ExoTrooper");
        PatButton btnHome   = new PatButton("Home");
        PatButton btnTest   = new PatButton("validar");

        btnExo   .addActionListener(e -> setPanel(new PExoTrooper()));
        btnHome  .addActionListener(e -> setPanel(new PHome()));
        btnTest  .addActionListener(e -> AppMSG.showError("mensaje de error"));

        pnlMenu.addMenuItem(btnExo  );
        pnlMenu.addMenuItem(btnHome );
        pnlMenu.addMenuItem(btnTest );
    }

    private void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(pnlMain);
        pnlMain = formularioPanel;
        container.add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void initComponents(String tilteApp) {
        setTitle(tilteApp);
        setSize(930, 600);
        setResizable(false);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlMain, BorderLayout.CENTER);
        setVisible(true);
    }
}