package de.unidue.langtech.teaching.pp.schuh.comparator;

import java.util.Random;

public class RandomSentenceComparator extends AbstractSentenceComparator {

	@Override
	public float compare() {
		return new Random().nextFloat() * 5;
	}

}
