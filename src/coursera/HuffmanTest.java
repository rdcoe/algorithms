package coursera;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class HuffmanTest {

	@Test
	public void test() {
		Character[] chars = { new Character('a'), new Character('b'),
				new Character('c'), new Character('a'), new Character('b'),
				new Character('d') };

		Map<Character, Integer> expected = new HashMap<>();
		expected.put(new Character('a'), new Integer(2));
		expected.put(new Character('b'), new Integer(2));
		expected.put(new Character('c'), new Integer(1));
		expected.put(new Character('d'), new Integer(1));

		List<Character> charList = Arrays.asList(chars);

		Huffman huffman = new Huffman();
		Map<Character, Integer> counts = huffman.times(charList);

		Assert.assertEquals(counts.size(), expected.size());
		for (Map.Entry<Character, Integer> entry : expected.entrySet()) {
			Assert.assertEquals(counts.get(entry.getKey()), entry.getValue());
		}
	}
}
