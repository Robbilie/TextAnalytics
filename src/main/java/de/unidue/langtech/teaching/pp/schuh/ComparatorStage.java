package de.unidue.langtech.teaching.pp.schuh;

import java.lang.reflect.InvocationTargetException;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;

import de.unidue.langtech.teaching.pp.schuh.comparator.AbstractSentenceComparator;
import de.unidue.langtech.teaching.pp.type.GoldScore;
import de.unidue.langtech.teaching.pp.type.GoldSentences;

public class ComparatorStage extends JCasAnnotator_ImplBase {
	
    public static final String PARAM_COMPARATOR_CLASS = "PARAM_COMPARATOR_CLASS";
    @ConfigurationParameter(name = PARAM_COMPARATOR_CLASS)
    private Class<? extends AbstractSentenceComparator> comparatorClass;
	
    public static final String PARAM_COMPARATOR_NAME = "PARAM_COMPARATOR_NAME";
    @ConfigurationParameter(name = PARAM_COMPARATOR_NAME)
    private String comparatorName;

	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		GoldSentences gSentences = JCasUtil.selectSingle(aJCas, GoldSentences.class);
			try {
				AbstractSentenceComparator obj = comparatorClass
						.getConstructor()
						.newInstance();

				obj.setSentences(gSentences.getFirstSentence(), gSentences.getSecondSentence());
				FSArray scores = gSentences.getScores();
				GoldScore gScore = new GoldScore(aJCas);
					gScore.setName(comparatorName);
					gScore.setSimilarity(obj.compare());
				FSArray newScores = new FSArray(aJCas, scores.size() + 1);
					newScores.copyFromArray(scores.toArray(), 0, 0, scores.size());
					newScores.set(scores.size(), gScore);
				gSentences.setScores(newScores);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}

	}

}
