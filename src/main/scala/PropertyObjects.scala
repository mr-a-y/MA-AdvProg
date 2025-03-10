case class Address(location: Option[String], city: String, postalCode: String) {
  def fullAddress: String = location match {
    case Some(loc) => s"$loc, $city, $postalCode"
    case None      => s"$city, $postalCode"
  }
}

trait Property {
  def name: String
  def price: Int
  def area: Int
  def bedrooms: Int
  def bathrooms: Int
  def receptions: Int
  def address: Address
  def propertyType: String  
}

abstract class BaseProperty(
  val name: String,
  val price: Int,
  val area: Int,
  val bedrooms: Int,
  val bathrooms: Int,
  val receptions: Int,
  val address: Address,
  val propertyType: String 
) extends Property


case class PropertyRecord(
  override val name: String,
  override val price: Int,
  override val area: Int,
  override val bedrooms: Int,
  override val bathrooms: Int,
  override val receptions: Int,
  override val address: Address,
  override val propertyType: String  
) extends BaseProperty(name, price, area, bedrooms, bathrooms, receptions, address, propertyType)
