package de.unidue.langtech.teaching.pp.schuh;

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

import de.unidue.langtech.teaching.pp.type.GoldSentences;

public class SentenceExtractorTest {
	
	@Test
	public void testSentenceExtractor() throws UIMAException {
		JCas jcas = JCasFactory.createJCas();
		jcas.setDocumentText("0\t5.000\ttest\ttest");
		
		AnalysisEngineDescription segmenter = createEngineDescription(SentenceExtractor.class);
		AnalysisEngine segEngine = createEngine(segmenter);
		segEngine.process(jcas);
		
		GoldSentences gSentences = JCasUtil.selectSingle(jcas, GoldSentences.class);

		assertEquals(gSentences.getFirstSentence().getSentence(), "test");
		assertEquals(gSentences.getSecondSentence().getSentence(), "test");
		assertEquals(gSentences.getId(), 0);
		assertEquals(gSentences.getSimilarity(), 5f, 0f);
	}

}
