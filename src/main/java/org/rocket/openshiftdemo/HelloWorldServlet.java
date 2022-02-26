package org.rocket.openshiftdemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 public static String currentWorkingDirectory =  System.getProperty("user.dir");
	 public static String classPath = System.getProperty("java.class.path");
	 public static final String NEW_LINE = System.getProperty("line.separator");
	 public static final String  clientOsName = System.getProperty("os.name");
	 public static final String javaVendor = System.getProperty("java.vendor");
	 public static final String javaVersion = System.getProperty( "java.version");
	 public static final String tmpDir = System.getProperty( "java.io.tmpdir");
	 
	
	
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		StringBuilder builder = new StringBuilder();
		builder.append("currentWorkingDirectory=").append(currentWorkingDirectory).append(NEW_LINE);
		builder.append("classPath=").append(classPath).append(NEW_LINE);
		builder.append("clientOsName=").append(clientOsName).append(NEW_LINE);
		builder.append("javaVendor=").append(javaVendor).append(NEW_LINE);
		builder.append("javaVersion=").append(javaVersion).append(NEW_LINE);
		builder.append("tmpDir=").append(tmpDir).append(NEW_LINE);
		builder.append("NEW_LINE=").append(NEW_LINE).append(NEW_LINE);
		DBC11011.dbCall(builder);
		
		
		
		
		response.getWriter().append(builder.toString()).append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
