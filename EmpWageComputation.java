import java.util.ArrayList;
import java.util.Scanner;

public class EmpWageComputation
{
	static final int HALFDAY=1,FULLDAY=2;
	public static EmpWageBuilder[] build=new EmpWageBuilder[2];
	public static int COMPANY_COUNT=0;

	static int present()
	{
		int random=(int)Math.floor(Math.random()*10)%3;
		return random;
	}

	static int getWorkingHrs(int attdn)
	{
		int workingHrs;
		switch(attdn)
		{
				case HALFDAY:
					workingHrs=4;
					break;
				case FULLDAY:
					workingHrs=8;
					break;
				default:
					workingHrs=0;
		}

		return workingHrs;
	}

	public static void CalculateWage(String Company,int WAGEPERHR,int MONTH,int MAXWORKINGHRS)
	{
		int workingHrs=0,salary,totalSalary=0,totalWorkingHrs=0,day;
		for(day=1;day<=MONTH && totalWorkingHrs<=MAXWORKINGHRS;day++)
		{

			workingHrs=getWorkingHrs(present());

			if(totalWorkingHrs==96||totalWorkingHrs==94)
			{
				if (workingHrs==8)
				break;
			}
			else if(totalWorkingHrs==98)
			{
				break;
			}
			totalWorkingHrs+=workingHrs;
			salary=WAGEPERHR*workingHrs;
			totalSalary+=salary;
		}
		build[COMPANY_COUNT]=new EmpWageBuilder(Company,totalSalary);
		COMPANY_COUNT++;


	}
	public static void main(String[] args)
	{
		EmpWageComputation obj=new EmpWageComputation();
		obj.CalculateWage("Microsoft",20,30,100);
		obj.CalculateWage("Bhoodev",30,15,120);
		int len=build.length;
		for(int i=0;i<len;i++)
		{
			build[i].show();
		}
	}
}

class EmpWageBuilder
{
	public String COMPANY_NAME;
	public int TOTAL_WAGE;

	EmpWageBuilder(String company_name,int totalWage)
	{
		this.COMPANY_NAME=company_name;
		this.TOTAL_WAGE=totalWage;
	}

	public void show()
	{
		System.out.println("Company Name : "+COMPANY_NAME+", Total Wage :"+TOTAL_WAGE);
	}
}
