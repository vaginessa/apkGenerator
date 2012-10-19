
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
        Button btn = new Button();
        btn.setX(rand.nextInt(width)); 
        btn.setY(rand.nextInt(height));
        btn.setName("btn"+(correlative++));
        btn.setValue("btn"+correlative);
        btn.setWidth(rand.nextInt(controlWidth));
        btn.setHeight(rand.nextInt(controlHeight));
        btn.setEnabled(rand.nextInt(2)==0);
        // No need to randomize this attribute
        // But if you do, copy this line: rand.nextInt(2)==0
        btn.setVisible(true);
        return btn;
    }
    
    public static Label generateLabel()
    {
        Label lbl = new Label();
        lbl.setX(rand.nextInt(width)); 
        lbl.setY(rand.nextInt(height));
        lbl.setName("btn"+(correlative++));
        lbl.setValue("btn"+correlative);
        lbl.setWidth(rand.nextInt(controlWidth));
        lbl.setHeight(rand.nextInt(controlHeight));
        lbl.setEnabled(rand.nextInt(2)==0);
        lbl.setVisible(true);
        return lbl;
    }
}
