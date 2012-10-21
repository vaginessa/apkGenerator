
package _apkGenerator;

import Semantics.Controls.*;
import java.util.Random;

public class RandomControlGenerator 
{
    // Based on my Cell phone WxH 480x800
    private final static int width = 480;
    private final static int height = 800;
    private final static int controlWidth = 100;
    private final static int controlHeight = 50;
    
    // DontTouch
    private static int correlative = 0;
    public static Random rand = new Random();
    
    public static Button generateButton()
    {
        String name = "btn";
        Button btn = (Button) getControl(name);
        btn.setValue(name+correlative);
        return btn;
    }
    
    public static Label generateLabel()
    {
        String name = "lbl";
        Label lbl = (Label) getControl(name);
        lbl.setValue(name+correlative);
        return lbl;
    }
    
    public static TextBox generateTextBox()
    {
        String name = "txt";
        TextBox txt = (TextBox) getControl(name);
        txt.setValue(name+correlative);
        return txt;
    }
    
    public static CheckBox generateCheckBox()
    {
        String name = "chkBox";
        CheckBox chkBox = (CheckBox) getControl(name);
        chkBox.setText(name+correlative);
        //chkBox.setDirection();
        chkBox.setChecked(rand.nextBoolean());
        return chkBox;
    }
    
    public static DatePicker generateDatePicker()
    {
        String name = "datePicker";
        DatePicker datePicker = (DatePicker) getControl(name);
        return datePicker;
    }
    
    public static RadioButton generateRadioButton()
    {
        String name = "radioBtn";
        RadioButton radioBtn = (RadioButton) getControl(name);
        radioBtn.setChecked(rand.nextBoolean());
        radioBtn.setText(name+correlative);
        return radioBtn;
    }
        
    private static Control getControl(String name)
    {
        Control control = new Control();
        control.setX(rand.nextInt(width)); 
        control.setY(rand.nextInt(height));
        control.setName(name+(correlative++));
        control.setWidth(rand.nextInt(controlWidth));
        control.setHeight(rand.nextInt(controlHeight));
        control.setEnabled(rand.nextBoolean());
        // No need to randomize this attribute
        // But if you do, copy this line: rand.nextBoolean()
        control.setVisible(true);
        return control;
    }
    
}
