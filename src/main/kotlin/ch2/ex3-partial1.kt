package ch2.partial1

fun <A, B, C> partial1(a: A, f: (A, B) -> C): (B) -> C = { b: B -> f(a, b) }

fun main(args: Array<String>) {
    val add = {x: Int, y: Int -> x + y}
    val add2 = partial1(2, add)
    assert(4 == add2(2))
}

