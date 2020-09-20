public class EmpWageComputation
{
	public static final int HALFDAY=1,FULLDAY=2;

	private static int COMPANY_COUNT=0;
	private CompanyEmpWage[] CompanyEmpWageArray;


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

	public void CalculateWage()
	{
		for(int i=0;i<COMPANY_COUNT;i++)
		{
			CompanyEmpWageArray[i].setTotalWage(CalculateWage(CompanyEmpWageArray[i]));
                        CompanyEmpWageArray[i].show();
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
		}

		return totalSalary;


	}

	public EmpWageComputation()
	{
		CompanyEmpWageArray=new CompanyEmpWage[5];
	}

	private void addCompanyEmpWage(String Company,int WagePerHr,int Month,int MaxWorkingHrs)
	{
		CompanyEmpWageArray[COMPANY_COUNT]=new CompanyEmpWage(Company,WagePerHr,Month,MaxWorkingHrs);
		COMPANY_COUNT++;
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





