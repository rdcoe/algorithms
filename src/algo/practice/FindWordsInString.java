package algo.practice;

import java.util.ArrayList;
import java.util.SortedSet;

public class FindWordsInString {
	private String string;
	private SortedSet<String> dict;

	public FindWordsInString(String stringToSearch) {
		string = stringToSearch;
	}

	public void loadDictionary(SortedSet<String> dict) {
		this.dict = dict;
	}

	public String[] extractWords() {
		ArrayList<String> list = new ArrayList<>();

		for (int start = 0; start <= string.length(); start++) {
			for (int i = start; i <= string.length(); i++) {
				String s = string.substring(start, i);
				if (dict.contains(s)) {
					list.add(s);
					start = i;
					continue;
				}
			}
		}

		return list.toArray(new String[list.size()]);
	}
}
