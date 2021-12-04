package day01

import lib.readTestInput
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainTest {
	private val testInput = readTestInput("day01/test")

	@Test
	fun `Validate day01 part 1`() {
		assertEquals(7, part1(testInput))
	}

	@Test
	fun `Validate day01 part 2`() {
		assertEquals(5, part2(testInput))
	}
}
