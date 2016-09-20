package chapter9

import Element.elem
/**
  * Created by hao.wu on 13/09/2016.
  */
abstract class Element {
  def contents: Array[String]
  def height:Int = contents.length
  def width:Int = if(height == 0) 0 else contents(0).length

  def beside(that: Element):Element = elem(
    for {
      (line1, line2) <- this.contents zip that.contents
    }yield line1 + line2
  )

  def above(that: Element):Element = elem(
    that.contents ++ this.contents
  )

  override def toString = this.contents mkString "\n"
}

object Element {

  def elem(contents: Array[String]): Element = new ArrayElement(contents)
  def elem(chr: Char, width:Int, height:Int):Element = new UniformElement(chr, width, height)
  def elem(line:String):Element = new LineElement(line)

  class ArrayElement(val contents:Array[String]) extends Element{
  }

  class LineElement(s:String) extends Element{
    val contents = Array(s)
    override def height: Int = 1
    override def width: Int = s.length
  }

  class UniformElement(ch:Char, override val height:Int,override val width:Int) extends Element{
    private val line = ch.toString * width
    override def contents = Array.fill(height)(line)
  }
}
