package de.unidue.langtech.teaching.pp.schuh;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.StringArray;

import de.unidue.langtech.teaching.pp.type.GoldSentence;
import de.unidue.langtech.teaching.pp.type.GoldSentences;

public class SentenceExtractor extends JCasAnnotator_ImplBase {

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		String[] parts = aJCas.getDocumentText().toLowerCase().split("\\t");
		
		GoldSentences gSentences = new GoldSentences(aJCas);
			gSentences.setId(Integer.parseInt(parts[0]));
			gSentences.setSimilarity(Float.parseFloat(parts[1]));
			gSentences.setScores(new FSArray(aJCas, 0));
			gSentences.setFirstSentence(this.processSentence(aJCas, parts[2]));
			gSentences.setSecondSentence(this.processSentence(aJCas, parts[3]));
			gSentences.addToIndexes();
	}

	public GoldSentence processSentence(JCas aJCas, String rawSentence) {
		String sentence = rawSentence.replaceAll("[^a-z0-9\\ ]", "");
		GoldSentence gSentence = new GoldSentence(aJCas);
			gSentence.setSentence(sentence);
			gSentence.setLength(sentence.length());
			String[] words = sentence.split(" ");
			StringArray gWords = new StringArray(aJCas, words.length);
				gWords.copyFromArray(words,0, 0, words.length);
			gSentence.setWords(gWords);
			gSentence.setWordCount(words.length);
		return gSentence;
	}

}
