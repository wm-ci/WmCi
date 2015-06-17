package WmCi;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2015-06-07 02:21:06 MST
// -----( ON-HOST: 192.168.0.15

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
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
		// @sigtype java 3.5
		// [i] object:0:required input
		// [i] object:0:required compare
		// [o] object:0:required success
		// [o] field:0:required message
		IDataCursor cursor = pipeline.getCursor();
		String input = cursor.first("input") ? (String)cursor.getValue() : null;
		String compare = cursor.first("compare") ? (String)cursor.getValue() : null;
		
		Result result = Eval.equal(input, compare);
		
		cursor.insertAfter("success", result.isSuccess());
		cursor.insertAfter("message", result.getMessage());
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void notEqual (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(notEqual)>> ---
		// @sigtype java 3.5
		// [i] object:0:required input
		// [i] object:0:required compare
		// [o] object:0:required success
		// [o] field:0:required message
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

