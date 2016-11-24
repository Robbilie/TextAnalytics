package de.unidue.langtech.teaching.pp.example.pipeline;

import org.apache.uima.fit.factory.AnalysisEngineFactory;
import org.apache.uima.fit.factory.CollectionReaderFactory;
import org.apache.uima.fit.pipeline.SimplePipeline;

import de.unidue.langtech.teaching.pp.example.BaselineExample;
import de.unidue.langtech.teaching.pp.example.EvaluatorExample;
import de.unidue.langtech.teaching.pp.example.ReaderExample;

import org.apache.uima.fit.component.CasDumpWriter;

import de.tudarmstadt.ukp.dkpro.core.snowball.SnowballStemmer;
import de.tudarmstadt.ukp.dkpro.core.tokit.BreakIteratorSegmenter;

public class BasicPipeline
{

    public static void main(String[] args)
        throws Exception
    {
        SimplePipeline.runPipeline(
                CollectionReaderFactory.createReader(
                        ReaderExample.class,
                        ReaderExample.PARAM_INPUT_FILE, "src/test/resources/test/inputNewFormat.txt"
                ),
                AnalysisEngineFactory.createEngineDescription(BaselineExample.class, BaselineExample.PARAM_MANDATORY_DEFAULT, "WEW LAD"),
                AnalysisEngineFactory.createEngineDescription(EvaluatorExample.class),
                //AnalysisEngineFactory.createEngineDescription(BreakIteratorSegmenter.class),
                //AnalysisEngineFactory.createEngineDescription(SnowballStemmer.class, SnowballStemmer.PARAM_LANGUAGE, "de"),
                AnalysisEngineFactory.createEngineDescription(CasDumpWriter.class)
        );
    }
}
