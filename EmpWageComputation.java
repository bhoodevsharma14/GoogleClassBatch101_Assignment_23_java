import java.util.ArrayList;
import java.util.Scanner;

public class EmpWageComputation
{
	public static final int HALFDAY=1,FULLDAY=2;
	public static int COMPANY_COUNT=0;
	private final int TOTAL_WAGE,WAGEPERHR,MONTH,MAXWORKINGHRS;
	public String COMPANY_NAME;
//	public static EmpWageComputation[] build=new EmpWageComputation[2];



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

	public int CalculateWage()
	{
		int workingHrs=0,salary,totalSalary=0,totalWorkingHrs=0,day;
		for(day=1;day<=this.MONTH && totalWorkingHrs<=this.MAXWORKINGHRS;day++)
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
			salary=this.WAGEPERHR*workingHrs;
			totalSalary+=salary;
		}
		//build[COMPANY_COUNT]=new EmpWageComputation(Company,totalSalary);
		COMPANY_COUNT++;
		return totalSalary;


	}

	public EmpWageComputation(String Company,int WagePerHr,int Month,int MaxWorkingHrs)
	{
		this.COMPANY_NAME=Company;
		this.WAGEPERHR=WagePerHr;
		this.MONTH=Month;
		this.MAXWORKINGHRS=MaxWorkingHrs;
		this.TOTAL_WAGE=CalculateWage();;
		this.show();
	}

	public void show()
	{
		System.out.println("Company Name : "+this.COMPANY_NAME+", Total Wage :"+this.TOTAL_WAGE);
	}

	public static void main(String[] args)
	{
		EmpWageComputation Microsoft=new EmpWageComputation("Microsoft",20,30,100);
		EmpWageComputation FlipKart=new EmpWageComputation("FlipKart",30,15,120);
	}
}

