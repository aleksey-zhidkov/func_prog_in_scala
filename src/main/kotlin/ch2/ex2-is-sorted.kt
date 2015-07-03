package ch2.isSorted

fun <A> isSorted(arr: Array<A>, gt: (A, A) -> Boolean): Boolean {

    @tailRecursive fun impl(arr: Array<A>, idx: Int, gt: (A, A) -> Boolean): Boolean =
    when {
        arr.size() - idx <= 1 -> true
        arr.size() - idx == 2 -> gt(arr[idx], arr[idx + 1])
        !gt(arr[idx], arr[idx + 1]) -> false
        else -> impl(arr, idx + 1, gt)
    }
    return impl(arr, 0, gt)
}

fun main(args: Array<String>) {
    val gt: (Int, Int) -> Boolean = {a: Int, b: Int -> a < b}
    assert(isSorted(arrayOf(), gt))
    assert(isSorted(arrayOf(1), gt))
    assert(isSorted(arrayOf(1, 2), gt))
    assert(isSorted(arrayOf(1, 2, 3), gt))
    assert(!isSorted(arrayOf(2, 1), gt))
    assert(!isSorted(arrayOf(3, 2, 1), gt))
    assert(!isSorted(arrayOf(1, 2, 1), gt))
    assert(!isSorted(arrayOf(1, 1, 1), gt))
    assert(!isSorted(arrayOf(0), gt))
}
