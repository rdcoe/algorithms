package algo.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class PracticeAlgorithms {

	public static String findLongestPalindrome(String input) {
		if (input == null || input.length() == 0)
			return "";

		HashSet<String> found = new HashSet<>();
		int n = input.length() / 2;
		for (int ws = 2; ws <= input.length(); ws++) {
			int index = 0;
			while (index < n && index + ws <= input.length()) {
				String subs = input.substring(index, index + ws);
				if (isPalindrome(subs)) {
					// dictionary check missing
					found.add(subs);
					break;
				} else {
					index++;
				}
			}
		}

		String[] sortedByLengthDesc = found.toArray(new String[found.size()]);
		if (found.size() >= 1) {
			Arrays.sort(sortedByLengthDesc, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return (o1.length() >= o2.length() ? -1 : 1);
				}
			});
		}

		return (sortedByLengthDesc.length == 0 ? "" : sortedByLengthDesc[0]);
	}

	public static boolean isPalindrome(String input) {
		if (input == null || input.length() == 0)
			return false;

		int n = input.length() / 2;
		for (int i = 0, j = input.length() - 1; i < n; i++, j--) {
			if (input.charAt(i) != input.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
