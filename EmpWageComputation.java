import java.util.*;
interface IEmpWageComputation
{
	public void addCompanyEmpWage(String Company,int WagePerHr,int Month,int MaxWorkingHrs);
	public void CalculateWage();
}

public class EmpWageComputation implements IEmpWageComputation
{
	public static final int HALFDAY=1,FULLDAY=2;

	ArrayList<CompanyEmpWage>CompanyEmpWageList;
	ArrayList dailyWageList;


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

	@Override
	public void CalculateWage()
	{
		for(CompanyEmpWage list:CompanyEmpWageList)
		{
			list.setTotalWage(CalculateWage(list));
			list.show();
			System.out.println("The Daily Wage List is :\n"+dailyWageList+"\n");

		}


	}

	public int CalculateWage(CompanyEmpWage CompanyEmpWage)
	{
		int workingHrs=0,salary,totalSalary=0,totalWorkingHrs=0,day;
		for(day=1;day<=CompanyEmpWage.MONTH && totalWorkingHrs<=CompanyEmpWage.MAXWORKINGHRS;day++)
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
			salary=CompanyEmpWage.WAGEPERHR*workingHrs;
			totalSalary+=salary;
			dailyWageList.add(salary);
		}

		return totalSalary;


	}

	public EmpWageComputation()
	{
		CompanyEmpWageList=new ArrayList<>();
		dailyWageList=new ArrayList<>();
	}

	@Override
	public void addCompanyEmpWage(String Company,int WagePerHr,int Month,int MaxWorkingHrs)
	{
		CompanyEmpWageList.add(new CompanyEmpWage(Company,WagePerHr,Month,MaxWorkingHrs));
	}

	public static void main(String[] args)
	{
		EmpWageComputation  obj=new EmpWageComputation();
		obj.addCompanyEmpWage("Microsoft",20,30,100);
		obj.addCompanyEmpWage("FlipKart",30,15,120);
		obj.CalculateWage();


	}
}

class CompanyEmpWage
{
	public final int WAGEPERHR,MONTH,MAXWORKINGHRS;
	public int TOTAL_WAGE;
	public String COMPANY_NAME;

	public CompanyEmpWage(String Company,int WagePerHr,int Month,int MaxWorkingHrs)
	{
		this.COMPANY_NAME=Company;
		this.WAGEPERHR=WagePerHr;
		this.MONTH=Month;
		this.MAXWORKINGHRS=MaxWorkingHrs;
	}

	public void setTotalWage(int totalSalary)
	{
		this.TOTAL_WAGE=totalSalary;
	}

	public void show()
	{
		System.out.println("Company Name : "+this.COMPANY_NAME+", Total Wage :"+this.TOTAL_WAGE);
	}

}
