package de.unidue.langtech.teaching.pp.schuh;

import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.component.JCasCollectionReader_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.util.Progress;

import java.io.File;
import java.io.IOException;

/**
 * Created by rschuh on 2/7/17.
 */
public class Reader extends JCasCollectionReader_ImplBase {

	// Input File Path Name
	public static final String PARAM_INPUT_FILE = "InputFile";
	@ConfigurationParameter(name = PARAM_INPUT_FILE)
	private File inputFile;

	@Override
	public void getNext(JCas jCas) throws IOException, CollectionException {

	}

	@Override
	public boolean hasNext() throws IOException, CollectionException {
		return false;
	}

	@Override
	public Progress[] getProgress() {
		return new Progress[0];
	}
}
