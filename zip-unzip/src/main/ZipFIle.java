package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFIle {

	public static void main(String[] args) throws Exception {
		    String sourceFile = "D:\\token.txt";
	        FileOutputStream fos = new FileOutputStream("D:\\test.zip");
	        ZipOutputStream zipOut = new ZipOutputStream(fos);
	        File fileToZip = new File(sourceFile);
	        FileInputStream fis = new FileInputStream(fileToZip);
	        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
	        zipOut.putNextEntry(zipEntry);
	        byte[] bytes = new byte[1024];
	        int length;
	        while((length = fis.read(bytes)) >= 0) {
	            zipOut.write(bytes, 0, length);
	        }
	        zipOut.close();
	        fis.close();
	        fos.close();
	}

}
