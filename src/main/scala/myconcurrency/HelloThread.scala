package myconcurrency

/**
  * Created by hao.wu on 14/09/2016.
  */
class HelloThread(id:Int) extends Thread{
  override def run(): Unit = {
    println("Hello world! from myCon: " + id)
    println("after print hello from: " + id)
  }
}

object HelloThread{
  def apply(id: Int): HelloThread = new HelloThread(id)
}
