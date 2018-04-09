package com.report.test;

import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ChangeAllure {

	public static int broke;
	public static int skip;
	public static int other;
	public static int cancled;
	public static int totaljson;
	public static String  finalJson;
	static public JSONParser parser = new JSONParser();
public static String widgets =null;


	@SuppressWarnings("unchecked")
	public static void changeJson(String JsonName,int changeCount) {
		//		String changeReport = "iOS_Smoke_Automation";
		//		String widgets = "/Users/macmini/.jenkins/jobs/"+changeReport+"/builds/6/archive/allure-report/data/";

		try
		{
			String FilePath= execute.widgets+JsonName+".json";
					//execute.widgets+JsonName+".json";
			Object object = parser
					.parse(new FileReader(FilePath));
			JSONObject jsonObject=null;
			JSONArray jsonArray = null;
			System.out.println("execute.changeReport is "+execute.changeReport);
			
			for(int i=1;i<=changeCount;i++) {
				jsonObject = (JSONObject)object;
				if(execute.changeReport.equals("iOS_ARMS_Automation") ||execute.changeReport.equals("iOS_CustomParams_Automation")) {
					if(JsonName.equals("summary")) {
						//jsonObject=(JSONObject)jsonObject.get("summary");

						//jsonObject=(JSONObject)jsonObject.get("summary");
						jsonObject.put("reportName", execute.changeReport+"_Report");
						finalJson=object.toString();
						@SuppressWarnings("resource")
						FileWriter FW = new FileWriter(FilePath);
						FW.write(object.toString());
						FW.flush();

					}
				}else if(execute.changeReport.equals("iOS_Smoke_Automation")) {

					if(JsonName.equals("summary")) {

						if(i==1) {
							//jsonObject=(JSONObject)jsonObject.get("summary");
							jsonObject.put("reportName", execute.changeReport+"_Report");
						}else if(i==2) {
							jsonObject=(JSONObject)jsonObject.get("behaviors");
							jsonArray=(JSONArray)jsonObject.get("items");
							jsonObject=(JSONObject) jsonArray.get(0);
						}else if(i==3) {
							jsonObject=(JSONObject)jsonObject.get("suites");
							jsonArray=(JSONArray)jsonObject.get("items");
							jsonObject=(JSONObject) jsonArray.get(0);
						}

					}else if(JsonName.equals("xunit")) {
						jsonArray=(JSONArray)jsonObject.get("testSuites");
						jsonObject=(JSONObject) jsonArray.get(0);
					}

					jsonObject=(JSONObject)jsonObject.get("statistic");
					String broken = jsonObject.get("broken").toString();
					String skipped = jsonObject.get("skipped").toString();
					String unknown = jsonObject.get("unknown").toString();
					String total = jsonObject.get("total").toString();
					System.out.println("broken tests are : "+broken );
					broke=Integer.parseInt(broken);
					System.out.println("skipped tests are : "+skipped );
					skip=Integer.parseInt(skipped);
					System.out.println("broken tests are : "+unknown );
					other=Integer.parseInt(unknown);
					totaljson =Integer.parseInt(total);
					cancled=broke+skip+other;
					totaljson=totaljson-cancled;
					jsonObject.put("broken", broke-broke);
					jsonObject.put("skip", skip-skip);
					jsonObject.put("unknown", other-other);
					jsonObject.put("total", totaljson);
					finalJson=object.toString();
					@SuppressWarnings("resource")
					FileWriter FW = new FileWriter(FilePath);
					FW.write(object.toString());
					FW.flush();

				}
			}
		}catch(Exception e) {

		}
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		 widgets="/Users/macmini/.jenkins/jobs/iOS_CustomParams_Automation/builds/116/archive/allure-report/widgets/";
		changeJson("summary",3);
		//changeJson("xunit",1);
	}

}
