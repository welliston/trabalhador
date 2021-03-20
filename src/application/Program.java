package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("Enter worker data:");
		System.out.print("name: ");
		String workerName = sc.nextLine();
		
		System.out.print("level: ");
		String workerLevel = sc.nextLine();
		
		System.out.print("base salary: ");
		Double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),baseSalary,
				new Department(departmentName));
		
		System.out.print("How many contracts to this worker?");
		int contractsmany = sc.nextInt();
		
		for(int i=0; i< contractsmany; i++) {
			System.out.println("Enter contract #"+ (i+1) + "data:");
			System.out.print("Date (DD/MM/YYYY):");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			
			HourContract hourContract = new HourContract(contractDate,valuePerHour,hours);
			worker.addContract(hourContract);
			
		}
		
		System.out.print("Enter month and year to calculate income (MM/YYYY):");
		String yearAndMonth = sc.next();
		
		int month = Integer.parseInt(yearAndMonth.substring(0,2));
		int year = Integer.parseInt(yearAndMonth.substring(3));
		
		System.out.println("nome: " + worker.getName());
		System.out.println("department: " + worker.getDepartment().getName());
		System.out.println("Income for " + yearAndMonth + ":" + worker.income(year,month));
		
       sc.close();
	}

}
