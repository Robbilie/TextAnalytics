package de.unidue.langtech.teaching.pp.schuh.comparator;

import de.unidue.langtech.teaching.pp.type.GoldSentence;

public abstract class AbstractSentenceComparator implements ISentenceComparator {
	
	GoldSentence g1;
	GoldSentence g2;
	
	public void setSentences(GoldSentence g1, GoldSentence g2)  {
		this.g1 = g1;
		this.g2 = g2;
	}

}
