package de.unidue.langtech.teaching.pp.schuh;

import org.apache.commons.io.FileUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.component.JCasCollectionReader_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by rschuh on 2/7/17.
 */
public class Reader extends JCasCollectionReader_ImplBase {

	// Input File Path Name
	public static final String PARAM_SENTENCE_INPUT_FILE = "SentenceInputFile";
	@ConfigurationParameter(name = PARAM_SENTENCE_INPUT_FILE)
	private File sentenceInputFile;
	
	// Score Input File Path Name
	public static final String PARAM_SCORE_INPUT_FILE = "ScoreInputFile";
	@ConfigurationParameter(name = PARAM_SCORE_INPUT_FILE)
	private File scoreInputFile;

	private List<String> sentenceLines;
	private List<String> scoreLines;
	private int currentLine;

	@Override
	public void initialize (UimaContext context) throws ResourceInitializationException {
		super.initialize(context);

		currentLine = 0;
		try {
			sentenceLines = FileUtils.readLines(sentenceInputFile);
			scoreLines = FileUtils.readLines(scoreInputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void getNext(JCas jCas) throws IOException, CollectionException {
		jCas.setDocumentText(currentLine + "\t" + scoreLines.get(currentLine) + "\t" + sentenceLines.get(currentLine));
        currentLine++;
	}

	@Override
	public boolean hasNext() throws IOException, CollectionException {
		return currentLine < sentenceLines.size();
	}

	@Override
	public Progress[] getProgress() {
		return new Progress[] { new ProgressImpl(currentLine, sentenceLines.size(), "sentences") };
	}
}
