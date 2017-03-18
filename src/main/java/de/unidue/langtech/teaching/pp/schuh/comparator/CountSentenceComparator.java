package de.unidue.langtech.teaching.pp.schuh.comparator;

public class CountSentenceComparator extends AbstractSentenceComparator {

	@Override
	public float compare() {
		return g1.getWordCount() == g2.getWordCount() ? 5f : 0f;
	}

}
