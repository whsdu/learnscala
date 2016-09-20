package chapter6

/**
  * Created by hao.wu on 06/09/2016.
  */
class RationalNum(n:Int, d:Int) extends Ordered[RationalNum]{
  require( d != 0)
  private val c = gcd(n.abs,d.abs)
  val numerator:Int = n/c
  val denominator:Int = d/c

  def this(n:Int) = this(n,1)

  override def toString() = numerator +"/"+denominator

  def + (other:RationalNum):RationalNum = RationalNum(this.numerator * other.denominator + other.numerator * this.denominator,
    this.denominator * other.denominator)

  def * (other:RationalNum) = RationalNum( this.numerator * other.numerator, this.denominator * other.denominator)

  def neg():RationalNum = RationalNum( -this.numerator,this.denominator)

  def max (other:RationalNum):RationalNum = if(this < other) other else this

  def - (other:RationalNum) = this + other.neg

  private def gcd(a:Int, b:Int):Int = if( b==0) a else gcd(b, a%b)

  override def compare(that: RationalNum): Int =
    (this.numerator * that.denominator) - (that.numerator * this.denominator)
}


object RationalNum{
  def apply(n:Int, d:Int) = new RationalNum(n,d)
  def apply(n:Int) = new RationalNum(n)
}
