package edu.handong.analysis.utils;

public class NoExcelFileExist extends Exception {
	public NoExcelFileExist(String fileName)
	{
		super("In zipfile: " + fileName + ", Dont exist Excel file!");
	}
}