// Class mutability
// We can use `val` and `var` to define **public** properties of a class.
// Properties that don't have either annotation are private and immutable.
class Car(color: String, val wheels: Int, var engine: String) {
  def call(): Unit = {
    println(s"This is a car with $color paint, $wheels wheels, and $engine engine")
  }

  // To update a `Car` immutably, we create a new instance.
  def repaint(color: String): Car = {
    new Car(color, wheels, engine)
  }
}

object Mutability extends App {
  val blueCar = new Car("blue", 4, "diesel")
  blueCar.call()

  // This errors because `color` is private.
  // blueCar.color = "green"
  // This errors because `wheels` is immutable.
  // blueCar.wheels = 3
  blueCar.engine = "electric"
  blueCar.call()

  // Create a new car with the new color.
  val greenCar = blueCar.repaint("green")
  greenCar.call()

  // Collection mutability
  // Scala provides default libraries for immutable and mutable collections.

  // Immutable collections
  // Immutable collections are provided by `scala.collection.immutables` and
  // are re-exported by `scala` so no import is necessary to use them.

  // `Seq` is a trait representing an immutable iterator with a defined order
  // of elements and indexing. The default implementation of `Seq` is the
  // `List` class, which is backed by a linked-list.
  val pets = Seq("Cat", "Dog")

  // All operations on `Seq` return a new collection without mutating the
  // original.
  val myPets = pets :+ "Hamster" // push
  val notPets = pets ++ List("Giraffe", "Elephant") // concat
  val yourPets = pets.updated(0, "Mice") // update

  // Immutable collections are compared by value.
  assert(pets == Seq("Cat", "Dog"))
  assert(myPets == Seq("Cat", "Dog", "Hamster"))
  assert(notPets == Seq("Cat", "Dog", "Giraffe", "Elephant"))
  assert(yourPets == Seq("Mice", "Dog"))

  // Mutable collections
  // Mutable collections must be imported explicitly.
  import scala.collection.mutable.ArrayBuffer

  val breakfasts = ArrayBuffer("Sandwich", "Salad")

  // Mutable collections are also compared by value.
  breakfasts += "Bagels" // push
  assert(breakfasts == ArrayBuffer("Sandwich", "Salad", "Bagels"))
  breakfasts ++= Seq("PB & J", "Pancake") // concat
  assert(breakfasts == ArrayBuffer("Sandwich", "Salad", "Bagels", "PB & J", "Pancake"))
  breakfasts.update(2, "Steak") // update
  assert(breakfasts == ArrayBuffer("Sandwich", "Salad", "Steak", "PB & J", "Pancake"))
  breakfasts -= "PB & J" // find and remove
  assert(breakfasts == ArrayBuffer("Sandwich", "Salad", "Steak", "Pancake"))
  breakfasts -= "Fried rice" // find and remove, no-op if not found
  assert(breakfasts == ArrayBuffer("Sandwich", "Salad", "Steak", "Pancake"))
}