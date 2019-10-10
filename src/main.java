import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;



public class main {

	public static void main(String[] args) {
		File folder = new File("D:\\NY-Files\\Desktop\\atak");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
		    System.out.println("File " + listOfFiles[i].getName());
		  } else if (listOfFiles[i].isDirectory()) {
		    System.out.println("Directory " + listOfFiles[i].getName());
		  }
		}
		
		for(int y=0;y<listOfFiles.length;y++) {
			
		
       byte[] bArray = readFileToByteArray(listOfFiles[0]);
        for(int i=0;i<bArray.length;i++) {
        	bArray[i]*=4;
        }
        
        try {
			OutputStream  os   = new FileOutputStream("D:\\NY-Files\\Desktop\\atak\\"+listOfFiles[y].getName());
			try {
				os.write(bArray);
				os.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
      
     //   writeBytetoFile(bArray, listOfFiles[0].getName(),folder);
		
   //  System.out.println(bArray[2]);
	}
	//DOSYALARI BYTE SEKLÝNDE SORUNSUZ OKUDUK.
		 private static byte[] readFileToByteArray(File file){
		        FileInputStream fis = null;
		        // Creating a byte array using the length of the file
		        // file.length returns long which is cast to int
		        byte[] bArray = new byte[(int) file.length()];
		        try{
		            fis = new FileInputStream(file);
		            fis.read(bArray);
		            fis.close();        
		            
		        }catch(IOException ioExp){
		            ioExp.printStackTrace();
		        }
		        return bArray;
		    }
		 
		 
		 private static void writeBytetoFile(byte[] bArray,String DosyaAdi,File folder) {
			 BufferedImage image = null;
				try {
					FileInputStream fileInputStream = new FileInputStream("D:\\NY-Files\\Desktop\\atak"+"\\"+DosyaAdi);
					fileInputStream.read(bArray);
					System.out.println(bArray[0]);
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        try {
		        	System.out.println(DosyaAdi);
					File file= new File("D:\\NY-Files\\Desktop\\atak"+"\\"+"de"+".pptx");
					file.createNewFile();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		 }
		 
		 
}
