main(){
  //Makes an object instance from the Dwelling class, this line will not compile because you cannot create an instance from an abstract class!
  val dwelling = Dwelling()
  //created a root class of Dwelling; the class must be astract, because variable will remain undefined. It cannot be instantiated because it is not fully implemented.
  abstract class Dwelling(){
  
    //abstract because undefined in parent class, not initialized.
    //All dwellings require a building material of some kind.
    abstract val buildingMaterial: String
  }
}
