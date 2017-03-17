

/* First created by JCasGen Thu Mar 16 22:07:23 CET 2017 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.jcas.cas.FSList;
import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Fri Mar 17 01:57:29 CET 2017
 * XML source: /home/rschuh/projects/TextAnalytics/src/main/resources/desc/type/GoldSentences.xml
 * @generated */
public class GoldSentences extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GoldSentences.class);
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
  protected GoldSentences() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public GoldSentences(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public GoldSentences(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public GoldSentences(JCas jcas, int begin, int end) {
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
  //* Feature: id

  /** getter for id - gets Dataset ID
   * @generated
   * @return value of the feature 
   */
  public int getId() {
    if (GoldSentences_Type.featOkTst && ((GoldSentences_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    return jcasType.ll_cas.ll_getIntValue(addr, ((GoldSentences_Type)jcasType).casFeatCode_id);}
    
  /** setter for id - sets Dataset ID 
   * @generated
   * @param v value to set into the feature 
   */
  public void setId(int v) {
    if (GoldSentences_Type.featOkTst && ((GoldSentences_Type)jcasType).casFeat_id == null)
      jcasType.jcas.throwFeatMissing("id", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    jcasType.ll_cas.ll_setIntValue(addr, ((GoldSentences_Type)jcasType).casFeatCode_id, v);}    
   
    
  //*--------------*
  //* Feature: firstSentence

  /** getter for firstSentence - gets 
   * @generated
   * @return value of the feature 
   */
  public GoldSentence getFirstSentence() {
    if (GoldSentences_Type.featOkTst && ((GoldSentences_Type)jcasType).casFeat_firstSentence == null)
      jcasType.jcas.throwFeatMissing("firstSentence", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    return (GoldSentence)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((GoldSentences_Type)jcasType).casFeatCode_firstSentence)));}
    
  /** setter for firstSentence - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setFirstSentence(GoldSentence v) {
    if (GoldSentences_Type.featOkTst && ((GoldSentences_Type)jcasType).casFeat_firstSentence == null)
      jcasType.jcas.throwFeatMissing("firstSentence", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    jcasType.ll_cas.ll_setRefValue(addr, ((GoldSentences_Type)jcasType).casFeatCode_firstSentence, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: secondSentence

  /** getter for secondSentence - gets 
   * @generated
   * @return value of the feature 
   */
  public GoldSentence getSecondSentence() {
    if (GoldSentences_Type.featOkTst && ((GoldSentences_Type)jcasType).casFeat_secondSentence == null)
      jcasType.jcas.throwFeatMissing("secondSentence", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    return (GoldSentence)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((GoldSentences_Type)jcasType).casFeatCode_secondSentence)));}
    
  /** setter for secondSentence - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSecondSentence(GoldSentence v) {
    if (GoldSentences_Type.featOkTst && ((GoldSentences_Type)jcasType).casFeat_secondSentence == null)
      jcasType.jcas.throwFeatMissing("secondSentence", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    jcasType.ll_cas.ll_setRefValue(addr, ((GoldSentences_Type)jcasType).casFeatCode_secondSentence, jcasType.ll_cas.ll_getFSRef(v));}    
   
    
  //*--------------*
  //* Feature: similarity

  /** getter for similarity - gets 
   * @generated
   * @return value of the feature 
   */
  public float getSimilarity() {
    if (GoldSentences_Type.featOkTst && ((GoldSentences_Type)jcasType).casFeat_similarity == null)
      jcasType.jcas.throwFeatMissing("similarity", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((GoldSentences_Type)jcasType).casFeatCode_similarity);}
    
  /** setter for similarity - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSimilarity(float v) {
    if (GoldSentences_Type.featOkTst && ((GoldSentences_Type)jcasType).casFeat_similarity == null)
      jcasType.jcas.throwFeatMissing("similarity", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    jcasType.ll_cas.ll_setFloatValue(addr, ((GoldSentences_Type)jcasType).casFeatCode_similarity, v);}    
   
    
  //*--------------*
  //* Feature: scores

  /** getter for scores - gets 
   * @generated
   * @return value of the feature 
   */
  public FSArray getScores() {
    if (GoldSentences_Type.featOkTst && ((GoldSentences_Type)jcasType).casFeat_scores == null)
      jcasType.jcas.throwFeatMissing("scores", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((GoldSentences_Type)jcasType).casFeatCode_scores)));}
    
  /** setter for scores - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setScores(FSArray v) {
    if (GoldSentences_Type.featOkTst && ((GoldSentences_Type)jcasType).casFeat_scores == null)
      jcasType.jcas.throwFeatMissing("scores", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    jcasType.ll_cas.ll_setRefValue(addr, ((GoldSentences_Type)jcasType).casFeatCode_scores, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for scores - gets an indexed value - 
   * @generated
   * @param i index in the array to get
   * @return value of the element at index i 
   */
  public GoldScore getScores(int i) {
    if (GoldSentences_Type.featOkTst && ((GoldSentences_Type)jcasType).casFeat_scores == null)
      jcasType.jcas.throwFeatMissing("scores", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((GoldSentences_Type)jcasType).casFeatCode_scores), i);
    return (GoldScore)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((GoldSentences_Type)jcasType).casFeatCode_scores), i)));}

  /** indexed setter for scores - sets an indexed value - 
   * @generated
   * @param i index in the array to set
   * @param v value to set into the array 
   */
  public void setScores(int i, GoldScore v) { 
    if (GoldSentences_Type.featOkTst && ((GoldSentences_Type)jcasType).casFeat_scores == null)
      jcasType.jcas.throwFeatMissing("scores", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((GoldSentences_Type)jcasType).casFeatCode_scores), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((GoldSentences_Type)jcasType).casFeatCode_scores), i, jcasType.ll_cas.ll_getFSRef(v));}
  }

    