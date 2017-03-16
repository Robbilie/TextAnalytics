

/* First created by JCasGen Thu Mar 16 22:03:08 CET 2017 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Thu Mar 16 22:03:08 CET 2017
 * XML source: /home/rschuh/projects/TextAnalytics/src/main/resources/desc/type/GoldSentences.xml
 * @generated */
public class GoldScore extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GoldScore.class);
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
  protected GoldScore() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public GoldScore(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public GoldScore(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public GoldScore(JCas jcas, int begin, int end) {
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
  //* Feature: name

  /** getter for name - gets 
   * @generated
   * @return value of the feature 
   */
  public String getName() {
    if (GoldScore_Type.featOkTst && ((GoldScore_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "de.unidue.langtech.teaching.pp.type.GoldScore");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GoldScore_Type)jcasType).casFeatCode_name);}
    
  /** setter for name - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setName(String v) {
    if (GoldScore_Type.featOkTst && ((GoldScore_Type)jcasType).casFeat_name == null)
      jcasType.jcas.throwFeatMissing("name", "de.unidue.langtech.teaching.pp.type.GoldScore");
    jcasType.ll_cas.ll_setStringValue(addr, ((GoldScore_Type)jcasType).casFeatCode_name, v);}    
   
    
  //*--------------*
  //* Feature: score

  /** getter for score - gets 
   * @generated
   * @return value of the feature 
   */
  public float getScore() {
    if (GoldScore_Type.featOkTst && ((GoldScore_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "de.unidue.langtech.teaching.pp.type.GoldScore");
    return jcasType.ll_cas.ll_getFloatValue(addr, ((GoldScore_Type)jcasType).casFeatCode_score);}
    
  /** setter for score - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setScore(float v) {
    if (GoldScore_Type.featOkTst && ((GoldScore_Type)jcasType).casFeat_score == null)
      jcasType.jcas.throwFeatMissing("score", "de.unidue.langtech.teaching.pp.type.GoldScore");
    jcasType.ll_cas.ll_setFloatValue(addr, ((GoldScore_Type)jcasType).casFeatCode_score, v);}    
  }

    