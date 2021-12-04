package day04

import lib.readTestInput
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainTest {
	private val testInput = readTestInput("day04/test")

	@Test
	fun `Validate day04 part 1`() {
		assertEquals(4512, part1(testInput))
	}

	@Test
	fun `Validate day04 part 2`() {
		assertEquals(1924, part2(testInput))
	}
}
