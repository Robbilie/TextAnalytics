package de.unidue.langtech.teaching.pp.schuh.comparator;

public class ExactSentenceComparator extends AbstractSentenceComparator {

	@Override
	public float compare() {
		return g1.getSentence().equals(g2.getSentence()) ? 5f : 0f;
	}

}
