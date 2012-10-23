
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
        Button btn = new Button();
        
        btn.setX(rand.nextInt(width)); 
        btn.setY(rand.nextInt(height));
        btn.setName(name+(correlative++));
        btn.setWidth(rand.nextInt(controlWidth));
        btn.setHeight(rand.nextInt(controlHeight));
        btn.setEnabled(rand.nextBoolean());
        btn.setVisible(true);
        
        btn.setValue(name+correlative);
        return btn;
    }
    
    public static Label generateLabel()
    {
        String name = "lbl";
        Label lbl = new Label();
        
        lbl.setX(rand.nextInt(width)); 
        lbl.setY(rand.nextInt(height));
        lbl.setName(name+(correlative++));
        lbl.setWidth(rand.nextInt(controlWidth));
        lbl.setHeight(rand.nextInt(controlHeight));
        lbl.setEnabled(rand.nextBoolean());
        lbl.setVisible(true);
        
        lbl.setValue(name+correlative);
        return lbl;
    }
    
    public static TextBox generateTextBox()
    {
        String name = "txt";
        TextBox txt = new TextBox();
        
        txt.setX(rand.nextInt(width)); 
        txt.setY(rand.nextInt(height));
        txt.setName(name+(correlative++));
        txt.setWidth(rand.nextInt(controlWidth));
        txt.setHeight(rand.nextInt(controlHeight));
        txt.setEnabled(rand.nextBoolean());
        txt.setVisible(true);
        
        txt.setValue(name+correlative);
        return txt;
    }
    
    public static CheckBox generateCheckBox()
    {
        String name = "chkBox";
        CheckBox chkBox = new CheckBox();

        chkBox.setX(rand.nextInt(width)); 
        chkBox.setY(rand.nextInt(height));
        chkBox.setName(name+(correlative++));
        chkBox.setWidth(rand.nextInt(controlWidth));
        chkBox.setHeight(rand.nextInt(controlHeight));
        chkBox.setEnabled(rand.nextBoolean());
        chkBox.setVisible(true);
        
        chkBox.setText(name+correlative);
        //chkBox.setDirection();
        chkBox.setChecked(rand.nextBoolean());
        return chkBox;
    }
    
    public static DatePicker generateDatePicker()
    {
        String name = "datePicker";
        DatePicker datePicker = new DatePicker();
        
        datePicker.setX(rand.nextInt(width)); 
        datePicker.setY(rand.nextInt(height));
        datePicker.setName(name+(correlative++));
        datePicker.setWidth(rand.nextInt(controlWidth));
        datePicker.setHeight(rand.nextInt(controlHeight));
        datePicker.setEnabled(rand.nextBoolean());
        datePicker.setVisible(true);
        
        return datePicker;
    }
    
    public static RadioButton generateRadioButton()
    {
        String name = "radioBtn";
        RadioButton radioBtn = new RadioButton();
        
        radioBtn.setX(rand.nextInt(width)); 
        radioBtn.setY(rand.nextInt(height));
        radioBtn.setName(name+(correlative++));
        radioBtn.setWidth(rand.nextInt(controlWidth));
        radioBtn.setHeight(rand.nextInt(controlHeight));
        radioBtn.setEnabled(rand.nextBoolean());
        radioBtn.setVisible(true);
        
        radioBtn.setChecked(rand.nextBoolean());
        radioBtn.setText(name+correlative);
        return radioBtn;
    }
        
    /*private static Control getControl(String name)
    {
        Control control = new Control();
        control.setX(rand.nextInt(width)); 
        control.setY(rand.nextInt(height));
        control.setName(name+(correlative++));
        control.setWidth(rand.nextInt(controlWidth));
        control.setHeight(rand.nextInt(controlHeight));
        control.setEnabled(rand.nextBoolean());
        control.setVisible(true);
        return control;
    }*/
    
}
