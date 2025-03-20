
// jpc: I see that pretty much none of the suggestions has been taken into account. Unfortunate.
object Main {
  def main(args: Array[String]): Unit = {
    val filePath = "08-PropertiesLondon.csv"
    val properties: List[Property[Int]] = PropertyDataImporter.loadProperties(filePath)

    println(s"✅ Loaded ${properties.length} properties.")

    properties.take(5).foreach(p => println(p.address.fullAddress))

    properties.take(5).foreach(printPricedAndSized)
  }

  type PricedAndSized = { def price: Int; def area: Int }

  import scala.reflect.Selectable.reflectiveSelectable

  def printPricedAndSized(property: PricedAndSized): Unit = {
    println(s"Price: ${property.price}, Area: ${property.area}")
  }
}