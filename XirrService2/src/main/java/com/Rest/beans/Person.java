package com.Rest.beans;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement
public class Person 
{
    private String id;
    private String gender;

	public String getId() {
		return id;
	}
	public String setId(String id) {
		return this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
 
  
}