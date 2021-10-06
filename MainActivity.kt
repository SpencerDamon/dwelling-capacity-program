/**Program that implements classes for different kinds of dwellings.
 * Shows my personal notes from the codelab.
 * Shows how to:
 * Create class hierarchy, variables and functions with inherintance,
 * abstract class, overriding, and private vs. public variables.
 */
//imports the PI  and sqrt mathematical values from the Kotlin math library.
import kotlin.math.PI
import kotlin.math.sqrt

fun main(){

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
    getRoom()
    println("Floor area: ${floorArea()}")
  }
     
  with(roundHut){
        println("\nRound Hut\n=========")
        println("Building Material: ${buildingMaterial}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Carpet size: ${calculateMaxCarpetSize()}")
        
        
    }
     
    with(roundTower){
        println("\nRound Tower\n===========")
        println("Building Material: ${buildingMaterial}")
        println("Floors: ${floors}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
        getRoom()
        println("Carpet size: ${calculateMaxCarpetSize()}")
    }
} 

 /**Defines properties common to all dwellings.
 * All dwellings have floor space,
 * but its calculation is specific to the subclass.
 * Checking and getting a room are implemented here
 * because they are the same for all Dwelling subclasses
 * 
 * @param residents Current number of residents
 */         
//created a root class of Dwelling; the class must be astract, because variable will remain undefined. It cannot be instantiated because it is not fully implemented.
//Defined the residents property to be inherited and used by all other children classes.
//private declares the property to only been seen or used by this class, and inaccessable to the rest of the program.
abstract class Dwelling(private var residents: Int){
  
    //abstract because undefined in parent class, not initialized.
    //All dwellings require a building material of some kind.
    abstract val buildingMaterial: String
    
    //The capacity property changes for different dwellings therefore it can only be defined in subclasses of the Dwelling root class.
    abstract val capacity: Int
      
     /**Calculates the floor area of the dwelling.
     * Implemented by subclasses where shape is determined.
     * 
     * @return floor area
     */
    //Double is a data Type used for floating point numbers, decimals eg. 5.8793
    abstract fun floorArea(): Double
  
     /**Checks whether there is room for another resident.
     * 
     * @return true if room is available, false otherwise.
     */
    //Returns a Boolean value to where it is called; residents must be limited by capacity.
    fun hasRoom() : Boolean {
      return residents < capacity
      
    }
    
     /**Compares the capacity to the number of residents and
     * if capacity is larger than number of residents,
     * add resident by increasing the number of residents.
     * Print the result.
     */
    fun getRoom(){
        if (residents < capacity){
            //Alternatively residents ++
            residents + 1
            println ("You got a room!")
        }else {
            println ("Sorry, at capacity and no rooms left.")
        }
    }
}

/**A square cabin dwelling.
* 
* @param residents Current number of residents
* @param length Length
*/

//Creates a class and object instance; a colon indicates an inheritance relationship to parent class, followed by a call to initialize the parent Dwelling and calling its constructor.
//Must pass the required parameters ezpected by the superclass could be fized Dwelling(3), to be more flezible pass the private variable residents.
//shorthand for class SquareCabin constructor(residents: Int)...
//
class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
    //the abstract values below were defined in the parent class, so we must provide a value.
    //The override keyword indicates these properties were defined in a parent class and is about to be overridden in this class.
    override val buildingMaterial = "Wood"
    override val capacity = 6
     
    /**Calculates floor area for a square dwelling.
    * 
    * @return floor area
    */
    override fun floorArea(): Double{
        return length * length
    }
  
}

/**Dwelling with a circular floorspace
* 
* @param residents Current number of residents
* @param radius Radius
*/
//kotlin classes are closed  by default, the open keyword is used to create a subclass
open class RoundHut (residents: Int, val radius: Double) : Dwelling(residents){
   override val buildingMaterial = "Straw"
   override val capacity = 4
   
   /**Calculate floor area for round dwellng.
   * 
   * a@return floor area
   */
   override fun floorArea(): Double{
     //could use kotlin.math.PI * radius * radius, instead of using an import statement above main()   
     return PI * radius * radius 
    }
   
    /**Calculates the max length for a square carpet
    * that fits a circular floor.
    * 
    * @return length of carpet
    */ 
    fun calculateMaxCarpetSize(): Double{
        val diameter = 2 * radius
        //Returns square units of a circle
        return sqrt(diameter * diameter / 2)
    }
}

/**Round tower with multiple stories.
* 
* @param residents Current number of residents
* @param radius Radius
* @param floors Number of stories
*/
class RoundTower (
    residents: Int, 
    radius: Double,
    val floors: Int = 2) : RoundHut(residents, radius){
    override val buildingMaterial = "Stone"
    /**
    * //Capacity depends on the number of floors.
    */
    override val capacity = 4 * floors
    
    /**Calculates the total floor area
    * with multiple stories.
    * 
    * @return floor area
    */ 
    override fun floorArea(): Double{
      //super is used to call a function that is defined in the parent class  
      return super.floorArea() * floors
    }
    
} 

