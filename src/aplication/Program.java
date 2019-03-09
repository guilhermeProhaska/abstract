package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.CompanyTax;
import entities.IndividualTax;
import entities.Tax;

public class Program {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Tax> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			
			if(ch == 'i') {
				System.out.print("Healthy expenditures: ");
				double healthyExpenditures = sc.nextDouble();
				list.add(new IndividualTax(name, anualIncome, healthyExpenditures));
			}
			else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new CompanyTax(name, anualIncome, numberOfEmployees));
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		for(Tax tax : list) {
			System.out.printf("%s: $ %.2f%n", tax.getName(), tax.taxPayed());
		}
		
		double sum = 0;
		for(Tax tax : list) {
			sum += tax.taxPayed();
		}
		
		System.out.printf("TOTAL TAXES: $ %.2f", sum);
		sc.close();
	}

}
