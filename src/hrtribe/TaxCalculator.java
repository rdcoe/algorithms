package hrtribe;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class TaxCalculator {
	TreeMap<Integer, Float> taxTable = new TreeMap<>();

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
