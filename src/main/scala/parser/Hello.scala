package parser
import play.api.libs.json._
import scala.io.Source
import chapter6._
import chapter9._
import myconcurrency._
import java.util.concurrent._
import scala.concurrent.duration._
/**
  * Created by hao.wu on 01/09/2016.
  */
object Hello extends App{
  println("Hello this is from test project 3!!!")

  val source:String = Source.fromFile(dbjsonFileName).getLines().mkString
  println(source)
  val mjson:JsValue= Json.parse(source)
  println(mjson)
  val dbname = "NON_GTBU"
  val host = (mjson \ dbname \ "host").toString()
  val port = (mjson \ dbname \ "port").toString().toInt
  val pwd = (mjson \ dbname \ "pwd").toString()
  val usr = (mjson \ dbname \ "usr").toString()

  println(host)
  println(port)
  println(pwd)
  println(usr)

  val myjs:JsObject = Json.obj()
  def getSix = 6
  val t1 = RationalNum(1,3)
  val t2 = RationalNum(2,5)
  t1 + t2

  val tn1 = new RationalNum(5)
  println(tn1)
  val t4 = RationalNum(4,12)
  println(t4)
  val tsingle = RationalNum(7)
  println(tsingle)

  val myConList:Seq[HelloThread] = (0 to 5)  map (HelloThread(_))
  for(myCon <- myConList) myCon.start()
  for(myCon <- myConList) myCon.join()
  val mypi = sampling(200)
  println(4.0* mypi)

  import chapter12._

  val forg = new Forg
  println(forg)
  forg.philosophize

  val rect = new Rectangle((1,1),(10,10))
  println(rect.left)
  println(rect.bottomright)
  println(rect.right)
  println(rect.width)

  if(t1<t2) println("t1 is less than t2")
  else println("t1 is great than t2")

  val tql = new BasicIntQue
  tql.put(10)
  println(tql.get)

  val tdql = new BasicIntQue with Doubling
  tdql.put(10)
  println(tdql.get)

  val tifql = new BasicIntQue with Incrementing with Filtering
  tifql.put(0)
  println(tifql.get)

  val tfiql = new BasicIntQue with Filtering with Incrementing
  tfiql.put(-1)
  println(tfiql.get)

  println("test the git plugins")
}
