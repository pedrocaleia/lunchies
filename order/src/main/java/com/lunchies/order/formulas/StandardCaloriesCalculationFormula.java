package com.lunchies.order.formulas;

import org.springframework.stereotype.Component;

/**
 * @author Pedro Caleia
 */
@Component
public class StandardCaloriesCalculationFormula implements CaloriesCalculationFormula {

	@Override
	public int calculate(int entryCalorieCount, int mainCourseCalorieCount, int beverageCalorieCount) {
		return entryCalorieCount + mainCourseCalorieCount + beverageCalorieCount;
	}

}
