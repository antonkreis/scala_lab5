import org.scalatest.FunSuite

class ApplicationTest extends FunSuite {
  test("Application.isPositive"){
    assert(Application.isPositive(4)===true)
    assert(Application.isPositive(-4)===false)
  }
  test("Application.isPositiveTailRecursion"){
    assert(Application.positiveNumbersTailRecursion(List(1, -2, 0))===List(1, 0))
  }
  test("Application.divideEvenAndIncrementNotEven"){
    assert(Application.divideEvenAndIncrementNotEven(3)===4)
    assert(Application.divideEvenAndIncrementNotEven(4)===2)
    assert(Application.divideEvenAndIncrementNotEven(0)===0)
    assert(Application.divideEvenAndIncrementNotEven(-3)===(-2))
    assert(Application.divideEvenAndIncrementNotEven(-4)===(-2))
  }
  test("Application.divideEvenAndIncrementNotEvenTailRecursion"){
    assert(Application.divideEvenAndIncrementNotEvenTailRecursion(List(1, -2, 0, 2, -3))===List(2, -1, 0, 1, -2))
  }
}
