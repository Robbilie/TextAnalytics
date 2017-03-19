package de.unidue.langtech.teaching.pp.schuh;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FMeasureCalculator {
	
	List<Float> goldValues;
	List<Float> testValues;
	
	List<Float> recalls = new ArrayList<Float>();
	List<Float> precisions = new ArrayList<Float>();
	
	int range = 3;
	
	public void setGoldValues(List<Float> goldValues) {
		this.goldValues = goldValues;
	}
	
	public void setTestValues(List<Float> testValues) {
		this.testValues = testValues;
	}
	
	public void setRange(int range) {
		this.range = range;
	}
	
	public float calculateFMeasure() {
		
		IntStream.rangeClosed(0, range - 1).forEach(i -> {
			List<float[]> pairs = pair(goldValues, testValues);
			int TP = pairs.stream()
					.filter(pair -> 
						isInSpace(5f, range, i, pair[0]) && 
						isInSpace(5f, range, i, pair[1])
					)
					.collect(Collectors.toList()).size();
			int FN = pairs.stream()
					.filter(pair -> 
						isInSpace(5f, range, i, pair[0]) && 
						!isInSpace(5f, range, i, pair[1])
					)
					.collect(Collectors.toList()).size();
			int FP = pairs.stream()
					.filter(pair -> 
						!isInSpace(5f, range, i, pair[0]) && 
						isInSpace(5f, range, i, pair[1])
					)
					.collect(Collectors.toList()).size();
			recalls.add(TP + FN == 0 ? 0f : (float)TP / (float)(TP + FN));
			precisions.add(TP + FP == 0 ? 0f : (float)TP / (float)(TP + FP));
		});
		
		float recall = harmonic(recalls);
		float precision = harmonic(precisions);
		
		return (precision + recall == 0f ? 0f : (2 * (precision * recall) / (precision + recall)));
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
