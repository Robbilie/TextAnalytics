package de.unidue.langtech.teaching.pp.schuh.comparator;

import de.unidue.langtech.teaching.pp.type.GoldSentence;

public interface ISentenceComparator {
	
	void setSentences(GoldSentence g1, GoldSentence g2);
	
	float compare();

}
