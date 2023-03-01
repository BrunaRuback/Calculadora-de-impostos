import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws Exception 
    {
        Scanner sc = new Scanner(System.in);

        ArrayList<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++)
        {
            System.out.println("---- Tax payer #" + i + " data ----");
            System.out.print("Individual or company (i/c)? ");
            char type = sc.next().charAt(0);

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            Double anualIncome = sc.nextDouble();

            switch(type)
            {
                case 'i':
                    System.out.print("Health expenditures: ");
                    Double healthExpenditures = sc.nextDouble();

                    taxPayers.add(new Individual(name, anualIncome, healthExpenditures));
                    break;
                case 'c':
                    System.out.print("Number of employees: ");
                    int numberOfEmployees = sc.nextInt();

                    taxPayers.add(new Company(name, anualIncome, numberOfEmployees));
                    break;       
            }
        }

		System.out.println();
        
		System.out.println("--- TAXES PAID ---");
        double total = 0;
		for (TaxPayer t : taxPayers) 
        {
			double tax = t.tax();
			System.out.println(t.getName() + ": $ " + String.format("%.2f", tax));
			total += tax;
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", total));
		
		sc.close();

    }

}
