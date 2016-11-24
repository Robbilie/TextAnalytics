package de.unidue.langtech.teaching.pp.ownReaderTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.tudarmstadt.ukp.dkpro.core.api.segmentation.type.Token;
import de.unidue.langtech.teaching.pp.type.GoldLanguage;
import org.apache.commons.io.FileUtils;
import org.apache.uima.UimaContext;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.fit.component.JCasCollectionReader_ImplBase;
import org.apache.uima.fit.descriptor.ConfigurationParameter;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

public class NewReader
    extends JCasCollectionReader_ImplBase
{
    public static final String PARAM_INPUT_FILE = "InputFile";
    @ConfigurationParameter(name = PARAM_INPUT_FILE, mandatory = true)
    private File inputFile;

    private List<String> lines;
    private int currentLine;

    private List<List<String>> parts = new ArrayList<>();
    private int currentPart;

    public void initialize(UimaContext context)
        throws ResourceInitializationException
    {
        super.initialize(context);

        try {
            lines = FileUtils.readLines(inputFile);
            currentLine = 0;

            List<String> part = new ArrayList<>();
            while(currentLine < lines.size()) {


                if(lines.get(currentLine).isEmpty() || currentLine == lines.size() - 1) {
                    if(currentLine == lines.size() - 1) {
                        part.add(lines.get(currentLine));
                    }
                    parts.add(part);
                    part = new ArrayList<>();
                } else {
                    part.add(lines.get(currentLine));
                }

                currentLine++;
            }

            currentPart = 0;
        }
        catch (IOException e) {
            throw new ResourceInitializationException(e);
        }
    }

    public boolean hasNext()
        throws IOException, CollectionException
    {
        return currentPart < parts.size();
    }

    public Progress[] getProgress()
    {
        return new Progress[] { new ProgressImpl(currentPart, parts.size(), "lines") };
    }

    public void getNext(JCas aJCas)
        throws IOException, CollectionException
    {

        List<String> part = parts.get(currentPart);

        if (part.size() < 1) {
            throw new IOException("Wrong part format: " + parts.get(currentPart));
        }

        String language = part.get(0);

        GoldLanguage goldLanguage = new GoldLanguage(aJCas);
        goldLanguage.setLanguage(language);
        goldLanguage.addToIndexes();

        aJCas.setDocumentText(String.join(" ", part.subList(1, part.size())));

        part
                .subList(1, part.size())
                .stream()
                .map(s -> new Token(
                        aJCas,
                        aJCas.getDocumentText().indexOf(s),
                        aJCas.getDocumentText().indexOf(s) + s.length())
                )
                .forEach(t -> t.addToIndexes());

        currentPart++;
    }

}
