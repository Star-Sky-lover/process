package com.itheima.wordcount

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object WordCount {


  def main(args: Array[String]): Unit = {
    val conf: SparkConf =
      new SparkConf().setMaster("local[*]").setAppName("WordCount")

    val sc = new SparkContext(conf)

    sc.textFile("/input")
      .flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _)
      .saveAsTextFile("/output")

    sc.stop()
  }


  def wordCount(line: String): Unit = {


    val strings: Array[String] = line.split(",")
    val tuples: Array[(String, Int)] = strings.map(_ -> 1)
    val stringToTuples: Map[String, Array[(String, Int)]] = tuples.groupBy(_._1)

    val stringToInt: Map[String, Int] = stringToTuples.map(x => (x._1, x._2.reduce((x, y) => x._2 + y._2)))

    println(stringToInt)
  }

}
