package de.unidue.langtech.teaching.pp.schuh;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        Field f;
		try {
			f = CasDumpWriter.class.getDeclaredField("out");
        	f.setAccessible(true);
        	out = (PrintWriter)f.get(this);
        	/*out.println("+\t\t+\t\t+");
        	out.println("|\tID\t|\tSimil.\t|");
        	out.println("+\t\t+\t\t+");*/
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
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
				calculatedValues.get(gScore.getName()).add(gScore.getSimilarity());
			});
		
			goldValues.add(gs.getSimilarity());
			
			/*
			out.println(
				"|\t" + 
				gs.getId() + 
				"\t|\t" + 
				gs.getSimilarity() + 
				"\t|\t" + 
				Arrays
					.asList(gs.getScores().toArray())
					.stream()
					.map(s -> ((GoldScore)s).getSimilarity() + "")
					.collect(Collectors.joining("\t|\t")) + 
				"\t|");
		    out.flush();
		    */
		} catch (CASException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void collectionProcessComplete() {
		
		calculatedValues.forEach((name, calculatedResults) -> {

			List<Float> recalls = new ArrayList<Float>();
			List<Float> precisions = new ArrayList<Float>();
			
			IntStream.rangeClosed(0, 2).forEach(i -> {
				List<float[]> pairs = pair(goldValues, calculatedResults);
				int TP = pairs.stream()
						.filter(pair -> 
							isInSpace(5f, 3, i, pair[0]) && 
							isInSpace(5f, 3, i, pair[1])
						)
						.collect(Collectors.toList()).size();
				int FN = pairs.stream()
						.filter(pair -> 
							isInSpace(5f, 3, i, pair[0]) && 
							!isInSpace(5f, 3, i, pair[1])
						)
						.collect(Collectors.toList()).size();
				int FP = pairs.stream()
						.filter(pair -> 
							!isInSpace(5f, 3, i, pair[0]) && 
							isInSpace(5f, 3, i, pair[1])
						)
						.collect(Collectors.toList()).size();
				//out.println(TP + " " + FN + " " + FP);
				recalls.add(TP + FN == 0 ? 0f : (float)TP / (float)(TP + FN));
				precisions.add(TP + FP == 0 ? 0f : (float)TP / (float)(TP + FP));
			});
			
			float recall = harmonic(recalls);
			float precision = harmonic(precisions);
			//out.println(recalls.toString() + " " + precisions.toString());
			//out.println(recall + " " + precision);
			out.println(name + " : " + (precision + recall == 0f ? 0f : (2 * (precision * recall) / (precision + recall))));
			
		});
		
		
		out.println("end");

		out.flush();
	}
	
	public boolean isInSpace(Float max, int parts, int part, Float value) {
		Float slice = max / parts;
		return (value > part * slice && value < (part + 1) * slice);
	}
	
	public List<float[]> pair(List<Float> l1, List<Float> l2) {
		List<float[]> r = new ArrayList<>();
		for (int i = 0; i < l1.size(); i++) {
			float[] f = { l1.get(i), l2.get(i) };
			r.add(f);
		}
		return r;
	}
	
	public float harmonic(List<Float> l) {
		float val = (float) l
			.stream()
			.map(f -> {
				if (f == 0)
					return 0;
				else
					return 1f / f;
			})
			.reduce(0f, (x, y) -> (x.floatValue()+y.floatValue()));
		if (val == 0f)
			return 0;
		else
			return l.stream().filter(f -> f != 0f).collect(Collectors.toList()).size() / val;
	}

}
