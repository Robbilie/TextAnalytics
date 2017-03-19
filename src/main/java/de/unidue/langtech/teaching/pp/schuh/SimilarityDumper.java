package de.unidue.langtech.teaching.pp.schuh;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.*;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.fit.component.CasDumpWriter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.resource.ResourceInitializationException;

import de.unidue.langtech.teaching.pp.type.GoldScore;
import de.unidue.langtech.teaching.pp.type.GoldSentences;

public class SimilarityDumper extends CasDumpWriter {
  
	private PrintWriter out;
	private HashMap<String, List<Float>> calculatedValues = new HashMap<>();
	private List<Float> goldValues = new ArrayList<Float>();
	
	@Override
    public void initialize(UimaContext context) throws ResourceInitializationException {
        super.initialize(context);
		try {
			Field f = CasDumpWriter.class.getDeclaredField("out");
        		f.setAccessible(true);
        	out = (PrintWriter)f.get(this);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void process(CAS aCAS) throws AnalysisEngineProcessException {
		try {
			GoldSentences gs = JCasUtil.selectSingle(aCAS.getJCas(), GoldSentences.class);
			
			Arrays.asList(gs.getScores().toArray()).stream().forEach(s -> {
				GoldScore gScore = (GoldScore)s;
				if (calculatedValues.containsKey(gScore.getName()) == false) {
					calculatedValues.put(gScore.getName(), new ArrayList<Float>());
				}
				calculatedValues.get(gScore.getName()).add(gs.getId(), gScore.getSimilarity());
			});
		
			goldValues.add(gs.getId(), gs.getSimilarity());
		} catch (CASException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void collectionProcessComplete() {
		
		calculatedValues.forEach((name, calculatedResults) -> {
			FMeasureCalculator fm = new FMeasureCalculator();
				fm.setGoldValues(goldValues);
				fm.setTestValues(calculatedResults);
			
			out.println(String.format("%0$-20s", name + ":") + fm.calculateFMeasure());
		});

		out.flush();
	}
	
}
