import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import javax.servlet.annotation.*;
@WebServlet("/Login")
public class Login extends HttpServlet
{	public void service(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException
	{		try
		{	res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			String a=req.getParameter("t1");
			String b=req.getParameter("t2");
			String c=req.getParameter("t3");
			String d=req.getParameter("t4");
			Configuration cfg=new Configuration();
			SessionFactory sf=cfg.configure().buildSessionFactory();
			Session ss=sf.openSession();
			mypojo pojo=new mypojo();
			pojo.setEmployeeid(a);
			pojo.setEmployeename(b);
			pojo.setEmployeeemail(c);
			pojo.setEmployeeaddress(d);
			Transaction tx=ss.beginTransaction();
			ss.save(pojo);
			tx.commit();
			ss.close();
			res.sendRedirect("success.html");
		}
		catch(Exception ae)
		{		}	}}


