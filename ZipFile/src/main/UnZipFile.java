package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZipFile {

	public static void main(String[] args) {
        String zipFilePath = "D:\\countries2.zip";  
        String destDir = "D:\\" ;  
        unzipfile( zipFilePath, destDir ) ;  
	}
	private static void unzipfile( String zipFilePath, String destDir ) {  
        File dir = new File( destDir ) ;  
        if( !dir.exists( ) ) dir.mkdirs( ) ;  
        FileInputStream FiS ;  
        byte[ ] buffer = new byte[ 1024 ] ;  
        try {  
            FiS = new FileInputStream( zipFilePath ) ;  
            ZipInputStream ZiS = new ZipInputStream( FiS ) ;  
            ZipEntry ZE = ZiS.getNextEntry( ) ;  
            while( ZE != null ) {  
                String fileName = ZE.getName( ) ;  
                File newFile = new File( destDir + File.separator + fileName ) ;  
                System.out.println( " Unzipping to " + newFile.getAbsolutePath( ) ) ;  
                new File( newFile.getParent( ) ).mkdirs( ) ;  
                FileOutputStream FoS = new FileOutputStream( newFile ) ;  
                int len ;  
                while ( ( len = ZiS.read( buffer ) )  > 0 ) {  
                FoS.write( buffer, 0, len ) ;  
                }  
                FoS.close( ) ;  
                ZiS.closeEntry( ) ;  
                ZE = ZiS.getNextEntry( ) ;  
            }  
            ZiS.closeEntry() ;  
            ZiS.close() ;  
            FiS.close() ;  
        } catch ( Exception e ) {  
            e.printStackTrace( ) ;  
        }  
      }  
}