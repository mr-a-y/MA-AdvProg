import scala.io.Source
import java.io.File
import scala.util.matching.Regex

object PropertyDataImporter {

  
  def loadProperties(filePath: String): List[Property] = {
    val file = new File(filePath)

    println(s"🔍 Looking for file at: ${file.getAbsolutePath}")

    

    val source = Source.fromFile(file)  

    try {
      val lines = source.getLines().toList


      val header = lines.head  
      println(s"🔍 CSV Header: $header")  
      
      val dataRows = lines.tail  

      dataRows.map { line =>
        val cols = splitCSV(line) 


        val name        = cols.lift(1).getOrElse("Unknown Property")  
        val price       = cols.lift(2).map(_.toInt).getOrElse(0)  
        val propertyType = cols.lift(3).getOrElse("Unknown Type")  
        val area        = cols.lift(4).map(_.toInt).getOrElse(0)
        val bedrooms    = cols.lift(5).map(_.toInt).getOrElse(0)
        val bathrooms   = cols.lift(6).map(_.toInt).getOrElse(0)
        val receptions  = cols.lift(7).map(_.toInt).getOrElse(0)
        val location = Option(cols(8)).filter(_.nonEmpty).getOrElse("Unknown")  
        val city        = cols.lift(9).getOrElse("Unknown City")
        val postalCode  = cols.lift(10).getOrElse("Unknown Postal Code")

        val address  = Address(Some(location), city, postalCode)

        PropertyRecord(name, price, area, bedrooms, bathrooms, receptions, address, propertyType)  
      }
    } finally {
      source.close()
    }
  }


  def splitCSV(line: String): Array[String] = {
    val regex: Regex = """"(.*?)"|([^,]+)""".r

    regex.findAllMatchIn(line).map { m =>
      if (m.group(1) != null) m.group(1)  
      else m.group(2)                     
    }.toArray
  }
}
