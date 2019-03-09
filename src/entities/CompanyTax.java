package entities;

public class CompanyTax extends Tax {

	private Integer numberOfEmployees;
	
	public CompanyTax() {
		super();
	}
	
	public CompanyTax(String name, Double anualIncome, Integer numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double taxPayed() {
		Integer thresholdEmployees = 10;
		Double taxPay;
		
		if(getNumberOfEmployees() > thresholdEmployees) {
			taxPay = getAnualIncome() * 0.14;
		}
		else {
			taxPay = getAnualIncome() * 0.16;
		}
		
		return taxPay;
	}

}
