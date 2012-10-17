package _apkGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class ApkGenerator {

	public String projectName = null;
	public String packageName = null;
        public String projectPath = null;
        
	public String JAVA_HOME = null;
	public String ANDROID_HOME = null;
	public String DEV_HOME = null;
        
        public String folderSeparator = null;
        private String extraCommand = "";
        
        public enum OperatingSystem{ Windows, UnixBased }
        
        public ApkGenerator(OperatingSystem os)
        {
            if( os == OperatingSystem.UnixBased )
            {
                folderSeparator = "/";
            }
            else if( os == OperatingSystem.Windows)
            {
                folderSeparator = "\\";
                extraCommand = "cmd /c ";
            }
        }
	
	public void createFolderStructure(String projectPath, String projectName, String packageName)
	{
            this.projectName = projectName;
            this.projectPath = projectPath;
            this.packageName = packageName;
            
            projectPath = projectPath + folderSeparator + projectName;

            JOptionPane.showMessageDialog(null, projectPath);

            String packageFolders[] = packageName.split("\\.");
            String folders = "";
            for(int i=0; i<packageFolders.length; i++)
            {
                folders += folderSeparator + packageFolders[i];
            }

            if(new File(projectPath).mkdir() &&
               new File(projectPath+folderSeparator+"src"+folders).mkdirs() &&
               new File(projectPath+folderSeparator+"res"+folderSeparator+"drawable").mkdirs() &&
               new File(projectPath+folderSeparator+"res"+folderSeparator+"layout").mkdir() &&
               new File(projectPath+folderSeparator+"res"+folderSeparator+"values").mkdir() &&
               new File(projectPath+folderSeparator+"obj").mkdir() && 
               new File(projectPath+folderSeparator+"lib").mkdir() &&
               new File(projectPath+folderSeparator+"bin").mkdir() &&
               new File(projectPath+folderSeparator+"docs").mkdir()
              )
            {
                JOptionPane.showMessageDialog(null,"Structure created succesfully");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Folder structure creation error");			
            }	
	}
	
	public void generateKeystore(String keyPath, String alias,
                                            String storepass, String keypass,
                                            String dname)
	{
            String command = extraCommand + "keytool -genkey -keystore "+ keyPath + folderSeparator +"keystore " +" -alias " + 
                             alias + " -storepass " + storepass + " -keypass " + keypass +
                             " -dname \"" + dname + "\"";
            
            print( executeCommand(command) );
	}
        
        public void generarR(String ProjectHome , String pathToAndroidJar)
        {
            String command = extraCommand + "aapt package -v -f -m -S " + ProjectHome + "\\res "+
                             "-J " + ProjectHome +"\\src " + " -M " + ProjectHome + "\\AndroidManifest.xml "+
                             "-I " + pathToAndroidJar; 
            
            print( executeCommand(command) );
        }
	
        public void compilarCodigo(String ProjectHome,String pathToAndroidJar, String packageName)
        {
            String packageFolders[] = packageName.split("\\.");
            String folders = "";
            for(int i=0; i<packageFolders.length; i++)
            {
                folders += "\\" + packageFolders[i];
            }
            
            String command = extraCommand + "javac -verbose -d " + ProjectHome + "\\obj "+
                             "-classpath " + pathToAndroidJar +";"+ProjectHome+"\\obj "+
                             "-sourcepath " + ProjectHome + "\\src "+
                             ProjectHome + folders + "\\*.java";
            print( executeCommand(command) );
        }
        
        public void crearDEX(String ProjectHome)
        {
            String command = extraCommand + "dx --dex --verbose --output="+
                            ProjectHome+"\\bin\\classes.dex "+
                            ProjectHome+"\\obj "+
                            ProjectHome+"\\lib ";
            print( executeCommand(command) );
        }
        
        public void crearAPKsinFirma(String ApkName, String ProjectHome, String pathToAndroidJar)
        {
            String command = extraCommand + "aapt package -v -f -M " + 
                              ProjectHome + "\\AndroidManifest.xml "+
                              "-S " + ProjectHome + "\\res " +
                              "-I " + pathToAndroidJar + " -F " +
                              ProjectHome + "\\bin\\"+ApkName + " "+
                              ProjectHome + "\\bin";
            print( executeCommand(command) );
        }
        
	public BufferedReader executeCommand(String command)
	{
            try 
            {
                JOptionPane.showMessageDialog(null, command);
                return new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec( command ).getInputStream()));
            }
            catch (IOException e) 
            { 
                System.out.println("Algo salio mal");
            }
            return null;
	}

        public void print(BufferedReader br)
        {
            String line;
            try 
            {
                line = br.readLine();
                while( line != null )
                {
                        System.out.println(line);
                        line = br.readLine(); 
                }
            } catch (IOException ex) 
            {
                System.out.println(ex.getMessage());
            }	
        }
        
}
