package org.springsource.examples.expenses.reports;

/**
 * @author Josh Long
 */
public class DefaultExpenseValidationStrategy implements ExpenseValidationStrategy {

	private double maxAbsoluteValue ;

	public DefaultExpenseValidationStrategy(double maxAbsoluteValue) {
		this.maxAbsoluteValue = maxAbsoluteValue;
	}

	public DefaultExpenseValidationStrategy() {
		this(25.0d);
	}

	@Override
	public boolean validate(Expense item) {
		if(item == null ) throw new IllegalArgumentException("the item can't be null");
		double charge = item.getAmount();
		return ( item.getReceipt() == null || charge > maxAbsoluteValue);
	}
}
