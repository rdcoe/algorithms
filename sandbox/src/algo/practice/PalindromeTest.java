package algo.practice;

import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {

	@Test
	public void testPalindrome() {
		String[] input = { "abba", "", null, "abcba", "abv" };

		int i = 0;
		boolean[] results = new boolean[input.length];
		for (String in : input) {
			results[i++] = PracticeAlgorithms.isPalindrome(in);
		}

		Assert.assertTrue(results[0]);
		Assert.assertFalse(results[1]);
		Assert.assertFalse(results[2]);
		Assert.assertTrue(results[3]);
		Assert.assertFalse(results[4]);
	}

	@Test
	public void testFindLongestPalindrome() {
		String[] input = { "abbainastring", "", null, "abcba", "abv",
				"thisisaracecardon'tyouknow" };

		int i = 0;
		String[] results = new String[input.length];
		for (String in : input) {
			results[i++] = PracticeAlgorithms.findLongestPalindrome(in);
		}

		Assert.assertEquals("abba", results[0]);
		Assert.assertEquals("", results[1]);
		Assert.assertEquals("", results[2]);
		Assert.assertEquals("abcba", results[3]);
		Assert.assertEquals("", results[4]);
		Assert.assertEquals("racecar", results[5]);
	}

}
