package de.unidue.langtech.teaching.pp.schuh.pipeline;

import de.unidue.langtech.teaching.pp.schuh.Reader;
import de.unidue.langtech.teaching.pp.schuh.SentenceExtractor;
import de.unidue.langtech.teaching.pp.schuh.ComparatorStage;
import de.unidue.langtech.teaching.pp.schuh.SimilarityDumper;
import de.unidue.langtech.teaching.pp.schuh.comparator.*;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;

/**
 * Created by rschuh on 2/7/17.
 */
public class SimilarityPipeline {

	public static void main (String[] args) throws Exception {

		SimplePipeline.runPipeline(
			CollectionReaderFactory.createReader(
					Reader.class, 
					Reader.PARAM_SENTENCE_INPUT_FILE, "src/test/resources/data/STS.input.MSRvid.txt", 
					Reader.PARAM_SCORE_INPUT_FILE, "src/test/resources/data/STS.gs.MSRvid.txt"),
            AnalysisEngineFactory.createEngineDescription(
            		SentenceExtractor.class),
            AnalysisEngineFactory.createEngineDescription(
            		ComparatorStage.class, 
            		ComparatorStage.PARAM_COMPARATOR_NAME,
            		"Min",
            		ComparatorStage.PARAM_COMPARATOR_CLASS, 
            		MinSentenceComparator.class),
            AnalysisEngineFactory.createEngineDescription(
            		ComparatorStage.class, 
            		ComparatorStage.PARAM_COMPARATOR_NAME,
            		"Max",
            		ComparatorStage.PARAM_COMPARATOR_CLASS, 
            		MaxSentenceComparator.class),
            AnalysisEngineFactory.createEngineDescription(
            		ComparatorStage.class, 
            		ComparatorStage.PARAM_COMPARATOR_NAME,
            		"Half",
            		ComparatorStage.PARAM_COMPARATOR_CLASS, 
            		HalfSentenceComparator.class),
            AnalysisEngineFactory.createEngineDescription(
            		ComparatorStage.class, 
            		ComparatorStage.PARAM_COMPARATOR_NAME,
            		"Random",
            		ComparatorStage.PARAM_COMPARATOR_CLASS, 
            		RandomSentenceComparator.class),
            AnalysisEngineFactory.createEngineDescription(
            		ComparatorStage.class, 
            		ComparatorStage.PARAM_COMPARATOR_NAME,
            		"Length",
            		ComparatorStage.PARAM_COMPARATOR_CLASS, 
            		LengthSentenceComparator.class),
            AnalysisEngineFactory.createEngineDescription(
            		ComparatorStage.class, 
            		ComparatorStage.PARAM_COMPARATOR_NAME,
            		"Substr",
            		ComparatorStage.PARAM_COMPARATOR_CLASS, 
            		SubstringSentenceComparator.class),
            AnalysisEngineFactory.createEngineDescription(
            		ComparatorStage.class, 
            		ComparatorStage.PARAM_COMPARATOR_NAME,
            		"Levenshtein",
            		ComparatorStage.PARAM_COMPARATOR_CLASS, 
            		LevenshteinSentenceComparator.class),
			AnalysisEngineFactory.createEngineDescription(SimilarityDumper.class)
		);

	}

}
