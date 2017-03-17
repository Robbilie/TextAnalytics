package de.unidue.langtech.teaching.pp.schuh;

import java.io.PrintWriter;
import java.lang.reflect.Field;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.fit.component.CasDumpWriter;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.resource.ResourceInitializationException;

import de.unidue.langtech.teaching.pp.type.GoldSentences;

public class SimilarityDumper extends CasDumpWriter {
  
	private PrintWriter out;
	
	@Override
    public void initialize(UimaContext context) throws ResourceInitializationException {
        super.initialize(context);
        Field f;
		try {
			f = CasDumpWriter.class.getDeclaredField("out");
        	f.setAccessible(true);
        	out = (PrintWriter)f.get(this);
        	out.println("+\t\t+\t\t+");
        	out.println("|\tID\t|\tSimil.\t|");
        	out.println("+\t\t+\t\t+");
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void process(CAS aCAS) throws AnalysisEngineProcessException {
		try {
			GoldSentences gs = JCasUtil.selectSingle(aCAS.getJCas(), GoldSentences.class);
			out.println("|\t" + gs.getId() + "\t|\t" + gs.getSimilarity() + "\t|");
		    out.flush();
		} catch (CASException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
