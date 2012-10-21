
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
        Label lbl = new Label();
        lbl.setValue(name+correlative);
        return lbl;
    }
    
    public static TextBox generateTextBox()
    {
        String name = "txt";
        TextBox txt = new TextBox();
        txt.setValue(name+correlative);
        return txt;
    }
    
    private static Control getControl(String name)
    {
        Control control = new Control();
        control.setX(rand.nextInt(width)); 
        control.setY(rand.nextInt(height));
        control.setName(name+(correlative++));
        control.setWidth(rand.nextInt(controlWidth));
        control.setHeight(rand.nextInt(controlHeight));
        control.setEnabled(rand.nextInt(2)==0);
        // No need to randomize this attribute
        // But if you do, copy this line: rand.nextInt(2)==0
        control.setVisible(true);
        return control;
    }
    
}
