package de.unidue.langtech.teaching.pp.example;

import java.util.*;
import java.util.stream.Collectors;

import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidue.langtech.teaching.pp.type.DetectedLanguage;

/**
 * The baseline always identifies "EN" as the document language.
 * 
 * @author zesch
 *
 */
public class BaselineExample
    extends JCasAnnotator_ImplBase
{

    @Override
    public void process(JCas jcas)
        throws AnalysisEngineProcessException
    {
        System.out.println("Document is: " + jcas.getDocumentText());
        
        Collection<Token> tokens = JCasUtil.select(jcas, Token.class);
        System.out.println("CAS contains " + tokens.size() + " tokens.");
        
        final DetectedLanguage languageAnno = new DetectedLanguage(jcas);

        HashMap<String, List<String>> languages = new HashMap<>();

        languages.put("DE", Arrays.asList(" der ", " die ", " das ", "Das ", "Der ", "Die "));
        languages.put("FR", Arrays.asList(" le ", " la ", " je ", " tu ", " il ", " elle "));
        languages.put("EN", Arrays.asList(" the ", " he ", " she ", " it "));

        languages.forEach((k, v) -> {
            List<String> found = v
                .stream()
                .filter(i -> jcas.getDocumentText().indexOf(i) >= 0)
                .collect(Collectors.toList());
            if(found.size() > 0)
                languageAnno.setLanguage(k);
        });

        languageAnno.addToIndexes();
    }
}