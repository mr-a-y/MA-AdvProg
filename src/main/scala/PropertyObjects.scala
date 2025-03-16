case class Address(location: Option[String], city: String, postalCode: String) {
  def fullAddress: String = location match {
    case Some(loc) => s"$loc, $city, $postalCode"
    case None      => s"$city, $postalCode"
  }
}

trait Property[+T] {
  def name: String
  def price: T
  def area: Int
  def bedrooms: Int
  def bathrooms: Int
  def receptions: Int
  def address: Address
  def propertyType: String
}

abstract class BaseProperty[T](
  val name: String,
  val price: T,
  val area: Int,
  val bedrooms: Int,
  val bathrooms: Int,
  val receptions: Int,
  val address: Address,
  val propertyType: String
) extends Property[T]

case class PropertyRecord[T](
  override val name: String,
  override val price: T,
  override val area: Int,
  override val bedrooms: Int,
  override val bathrooms: Int,
  override val receptions: Int,
  override val address: Address,
  override val propertyType: String
) extends BaseProperty[T](name, price, area, bedrooms, bathrooms, receptions, address, propertyType)