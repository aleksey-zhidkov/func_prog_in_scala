package ch2.curry

fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C = { a: A -> { b: B -> f(a, b) } }

fun main(args: Array<String>) {
    val add = {a: Int, b: Int -> a + b}
    val add2 = curry(add)(2)
    assert(4 == add2(2))
}

