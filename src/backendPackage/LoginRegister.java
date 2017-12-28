package backendPackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginRegister
 */
@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginRegister() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StudentDAOClass daoobj= new StudentDAOClass();
		
		String userName=request.getParameter("login_username");
		String password=request.getParameter("login_password");
		String submittype=request.getParameter("submit");
		
		
		
		BasicStudentClass basicobj=daoobj.getStudent(userName, password);
		request.getSession().setAttribute("basicobj", basicobj);
		
		
		//code for login button
		if(submittype.equals("Login") && basicobj!=null && basicobj.getUserName()!=null)
		{
			//request.setAttribute("message", basicobj.getUserName());
			request.getSession().setAttribute("basicobj", basicobj);
			request.getSession().setAttribute("userName", userName);
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
		
		
		//code for registration button
		else if(submittype.equals("Register"))
		{
			if(request.getParameter("register_username").isEmpty()!=true && request.getParameter("register_firstname").isEmpty()!=true &&
					request.getParameter("register_lastname").isEmpty()!=true && request.getParameter("register_password").isEmpty()!=true)
			
				{
			basicobj.setUserName(request.getParameter("register_username"));
			basicobj.setFirstName(request.getParameter("register_firstname"));
			basicobj.setLastName(request.getParameter("register_lastname"));
			basicobj.setPassword(request.getParameter("register_password"));
			daoobj.insertStudent(basicobj);
			request.setAttribute("successMessage", "Registration Complete");
			request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			else
			{
				request.setAttribute("emptyMessage", "Any Field cannot be empty! Fill carefully !");
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}
			
		}
		
		
		
		
		
		//code for update button
		else if(submittype.equals("Update"))
		{

			if(request.getParameter("update_firstname").isEmpty()!=true &&
					request.getParameter("update_lastname").isEmpty()!=true && request.getParameter("update_password").isEmpty()!=true)
			
				{
					//basicobj.setUserName(requestName);
					basicobj.setFirstName(request.getParameter("update_firstname"));
					basicobj.setLastName(request.getParameter("update_lastname"));
					basicobj.setPassword(request.getParameter("update_password"));
					
					String requestName=(String)request.getSession().getAttribute("userName");
					daoobj.updateStudent(basicobj, requestName);
					request.setAttribute("updateMessage", "Update Completed! Login Now!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			else
			{
				request.setAttribute("emptyMessage", "Any Field cannot be empty! Fill carefully !");
				request.getRequestDispatcher("registration.jsp").forward(request, response);
			}
		}
		
		//code for logout button
		else if(submittype.equals("Logout"))
		{
			HttpSession session= request.getSession(false);
			session.invalidate();
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		else
		{
			request.setAttribute("ErrorMessage", "Data not found, Click register");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
	}

}
