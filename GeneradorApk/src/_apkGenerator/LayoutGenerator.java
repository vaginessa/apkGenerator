
package _apkGenerator;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class LayoutGenerator 
{
    DocumentBuilderFactory dbFactory = null;
    DocumentBuilder docBuilder = null;
    Document document = null;
    Element root = null;
    int correlative;
    
    public LayoutGenerator()
    {
        try
        {
            dbFactory = DocumentBuilderFactory.newInstance();
            docBuilder = dbFactory.newDocumentBuilder();
            document = docBuilder.newDocument();   
            correlative = 0;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void generateLayoutRoot()
    {
        root = document.createElement("LinearLayout");
        root.setAttribute("xmlns:android", "http://schemas.android.com/apk/res/android");
        root.setAttribute("xmlns:tools", "http://schemas.android.com/tools");
        root.setAttribute("android:layout_width", "match_parent");
        root.setAttribute("android:layout_height", "match_parent");
        document.appendChild(root);
    }
    
    public void generateLayoutButton(String idName, String text, int width, int height,
                                    boolean visible, boolean enabled)
    {
        Element button = document.createElement("Button");
        button.setAttribute("android:id", "@id/"+idName);
        button.setAttribute("android:text", text);
        button.setAttribute("android:layout_width", ""+width+"dp");
        button.setAttribute("android:layout_height", ""+height+"dp");
        button.setAttribute("android:visibility", visible?"visible":"invisible");        
        button.setAttribute("android:enabled", enabled?"true":"false");
        root.appendChild(button);
    }
    
    public void generateLayoutLabel(String idName, String text, int width, int height,
                                    boolean visible, boolean enabled)
    {
        Element label = document.createElement("TextView");
        label.setAttribute("android:id", "@id/"+idName);
        label.setAttribute("android:text", text);
        label.setAttribute("android:layout_width", ""+width+"dp");
        label.setAttribute("android:layout_height", ""+height+"dp");
        label.setAttribute("android:visibility", visible?"visible":"invisible");        
        label.setAttribute("android:enabled", enabled?"true":"false");
        root.appendChild(label);
    }
    
    public void generateLayoutTextBox(String idName, String text, int width, int height,
                                    boolean visible, boolean enabled)
    {
        Element textbox = document.createElement("TextView");
        textbox.setAttribute("android:id", "@id/"+idName);
        textbox.setAttribute("android:text", text);
        textbox.setAttribute("android:layout_width", ""+width+"dp");
        textbox.setAttribute("android:layout_height", ""+height+"dp");
        textbox.setAttribute("android:visibility", visible?"visible":"invisible");        
        textbox.setAttribute("android:enabled", enabled?"true":"false");
        root.appendChild(textbox);
    }
    
    public void generateLayoutCheckbox(String idName, String text, int width, int height,
                                    boolean visible, boolean enabled, boolean checked)
    {
        Element checkBox = document.createElement("CheckBox");
        checkBox.setAttribute("android:id", "@id/"+idName);
        checkBox.setAttribute("android:text", text);
        checkBox.setAttribute("android:layout_width", ""+width+"dp");
        checkBox.setAttribute("android:layout_height", ""+height+"dp");
        checkBox.setAttribute("android:visibility", visible?"visible":"invisible");        
        checkBox.setAttribute("android:enabled", enabled?"true":"false");
        checkBox.setAttribute("android:checked", checked?"true":"false");
        
        root.appendChild(checkBox);
    }
    
    public void generateLayoutRadioButton(String idName, String text, int width, int height,
                                    boolean visible, boolean enabled, boolean checked)
    {
        Element radioButton = document.createElement("RadioButton");
        radioButton.setAttribute("android:id", "@id/"+idName);
        radioButton.setAttribute("android:text", text);
        radioButton.setAttribute("android:layout_width", ""+width+"dp");
        radioButton.setAttribute("android:layout_height", ""+height+"dp");
        radioButton.setAttribute("android:visibility", visible?"visible":"invisible");        
        radioButton.setAttribute("android:enabled", enabled?"true":"false");
        radioButton.setAttribute("android:checked", checked?"true":"false");
        
        root.appendChild(radioButton);
    }
    
    public void generateLayoutDatePicker(String idName,int width, int height,
                                         boolean visible, boolean enabled)
    {
        Element datePicker = document.createElement("DatePicker");
        datePicker.setAttribute("android:id", "@id/"+idName);
        datePicker.setAttribute("android:layout_width", ""+width+"dp");
        datePicker.setAttribute("android:layout_height", ""+height+"dp");
        datePicker.setAttribute("android:visibility", visible?"visible":"invisible");        
        datePicker.setAttribute("android:enabled", enabled?"true":"false");
        // Min values, Max values
        root.appendChild(datePicker);
    }
    
    public void generateLayoutPicture(String imagePath, String projectPath)
    {
    }
    
    // To Do's
    public void generateLayoutComboBox()
    {
        
    }
    
    public void generateLayoutLayout()
    {
        Element layout = document.createElement("LinearLayout");
        // Find Attributes
        
        // append all childs to layout, if any
        
        root.appendChild(layout);
    }
    
    public void generateLayout(String homePath)
    {
        try
        {
            TransformerFactory transFac = TransformerFactory.newInstance();
            Transformer trans = transFac.newTransformer();
            trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            trans.setOutputProperty(OutputKeys.INDENT, "yes");

            StringWriter sw = new StringWriter();
            StreamResult result = new StreamResult(sw);
            DOMSource source = new DOMSource(document);
            trans.transform(source, result);
            String xml = sw.toString();
            
            File file = new File(homePath + "test"+(correlative++)+".xml");
            FileOutputStream outputStream = new FileOutputStream(file);
            
            outputStream.write(xml.getBytes());
            outputStream.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
