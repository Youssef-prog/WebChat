import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  

public class Subscribe extends HttpServlet {
	private final long serialVersionUID = 1L;
        private final Util util = new Util();
        private String name = null;  
        
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
                
           
            try {
                name = request.getParameter("name");
                util.saveParam(name, "name");
                util.logInfo("POST /subscribe " + name);
            }
           catch (Exception e) {
                  try {
                      String s = util.getCustomStackTrace(e);
                      util.logError(s);
                  }
                  catch (Exception a) {}
                }        
            
        }
	 

}
