// Defined constants
def msg = "I was compiled by Scala 3. :)"

@main def hello(): Unit =
  println("Hello world!")
  println(msg)

  // Implicit vs explicit type annotations
  val implicitX = 1 + 1
  println(implicitX)
  val explicitX: Int = 2 + 2
  println(explicitX)

  // Mutable is opt-in
  var mutable = 1 + 2
  mutable = 6
  println(mutable)

  // Expression blocks
  // The last statement of the block is the block value.
  println({
    val x = 1 + 1
    x
  })

  // Anonymous functions
  (x: Int) => x + 1

  // Named functions
  val addOne = (x: Int) => x + 1

  // Use the universal apply method for Scala 3 to create new instances
  val greeter = Greeter("Hello ", "!")
  // Scala 2 `new` syntax
  val greeter2 = new Greeter("Hello ", "!")

  // In both 2 and 3, case classes can be created without `new`.
  val point = Point(2, 1)
  if (point == Point(2, 1)) {
    print(s"$point is not unique.")
  }


// Methods are defined with `def`, returns the last expression
def add(x: Int, y: Int): Int = x + y
// Use multi-line blocks with methods, returns the last expression
def addMore(x: Int, y: Int, z: Int) = {
  x + y + z
}

// Classes
class Greeter(prefix: String, suffix: String) {
  def greet(name: String): Unit =
    println(prefix + name + suffix)
}

// Case classes are immutable and compared by value.
// Useful for pattern matching and data records.
case class Point(x: Int, y: Int)

// Objects are single instances of their own definitions i.e. singletons of their own class.
// Objects can be referred to by their name.
object IdFactory {
  private var counter = 0
  def create(): Int = {
    counter += 1
    counter
  }
}

val idFact = IdFactory.create()

// Traits
// Traits are abstract data types that contain certain fields and methods.
// A class can only extend one class but multiple traits.
trait CanGreet {
  def greet(name: String): Unit
}

trait CanWalk {
  // Default implementations
  def walk(name: String): Unit =
    println(s"Walking $name!")
}

// Extend traits with `extends` and override an implementation with `override`.
class DefaultWalker extends CanWalk
class CustomWalker() extends CanWalk {
  override def walk(name: String): Unit = {
    println(s"Fast walking Scala developer $name")
  }
}