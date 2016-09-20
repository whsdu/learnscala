val FilesList = (new java.io.File(".")).listFiles

for (i <- 1 to 100; if i<3) yield(i)

for {
  i <- 1 to 100
  tl <- 'a' to 'c'
}yield (i,tl)

def makeRowSeq(row:Int,n:Int)={
  for(i <- 1 to n) yield row * i
}

def makTable(n:Int) = {
  for (r <- 1 to n) yield makeRowSeq(r,n).mkString(" ")
}

makTable(3).mkString("\n")

val x1 = 2
def x2 = 3

val x4 = (i:Int, t:Int) => i + t
def x3(i:Int)(t:Int) = i + t
x3(2)_
val tl = List(10,20,30,40,50)
val seg = List(5,10,15,20,25,30)

def calcu(t:Int,sl:List[Int]):List[Int] = {
  val head = sl.head
  if(t<0 || sl.isEmpty) Nil
  else (t min head) :: calcu(t-head,sl.tail)
}

for( t <- tl) yield calcu(t,seg)

class TC (i:Int, s:String)

val ts1, ts2 = new TC(1,"s")

ts1 == ts2

def tF[T]( a1: T => Boolean, a2:List[T]) ={
  for(e <- a2; if a1(e)) yield e
}
val tl1 = List(1,2,3,4,5,6,7)
val tl2 = List('a','b','c','d')

tF((i:Int) => i>3,tl1)
tF((s:Char) => s > 'c',tl2)

def tF2[T]( a1: T => Boolean, a2:T) ={
  if(a1(a2)) 1
  else 0
}

tF2(_ == 3,3)

tl2 contains 'd'