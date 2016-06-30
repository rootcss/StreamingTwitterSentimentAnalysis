package com.streaming.analysis

import org.apache.spark.mllib.feature.HashingTF
import org.apache.spark.mllib.linalg.Vector

/**
  * Created by jxy on 2016-06-30.
  */
object TrainingUtils {

  val numFeatures = 1000
  val hashingTF = new HashingTF(numFeatures)


  def toTuple(line: String) = {
    val parts = line split(",") //space = dot operator (.) in Scala
    val text = parts drop(5) mkString(" ") //text data may contain comma, so get slice of string till end
    (parts(0) replaceAll("^\"|\"$", ""), TweetUtils.filterOnlyWords(text))
  }

  def featureVectorization(sentenceData: String): Vector = {
    hashingTF.transform(sentenceData.toSeq)
  }
}
