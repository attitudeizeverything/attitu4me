package com.yoho;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionSupport;
import com.yoho.listener.HibernateListener;
public class Welcome extends ActionSupport{	
	private static final long serialVersionUID = 1L;
	
	private String accesstype;
	/*
	ModelSignage accesstype = new ModelSignage();

	public Object getModel() {
		return accesstype;
	}


	//save 
	

	//list all customers
	public String listCustomer() throws Exception{

		//get hibernate session from the servlet context
		SessionFactory sessionFactory =
	         (SessionFactory) ServletActionContext.getServletContext()
                     .getAttribute(HibernateListener.KEY_NAME);

		Session session = sessionFactory.openSession();

		customerList = session.createQuery("from Customer").list();

		return SUCCESS;

	}
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	*/
	public String getAccesstype() {
		return accesstype;
	}

	public void setAccesstype(String accesstype) {
		this.accesstype = accesstype;
	}

	public String execute() throws Exception{

		if(accesstype.equals("welcome"))
		{
		
		//get hibernate session from the servlet context
		SessionFactory sessionFactory =
	         (SessionFactory) ServletActionContext.getServletContext()
                     .getAttribute(HibernateListener.KEY_NAME);

		Session session = sessionFactory.openSession();

		//save it
		setAccesstype(accesstype);;

		session.beginTransaction();
		session.save(accesstype);
		session.getTransaction().commit();

		return SUCCESS;
		}else 
			return ERROR;

	}
	
	/*
	public String execute()
	{		
		if(accesstype.equals("welcome"))
		{
			 java.sql.Connection con = null;
			 String url = "jdbc:mysql://192.168.225.225:3306";
			 String user = "root";
			 String password = "";

			 try
			    {
			      // create a mysql database connection
				 Class.forName("com.mysql.jdbc.Driver");
				 con = DriverManager.getConnection(url, user, password);
			     Statement st = (Statement) con.createStatement(); 

			     st.executeUpdate("insert into yoho.access(id,ACCESS_TYPE,IS_ACTIVE) " + "VALUES (2,\""+accesstype+"\",1)");

			     con.close();
			    }
			    catch (Exception e)
			    {
			      System.err.println("Error!");
			      System.err.println(e.getMessage());
			    }
			 
			return SUCCESS;
			
		}else 
			return ERROR;
	}
	*/
	
}
