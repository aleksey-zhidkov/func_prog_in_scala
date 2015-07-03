package ch2.uncurry

import ch2.curry.curry

fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C = { a: A, b: B -> f(a)(b) }

fun main(args: Array<String>) {
    val add = { a:Int, b: Int -> a + b}
    val addCurried = curry(add)
    val addUncurried = uncurry(addCurried)
    assert(4 == addUncurried(2, 2))
}

