package trApp.trDesktopApp.trCustomControl;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import trInfrastructure.AppStyle;

public class PatTextBox extends JTextField {

    public PatTextBox() {
        customizeComponent();
    }

    private void customizeComponent() {
        setBorderRect();
        setBorderDownLine();
        setFont(AppStyle.FONT);  
        setForeground(AppStyle.COLOR_FONT_LIGHT);  
        setCaretColor(AppStyle.COLOR_CURSOR);  
        setMargin(new Insets(4, 4, 4, 4));    
        setOpaque(false);                  
        //setUI(new BasicTextFieldUI());        
    }

    public void setBorderRect() {
        Border lineBorder = BorderFactory.createLineBorder(AppStyle.COLOR_BORDER);
        Border emptyBorder = new EmptyBorder(4, 4, 4, 4);  
        setBorder( new CompoundBorder(lineBorder, emptyBorder));
    }

    private void setBorderDownLine(){
        int thickness = 1;
        setBorder(  BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(0, 0, thickness, 0),
                    BorderFactory.createMatteBorder(0, 0, thickness, 0, AppStyle.COLOR_BORDER) 
        ));
    }
}
