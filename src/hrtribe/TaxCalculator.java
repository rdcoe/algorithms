package hrtribe;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TaxCalculator {
	TreeMap<Integer, Float> taxTable = new TreeMap<>();

	public static void main(String[] args)
	{
		TaxCalculator calc = new TaxCalculator();
		double income = 134000;
		calc.taxTable.clear();
		calc.taxTable.put(0, 0.0f);
		calc.taxTable.put(44701, 0.15f);
		calc.taxTable.put(89401, 0.22f);
		calc.taxTable.put(138586, 0.26f);
		calc.taxTable.put(Integer.MAX_VALUE, 0.29f);
		double tax = calc.calculateTax(income);
		System.out.printf("tax on %6.2f is %6.2f", income, tax);
	}
	
	public TaxCalculator() {
		taxTable.put(0, 0.0f);
		taxTable.put(10000, 0.10f);
		taxTable.put(20000, 0.15f);
		taxTable.put(30000, 0.20f);
		taxTable.put(50000, 0.30f);
		taxTable.put(Integer.MAX_VALUE, 0.40f);
	}

	public float calculateTax(double income) {
		float payable = 0;
		if (income > 0) {
			Entry<Integer, Float> floor = taxTable.floorEntry((int) income);
			Entry<Integer, Float> ceiling = taxTable.ceilingEntry((int) income);
			float effectiveTaxRate = getEffectiveTaxRate(floor.getKey());
			payable = effectiveTaxRate * floor.getKey();

			int diff = (int) income - floor.getKey();
			payable += diff * ceiling.getValue();
		}

		return payable;
	}

	float getEffectiveTaxRate(Integer ceiling) {
		float rate = 0f;
		int prevLevel = 0;
		int prevRange = 0;
		float prevRate = 0f;
		for (Map.Entry<Integer, Float> entry : taxTable.entrySet()) {
			Integer currLevel = entry.getKey();
			float currRate = entry.getValue();
			if (currLevel > ceiling) {
				break;
			}
			int currRange = currLevel - prevLevel;
			if ((prevRange + currRange) > 0) {
				rate = (prevRate * prevRange + currRange * currRate)
						/ (float) (prevRange + currRange);
			}
			prevLevel = currLevel;
			prevRate = rate;
			prevRange += currRange;
		}

		return rate;
	}
}
