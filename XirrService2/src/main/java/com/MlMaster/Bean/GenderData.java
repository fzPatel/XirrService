package com.MlMaster.Bean;
public class GenderData
{
    private String id;

    private String gender;

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getGender ()
    {
        return gender;
    }

    public void setGender (String gender)
    {
        this.gender = gender;
    }

	@Override
	public String toString() {
		return "GenderData [id=" + id + ", gender=" + gender + "]";
	}

    
}