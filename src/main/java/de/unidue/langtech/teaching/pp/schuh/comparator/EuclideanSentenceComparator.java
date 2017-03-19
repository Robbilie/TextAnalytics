package de.unidue.langtech.teaching.pp.schuh.comparator;

import org.simmetrics.StringMetric;
import org.simmetrics.metrics.StringMetrics;

public class EuclideanSentenceComparator extends AbstractSentenceComparator {

	@Override
	public float compare() {
		StringMetric metric = StringMetrics.euclideanDistance();
		return metric.compare(g1.getSentence(), g2.getSentence()) * 5f;
	}

}
