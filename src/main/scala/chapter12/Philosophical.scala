package chapter12
import scala.collection.mutable.ArrayBuffer

/**
  * Created by hao.wu on 18/09/2016.
  */
trait Philosophical {
  def philosophize() = println(" I consume memmory, therefore I am")
}
class Animal
trait Haslegs

class Forg extends  Animal with Philosophical with Haslegs{
  override def toString: String = "green"

  override def philosophize(): Unit = println("It ani't easy being: " + toString + "!")
}

trait Rectangular{
  def topleft:Point
  def bottomright:Point

  def left = topleft._1
  def right = bottomright._2
  def width = right - left
}

abstract class Component extends Rectangular{}
class Rectangle(val topleft:Point, val bottomright:Point ) extends Rectangular{
}

abstract class IntQue{
  def get:Int
  def put(x:Int)
}

class  BasicIntQue extends IntQue{
  private val buf = new ArrayBuffer[Int]
  override def get: Int = buf.remove(0)
  override def put(x: Int): Unit = buf += x
}

trait Doubling extends IntQue{
  abstract override def put(x: Int): Unit = super.put(2*x)
}

trait Incrementing extends IntQue{
  abstract override def put(x:Int):Unit = super.put(x+1)
}

trait Filtering extends IntQue{
  abstract override def put(x:Int):Unit = if(x>=0) super.put(x)
}