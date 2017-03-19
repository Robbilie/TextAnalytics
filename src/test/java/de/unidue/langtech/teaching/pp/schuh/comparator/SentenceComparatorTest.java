package de.unidue.langtech.teaching.pp.schuh.comparator;

import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngine;
import static org.apache.uima.fit.factory.AnalysisEngineFactory.createEngineDescription;
import static org.junit.Assert.assertEquals;

import org.apache.uima.UIMAException;
import org.apache.uima.analysis_engine.AnalysisEngine;
import org.apache.uima.analysis_engine.AnalysisEngineDescription;
import org.apache.uima.fit.factory.JCasFactory;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.junit.Test;

import de.unidue.langtech.teaching.pp.schuh.SentenceExtractor;
import de.unidue.langtech.teaching.pp.type.GoldSentences;

public class SentenceComparatorTest {
	
	public JCas init(String text) throws UIMAException {
		JCas jcas = JCasFactory.createJCas();
		jcas.setDocumentText(text);
		
		AnalysisEngineDescription segmenter = createEngineDescription(SentenceExtractor.class);
		AnalysisEngine segEngine = createEngine(segmenter);
		segEngine.process(jcas);
		
		return jcas;
	}
	
	@Test
	public void testMinSentenceComparator() throws UIMAException {
		JCas aJCas = init("0\t5\ttest\ttest");
		
		GoldSentences gSentences = JCasUtil.selectSingle(aJCas, GoldSentences.class);
		
		AbstractSentenceComparator sc = new MinSentenceComparator();
			sc.setSentences(gSentences.getFirstSentence(), gSentences.getSecondSentence());
			
		assertEquals(0f, sc.compare(), 0f);
	}
	
	@Test
	public void testExactSentenceComparator() throws UIMAException {
		JCas aJCas = init("0\t5\ttest\ttest");
		
		GoldSentences gSentences = JCasUtil.selectSingle(aJCas, GoldSentences.class);
		
		AbstractSentenceComparator sc = new ExactSentenceComparator();
			sc.setSentences(gSentences.getFirstSentence(), gSentences.getSecondSentence());
			
		assertEquals(5f, sc.compare(), 0f);
	}

}
