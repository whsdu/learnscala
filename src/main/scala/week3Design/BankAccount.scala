package week3Design

/**
  * Created by hao.wu on 02/09/2016.
  */
class BankAccount {
  private var balance = 0

  def deposit(amount:Int):Unit =
    if (amount > 0) balance = balance + amount

  def withdraw(amount:Int):Int =
    if(amount > 0 && amount < balance) {
      balance = balance - amount
      balance
    }
    else throw new Error("Insufficent Balance!!!")

}
