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

		String sentence1 = parts[2].replaceAll("[^a-z0-9\\ ]", "");
		String sentence2 = parts[3].replaceAll("[^a-z0-9\\ ]", "");
		
		GoldSentences gSentences = new GoldSentences(aJCas);
			gSentences.setId(Integer.parseInt(parts[0]));
			gSentences.setSimilarity(Float.parseFloat(parts[1]));
			gSentences.setScores(new FSArray(aJCas, 0));

			GoldSentence gFirstSentence = new GoldSentence(aJCas);
				gFirstSentence.setSentence(sentence1);
				gFirstSentence.setLength(sentence1.length());
				String[] firstWords = sentence1.split(" ");
				StringArray gFirstWords = new StringArray(aJCas, firstWords.length);
					gFirstWords.copyFromArray(firstWords, 0, 0, firstWords.length);
				gFirstSentence.setWords(gFirstWords);
				gFirstSentence.setWordCount(firstWords.length);
			gSentences.setFirstSentence(gFirstSentence);
		
			GoldSentence gSecondSentence = new GoldSentence(aJCas);
				gSecondSentence.setSentence(sentence2);
				gSecondSentence.setLength(sentence2.length());
				String[] secondWords = sentence2.split(" ");
				StringArray gSecondWords = new StringArray(aJCas, secondWords.length);
					gSecondWords.copyFromArray(secondWords, 0, 0, secondWords.length);
				gSecondSentence.setWords(gSecondWords);
				gSecondSentence.setWordCount(secondWords.length);
			gSentences.setSecondSentence(gSecondSentence);
			
			gSentences.addToIndexes();
	}

}
