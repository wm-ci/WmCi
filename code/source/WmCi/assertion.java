package WmCi;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2015-07-04 23:54:52 MST
// -----( ON-HOST: 192.168.0.16

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.ArrayList;
import java.util.List;
import com.wmci.assertion.*;
// --- <<IS-END-IMPORTS>> ---

public final class assertion

{
	// ---( internal utility methods )---

	final static assertion _instance = new assertion();

	static assertion _newInstance() { return new assertion(); }

	static assertion _cast(Object o) { return (assertion)o; }

	// ---( server methods )---




	public static final void equal (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(equal)>> ---
		// @specification WmCi.spec:BasicAssert
		// @sigtype java 3.5
		IDataCursor cursor = pipeline.getCursor();
		String input = cursor.first("input") ? (String)cursor.getValue() : null;
		String compare = cursor.first("compare") ? (String)cursor.getValue() : null;
		
		Result result = Eval.equal(input, compare);
		
		cursor.insertAfter("success", result.isSuccess());
		cursor.insertAfter("message", result.getMessage());
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void equal2 (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(equal2)>> ---
		// @specification WmCi.spec:BasicTestCase
		// @sigtype java 3.5
		IDataCursor pipeCursor = pipeline.getCursor();
		
		try {
			String input = pipeCursor.first("input") ? (String)pipeCursor.getValue() : null;
			String compare = pipeCursor.first("compare") ? (String)pipeCursor.getValue() : null;
			
			String initTime = null;//yyyy/MM/dd hh:mm:ss:SSS
			Result result = Eval.equal(input, compare);
			String endTime = null;//yyyy/MM/dd hh:mm:ss:SSS
		
			// create an testDoc IData object
			IData testDoc = IDataFactory.create();
			// create a cursor to use to add key value tuples to the
			// testDoc
			IDataCursor testCaseResult = testDoc.getCursor();
			// add key value tuples as required to the testDoc
			testCaseResult.insertAfter("test", pipeCursor.first("test") ? (String)pipeCursor.getValue() : null);
			testCaseResult.insertAfter("case", pipeCursor.first("case") ? (String)pipeCursor.getValue() : null);
			testCaseResult.insertAfter("element", pipeCursor.first("element") ? (String)pipeCursor.getValue() : null);
			testCaseResult.insertAfter("success", result.isSuccess());
			testCaseResult.insertAfter("message", result.getMessage());
			testCaseResult.insertAfter("initTime", initTime);
			testCaseResult.insertAfter("endTime", endTime);
			// ...
			// destroy the intermediateCursor when done adding key value tuples
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
		IDataCursor cursor = pipeline.getCursor();
		String input = cursor.first("input") ? (String)cursor.getValue() : null;
		String compare = cursor.first("compare") ? (String)cursor.getValue() : null;
		
		Result result = Eval.notEqual(input, compare);
		
		cursor.insertAfter("success", result.isSuccess());
		cursor.insertAfter("message", result.getMessage());
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

