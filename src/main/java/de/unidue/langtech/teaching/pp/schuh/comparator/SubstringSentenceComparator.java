package de.unidue.langtech.teaching.pp.schuh.comparator;

public class SubstringSentenceComparator extends AbstractSentenceComparator {

	@Override
	public float compare() {
		return g1.getSentence().contains(g2.getSentence()) || g2.getSentence().contains(g1.getSentence()) ? 5f : 0f;
	}

}
