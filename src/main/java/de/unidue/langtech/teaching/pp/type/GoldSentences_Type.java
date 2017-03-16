
/* First created by JCasGen Thu Mar 16 22:07:23 CET 2017 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Thu Mar 16 22:07:23 CET 2017
 * @generated */
public class GoldSentences_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = GoldSentences.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.GoldSentences");
 
  /** @generated */
  final Feature casFeat_id;
  /** @generated */
  final int     casFeatCode_id;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getId(int addr) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    return ll_cas.ll_getIntValue(addr, casFeatCode_id);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setId(int addr, int v) {
        if (featOkTst && casFeat_id == null)
      jcas.throwFeatMissing("id", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    ll_cas.ll_setIntValue(addr, casFeatCode_id, v);}
    
  
 
  /** @generated */
  final Feature casFeat_firstSentence;
  /** @generated */
  final int     casFeatCode_firstSentence;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getFirstSentence(int addr) {
        if (featOkTst && casFeat_firstSentence == null)
      jcas.throwFeatMissing("firstSentence", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    return ll_cas.ll_getRefValue(addr, casFeatCode_firstSentence);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setFirstSentence(int addr, int v) {
        if (featOkTst && casFeat_firstSentence == null)
      jcas.throwFeatMissing("firstSentence", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    ll_cas.ll_setRefValue(addr, casFeatCode_firstSentence, v);}
    
  
 
  /** @generated */
  final Feature casFeat_secondSentence;
  /** @generated */
  final int     casFeatCode_secondSentence;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getSecondSentence(int addr) {
        if (featOkTst && casFeat_secondSentence == null)
      jcas.throwFeatMissing("secondSentence", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    return ll_cas.ll_getRefValue(addr, casFeatCode_secondSentence);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSecondSentence(int addr, int v) {
        if (featOkTst && casFeat_secondSentence == null)
      jcas.throwFeatMissing("secondSentence", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    ll_cas.ll_setRefValue(addr, casFeatCode_secondSentence, v);}
    
  
 
  /** @generated */
  final Feature casFeat_similarity;
  /** @generated */
  final int     casFeatCode_similarity;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public float getSimilarity(int addr) {
        if (featOkTst && casFeat_similarity == null)
      jcas.throwFeatMissing("similarity", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_similarity);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSimilarity(int addr, float v) {
        if (featOkTst && casFeat_similarity == null)
      jcas.throwFeatMissing("similarity", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    ll_cas.ll_setFloatValue(addr, casFeatCode_similarity, v);}
    
  
 
  /** @generated */
  final Feature casFeat_scores;
  /** @generated */
  final int     casFeatCode_scores;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public int getScores(int addr) {
        if (featOkTst && casFeat_scores == null)
      jcas.throwFeatMissing("scores", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    return ll_cas.ll_getRefValue(addr, casFeatCode_scores);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setScores(int addr, int v) {
        if (featOkTst && casFeat_scores == null)
      jcas.throwFeatMissing("scores", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    ll_cas.ll_setRefValue(addr, casFeatCode_scores, v);}
    
   /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @return value at index i in the array 
   */
  public int getScores(int addr, int i) {
        if (featOkTst && casFeat_scores == null)
      jcas.throwFeatMissing("scores", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_scores), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_scores), i);
	return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_scores), i);
  }
   
  /** @generated
   * @param addr low level Feature Structure reference
   * @param i index of item in the array
   * @param v value to set
   */ 
  public void setScores(int addr, int i, int v) {
        if (featOkTst && casFeat_scores == null)
      jcas.throwFeatMissing("scores", "de.unidue.langtech.teaching.pp.type.GoldSentences");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_scores), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_scores), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_scores), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public GoldSentences_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_id = jcas.getRequiredFeatureDE(casType, "id", "uima.cas.Integer", featOkTst);
    casFeatCode_id  = (null == casFeat_id) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_id).getCode();

 
    casFeat_firstSentence = jcas.getRequiredFeatureDE(casType, "firstSentence", "de.unidue.langtech.teaching.pp.type.GoldSentence", featOkTst);
    casFeatCode_firstSentence  = (null == casFeat_firstSentence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_firstSentence).getCode();

 
    casFeat_secondSentence = jcas.getRequiredFeatureDE(casType, "secondSentence", "de.unidue.langtech.teaching.pp.type.GoldSentence", featOkTst);
    casFeatCode_secondSentence  = (null == casFeat_secondSentence) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_secondSentence).getCode();

 
    casFeat_similarity = jcas.getRequiredFeatureDE(casType, "similarity", "uima.cas.Float", featOkTst);
    casFeatCode_similarity  = (null == casFeat_similarity) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_similarity).getCode();

 
    casFeat_scores = jcas.getRequiredFeatureDE(casType, "scores", "uima.cas.FSArray", featOkTst);
    casFeatCode_scores  = (null == casFeat_scores) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_scores).getCode();

  }
}



    