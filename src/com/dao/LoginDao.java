package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

public class LoginDao 
{
	String url = "jdbc:mysql://localhost:3306/temp";
	String username = "root";
	String password = "root";
	String query = "select * from logins where username = ? and password = ?";
	boolean flag = false;
	public boolean checkCredentials(String user, String pass) 
	{
		try
		{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,username,password);
				PreparedStatement st = con.prepareStatement(query);
				st.setString(1, user);
				st.setString(2, pass);
				ResultSet rs = st.executeQuery();
				if(rs.next())
				{
					flag = true;
				}

		}
		catch (Exception e )
				{
					// TODO: handle exception
				}
		return flag;

	}

}
