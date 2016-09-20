package chapter13.bobsdelights

/**
  * Created by hao.wu on 20/09/2016.
  */
abstract class Fruit(val name:String,val color:String) {
}

object Fruit{
  object Apple extends Fruit("Apple","Red")
  object Orange extends Fruit("Orange","Orange")
  object Pear extends Fruit("Pear","Yellow")
}