package com.lunchies.order.formulas;

/**
 * @author Pedro Caleia
 */
public interface CaloriesCalculationFormula {
	
	public int calculate(int entryCalorieCount, int mainCourseCalorieCount, int beverageCalorieCount);

}
