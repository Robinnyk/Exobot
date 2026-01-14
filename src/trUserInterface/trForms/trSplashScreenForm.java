package trUserInterface.trForms;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import trUserInterface.IAStyle;

public abstract class trSplashScreenForm {

    private static JFrame splashScreenForm;
    private static JProgressBar splashProgressBar;
    private static ImageIcon imagenIcon;
    private static JLabel lblSplash;

    public static void show(){

        imagenIcon = new ImageIcon(IAStyle.URL_SPLASH);
        lblSplash = new JLabel(imagenIcon);
        splashProgressBar = new JProgressBar(0,100);

        splashProgressBar.setStringPainted(true);

        splashScreenForm = new JFrame();
        splashScreenForm.setUndecorated(true);
        splashScreenForm.getContentPane().add(lblSplash, BorderLayout.CENTER);
        splashScreenForm.add(splashProgressBar, BorderLayout.SOUTH);
        splashScreenForm.setSize(imagenIcon.getIconWidth(), imagenIcon.getIconHeight());
        splashScreenForm.setLocationRelativeTo(null);   // Centrar en pantalla.

        splashScreenForm.setVisible(true);

        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50); // Esperar 50 milisegundos.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            splashProgressBar.setValue(i);
        }
        
        splashScreenForm.setVisible(false);

    }

}
