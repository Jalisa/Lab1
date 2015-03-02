import java.util.Scanner;

public class Calc{

	public static void Main(String[] args) {
		// second commit
		Scanner input = new Scanner(System.in);

		System.out.println("How many years will you work? ");
		int working_years = input.nextInt();

		System.out.println("How many years are you planning to retire? ");
		int retirement_years = input.nextInt();

		System.out
				.println("How many dollars will you require per month when retired? ");
		double retirement_income = input.nextDouble();

		System.out
				.println("How many dollars will you collect from SSI monthly? ");
		double ssi = input.nextDouble();

		System.out
				.println("What will be the annual return of your savings during retirement years? ");
		double retirement_return = input.nextDouble();
		while (retirement_return < 0 || retirement_return > 0.03) {
			System.out
					.println("Error, this return must be between 0 and 0.03. Try again. ");
			retirement_return = input.nextDouble();
		}

		System.out
				.println("What will be the annual return of your savings during working years? ");
		double working_return = input.nextDouble();
		while (working_return < 0 || working_return > 0.20) {
			System.out
					.println("Error, this return must be between 0 and 0.20. Try again. ");
			working_return = input.nextDouble();
		}

		input.close();

		double savings = 0;
		int month = 1;
		while (month < 12 * retirement_years + 1) {
			savings += (retirement_income - ssi)
					* Math.pow((1 - retirement_return / 12), (month));
			month += 1;
		}

		
		savings = (retirement_income - ssi)
				* (1 - Math.pow(1 + retirement_return / 12, -240))
				/ (retirement_return / 12);

		month = 0;
		double interest_coefficient = 0;
		while (month < 12 * working_years) {
			interest_coefficient += Math
					.pow((1 + working_return / 12), (month));
			month += 1;
		}

		double save_each_month = savings / interest_coefficient;
		System.out.println("You will need to save $" + save_each_month
				+ " every month during working years.");
	}

}
