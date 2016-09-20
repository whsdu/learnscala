package chapter13.retailor

import chapter13.bobsdelights.Fruit.{Apple => McIntosh,Orange}
import chapter13.bobsdelights.Fruit
/**
  * Created by hao.wu on 20/09/2016.
  */
class Retailor {
  def showFruit(fruit:Fruit) ={
    println(fruit.name + "s are " +fruit.color)
  }

}
