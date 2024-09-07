package com.project.deo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.project.bean.student;

public class InsertQuery {

	public static int isquery(student ob)
	{
		Connection conn=connet.suceess();
		int bal=0;
		try {
			
			PreparedStatement ps=conn.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1, ob.getId());
			ps.setString(2, ob.getName());
			ps.setString(3,ob.getEmail());
			ps.setString(4, ob.getPassword());
			
			 bal=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bal;
	}
	public static int isdelete(student ob)
	{
		Connection conn=connet.suceess();
		int bal=0;
		try {
			
			PreparedStatement ps=conn.prepareStatement("update student set name=? where id=?");
			ps.setString(1, ob.getName());
			ps.setInt(2, ob.getId());
			
			
			
			 bal=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bal;
	}
	public static int isupdate(student ob)
	{
		Connection conn=connet.suceess();
		int bal=0;
		try {
			
			PreparedStatement ps=conn.prepareStatement("delete from student where id=?");
			ps.setInt(1, ob.getId());
			
			
			
			 bal=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bal;
	}
	
	public static List<student> isShow()
	{
		Connection conn=connet.suceess();
		List<student>al=new ArrayList<student>();
		
		try {
			PreparedStatement ps=conn.prepareStatement("select * from student");
			
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				student ob=new student();
				
				ob.setId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setEmail(rs.getString(3));
				ob.setPassword(rs.getString(4));
				al.add(ob);
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return al;
	}
	public static int del(int id)
	{
		Connection conn=connet.suceess();
		
		int status=0;
		try
		{
			PreparedStatement ps=conn.prepareStatement("delete from student where id=?");
			ps.setInt(1, id);
			
			status=ps.executeUpdate();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return status;
		
	}
	
	public static student up(int id)
	{
		Connection conn=connet.suceess();
		student ob=new student();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from student where id=?");
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ob.setId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setEmail(rs.getString(3));
				ob.setPassword(rs.getString(4));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ob;
		
	}
	public static int isupdation(student ob)
	{
		Connection conn=connet.suceess();
		int status=0;
		try {
			PreparedStatement ps=conn.prepareStatement("update student set name=?,email=?,password=? where id=?");
			ps.setString(1,ob.getName());
			ps.setString(2, ob.getEmail());
			ps.setString(3, ob.getPassword());
			ps.setInt(4, ob.getId());
			
			status=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return status;
		
		
	}
	public static List<student> isfetch(String name)
	{
		List<student>al=new ArrayList<student>();
		Connection conn=connet.suceess();
		
		try
		{
			PreparedStatement ps=conn.prepareStatement("select * from student where name=?");
			ps.setString(1, name);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				student ob=new student();
				ob.setId(rs.getInt(1));
				ob.setName(rs.getString(2));
				ob.setEmail(rs.getString(3));
				ob.setPassword(rs.getString(4));
				al.add(ob);

				
			}
			
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return al;
	}
	

}
