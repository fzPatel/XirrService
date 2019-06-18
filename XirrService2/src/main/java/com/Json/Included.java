package com.Json;

import com.Json.*;;

public class Included
{
    private Attributes attributes;

    private String id;

    private String type;

    public Attributes getAttributes ()
    {
        return attributes;
    }

    public void setAttributes (Attributes attributes)
    {
        this.attributes = attributes;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [attributes = "+attributes+", id = "+id+", type = "+type+"]";
    }
}