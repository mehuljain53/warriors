package com.example.myapp_;

public class strings {
private static String ourname[]=new String[100];
private static String rollno[]=new String[100];
private static String bluename[]=new String[100];
private static String hardname[]=new String[100];
private static int l=0;


public static String getOurname(int length)
{
	
return ourname[length];
}
public static String rollno(int length)
{
	
return rollno[length];
}
public static String bluename(int length)
{
	
return bluename[length];
}
public static String hardname(int length)
{
	
return hardname[length];
}
public static int getlength()
{
	return l;
}
public static void  putOurname(String g)
{
ourname[l]=g;	

 
}public static void putrollno(String g)
{
	
rollno[l]=g;

}
public static void puthardname(String g)
{
hardname[l]=g;	

 
}public static void inclength()
{
l=l+1;	
 
}
public static void putBluename(String g)
{
bluename[l]=g;	
 
}
}
