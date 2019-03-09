package entities;

public class IndividualTax extends Tax {

	private Double healthyExpenditures;
	
	public IndividualTax() {
		super();
	}
	
	public IndividualTax(String name, Double anualIncome, Double healthyExpenditures) {
		super(name, anualIncome);
		this.healthyExpenditures = healthyExpenditures;
	}

	public Double getHealthyExpenditures() {
		return healthyExpenditures;
	}

	public void setHealthyExpenditures(Double healthyExpenditures) {
		this.healthyExpenditures = healthyExpenditures;
	}

	@Override
	public Double taxPayed() {

		Double threshold = 20000.00;
		Double taxPay;
		
		if(getAnualIncome() < threshold) {
			taxPay = getAnualIncome() * 0.15;
		}
		else {
			taxPay = getAnualIncome() * 0.25;
		}
		
		taxPay += - (healthyExpenditures * 0.5);
		return taxPay;
	}

}
