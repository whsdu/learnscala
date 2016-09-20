import scala.util.Random

/**
  * Created by hao.wu on 16/09/2016.
  */
package object myconcurrency {
  def sampling(cnt:Int):Double = {
    val randomX = new Random
    val randomY = new Random
    def aux_normal(x:Double, y:Double):Boolean = (x*x + y*y) < 1
    val inList = for{
      i <- 0 to cnt
      if aux_normal(randomX.nextDouble(),randomY.nextDouble())
    }yield i
    println(inList.length)
    println(cnt)
    (1.0 *inList.length/cnt)
  }
}
