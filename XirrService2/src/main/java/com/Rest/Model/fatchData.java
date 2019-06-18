package com.Rest.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.Rest.DataBase.Dbconnection;
import com.Rest.beans.Person;

public class fatchData {
		
	private Connection con; 
	private PreparedStatement ps;
	@Autowired
	Dbconnection d; //Dbconnection is a connection class present in connection package

	
public  List<Person> genderData()
{
	List<Person> listPerson = new ArrayList<Person>();


	Person p1= new Person();
	p1.setGender("male");
	p1.setId("1");
	Person p2= new Person();
	p2.setGender("female");
	p2.setId("2");
	listPerson.add(p1);
    listPerson.add(p2);
/*
	
int x=0;
try {	
	
con=d.start(); 
ps=con.prepareStatement("");
ps.setString(1, u);    
ps.setString(2, p);
ResultSet rs=ps.executeQuery();
if(rs.next())
{
x=1;

}
} catch (Exception e) {
System.out.println(e);
}
*/


return listPerson;
}



public  List<Person> Dateapi()
{
	List<Person> listPerson = new ArrayList<Person>();


	Person p1= new Person();
	p1.setGender("male");
	p1.setId("1");
	Person p2= new Person();
	p2.setGender("female");
	p2.setId("2");
	listPerson.add(p1);
    listPerson.add(p2);


return listPerson;
}


}