package day03

import lib.readTestInput
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainTest {
    private val testInput = readTestInput("day03/test")

    @Test
    fun `Validate day03 part 1`() {
        assertEquals(part1(testInput), 198)
    }

    @Test
    fun `Validate day03 part 2`() {
        assertEquals(part2(testInput), 0)
    }
}
