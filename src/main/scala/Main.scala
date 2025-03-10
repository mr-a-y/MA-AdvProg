object Main {
  def main(args: Array[String]): Unit = {
    val filePath = "08-PropertiesLondon.csv"  
    val properties: List[Property] = PropertyDataImporter.loadProperties(filePath)

    println(s"✅ Loaded ${properties.length} properties.")

    // Print first 5 properties to test 
    properties.take(5).foreach(p => println(p.address.fullAddress))
  }
}
