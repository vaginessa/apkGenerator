
package _apkGenerator;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Principal extends javax.swing.JFrame {

    private String RutaJava = null;
    private String RutaAndroid = null;
    private String RutaProyecto = null;
    
    private ApkGenerator genApk = null;
    
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
        RutaAndroid = "\"C:\\Program Files (x86)\\Android\\android-sdk\"";
        RutaProyecto = "";
        
        txtRutaAndroid.setText( RutaAndroid);
        txtRutaJDK.setText(RutaJava);
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
            // Si contiene espacio agregar comillas dobles para evitar problemas
            if( ruta.contains(" "))
            {
                ruta = "\"" + ruta + "\"";
            }
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
            // Si contiene espacio agregar comillas dobles para evitar problemas
            if( ruta.contains(" "))
            {
                ruta = "\"" + ruta + "\"";
            }
        }
        
        return ruta;
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(35, 35, 35))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(13, 13, 13)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRutaAndroid)
                                    .addComponent(txtRutaProyecto)
                                    .addComponent(txtRutaJDK))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCargarRutaAndroid, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCargarRutaProyecto, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCargarRutaJDK, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(50, 50, 50))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCrearKeystore, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtStorepass, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAlias, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPaqueteProyecto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(txtKeypass))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtAndroidJar)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnCrearR, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(btnEstructuraProyecto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCrearManifest)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAndroidJar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel9)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtRutaJDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargarRutaJDK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtRutaAndroid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargarRutaAndroid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRutaProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCargarRutaProyecto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPaqueteProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstructuraProyecto)
                    .addComponent(btnCrearManifest))
                .addGap(25, 25, 25)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel11)
                    .addComponent(txtAndroidJar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAndroidJar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtStorepass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtKeypass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearKeystore)
                    .addComponent(btnCrearR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarRutaJDKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCargarRutaJDKMouseClicked
        RutaJava = cargarFolder();
        txtRutaJDK.setText( RutaJava );
    }//GEN-LAST:event_btnCargarRutaJDKMouseClicked

    private void btnCargarRutaAndroidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCargarRutaAndroidMouseClicked
        RutaAndroid = cargarFolder();
        txtRutaAndroid.setText( RutaAndroid );
    }//GEN-LAST:event_btnCargarRutaAndroidMouseClicked

    private void btnCargarRutaProyectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCargarRutaProyectoMouseClicked
        RutaProyecto = cargarFolder();
        txtRutaProyecto.setText( RutaProyecto );
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
        
        /*Functions.packageName = txtPaqueteProyecto.getText();
        Functions.projectName = txtNombreProyecto.getText();
        Functions.pathProject = txtRutaProyecto.getText();
        Functions.createFolderStructure();*/
    }//GEN-LAST:event_btnEstructuraProyectoMouseClicked

    private void btnCrearKeystoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearKeystoreMouseClicked
        
        String alias = txtAlias.getText();
        String storePass = txtStorepass.getText();
        String keypass = txtKeypass.getText();
        String dname = "CN=android, OU=android, O=android, L=android, S=Villanueva, C=Honduras";
        
        
        if( genApk != null)
        {
            genApk.generateKeystore(RutaProyecto + genApk.folderSeparator + txtNombreProyecto.getText(),
                                    alias, storePass, keypass, dname);
        }
        //Functions.generateKeystore(RutaProyecto+"\\"+txtNombreProyecto.getText(), 
          //                         alias, storePass, keypass, dname);
    }//GEN-LAST:event_btnCrearKeystoreMouseClicked

    private void btnCrearRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearRMouseClicked
        String androidJarPath = txtAndroidJar.getText();
        JOptionPane.showMessageDialog(null, RutaProyecto+"\\"+txtNombreProyecto.getText());
        /*Functions.generarR(RutaProyecto+"\\"+txtNombreProyecto.getText(), androidJarPath);
        Functions.compilarCodigo(RutaProyecto+"\\"+txtNombreProyecto.getText(), androidJarPath, txtPaqueteProyecto.getText());
        Functions.crearDEX(RutaProyecto+"\\"+txtNombreProyecto.getText());
        Functions.crearAPKsinFirma(txtNombreProyecto.getText()+".apk", RutaProyecto+"\\"+txtNombreProyecto.getText(), androidJarPath);
        */
    }//GEN-LAST:event_btnCrearRMouseClicked

    private void btnAndroidJarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAndroidJarMouseClicked
        txtAndroidJar.setText( cargarArchivo() );
    }//GEN-LAST:event_btnAndroidJarMouseClicked

    private void btnCrearManifestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearManifestMouseClicked
//        ManifestGenerator mGen = new ManifestGenerator();
        
    }//GEN-LAST:event_btnCrearManifestMouseClicked
   
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
    private javax.swing.JButton btnCrearManifest;
    private javax.swing.JButton btnCrearR;
    private javax.swing.JButton btnEstructuraProyecto;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel1;
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
