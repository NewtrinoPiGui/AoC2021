package day01

import lib.readTestInput
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainTest {
    private val testInput = readTestInput("day01/test")

    @Test
    fun `Validate day01 part 1`() {
        assertEquals(part1(testInput), 7)
    }

    @Test
    fun `Validate day01 part 2`() {
        assertEquals(part2(testInput), 5)
    }
}
