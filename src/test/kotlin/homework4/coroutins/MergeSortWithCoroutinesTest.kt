import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class MergeSortWithCoroutinesTest {
    @ParameterizedTest
    @MethodSource("testForEmptyList")
    fun `test for empty list`(numberOfCoroutine: Int) {
        val sortClassOfInt = MergeSortWithCoroutines<Int>()
        assertEquals(mutableListOf<Int>(), sortClassOfInt.sort(mutableListOf(), numberOfCoroutine))
    }

    @ParameterizedTest
    @MethodSource("sortTestWithZeroCoroutine")
    fun `auto generated list coroutine sort test`(testList: MutableList<Int>, coroutineNumber: Int) {
        assertEquals(
            testList.sorted(),
            MergeSortWithCoroutines<Int>().sort(testList, coroutineNumber),
            "Coroutine sort test failed for ${2.pow(coroutineNumber)} coroutine number, ${testList.size} elements"
        )
    }

    companion object {
        @JvmStatic
        fun testForEmptyList() = listOf(
            Arguments.of(0),
            Arguments.of(7),
            Arguments.of(-1)
        )

        @JvmStatic
        fun sortTestWithZeroCoroutine() = listOf(
            Arguments.of(smallList(), -1),
            Arguments.of(smallMediumList(), -3),
            Arguments.of(bigMediumList(), -5),
            Arguments.of(bigList(), -100),
            Arguments.of(smallList(), 0),
            Arguments.of(smallMediumList(), 0),
            Arguments.of(bigMediumList(), 0),
            Arguments.of(bigList(), 0),
            Arguments.of(smallList(), 1),
            Arguments.of(smallMediumList(), 1),
            Arguments.of(bigMediumList(), 1),
            Arguments.of(bigList(), 1),
            Arguments.of(smallList(), 5),
            Arguments.of(smallMediumList(), 5),
            Arguments.of(bigMediumList(), 5),
            Arguments.of(bigList(), 5),
            Arguments.of(smallList(), 10),
            Arguments.of(smallMediumList(), 10),
            Arguments.of(bigMediumList(), 10),
            Arguments.of(bigList(), 10),
            Arguments.of(smallList(), 15),
            Arguments.of(smallMediumList(), 15),
            Arguments.of(bigMediumList(), 15),
            Arguments.of(bigList(), 15),
        )
    }
}
