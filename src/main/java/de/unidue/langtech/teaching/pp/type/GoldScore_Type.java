
/* First created by JCasGen Thu Mar 16 22:03:08 CET 2017 */
package de.unidue.langtech.teaching.pp.type;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Fri Mar 17 01:57:29 CET 2017
 * @generated */
public class GoldScore_Type extends Annotation_Type {
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = GoldScore.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("de.unidue.langtech.teaching.pp.type.GoldScore");
 
  /** @generated */
  final Feature casFeat_name;
  /** @generated */
  final int     casFeatCode_name;
  /** @generated
   * @param addr low level Feature Structure reference
   * @return the feature value 
   */ 
  public String getName(int addr) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "de.unidue.langtech.teaching.pp.type.GoldScore");
    return ll_cas.ll_getStringValue(addr, casFeatCode_name);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setName(int addr, String v) {
        if (featOkTst && casFeat_name == null)
      jcas.throwFeatMissing("name", "de.unidue.langtech.teaching.pp.type.GoldScore");
    ll_cas.ll_setStringValue(addr, casFeatCode_name, v);}
    
  
 
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
      jcas.throwFeatMissing("similarity", "de.unidue.langtech.teaching.pp.type.GoldScore");
    return ll_cas.ll_getFloatValue(addr, casFeatCode_similarity);
  }
  /** @generated
   * @param addr low level Feature Structure reference
   * @param v value to set 
   */    
  public void setSimilarity(int addr, float v) {
        if (featOkTst && casFeat_similarity == null)
      jcas.throwFeatMissing("similarity", "de.unidue.langtech.teaching.pp.type.GoldScore");
    ll_cas.ll_setFloatValue(addr, casFeatCode_similarity, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	 * @generated
	 * @param jcas JCas
	 * @param casType Type 
	 */
  public GoldScore_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_name = jcas.getRequiredFeatureDE(casType, "name", "uima.cas.String", featOkTst);
    casFeatCode_name  = (null == casFeat_name) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_name).getCode();

 
    casFeat_similarity = jcas.getRequiredFeatureDE(casType, "similarity", "uima.cas.Float", featOkTst);
    casFeatCode_similarity  = (null == casFeat_similarity) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_similarity).getCode();

  }
}



    