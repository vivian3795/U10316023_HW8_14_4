/**
 * ID: U10316023
 * Ex: 14.4
 * Information:
 *      Loan class is written according to the requirements on P580.
 */
import java.util.Scanner;

public class Loan {
  private double annualInterestRate;
  private int numberOfYears;
  private double loanAmount;
  private java.util.Date loanDate;

  /** Default constructor */
  public Loan() {
    this(2.5, 1, 1000);
  }

  /** Construct a loan with specified annual interest rate,
      number of years and loan amount 
    */
  public Loan(double annualInterestRate, int numberOfYears,
      double loanAmount) {
    setAnnualInterestRate(annualInterestRate);
    setNumberOfYears(numberOfYears);
    setLoanAmount(loanAmount);
    loanDate = new java.util.Date();
  }

  /** Return annualInterestRate */
  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  /** Set a new annualInterestRate & cannot less than or equal to zero.*/
  public void setAnnualInterestRate(double annualInterestRate) throws IllegalArgumentException {
	if(annualInterestRate>0)
		this.annualInterestRate = annualInterestRate;
	else
		throw new IllegalArgumentException(
        "Interest rate cannot less than or equal to zero.");
  }

  /** Return numberOfYears */
  public int getNumberOfYears() {
    return numberOfYears;
  }

  /** Set a new numberOfYears & cannot less than or equal to zero.*/
  public void setNumberOfYears(int numberOfYears) throws IllegalArgumentException {
    if(numberOfYears>0)
		this.numberOfYears = numberOfYears;
	else
		throw new IllegalArgumentException(
        "Number of years cannot less than or equal to zero.");
  }

  /** Return loanAmount */
  public double getLoanAmount() {
    return loanAmount;
  }

  /** Set a newloanAmount & cannot less than or equal to zero.*/
  public void setLoanAmount(double loanAmount) throws IllegalArgumentException {
	if(loanAmount>0)
		this.loanAmount = loanAmount;
	else
		throw new IllegalArgumentException(
        "Loan amount cannot less than or equal to zero.");
  }

  /** Find monthly payment */
  public double getMonthlyPayment() {
    double monthlyInterestRate = annualInterestRate / 1200;
    double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
      (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
    return monthlyPayment;    
  }

  /** Find total payment */
  public double getTotalPayment() {
    double totalPayment = getMonthlyPayment() * numberOfYears * 12;
    return totalPayment;    
  }

  /** Return loan date */
  public java.util.Date getLoanDate() {
    return loanDate;
  }

  /** Main method */
  public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);

    // Enter yearly interest rate
    System.out.print(
      "Enter yearly interest rate, for example, 8.25: ");
    double annualInterestRate = input.nextDouble();

    // Enter number of years
    System.out.print("Enter number of years as an integer: ");
    int numberOfYears = input.nextInt();

    // Enter loan amount
    System.out.print("Enter loan amount, for example, 120000.95: ");
    double loanAmount =  input.nextDouble();

    try{
		// Create Loan object
		Loan loan =
		new Loan(annualInterestRate, numberOfYears, loanAmount);

		// Display loan date, monthly payment, and total payment
		System.out.printf("The loan was created on %s\n" +
		"The monthly payment is %.2f\nThe total payment is %.2f\n",
		loan.getLoanDate().toString(), loan.getMonthlyPayment(), 
		loan.getTotalPayment());
	}
	catch(IllegalArgumentException ex){
		  System.out.println(ex);
	  }
  }
}
