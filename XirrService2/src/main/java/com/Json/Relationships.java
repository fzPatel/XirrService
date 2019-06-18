package com.Json;
public class Relationships
{
    private Author author;

    public Author getAuthor ()
    {
        return author;
    }

    public void setAuthor (Author author)
    {
        this.author = author;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [author = "+author+"]";
    }
}