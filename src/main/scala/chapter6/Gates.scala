package chapter6

/**
  * Created by hao.wu on 08/09/2016.
  */
abstract class Gates extends Simulation{
  def InverterDelay:Int
  def AndGateDelay:Int
  def OrGateDelay:Int

  class Wire{
    private var sigVal = false
    private var actions:List[Action] = List()

    def getSingal:Boolean = sigVal

    def setSingal(s:Boolean):Unit =
      if(s != sigVal){
        sigVal = s
        actions foreach (_())
      }

    def addAction(a:Action):Unit = {
      actions = a:: actions
      a()
    }
  }

  def inverter(input: Wire, output:Wire):Unit = {
    def invertAction():Unit = {
      val inputSig = input.getSingal
      afterDelay(InverterDelay){
        output setSingal !inputSig
      }
    }
    input addAction invertAction
  }

  def andGate(in1: Wire, in2:Wire, output: Wire) = {
    def andAction() = {
      val in1Sig = in1.getSingal
      val in2Sig = in2.getSingal
      afterDelay(AndGateDelay){
        output setSingal (in1Sig & in2Sig)
      }
    }
    in1 addAction andAction
    in2 addAction andAction
  }

  def orGate(in1:Wire, in2:Wire, output:Wire):Unit = {
    def orAction() = {
      val in1Sig = in1.getSingal
      val in2Sig = in2.getSingal
      afterDelay(OrGateDelay){
        output setSingal (in1Sig | in2Sig)
      }
    }
  }

  def probe(name: String, wire: Wire):Unit = {
    def probeAction():Unit = {
      println(s""" $name at: $currentTime value = ${wire.getSingal}""")
    }
    wire addAction probeAction
  }

}
