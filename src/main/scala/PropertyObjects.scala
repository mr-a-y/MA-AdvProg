// jpc: we can get rid of the ugly curly braces. Yes it's optional but we can remove them
// jpc: would it make sense to make the city an enum?
case class Address(location: Option[String], city: String, postalCode: String) {
  def fullAddress: String = location match {
    case Some(loc) => s"$loc, $city, $postalCode"
    case None      => s"$city, $postalCode"
  }
}

// jpc: You can avoid using the curly brackets, they are sort of ugly  for the body of a trait { }
trait Property[+T] { // jpc: why is it a covariant? no justification provided.
  def name: String
  def price: T  // why is the price a Type parameter? no motivation for this, I see no need for this.
  def area: Int
  def bedrooms: Int
  def bathrooms: Int
  def receptions: Int
  def address: Address
  def propertyType: String  //jpc: why not using an Enum for the different kinds of properties?
}

//jpc: another options is to have hierarchies of Property: like Flat or Duplex, can be specific types of Appartments. A richer hierarchy could be made at that point, this is a misseg opportunity for better typing decisions.


// jpc: I don't understand the purpose of having an abstract class here? It seems not to serve any particular purpose to define this abstract class. It's only a duplicated of the base trait and adds nothing new
//jpc: I would probably delete this abstract class
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

//jpc: why do we need to override here? With the case class none of that is necessary.
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
