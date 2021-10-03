main(){

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
  }
  //Creates a class and object instance; a colon indicates an inheritance relationship to parent class, followed by a call to initialize the parent Dwelling and calling its constructor.
  //Must pass the required parameters ezpected by the superclass could be fized Dwelling(3), to be more flezible pass the private variable residents.
  //shorthand for class SquareCabin constructor(residents: Int)...
  //
  class SquareCabin(residents: Int) : Dwelling(residents) {
    //the abstract values below were defined in the parent class, so we must provide a value.
    //The override keyword indicates these properties were defined in a parent class and is about to be overridden in this class.
    override val buildingMaterial = "Wood"
    override val capacity = 6
  
  }
}
