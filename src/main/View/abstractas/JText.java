package main.View.abstractas;

import java.awt.*;
import javax.swing.JTextField;

public class JText extends JTextField {
    protected String placeholder;

    public JText(int columns) {  
        super(columns);
    }
    public void setPlaceholder(String placeholder){
        this.setText(placeholder); 
        this.placeholder = placeholder;
    }
}
