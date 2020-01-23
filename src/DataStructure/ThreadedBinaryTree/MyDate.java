package DataStructure.ThreadedBinaryTree;

import java.util.*;
public class MyDate extends GregorianCalendar
{	
	int day;
	int month;
	int year;
	
	public MyDate (int day, int month, int year)
	{
		super (year, month, day);
		this.day = day;
		this.month = month;
		this.year = year;
	}

	/*public int compareTo (Object date)
	{
		MyDate compare = (MyDate) date;
		return (this.day - compare.get(Calendar.DAY_OF_MONTH));
	}*/

	public String toString ()
	{
		String output = "";
		switch (month)
		{
			case (1):
			{
				output = "January";
				break;
			}
			case (2):
			{
				output = "February";
				break;
			}
			case (3):
			{
				output = "March";
				break;
			}
			case (4):
			{
				output = "April";
				break;
			}
			case (5):
			{
				output = "May";
				break;
			}
			case (6):
			{
				output = "June";
				break;
			}
			case (7):
			{
				output = "July";
				break;
			}
			case (8):
			{
				output = "August";
				break;
			}
			case (9):
			{
				output = "September";
				break;
			}
			case (10):
			{
				output = "October";
				break;
			}
			case (11):
			{
				output = "November";
				break;
			}
			case (12):
			{
				output = "December";
				break;
			}
		}
		output += " "+day+", "+year;
		return output;
	}
}
