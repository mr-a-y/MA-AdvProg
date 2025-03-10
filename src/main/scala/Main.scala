object Main {
  def main(args: Array[String]): Unit = {
    val filePath = "08-PropertiesLondon.csv"  
    val properties: List[Property] = PropertyDataImporter.loadProperties(filePath)

    println(s"✅ Loaded ${properties.length} properties.")

    // Print first 5 properties to test 
    properties.take(5).foreach(p => println(p.address.fullAddress))

    //jpc: perhaps if the Postal code does not exist is better to use an option?
    properties.filter(p => p.address.postalCode == "Unknown Postal Code").foreach(println(_))
  }
}
