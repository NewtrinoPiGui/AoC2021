package day02

import lib.readTestInput
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainTest {
    private val testInput = readTestInput("day02/test")

    @Test
    fun `Validate day02 part 1`() {
        assertEquals(part1(testInput), 150)
    }

    @Test
    fun `Validate day02 part 2`() {
        assertEquals(part2(testInput), 900)
    }
}
