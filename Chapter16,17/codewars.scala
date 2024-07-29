@main def tester =

	val panda:Consumer[Panda] = new Consumer(new Fuel)


class Box[+T](value:T)

class Fuel 
object KiloOfFuel extends Fuel


class Plant extends Fuel
object KiloOfPlant extends Plant

class Bamboo extends Plant
object KiloOfBamboo extends Bamboo



object FuelBox extends Box[Fuel](KiloOfFuel)

object PlantBox extends Box[Plant](KiloOfPlant)

object BambooBox extends Box[Bamboo](KiloOfBamboo)





class Consumer[-T](value:T)



class Panda extends Consumer[Bamboo](KiloOfBamboo)

class Herbivore extends Consumer[Plant](KiloOfPlant)

class Fire extends Consumer[Fuel](KiloOfFuel)