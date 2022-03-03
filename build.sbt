name := "KafkaSparkIntegration"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq("org.apache.spark" % "spark-sql_2.11" % "2.2.0",
                        "org.apache.spark" % "spark-sql-kafka-0-10_2.11" % "2.2.0",
                        "org.apache.kafka" % "kafka-clients" % "0.11.0.1")

libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.2"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "2.3.2"
libraryDependencies += "org.lz4" % "lz4-java" % "1.7.1"

// lazy val excludeJpountz = ExclusionRule(organization = "net.jpountz.lz4", name = "lz4")

// lazy val kafkaClients = "org.apache.kafka" % "kafka-clients" % userKafkaVersionHere excludeAll(excludeJpountz) 
// libraryDependencies += "mysql" % "mysql-connector-java" % "8.0.19"


