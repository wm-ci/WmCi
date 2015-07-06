package WmCi;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2015-07-05 22:14:34 MST
// -----( ON-HOST: 192.168.0.16

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import com.wmci.util.*;
// --- <<IS-END-IMPORTS>> ---

public final class util

{
	// ---( internal utility methods )---

	final static util _instance = new util();

	static util _newInstance() { return new util(); }

	static util _cast(Object o) { return (util)o; }

	// ---( server methods )---




	public static final void doNotMapNullOrBlanks (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(doNotMapNullOrBlanks)>> ---
		// @sigtype java 3.5
		IDataCursor cursor = pipeline.getCursor();
		String input = cursor.first("input") ? (String)cursor.getValue() : null;
		
		String value = Util.doNotMapNullOrBlanks(input);
		
		if (value != null)
			cursor.insertAfter("value", value);
		
		cursor.destroy();	
		// --- <<IS-END>> ---

                
	}



	public static final void nvl (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(nvl)>> ---
		// @sigtype java 3.5
		// [i] field:0:required input
		// [i] field:0:required default
		// [i] object:0:required treatEmptyAsNull
		// [o] field:0:required value
		IDataCursor cursor = pipeline.getCursor();
		String input = cursor.first("input") ? (String)cursor.getValue() : null;
		String defaultValue = cursor.first("default") ? (String)cursor.getValue() : null;
		boolean treatEmptyAsNull = cursor.first("treatEmptyAsNull") ? ((Boolean)cursor.getValue())/*.equals("true")*/ : false;
		
		cursor.insertAfter("value", Util.nvl(input, defaultValue, treatEmptyAsNull));
		cursor.insertAfter("params", "input[" + input + "] defaultValue[" + defaultValue + "] treatEmptyAsNull[" + treatEmptyAsNull + "]");
		
		cursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

