package de.unidue.langtech.teaching.pp.schuh;

import java.lang.reflect.InvocationTargetException;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;

import de.unidue.langtech.teaching.pp.schuh.comparator.SentenceComparator;
import de.unidue.langtech.teaching.pp.type.GoldScore;
import de.unidue.langtech.teaching.pp.type.GoldSentence;
import de.unidue.langtech.teaching.pp.type.GoldSentences;

public class ComparatorStage extends JCasAnnotator_ImplBase {
	
    public static final String PARAM_COMPARATOR_CLASS = "PARAM_COMPARATOR_CLASS";
    @ConfigurationParameter(name = PARAM_COMPARATOR_CLASS)
    private Class<? extends SentenceComparator> comparatorClass;
	
    public static final String PARAM_COMPARATOR_NAME = "PARAM_COMPARATOR_NAME";
    @ConfigurationParameter(name = PARAM_COMPARATOR_NAME)
    private String comparatorName;

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		GoldSentences gSentence = JCasUtil.selectSingle(aJCas, GoldSentences.class);
		try {
			SentenceComparator obj = comparatorClass.getConstructor(GoldSentence.class, GoldSentence.class).newInstance(gSentence.getFirstSentence(), gSentence.getSecondSentence());
			FSArray scores = gSentence.getScores();
			GoldScore gScore = new GoldScore(aJCas);
				gScore.setName(comparatorName);
				gScore.setSimilarity(obj.compare());
			FSArray newScores = new FSArray(aJCas, scores.size() + 1);
				newScores.copyFromArray(scores.toArray(), 0, 0, scores.size());
				newScores.set(scores.size(), gScore);
			gSentence.setScores(newScores);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
