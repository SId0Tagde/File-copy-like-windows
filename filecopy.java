
import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class filecopy {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		String filetocopy = args[0];
		
		File f = new File("D:\\RoughSpace");
		File totalpathfiletocopy = new File(f, filetocopy);
		System.out.println("File exists true/false: " + totalpathfiletocopy.exists());
		
        String filenamewithooutextension = totalpathfiletocopy.getName();
        String stwo = filenamewithooutextension.substring(0, filenamewithooutextension.lastIndexOf("."));
        
       	FilenameFilter filenameFilter = (file,name) -> name.startsWith(stwo + " - Copy"); 
        int numberofcopiesthereplusone =  f.listFiles(filenameFilter).length + 2;

        File destFile = new File(f,stwo +" - Copy " + " (" + numberofcopiesthereplusone +")"+ ".txt");
        destFile.createNewFile();

        FileChannel srChannel =  new FileInputStream(totalpathfiletocopy).getChannel();
     	FileChannel destChannel = new FileOutputStream(destFile).getChannel();
            
        long n = destChannel.transferFrom(srChannel, 0, srChannel.size());

        srChannel.close();
        destChannel.close();  


	}

}
