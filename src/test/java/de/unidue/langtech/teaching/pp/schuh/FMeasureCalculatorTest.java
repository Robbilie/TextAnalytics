package de.unidue.langtech.teaching.pp.schuh;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FMeasureCalculatorTest {
	
	@Test
	public void testFMeasureComparator() {
		FMeasureCalculator fmc = new FMeasureCalculator();
		
			List<Float> goldValues = new ArrayList<Float>();
				goldValues.add(0f);
			fmc.setGoldValues(goldValues);
			
			List<Float> testValues = new ArrayList<Float>();
				testValues.add(0f);
			fmc.setTestValues(testValues);
			
		assertEquals(fmc.calculateFMeasure(), 0f, 0f);
	}

}
