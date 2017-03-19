package de.unidue.langtech.teaching.pp.schuh.comparator;

import org.apache.uima.UIMAException;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.jcas.JCas;

public class SentenceComparatorTest {
	
	public JCas init(String text) throws UIMAException {
		JCas jcas = JCasFactory.createJCas();
		jcas.setDocumentText(text);
		
		return jcas;
	}
	
	public void testMinSentenceComparator() {
		AbstractSentenceComparator sc = new MinSentenceComparator();
			//sc.setSentences(g1, g2);
	}

}
