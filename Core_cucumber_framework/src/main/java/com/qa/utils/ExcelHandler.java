package com.qa.utils;

import java.util.Map;
import java.util.TreeMap;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.cucumber.listener.Reporter;

public class ExcelHandler 
{
	public static Map<String,String> getTestDataInMap(String testDataFile,String sheetName,String testCaseId) throws Exception
	{
		Map<String,String> TestDataInMap=new TreeMap<String,String>();		
		String query=null;
		query=String.format("SELECT * FROM %s WHERE Run='Yes' and TestCaseId='%s'",
		sheetName,testCaseId);
		Fillo fillo=new Fillo();
		Connection conn=null;
		Recordset recordset=null;
		try
		{
			conn=fillo.getConnection(testDataFile);
			recordset=conn.executeQuery(query);
			//recordset=((com.codoid.products.fillo.Connection) conn).executeQuery(query);
			int number_of_testcase=recordset.getCount();
			System.out.println("Number of test cases will be executed:"+number_of_testcase);
			if(number_of_testcase>0)
			{
			while(recordset.next())
			{
				for(String field:recordset.getFieldNames())
				{
					TestDataInMap.put(field, recordset.getField(field));
				}
			}
			
			}else
			{
				System.out.println("Run mode is not set for test cases");
			}
		}
		catch(FilloException e)
		{
			Reporter.addStepLog("No run mode set");
			e.printStackTrace();
			throw new Exception("Test data cannot find . . .");			
		}
		conn.close();
		return TestDataInMap;		
	}
	
	public static void UpdateTestResultsToExcel(String testDataFilePath,String sheetName,String tcStatus,String testCaseId)
	{
		Connection conn=null;
		Fillo fillo =new Fillo();
		try{
			conn=fillo.getConnection(testDataFilePath);
			String query=String.format("UPDATE %s SET TestCaseStatus='%s' where TestCaseID='%s'", sheetName,tcStatus,testCaseId);
			conn.executeUpdate(query);
		} catch(FilloException e){
			e.printStackTrace();
		}		
	}

}