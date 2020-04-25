object Application extends App{

  // part 1

  val list1: List[Int] = List.fill(5)(scala.util.Random.between(-100, 100))
  println(list1)

  def isPositive(value: Int): Boolean = {
    value >= 0
  }

  val positiveNumbers1 = list1.filter(even => isPositive(even))
  println(positiveNumbers1)

  def positiveNumbersTailRecursion(list: List[Int]): List[Int] = {

    if (list.isEmpty) list else if(list.size == 1){
      if (list.head>=0) list else list.drop(1)
    }
    else{
      if(list.head >=0){
        positiveNumbersIteration(List(list.head), list.drop(1)).reverse
      } else
        positiveNumbersIteration(List(), list.drop(1)).reverse
    }
  }

  @scala.annotation.tailrec
  private def positiveNumbersIteration(accumulator: List[Int], list: List[Int]): List[Int] = {
    if (list.size == 1) {
      if (list.head>=0) list:::accumulator else accumulator
    }
    else {
      if(list.head >= 0){
        positiveNumbersIteration(List(list.head):::accumulator, list.drop(1))
      }
      else positiveNumbersIteration(accumulator, list.drop(1))
    }
  }

  val positiveNumbers2 = positiveNumbersTailRecursion(list1)
  println(positiveNumbers2)

  // part 2

  val list2: List[Int] = List.fill(5)(scala.util.Random.nextInt(100))
  println(list2)

  def divideEvenAndIncrementNotEven(value: Int): Int = {
    if ((value % 2) == 0) value/2 else value+1
  }

  val divideAndIncrementNumbers1 = list2.map(value => divideEvenAndIncrementNotEven(value))
  println(divideAndIncrementNumbers1)

  def divideEvenAndIncrementNotEvenTailRecursion(list: List[Int]): List[Int] = {

    if (list.isEmpty) list else if(list.size == 1){
      if ((list.head % 2) == 0) List(list.head / 2) else List(list.head + 1)
    }
    else{
      if((list.head % 2) == 0){
        divideEvenAndIncrementNotEvenIteration(List(list.head / 2), list.drop(1)).reverse
      } else
        divideEvenAndIncrementNotEvenIteration(List(list.head + 1), list.drop(1)).reverse
    }
  }

  @scala.annotation.tailrec
  private def divideEvenAndIncrementNotEvenIteration(accumulator: List[Int], list: List[Int]): List[Int] = {
    if (list.size == 1) {
      if ((list.head % 2) == 0) List(list.head / 2):::accumulator else List(list.head + 1):::accumulator
    }
    else {
      if((list.head % 2) == 0){
        divideEvenAndIncrementNotEvenIteration(List(list.head / 2):::accumulator, list.drop(1))
      }
      else divideEvenAndIncrementNotEvenIteration(List(list.head + 1):::accumulator, list.drop(1))
    }
  }

  val divideAndIncrementNumbers2 = divideEvenAndIncrementNotEvenTailRecursion(list2)
  println(divideAndIncrementNumbers2)
}
