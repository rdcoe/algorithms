package algo.practice;

import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

public class FindWordsInStringTest {

	@Test
	public void testFind1WordInString() {
		String s = "word";
		TreeSet<String> dict = new TreeSet<>();
		dict.add("word");

		FindWordsInString find = new FindWordsInString(s);
		find.loadDictionary(dict);

		String[] foundWords = find.extractWords();

		Assert.assertEquals("expected 1 word.", 1, foundWords.length);
		Assert.assertSame(s, foundWords[0]);
	}

	@Test
	public void testFind2WordInString() {
		String s = "wordstring";
		TreeSet<String> dict = new TreeSet<>();
		dict.add("word");
		dict.add("string");

		FindWordsInString find = new FindWordsInString(s);
		find.loadDictionary(dict);

		String[] foundWords = find.extractWords();

		Assert.assertEquals("expected 2 words.", 2, foundWords.length);
		Assert.assertTrue(dict.contains(foundWords[0]));
		Assert.assertTrue(dict.contains(foundWords[1]));
	}

	@Test
	public void testFind2WordInStringWithExtraCharacters() {
		String s = "wordxxxstringxxx";
		TreeSet<String> dict = new TreeSet<>();
		dict.add("word");
		dict.add("string");

		FindWordsInString find = new FindWordsInString(s);
		find.loadDictionary(dict);

		String[] foundWords = find.extractWords();

		Assert.assertEquals("expected 2 words.", 2, foundWords.length);
		Assert.assertTrue(dict.contains(foundWords[0]));
		Assert.assertTrue(dict.contains(foundWords[1]));
	}

	// "programcreek", ["programcree","program","creek"].
	@Test
	public void testFind3WordInStringWithOverlappingCharacters() {
		String s = "programcreek";
		TreeSet<String> dict = new TreeSet<>();
		dict.add("programcree");
		dict.add("program");
		dict.add("creek");

		FindWordsInString find = new FindWordsInString(s);
		find.loadDictionary(dict);

		String[] foundWords = find.extractWords();

		Assert.assertEquals("expected 3 words.", 3, foundWords.length);
		Assert.assertTrue(dict.contains(foundWords[0]));
		Assert.assertTrue(dict.contains(foundWords[1]));
		Assert.assertTrue(dict.contains(foundWords[2]));
	}

}
