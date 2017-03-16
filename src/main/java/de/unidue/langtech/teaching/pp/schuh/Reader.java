package de.unidue.langtech.teaching.pp.schuh;

import org.apache.commons.io.FileUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.component.JCasCollectionReader_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.cas.StringArray;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

import de.unidue.langtech.teaching.pp.type.GoldSentence;
import de.unidue.langtech.teaching.pp.type.GoldSentences;

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

		try {
			currentLine = 0;
			sentenceLines = FileUtils.readLines(sentenceInputFile);
			scoreLines = FileUtils.readLines(scoreInputFile);
		} catch (IOException e) {
			throw new ResourceInitializationException(e);
		}
	}

	@Override
	public void getNext(JCas jCas) throws IOException, CollectionException {
		String[] sentences = sentenceLines.get(currentLine).split("\\t");
		Float score = Float.parseFloat(scoreLines.get(currentLine));
		
		GoldSentences gSentences = new GoldSentences(jCas);
			gSentences.setId(currentLine);
			gSentences.setSimilarity(score);
			gSentences.setScores(new FSList(jCas));

			GoldSentence gFirstSentence = new GoldSentence(jCas);
				gFirstSentence.setSentence(sentences[0]);
				gFirstSentence.setLength(sentences[0].length());
				String[] firstWords = sentences[0].split(" ");
				StringArray gFirstWords = new StringArray(jCas, firstWords.length);
					gFirstWords.copyFromArray(firstWords, 0, 0, firstWords.length);
				gFirstSentence.setWords(gFirstWords);
				gFirstSentence.setWordCount(firstWords.length);
			gSentences.setFirstSentence(gFirstSentence);
		
			GoldSentence gSecondSentence = new GoldSentence(jCas);
				gSecondSentence.setSentence(sentences[1]);
				gSecondSentence.setLength(sentences[0].length());
				String[] secondWords = sentences[0].split(" ");
				StringArray gSecondWords = new StringArray(jCas, secondWords.length);
					gSecondWords.copyFromArray(secondWords, 0, 0, secondWords.length);
				gSecondSentence.setWords(gSecondWords);
				gSecondSentence.setWordCount(secondWords.length);
			gSentences.setSecondSentence(gSecondSentence);
			
			gSentences.addToIndexes();
			
		jCas.setDocumentText(sentenceLines.get(currentLine));
		
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
