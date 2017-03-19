package de.unidue.langtech.teaching.pp.schuh.comparator;

import org.simmetrics.metrics.Levenshtein;

public class LevenshteinSentenceComparator extends AbstractSentenceComparator {

	@Override
	public float compare() {
		Levenshtein metric = new Levenshtein();
		return metric.compare(g1.getSentence(), g2.getSentence());
	}

}
