package ch2.compose

import ch2.curry.curry

fun <A, B, C> compose(f: (A) -> B, g: (B) -> C): (A) -> C = { a: A -> g(f(a)) }

fun main(args: Array<String>) {
    val add = { a: Int, b: Int -> a + b }
    val mul = { a: Int, b: Int -> a * b }

    val add2 = curry(add)(2)
    val mul2 = curry(mul)(2)
    val addAndMul = compose(add2, mul2)
    val mulAndAdd = compose(mul2, add2)
    assert(8 == addAndMul(2))
    assert(6 == mulAndAdd(2))
}

