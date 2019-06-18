package com.Json;

import java.util.ArrayList;

public class Json1Impl 
{

	public  ArrayList < Object > getData() 
	
		{
	
		ArrayList < Object > data = new ArrayList < Object > ();
		Included d=new Included();
		 d.setId("1");
		 d.setType("articles");
		 
		 Attributes a=new Attributes();
		 
		 a.setAge("25");
		 a.setName("Firoz");
		 a.setGender("Male");
		 	 
		 data.add(d);
		 data.add(a);
		 
		 return data;
		   
		 /*
		 "included": [
			    {
			      "type": "people",
			      "id": "42",
			      "attributes": {
			        "name": "John",
			        "age": 80,
			        "gender": "male"
			      }
			    }
			  ]
		 */
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	 /*
		 
		"data": [{
			    "type": "articles",
			    "id": "1",
			    "attributes": {
			      "title": "JSON:API paints my bikeshed!",
			      "body": "The shortest article. Ever.",
			      "created": "2015-05-22T14:56:29.000Z",
			      "updated": "2015-05-22T14:56:28.000Z"
			    },
			    "relationships": {
			      "author": {
			        "data": {"id": "42", "type": "people"}
			      }
			    }
			  }],
			  "included": [
			    {
			      "type": "people",
			      "id": "42",
			      "attributes": {
			        "name": "John",
			        "age": 80,
			        "gender": "male"
			      }
			    }
			  ]
			*/}
	}

	
	

