/**
  * Created by hao.wu on 06/09/2016.
  */
import chapter6._
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Chapter6Test extends FunSuite{
  val t1 = RationalNum(1,3)
  val t2 = RationalNum(1,3)

  test("this is a first try of test"){
    assert(t1 != t2)
  }
}
