/**
 * 
 */
package com.report.test;

import org.zeroturnaround.zip.ZipUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 * @author Naresh
 *
 */
public class Function {
	static List<String> filesListInDir = new ArrayList<String>();
	static String destDir =null;
	static String BuildNo=null;
	static File dir;
	public static String ProjectName=null;
	//public static ZipOutputStream zip=null;
	 @SuppressWarnings("unused")
	
	 //UnZip And Zip Folder
	 public static void zipfolder(String ExecutionType) throws Exception {
		 ByteArrayOutputStream actualOs = new ByteArrayOutputStream(1024);
		 String zipFolder ="/Users/macmini/.jenkins/jobs/"+Function.ProjectName+"/builds/"+BuildNo+"/archive/allure-report";
		 String zipFile ="/Users/macmini/.jenkins/jobs/"+Function.ProjectName+"/builds/"+BuildNo+"/archive/allure-report.zip";
		 String DestDir = "/Users/macmini/.jenkins/jobs/"+Function.ProjectName+"/builds/"+BuildNo+"/archive";
		 // execute test
		 if(ExecutionType.equals("unzip")) {
			 ZipUtil.unpack(new File(zipFile), new File(DestDir));
		 }else if(ExecutionType.equals("zip")) {
			 //Zip Folder using Command line 
			 String[] openCharles_str ={"/bin/bash", "-c", "cd "+DestDir+" && zip -r allure-report allure-report"};
				Runtime.getRuntime().exec(openCharles_str);	
				Thread.sleep(10000);
				//DeleteFiles();
			 
		 } 
	 }
	
	 
	 //Delete zip file
	 public static void DeleteFiles() {
		    File file = new File("/Users/macmini/.jenkins/jobs/"+Function.ProjectName+"/builds/"+BuildNo+"/archive/allure-report");
		    System.out.println("Called deleteFiles");
		    if (file.isDirectory()) {
		        for (File f : file.listFiles()) {
		            DeleteFiles();
		        }
		    } else {
		        file.delete();
		    }
		}
	  
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
			String Destination_File=null;
			String SourcePath="/Users/macmini/.jenkins/workspace/ReportModify_iOS/Allure_Style/";
			String DestinationPath=destDir+"allure-report/";
			List<String> get_content_file_name = listFiles(SourcePath);
			String Filename=null;
			String destPath=null;
			for (int i=0;i < get_content_file_name.size();i++)
			{

				Filename=get_content_file_name.get(i);
				System.out.println("File name is :"+Filename);
				sourceFile = new File(SourcePath.concat(get_content_file_name.get(i)));
				if(get_content_file_name.get(i).contains("styles.css")){
					destPath=DestinationPath;
					destinationFile = new File(destPath.concat(get_content_file_name.get(i)));
					Destination_File=destinationFile.toString();
				}else if(get_content_file_name.get(i).contains("environment.json")||get_content_file_name.get(i).contains("timeline.json")||get_content_file_name.get(i).contains("report.json")){
					destPath=DestinationPath+"/data/";
					destinationFile = new File(DestinationPath+"data/".concat(get_content_file_name.get(i)));
				}


				//FileUtils.moveFile(sourceFile, destinationFile);
				
				System.out.println("Old css was cleaned");
				//FileUtils.cleanDirectory(destinationFile);
				FileUtils.copyFile(sourceFile, destinationFile);

			}
			ChangeAllure.changeJson("widgets",3);
		}
	

}
