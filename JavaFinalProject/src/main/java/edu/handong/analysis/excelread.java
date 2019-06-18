package edu.handong.analysis;


import java.io.File;
import java.util.ArrayList;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;


public class excelread {
	public class ExcelZip extends Thread {
		
	
		private ArrayList<fileanalysis> excels;
		
		private File file;

		public ExcelZip(String path)
		{
			file = new File(path);
		}
		
		public void filepath(String path) {
	ZipFile zipFile;
	try {
		zipFile = new ZipFile(path);
		Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

	    while(entries.hasMoreElements()){
	    	ZipArchiveEntry entry = entries.nextElement();
	        InputStream stream = zipFile.getInputStream(entry);
	    
	        excelread myReader = new excelread();
	        
	        for(String value:myReader.getData(stream)) {
	        	System.out.println(value);
	        }
	    }
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
