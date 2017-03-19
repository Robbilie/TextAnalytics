package de.unidue.langtech.teaching.pp.schuh;

import static org.junit.Assert.assertEquals;

import org.apache.uima.collection.CollectionReaderDescription;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.JCasIterable;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.junit.Test;

public class ReaderTest {
	
	@Test
	public void testReader() throws ResourceInitializationException {
		CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
			Reader.class,
			Reader.PARAM_SENTENCE_INPUT_FILE, 
			"src/test/resources/test/readerTestData.txt", 
			Reader.PARAM_SCORE_INPUT_FILE, 
			"src/test/resources/test/readerTestScores.txt"
		);
		for (JCas jcas : new JCasIterable(reader)) {
			assertEquals(jcas.getDocumentText(), "0\t5.000\ttest\ttest");
		}
	}
	
	@Test
	public void testCompactReader() throws ResourceInitializationException {
		CollectionReaderDescription reader = CollectionReaderFactory.createReaderDescription(
			Reader.class,
			Reader.PARAM_SENTENCE_INPUT_FILE, 
			"src/test/resources/test/readerTestCompact.txt"
		);
		for (JCas jcas : new JCasIterable(reader)) {
			assertEquals(jcas.getDocumentText(), "0\t5.000\ttest\ttest");
		}
	}

}
