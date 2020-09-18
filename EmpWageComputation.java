import java.util.Scanner;
public class EmpWageComputation
{
	static final int HALFDAY=1,FULLDAY=2;

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

		System.out.println(Company+"\t Company Employee Earns "+totalSalary+" This Month\n");

	}

	public EmpWageComputation(int numberOfCompany)
	{
		for(int i=1;i<=numberOfCompany;i++)
			{	Scanner sc1=new Scanner(System.in);
				System.out.println("\nEnter Name of Company : ");
				String companyName=sc1.nextLine();
				System.out.println("Enter Wage Per Hours : ");
				int wagePerHr=sc1.nextInt();
				System.out.println("Number of Working Days : ");
				int month=sc1.nextInt();
				System.out.println("Maximun Nuber of working Hours : ");
				int maxworkinghrs=sc1.nextInt();
				CalculateWage(companyName,wagePerHr,month,maxworkinghrs);
			}
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number of Companies");
		int numberOfCompany=	sc.nextInt();
		EmpWageComputation obj=new EmpWageComputation(numberOfCompany);
	}
}
