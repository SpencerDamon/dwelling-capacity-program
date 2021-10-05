//imports the PI mathematical value from the Kotlin math library.
import kotlin.math.PI
main(){

  //Tests code: creates an instance of SquareCabin and initializes it to 6 residents
  //val squareCabin = SquareCabin(6)
  //println("\nSquare Cabin\n============")
  //println("Capacity: ${squareCabin.capacity}")
  //println("Material: ${squareCabin.buildingMaterial}")
  //println("Has room?: ${sqaureCabin.hasRoom()}")
  
  //Refactors the above using a with statement; with(instanceName){all operations to do with instanceName}
  val squareCabin = SquareCabin(6, 50.0)
  val roundHut = RoundHut(3, 10.0)
  val roundTower = RoundTower (4, 15.5)
  
  with(squareCabin){
    println("\nSquare Cabin\n============")
    println("Capacity: ${capacity}")
    println("Material: ${buildingMaterial}")
    println("Has room?: ${hasRoom()}")
  }
     
  with(roundHut){
        println("\nRound Hut\n=========")
        println("Building Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
        
    }
     
    with(roundTower){
        println("\nRound Tower\n===========")
        println("Building Material: ${buildingMaterial}")
        println("Floors: ${floors}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        println("Floor area: ${floorArea()}")
    }
} 

}

          
  //created a root class of Dwelling; the class must be astract, because variable will remain undefined. It cannot be instantiated because it is not fully implemented.
  //Defined the residents property to be inherited and used by all other children classes.
  //private declares the property to only been seen or used by this class, and inaccessable to the rest of the program.
  abstract class Dwelling(private var residents: Int){
  
    //abstract because undefined in parent class, not initialized.
    //All dwellings require a building material of some kind.
    abstract val buildingMaterial: String
    
    //The capacity property changes for different dwellings therefore it can only be defined in subclasses of the Dwelling root class.
    abstract val capacity: Int
    
    //Returns a Boolean value to where it is called; residents must be limited by capacity.
    fun hasRoom() : Boolean {
      return residents < capacity
    
    }
    //Double is a data Type used for floating point numbers, decimals eg. 5.8793
    abstract fun floorArea(): Double
  }
  //Creates a class and object instance; a colon indicates an inheritance relationship to parent class, followed by a call to initialize the parent Dwelling and calling its constructor.
  //Must pass the required parameters ezpected by the superclass could be fized Dwelling(3), to be more flezible pass the private variable residents.
  //shorthand for class SquareCabin constructor(residents: Int)...
  //
  class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    //the abstract values below were defined in the parent class, so we must provide a value.
    //The override keyword indicates these properties were defined in a parent class and is about to be overridden in this class.
    override val buildingMaterial = "Wood"
    override val capacity = 6
    override fun floorArea(): Double{
        return length * length
    }
  
  }

  //kotlin classes are closed  by default, the open keyword is used to create a subclass
open class RoundHut (residents: Int, val radius: Double) : Dwelling(residents){
   override val buildingMaterial = "Straw"
   override val capacity = 4
   override fun floorArea(): Double{
     //could use kotlin.math.PI * radius * radius, instead of using an import statement above main()   
     return PI * radius * radius 
    }
}

class RoundTower (
    residents: Int, 
    radius: Double,
    val floors: Int = 2) : RoundHut(residents, radius){
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors
    override fun floorArea(): Double{
        return super.floorArea() * floors
    }
    
} 

