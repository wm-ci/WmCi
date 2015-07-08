package WmCi;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2015-07-07 21:59:08 MST
// -----( ON-HOST: 192.168.0.16

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.ArrayList;
import java.util.List;
import com.wmci.assertion.*;
import com.wmci.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class assertion

{
	// ---( internal utility methods )---

	final static assertion _instance = new assertion();

	static assertion _newInstance() { return new assertion(); }

	static assertion _cast(Object o) { return (assertion)o; }

	// ---( server methods )---




	public static final void contains (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(contains)>> ---
		// @specification WmCi.spec:BasicAssert
		// @sigtype java 3.5
		IDataCursor pipeCursor = pipeline.getCursor();
		
		try {
			String input = pipeCursor.first("input") ? (String)pipeCursor.getValue() : null;
			String compare = pipeCursor.first("compare") ? (String)pipeCursor.getValue() : null;
			
			String initTime = Util.getTimeStamp();		
			Result result = Eval.contains(input, compare);	
			String endTime = Util.getTimeStamp();		
			
			// Add test result to output document
			IData[] outResultList = buildTestResults(pipeCursor, result, initTime, endTime);
			
			// add the outputDoc to the pipeline
			IDataUtil.put(pipeCursor, "resultList", outResultList);
			
		} finally {
			// destroy the pipelineCursor
			pipeCursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}



	public static final void equal (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(equal)>> ---
		// @specification WmCi.spec:BasicAssert
		// @sigtype java 3.5
		IDataCursor pipeCursor = pipeline.getCursor();
		
		try {
			String input = pipeCursor.first("input") ? (String)pipeCursor.getValue() : null;
			String compare = pipeCursor.first("compare") ? (String)pipeCursor.getValue() : null;
			
			String initTime = Util.getTimeStamp();		
			Result result = Eval.equal(input, compare);	
			String endTime = Util.getTimeStamp();		
			
			// Add test result to output document
			IData[] outResultList = buildTestResults(pipeCursor, result, initTime, endTime);
			
			// add the outputDoc to the pipeline
			IDataUtil.put(pipeCursor, "resultList", outResultList);
			
		} finally {
			// destroy the pipelineCursor
			pipeCursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}



	public static final void matches (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(matches)>> ---
		// @specification WmCi.spec:BasicAssert
		// @sigtype java 3.5
		IDataCursor pipeCursor = pipeline.getCursor();
		
		try {
			String input = pipeCursor.first("input") ? (String)pipeCursor.getValue() : null;
			String compare = pipeCursor.first("compare") ? (String)pipeCursor.getValue() : null;
			
			String initTime = Util.getTimeStamp();		
			Result result = Eval.matches(input, compare);	
			String endTime = Util.getTimeStamp();		
			
			// Add test result to output document
			IData[] outResultList = buildTestResults(pipeCursor, result, initTime, endTime);
			
			// add the outputDoc to the pipeline
			IDataUtil.put(pipeCursor, "resultList", outResultList);
			
		} finally {
			// destroy the pipelineCursor
			pipeCursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}



	public static final void notContains (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(notContains)>> ---
		// @specification WmCi.spec:BasicAssert
		// @sigtype java 3.5
		IDataCursor pipeCursor = pipeline.getCursor();
		
		try {
			String input = pipeCursor.first("input") ? (String)pipeCursor.getValue() : null;
			String compare = pipeCursor.first("compare") ? (String)pipeCursor.getValue() : null;
			
			String initTime = Util.getTimeStamp();		
			Result result = Eval.notContains(input, compare);	
			String endTime = Util.getTimeStamp();		
			
			// Add test result to output document
			IData[] outResultList = buildTestResults(pipeCursor, result, initTime, endTime);
			
			// add the outputDoc to the pipeline
			IDataUtil.put(pipeCursor, "resultList", outResultList);
			
		} finally {
			// destroy the pipelineCursor
			pipeCursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}



	public static final void notEqual (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(notEqual)>> ---
		// @specification WmCi.spec:BasicAssert
		// @sigtype java 3.5
		IDataCursor pipeCursor = pipeline.getCursor();
		
		try {
			String input = pipeCursor.first("input") ? (String)pipeCursor.getValue() : null;
			String compare = pipeCursor.first("compare") ? (String)pipeCursor.getValue() : null;
			
			String initTime = Util.getTimeStamp();		
			Result result = Eval.notEqual(input, compare);	
			String endTime = Util.getTimeStamp();		
			
			// Add test result to output document
			IData[] outResultList = buildTestResults(pipeCursor, result, initTime, endTime);
			
			// add the outputDoc to the pipeline
			IDataUtil.put(pipeCursor, "resultList", outResultList);
			
		} finally {
			// destroy the pipelineCursor
			pipeCursor.destroy();
		}
		// --- <<IS-END>> ---

                
	}

	// --- <<IS-START-SHARED>> ---
	public static IData[] buildTestResults(IDataCursor pipeCursor, Result result, String initTime, String endTime) {
		
		IData testDoc = IDataFactory.create();
		IDataCursor testCaseResult = testDoc.getCursor();
		
		// Build WmCi.docs:testCaseResult structure
		//
		if(pipeCursor.first("test"))
			testCaseResult.insertAfter("test", (String)pipeCursor.getValue());
		if(pipeCursor.first("case"))
			testCaseResult.insertAfter("case", (String)pipeCursor.getValue());
		if(pipeCursor.first("element"))
			testCaseResult.insertAfter("element", (String)pipeCursor.getValue());
		
		testCaseResult.insertAfter("success", result.isSuccess());
		
		if(!Util.nvl(result.getMessage(), "", true).equals(""))
			testCaseResult.insertAfter("message", result.getMessage());
		
		testCaseResult.insertAfter("initTime", initTime);
		testCaseResult.insertAfter("endTime", endTime);
		
		testCaseResult.destroy();
		
		// Take input resultList
		IData[] outResultList;
		IData[] inResultList = pipeCursor.first("resultList") ? IDataUtil.getIDataArray(pipeCursor, "resultList") : null;
		
		// Build new output resultList
		if (inResultList == null) 
			outResultList = new IData[1];
		else {
			outResultList = new IData[inResultList.length + 1];
			System.arraycopy(inResultList, 0, outResultList, 0, inResultList.length);
		}
	
		// Append new assertion
		outResultList[outResultList.length - 1] = testDoc;
		
		return outResultList;
	}
	// --- <<IS-END-SHARED>> ---
}

