package coursera;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class Huffman {

	public Map<Character, Integer> times(List<Character> charList) {
		ListIterator<Character> iter = charList.listIterator();
		Map<Character, Integer> counts = new HashMap<>();

		while (iter.hasNext()) {
			Character c = iter.next();
			if (!counts.containsKey(c)) {
				counts.put(c, 1);
			} else {
				counts.put(c, counts.get(c) + 1);
			}
		}

		return counts;
	}

}
