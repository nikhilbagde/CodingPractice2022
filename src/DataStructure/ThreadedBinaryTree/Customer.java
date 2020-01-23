package DataStructure.ThreadedBinaryTree;

public class Customer
{
	String name;
	MyDate birthDate;
	int birthMonth;
	int birthDay;
	int birthYear;
	int zip;

	public Customer()
	{
		name = null;
		birthDate = new MyDate (1,1,1980);
		birthMonth = 1;
		birthDay = 1;
		birthYear = 1980;
		zip = 29401;
	}

	public Customer(String name, int month, int day, int year, int zip)
	{
		this.name = name;
		birthDate = new MyDate (day, month, year);
		birthMonth = month;
		birthDay = day;
		birthYear = year;
		this.zip = zip;
	}
	
	public String getName()
	{
		return name;
	}

	public int getBirthMonth()
	{
		return birthMonth;
	}
	
	public int getBirthDay()
	{
		return birthDay;
	}

	public int getBirthYear()
	{
		return birthYear;
	}
	
	public int getZip()
	{
		return zip;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public void setBirthMonth(int month)
	{
		birthMonth = month;
	}
	
	public void setBirthDay(int day)
	{
		birthDay = day;
	}

	public void setBirthYear(int year)
	{
		birthYear = year;
	}

	public void setZip(int zip)
	{
		this.zip = zip;
	}

	public String toString ()
	{
		String output;
		output = "Name: "+name+" BirthDay: "+birthDate+" Zip: "+zip;
		return output;
	}
}
