package org.rocket.util;

public class Util {
	
	
	public static final String CRMTRACE = "[OPENSHIFTTRACE]";
	 public static final String NEW_LINE = System.getProperty("line.separator");
	 
	 public static String getCursomStackTrace(String info, Throwable aThrowable) {
		    // add the class name and any message passed to constructor
		    final StringBuilder result = new StringBuilder("");

		    if (aThrowable == null)
		        return result.toString();

		    result.append(aThrowable.toString());
		  
		    result.append(NEW_LINE);

		    // add each element of the stack trace
		    for (StackTraceElement element : aThrowable.getStackTrace()) {
		        result.append(element);
		        result.append(NEW_LINE);
		    }
		    
		    String temp=(CRMTRACE+ ":Info:"+ info + "\r\nException\r\n"  +   result.toString());

		    return temp;
		}

		/**
		 * Gets the custom stack trace.
		 *
		 * @param aThrowable
		 *            the a throwable
		 * @return the custom stack trace
		 */
		public static String getCursomStackTrace(String info, Exception aThrowable) {
		    // add the class name and any message passed to constructor
		    final StringBuilder result = new StringBuilder("");
		    if (aThrowable == null) {
		        return result.toString();
		    }
		    result.append(aThrowable.toString());
		    final String NEW_LINE = System.getProperty("line.separator");
		    result.append(NEW_LINE);

		    // add each element of the stack trace
		    for (StackTraceElement element : aThrowable.getStackTrace()) {
		        result.append(element);
		        result.append(NEW_LINE);
		    }
		    
		   String temp = (CRMTRACE+ ": Info:"+ info + "\r\nException\r\n"  +   result.toString());
		   return temp;

		 	}
		

}
