package de.unidue.langtech.teaching.pp.schuh.pipeline;

import de.unidue.langtech.teaching.pp.schuh.Reader;
import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;

/**
 * Created by rschuh on 2/7/17.
 */
public class SimilarityPipeline {

	public static void main (String[] args) throws Exception {

		SimplePipeline.runPipeline(
			CollectionReaderFactory.createReader(Reader.class, Reader.PARAM_INPUT_FILE, "src/test/resources/test/input.txt"),
			//AnalysisEngineFactory.createEngineDescription()
		);

	}

}
