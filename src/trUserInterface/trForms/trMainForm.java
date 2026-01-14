package trUserInterface.trForms;

import java.awt.Container;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import trUserInterface.IAStyle;

public class trMainForm extends JFrame{

    trMenuPanel menuPanel = new trMenuPanel();
    JPanel mainPanel = new trMainPanel();

    public trMainForm(String tittleApp) {
       customizeComponent(tittleApp);
       menuPanel.btnHome.addActionListener(e -> setPanel(new trMainPanel()));
       menuPanel.btnLogin.addActionListener(e -> setPanel(new LoginPanel()));
       menuPanel.btnSexo.addActionListener(e -> setPanel(new SexoPanel()));
       menuPanel.btnLocalidad.addActionListener(e -> setPanel(new trMainPanel()));
       // Agregar
       menuPanel.btnTest.addActionListener(e -> {IAStyle.showMsgError("Mensaje de Error");});
    }

    private void setPanel (JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(mainPanel);
        mainPanel = formularioPanel;
        container.add(mainPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    private void customizeComponent(String tittleApp) {
        setTitle(tittleApp);
        setSize(930, 800);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar en pantalla.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Crear un contenedor para los dos paneles usando BorderLayout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Agregar los paneles al contenedor
        container.add(menuPanel, BorderLayout.WEST);
        container.add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
        
    }

}
