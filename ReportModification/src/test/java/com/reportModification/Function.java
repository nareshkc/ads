/**
 * 
 */
package com.reportModification;

/**
 * @author Naresh
 *
 */
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterClass;
 
public class Function {


	  
	//get all the files in the folder
		public static List<String> listFiles(String directoryName){

			//String file_name = null;
			List<String> filelist = new ArrayList<String>();
			File directory = new File(directoryName);
			//get all the files from a directory
			File[] fList = directory.listFiles();
			for (File file : fList){
				if (file.isFile()){
					filelist.add(file.getName());
					//file_name = file.getName();
					//break;
				}
			}
			return filelist;
		}/* --- End Get File Names from Folder  --- */
	//Moving Files
		public static void move_Files(String Foldername)throws Exception{
			String projDir = System.getProperty("user.dir");
			File sourceFile,destinationFile = null;
			String SourcePath="/Users/macmini/.jenkins/workspace/ReportModify_iOS/Allure_Style/";
			String DestinationPath="/Users/macmini/.jenkins/workspace/iOS_ARMS/allure-report/";
			List<String> get_content_file_name = listFiles(SourcePath);
			String Filename=null;
			String destPath=null;
			for (int i=0;i < get_content_file_name.size();i++)
			{

				Filename=get_content_file_name.get(i);
				System.out.println("File name is :+"+Filename);
				sourceFile = new File(SourcePath.concat(get_content_file_name.get(i)));
				if(get_content_file_name.get(i).contains("styles.css")){
					destPath=DestinationPath;
					destinationFile = new File(destPath.concat(get_content_file_name.get(i)));
				}else if(get_content_file_name.get(i).contains("environment.json")||get_content_file_name.get(i).contains("timeline.json")||get_content_file_name.get(i).contains("report.json")){
					destPath=DestinationPath+"/data/";
					destinationFile = new File(DestinationPath+"data/".concat(get_content_file_name.get(i)));
				}



				//FileUtils.cleanDirectory(new File(destPath));
				FileUtils.copyFile(sourceFile, destinationFile);

			}
		}
	}


