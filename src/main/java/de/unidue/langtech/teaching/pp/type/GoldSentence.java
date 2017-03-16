

/* First created by JCasGen Thu Mar 16 22:03:08 CET 2017 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.StringArray;
import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Thu Mar 16 22:07:23 CET 2017
 * XML source: /home/rschuh/projects/TextAnalytics/src/main/resources/desc/type/GoldSentences.xml
 * @generated */
public class GoldSentence extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GoldSentence.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected GoldSentence() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public GoldSentence(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public GoldSentence(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public GoldSentence(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: sentence

  /** getter for sentence - gets 
   * @generated
   * @return value of the feature 
   */
  public String getSentence() {
    if (GoldSentence_Type.featOkTst && ((GoldSentence_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "de.unidue.langtech.teaching.pp.type.GoldSentence");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GoldSentence_Type)jcasType).casFeatCode_sentence);}
    
  /** setter for sentence - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSentence(String v) {
    if (GoldSentence_Type.featOkTst && ((GoldSentence_Type)jcasType).casFeat_sentence == null)
      jcasType.jcas.throwFeatMissing("sentence", "de.unidue.langtech.teaching.pp.type.GoldSentence");
    jcasType.ll_cas.ll_setStringValue(addr, ((GoldSentence_Type)jcasType).casFeatCode_sentence, v);}    
   
    
  //*--------------*
  //* Feature: length

  /** getter for length - gets 
   * @generated
   * @return value of the feature 
   */
  public int getLength() {
    if (GoldSentence_Type.featOkTst && ((GoldSentence_Type)jcasType).casFeat_length == null)
      jcasType.jcas.throwFeatMissing("length", "de.unidue.langtech.teaching.pp.type.GoldSentence");
    return jcasType.ll_cas.ll_getIntValue(addr, ((GoldSentence_Type)jcasType).casFeatCode_length);}
    
  /** setter for length - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setLength(int v) {
    if (GoldSentence_Type.featOkTst && ((GoldSentence_Type)jcasType).casFeat_length == null)
      jcasType.jcas.throwFeatMissing("length", "de.unidue.langtech.teaching.pp.type.GoldSentence");
    jcasType.ll_cas.ll_setIntValue(addr, ((GoldSentence_Type)jcasType).casFeatCode_length, v);}    
   
    
  //*--------------*
  //* Feature: words

  /** getter for words - gets 
   * @generated
   * @return value of the feature 
   */
  public StringArray getWords() {
    if (GoldSentence_Type.featOkTst && ((GoldSentence_Type)jcasType).casFeat_words == null)
      jcasType.jcas.throwFeatMissing("words", "de.unidue.langtech.teaching.pp.type.GoldSentence");
    return (StringArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((GoldSentence_Type)jcasType).casFeatCode_words)));}
    
  /** setter for words - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setWords(StringArray v) {
    if (GoldSentence_Type.featOkTst && ((GoldSentence_Type)jcasType).casFeat_words == null)
      jcasType.jcas.throwFeatMissing("words", "de.unidue.langtech.teaching.pp.type.GoldSentence");
    jcasType.ll_cas.ll_setRefValue(addr, ((GoldSentence_Type)jcasType).casFeatCode_words, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for words - gets an indexed value - 
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public String getWords(int i) {
    if (GoldSentence_Type.featOkTst && ((GoldSentence_Type)jcasType).casFeat_words == null)
      jcasType.jcas.throwFeatMissing("words", "de.unidue.langtech.teaching.pp.type.GoldSentence");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((GoldSentence_Type)jcasType).casFeatCode_words), i);
    return jcasType.ll_cas.ll_getStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((GoldSentence_Type)jcasType).casFeatCode_words), i);}

  /** indexed setter for words - sets an indexed value - 
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setWords(int i, String v) { 
    if (GoldSentence_Type.featOkTst && ((GoldSentence_Type)jcasType).casFeat_words == null)
      jcasType.jcas.throwFeatMissing("words", "de.unidue.langtech.teaching.pp.type.GoldSentence");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((GoldSentence_Type)jcasType).casFeatCode_words), i);
    jcasType.ll_cas.ll_setStringArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((GoldSentence_Type)jcasType).casFeatCode_words), i, v);}
   
    
  //*--------------*
  //* Feature: wordCount

  /** getter for wordCount - gets 
   * @generated
   * @return value of the feature 
   */
  public int getWordCount() {
    if (GoldSentence_Type.featOkTst && ((GoldSentence_Type)jcasType).casFeat_wordCount == null)
      jcasType.jcas.throwFeatMissing("wordCount", "de.unidue.langtech.teaching.pp.type.GoldSentence");
    return jcasType.ll_cas.ll_getIntValue(addr, ((GoldSentence_Type)jcasType).casFeatCode_wordCount);}
    
  /** setter for wordCount - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setWordCount(int v) {
    if (GoldSentence_Type.featOkTst && ((GoldSentence_Type)jcasType).casFeat_wordCount == null)
      jcasType.jcas.throwFeatMissing("wordCount", "de.unidue.langtech.teaching.pp.type.GoldSentence");
    jcasType.ll_cas.ll_setIntValue(addr, ((GoldSentence_Type)jcasType).casFeatCode_wordCount, v);}    
  }

    