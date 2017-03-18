package de.unidue.langtech.teaching.pp.schuh.comparator;

public class LengthSentenceComparator extends AbstractSentenceComparator {

	@Override
	public float compare() {
		return g1.getLength() == g2.getLength() ? 5f : 0f;
	}

}
