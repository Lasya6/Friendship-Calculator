package in.ac.vce;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

/**
 * Servlet implementation class Friendshippercent
 */
public class Friendshippercent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Friendshippercent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public static int lcs(char[] your, char[] friend, int yournamelength, int friendnamelength)
	{
		if (yournamelength == 0 || friendnamelength == 0)
            return 0;
		
        if (your[yournamelength - 1] == friend[friendnamelength - 1])
            return 1 + lcs(your, friend, yournamelength - 1, friendnamelength - 1);
        
        else
            return Math.max(lcs(your, friend, yournamelength, friendnamelength- 1), lcs(your, friend, yournamelength - 1, friendnamelength));
        
		
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String yourname = request.getParameter("yourname");
		String friendname = request.getParameter("friendname");
		
		int yournamelength = yourname.length();
		int friendnamelength = friendname.length();
		
	    int res=0;
	    
		char your[] = yourname.toCharArray();
		char friend[] = friendname.toCharArray();
		
		res = Friendshippercent.lcs(your, friend, yournamelength, friendnamelength);	
	
		double frpercent,frfraction;
		
		int maxlen = Math.max(friendnamelength, yournamelength);
		
		frfraction = (double)res/maxlen;
		
		frpercent = frfraction*100;
		
		String docType =
		         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		final DecimalFormat df = new DecimalFormat("0.00");
		      out.println(docType +
		         "<html>\n" +"<body bgcolor = \"fa8072\">\n" +
		               "<h1 align = \"center\">" + "Your friendship percentage is: "+ df.format(frpercent) +
		               "</h1>\n\n" +"</body>" + 
		    		  "</html>");
	}
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
