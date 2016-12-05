package com.example.user.sqliteexample;

/**
 * Created by User on 5/12/2016.
 */
import	com.example.user.sqliteexample.UserContract.User;

public class	UserRecord	{
    private	String	name;
    private	String	email;
    public	String	getName()	{
        return	name;
    }
    public void	setName(String	name)	{
        this.name	=	name;
    }
    public	String	getEmail()	{
        return	email;
    }
    public void	setEmail(String	email)	{
        this.email	=	email;
    }
    @Override
    public	String	toString(){
        return	User.COLUMN_NAME	+	":"	+	this.name	+
                ","	+	User.COLUMN_EMAIL	+	":"	+	this.email;
    }
}
