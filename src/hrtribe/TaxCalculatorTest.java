package hrtribe;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class TaxCalculatorTest {
	@Test
	public void testEffectiveTaxRate() {
		TaxCalculator calc = new TaxCalculator();
		float rate0 = calc.getEffectiveTaxRate(0);
		float rate10 = calc.getEffectiveTaxRate(10000);
		float rate125 = calc.getEffectiveTaxRate(20000);
		float rate15 = calc.getEffectiveTaxRate(30000);
		float rate21 = calc.getEffectiveTaxRate(50000);

		NumberFormat fmt = NumberFormat.getPercentInstance(Locale.getDefault());
		Assert.assertEquals("extepected 0% but was " + fmt.format(rate0),
				fmt.format(0f), fmt.format(rate0));
		Assert.assertEquals("extepected 10% but was " + fmt.format(rate10),
				fmt.format(0.1f), fmt.format(rate10));
		Assert.assertEquals("extepected 12.5% but was " + fmt.format(rate125),
				fmt.format(0.125f), fmt.format(rate125));
		Assert.assertEquals("extepected 15% but was " + fmt.format(rate15),
				fmt.format(0.15f), fmt.format(rate15));
		Assert.assertEquals(
				"extepected 26.25% but was " + fmt.format(rate21),
				fmt.format(0.21f), fmt.format(rate21));
	}

	@Test
	public void testTaxableIncomeZeroWhenIncomeIsZero() {
		double income = 0;

		TaxCalculator calc = new TaxCalculator();
		float payable = calc.calculateTax(income);

		Assert.assertTrue("should be 0 but was " + payable, payable == 0f);
	}

	@Test
	public void testTaxableIncomeWhenIncomeLessThanMinimumTaxabale() {
		double income = 9000;

		TaxCalculator calc = new TaxCalculator();
		float payable = calc.calculateTax(income);

		Assert.assertTrue("should be 900 but was " + payable, payable == 900f);
	}

	@Test
	public void testTaxableIncomeWhenIncomeMoreThanMinimumAndLessThanMaximum() {
		double income = 35000;

		TaxCalculator calc = new TaxCalculator();
		float payable = calc.calculateTax(income);

		// expected = 10000*.1 + 10000 * .15 + 10000 * .2 + 5000 * .3
		Assert.assertTrue("should be 6000 but was " + payable, payable == 6000f);
	}

	@Test
	public void testTaxableIncomeWhenIncomeMoreThanMaximum() {
		double income = 85000;

		TaxCalculator calc = new TaxCalculator();
		float payable = calc.calculateTax(income);

		// expected = 10000*.1 + 10000 * .15 + 10000 * .2 + 20000 * .3 + 35000 *
		// .4
		Assert.assertTrue("should be 24500 but was " + payable,
				payable == 24500f);
	}
}
