
package _apkGenerator;

import Semantics.Controls.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    private String RutaJava = null;
    private String RutaAndroid = null;
    private String RutaProyecto = null;
    
    private ApkGenerator genApk = null;
    ArrayList<Control> list = new ArrayList<Control>();
    
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("_apkGenerator/icon.png"));
        return retValue;
    }
   
    public Principal() {
        initComponents();
        
        String os = System.getProperty("os.name").toLowerCase();
        
        if( os.contains("win") )
        {
            genApk = new ApkGenerator(ApkGenerator.OperatingSystem.Windows);
        }
        else if( os.indexOf("nix") >= 0  || os.indexOf("nux") >= 0 || os.indexOf("mac")>=0   )
        {
            genApk = new ApkGenerator(ApkGenerator.OperatingSystem.UnixBased);
        }
        
        RutaJava = "C:\\Program Files\\Java\\jdk1.6.0_34";
        RutaAndroid = "C:\\Program Files (x86)\\Android\\android-sdk";
        RutaProyecto = "";
        
        genApk.JAVA_HOME = RutaJava;
        genApk.ANDROID_HOME = RutaAndroid;
        
        txtRutaAndroid.setText( RutaAndroid);
        txtRutaJDK.setText(RutaJava);
        txtAndroidJar.setText("C:\\Program Files (x86)\\Android\\android-sdk\\platforms\\android-10\\android.jar");
    }
    
    private String cargarFolder()
    {
        String ruta = null;
        JFileChooser dialogo = new JFileChooser();
        
        dialogo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        int resultado = dialogo.showOpenDialog(this);
        
        if( resultado == JFileChooser.APPROVE_OPTION)
        {
            ruta = dialogo.getSelectedFile().getAbsolutePath();
        }
        
        return ruta;
    }
    
    private String cargarArchivo()
    {
        String ruta = null;
        
        JFileChooser dialogo = new JFileChooser();
        dialogo.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int resultado = dialogo.showOpenDialog(this);
        
        if( resultado == JFileChooser.APPROVE_OPTION)
        {
            ruta = dialogo.getSelectedFile().getAbsolutePath();
        }
        
        return ruta;
    }
    
    public ArrayList<Control> getControls()
    {
        String projectHome = RutaProyecto+ApkGenerator.getFolderSeparator()+txtNombreProyecto.getText();
        list.add(RandomControlGenerator.generateButton());
        list.add(RandomControlGenerator.generateCheckBox());
        list.add(RandomControlGenerator.generateRadioButton());
        list.add(RandomControlGenerator.generateTextBox());
        list.add(RandomControlGenerator.generateLabel());
        list.add(RandomControlGenerator.generatePicture("C:\\Users\\Richard\\Documents\\potato.png"));
        list.add(RandomControlGenerator.generateListBox(projectHome));
        list.add(RandomControlGenerator.generateComboBox());
        list.add(RandomControlGenerator.generateDatePicker());
        return list;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtRutaJDK = new javax.swing.JTextField();
        txtRutaAndroid = new javax.swing.JTextField();
        txtRutaProyecto = new javax.swing.JTextField();
        btnCargarRutaJDK = new javax.swing.JButton();
        btnCargarRutaAndroid = new javax.swing.JButton();
        btnCargarRutaProyecto = new javax.swing.JButton();
        btnEstructuraProyecto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreProyecto = new javax.swing.JTextField();
        txtPaqueteProyecto = new javax.swing.JTextField();
        btnCrearKeystore = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0));
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtAlias = new javax.swing.JTextField();
        txtStorepass = new javax.swing.JTextField();
        txtKeypass = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnCrearR = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtAndroidJar = new javax.swing.JTextField();
        btnAndroidJar = new javax.swing.JButton();
        btnCrearManifest = new javax.swing.JButton();
        btnCrearLayout = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ruta del JDK");

        jLabel2.setText("Ruta de Android");

        jLabel3.setText("Ruta del Proyecto");

        btnCargarRutaJDK.setText("...");
        btnCargarRutaJDK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCargarRutaJDKMouseClicked(evt);
            }
        });

        btnCargarRutaAndroid.setText("...");
        btnCargarRutaAndroid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCargarRutaAndroidMouseClicked(evt);
            }
        });

        btnCargarRutaProyecto.setText("...");
        btnCargarRutaProyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCargarRutaProyectoMouseClicked(evt);
            }
        });

        btnEstructuraProyecto.setText("Crear Estructura del Proyecto");
        btnEstructuraProyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstructuraProyectoMouseClicked(evt);
            }
        });

        jLabel4.setText("Nombre del Proyecto");

        jLabel5.setText("Paquete del Proyecto");

        btnCrearKeystore.setText("Crear Keystore");
        btnCrearKeystore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearKeystoreMouseClicked(evt);
            }
        });

        jLabel6.setText("Alias");

        jLabel7.setText("Storepass");

        jLabel8.setText("Keypass");

        jLabel9.setText("CREACION del KEYSTORE");

        btnCrearR.setText("Crear APK");
        btnCrearR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearRMouseClicked(evt);
            }
        });

        jLabel11.setText("AndroidJar");

        btnAndroidJar.setText("...");
        btnAndroidJar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAndroidJarMouseClicked(evt);
            }
        });

        btnCrearManifest.setText("Crear Manifest");
        btnCrearManifest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearManifestMouseClicked(evt);
            }
        });

        btnCrearLayout.setText("Crear Layout");
        btnCrearLayout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCrearLayoutMouseClicked(evt);
            }
        });

        jLabel10.setText("Creacion del Proyecto");

        jButton1.setText("BotonPrueba");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(52, 52, 52))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(27, 27, 27)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtRutaAndroid, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                .addComponent(txtRutaJDK, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtRutaProyecto))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCargarRutaJDK)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCargarRutaAndroid)
                                    .addComponent(btnCargarRutaProyecto))
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(btnCrearKeystore, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(44, 44, 44)
                                                .addComponent(txtAlias))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel8))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txtKeypass)
                                                    .addComponent(txtStorepass))))
                                        .addGap(100, 100, 100))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtPaqueteProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEstructuraProyecto)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addGap(61, 61, 61)
                                .addComponent(txtAndroidJar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAndroidJar)
                                .addGap(52, 52, 52)))
                        .addGap(336, 336, 336))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrearLayout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrearManifest)
                        .addGap(18, 18, 18)
                        .addComponent(btnCrearR, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRutaJDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(btnCargarRutaJDK))
                    .addComponent(jLabel6)
                    .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtStorepass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRutaAndroid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnCargarRutaAndroid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtKeypass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRutaProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnCargarRutaProyecto))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearKeystore)
                    .addComponent(btnEstructuraProyecto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPaqueteProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtAndroidJar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAndroidJar))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnCrearLayout)
                    .addComponent(btnCrearManifest)
                    .addComponent(btnCrearR))
                .addGap(10, 10, 10)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarRutaJDKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCargarRutaJDKMouseClicked
        RutaJava = cargarFolder();
        txtRutaJDK.setText( RutaJava );
        genApk.JAVA_HOME = RutaJava;
    }//GEN-LAST:event_btnCargarRutaJDKMouseClicked

    private void btnCargarRutaAndroidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCargarRutaAndroidMouseClicked
        RutaAndroid = cargarFolder();
        txtRutaAndroid.setText( RutaAndroid );
        genApk.ANDROID_HOME = RutaAndroid;
    }//GEN-LAST:event_btnCargarRutaAndroidMouseClicked

    private void btnCargarRutaProyectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCargarRutaProyectoMouseClicked
        RutaProyecto = cargarFolder();
        txtRutaProyecto.setText( RutaProyecto );
        genApk.DEV_HOME = RutaProyecto;
    }//GEN-LAST:event_btnCargarRutaProyectoMouseClicked

    private void btnEstructuraProyectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstructuraProyectoMouseClicked
        if( txtNombreProyecto.getText().equals("") || txtPaqueteProyecto.getText().equals("") )
        {
            JOptionPane.showMessageDialog(null, "Both Project name and Package name are required");
            return;
        }
        
        genApk.createFolderStructure(txtRutaProyecto.getText(),
                                     txtNombreProyecto.getText(),
                                     txtPaqueteProyecto.getText());
        
    }//GEN-LAST:event_btnEstructuraProyectoMouseClicked

    private void btnCrearKeystoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearKeystoreMouseClicked
        
        String alias = txtAlias.getText();
        String storePass = txtStorepass.getText();
        String keypass = txtKeypass.getText();
        String dname = "\"CN=android, OU=android, O=android, L=android, S=Villanueva, C=Honduras\"";        
        
        if( genApk != null)
        {
            genApk.generateKeystore(RutaProyecto + genApk.folderSeparator + txtNombreProyecto.getText(),
                                    alias, storePass, keypass, dname);
        }
    }//GEN-LAST:event_btnCrearKeystoreMouseClicked

    private void btnCrearRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearRMouseClicked
        String androidJarPath = txtAndroidJar.getText();

        String projectHome = RutaProyecto+ApkGenerator.getFolderSeparator()+txtNombreProyecto.getText();

        JOptionPane.showMessageDialog(null, RutaProyecto+"\\"+txtNombreProyecto.getText());
        genApk.generarR(projectHome,androidJarPath);
        genApk.compilarCodigo(projectHome,androidJarPath,txtPaqueteProyecto.getText());

        genApk.crearDEX(projectHome);
        genApk.crearAPKsinFirma(txtNombreProyecto.getText(), projectHome, androidJarPath);
        genApk.firmarApk(txtNombreProyecto.getText(), projectHome, txtAlias.getText(), txtStorepass.getText(), txtKeypass.getText());
        genApk.optimizeApk(txtNombreProyecto.getText(), projectHome);       
    }//GEN-LAST:event_btnCrearRMouseClicked

    private void btnAndroidJarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAndroidJarMouseClicked
        txtAndroidJar.setText( cargarArchivo() );
    }//GEN-LAST:event_btnAndroidJarMouseClicked

    private void btnCrearManifestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearManifestMouseClicked

        ManifestGenerator mGen = new ManifestGenerator(txtPaqueteProyecto.getText(),"10");
        ArrayList<String> lista = new ArrayList<String>();
        lista.add("Main");
        mGen.generateManifestApplication("MyApp", lista);
        mGen.generateManifestFile(RutaProyecto+ ApkGenerator.getFolderSeparator() +txtNombreProyecto.getText());
    }//GEN-LAST:event_btnCrearManifestMouseClicked

    private void btnCrearLayoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearLayoutMouseClicked

        LayoutGenerator layoutGenerator = new LayoutGenerator();
               
        ArrayList<Control> controls = getControls();
        for(Control control : controls)
        {
            if( control instanceof Button)
            {
                Button btn = (Button) control;
                layoutGenerator.generateLayoutButton(btn.getName(), btn.getValue(), btn.getX(), 
                                                     btn.getY(),btn.getWidth(), btn.getHeight(), 
                                                     btn.isVisible(), btn.isEnabled());
            }
            else if( control instanceof Label)
            {
                Label lbl = (Label) control;
                layoutGenerator.generateLayoutLabel(lbl.getName(), lbl.getValue(), lbl.getX(), 
                                                    lbl.getY(), lbl.getWidth(), lbl.getHeight(), 
                                                    lbl.isVisible(), lbl.isEnabled());
            }
            else if( control instanceof CheckBox)
            {
                CheckBox chk = (CheckBox) control;
                layoutGenerator.generateLayoutCheckbox(chk.getName(), chk.getText(), chk.getX(), 
                                                       chk.getY(), chk.getWidth(), chk.getHeight(),
                                                       chk.isVisible(), chk.isEnabled(), chk.isChecked());
            }
            else if( control instanceof TextBox)
            {
                TextBox txt = (TextBox) control;
                layoutGenerator.generateLayoutTextBox(txt.getName(), txt.getValue(), txt.getX(), 
                                                      txt.getY(), txt.getWidth(), txt.getHeight(), 
                                                      txt.isVisible(), txt.isEnabled());
            }
            else if( control instanceof Picture)
            {
                Picture pic = (Picture) control;
                layoutGenerator.generateLayoutPicture(pic.getPath(), RutaProyecto+ApkGenerator.getFolderSeparator()+txtNombreProyecto.getText(),
                                                      pic.getName(),pic.getWidth(),pic.getHeight(),pic.getX(), pic.getY(), pic.isVisible(), pic.isEnabled());
            }
            else if( control instanceof ListBox)
            {
                ListBox listbox = (ListBox) control;
                layoutGenerator.generateListView(RutaProyecto+ApkGenerator.getFolderSeparator()+txtNombreProyecto.getText(),
                                                listbox.getName(), listbox.getWidth(), listbox.getHeight(), listbox.getX(), listbox.getY(), 
                                                listbox.isVisible(), listbox.isEnabled());
            }
            else if( control instanceof ComboBox)
            {
                ComboBox combobox = (ComboBox) control;
                layoutGenerator.generateLayoutComboBox(RutaProyecto+ApkGenerator.getFolderSeparator()+txtNombreProyecto.getText(),
                                                        combobox.getName(), combobox.getWidth(), combobox.getHeight(), combobox.getX(),
                                                        combobox.getY(), combobox.isVisible(), combobox.isEnabled());
            }
            else if( control instanceof DatePicker)
            {
                DatePicker datepicker = (DatePicker) control;
                layoutGenerator.generateLayoutDatePicker(datepicker.getName(), datepicker.getWidth(), datepicker.getHeight(),
                                                        datepicker.getX(), datepicker.getY(), datepicker.isVisible(), datepicker.isEnabled());
            }
        }
        layoutGenerator.generateLayout(RutaProyecto+ApkGenerator.getFolderSeparator()+
                                       txtNombreProyecto.getText());
    }//GEN-LAST:event_btnCrearLayoutMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) { 
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal p = new Principal();
                
                java.net.URL url = ClassLoader.getSystemResource("_apkGenerator/icon.png");
                Toolkit kit = Toolkit.getDefaultToolkit();
                Image img = kit.createImage(url);
                p.setIconImage(img);
                                
                p.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAndroidJar;
    private javax.swing.JButton btnCargarRutaAndroid;
    private javax.swing.JButton btnCargarRutaJDK;
    private javax.swing.JButton btnCargarRutaProyecto;
    private javax.swing.JButton btnCrearKeystore;
    private javax.swing.JButton btnCrearLayout;
    private javax.swing.JButton btnCrearManifest;
    private javax.swing.JButton btnCrearR;
    private javax.swing.JButton btnEstructuraProyecto;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtAlias;
    private javax.swing.JTextField txtAndroidJar;
    private javax.swing.JTextField txtKeypass;
    private javax.swing.JTextField txtNombreProyecto;
    private javax.swing.JTextField txtPaqueteProyecto;
    private javax.swing.JTextField txtRutaAndroid;
    private javax.swing.JTextField txtRutaJDK;
    private javax.swing.JTextField txtRutaProyecto;
    private javax.swing.JTextField txtStorepass;
    // End of variables declaration//GEN-END:variables
}
