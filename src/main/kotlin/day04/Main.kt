package day04

import readInput
import java.security.InvalidParameterException

class Board(inputRows: List<List<Int>>) {
	private val boardSize = 5
	private val rows: List<List<Int>>
	private val rowSelections = mutableMapOf<Int, MutableSet<Int>>()
	private val columnSelections = mutableMapOf<Int, MutableSet<Int>>()

	init {
		if (inputRows.size != boardSize) {
			throw InvalidParameterException("Invalid board size: Too many rows (${inputRows.size}) but expected $boardSize")
		}
		inputRows.forEachIndexed { index, inputRow ->
			if (inputRow.size != boardSize) {
				throw InvalidParameterException("Invalid board size: Too many columnns (${inputRow.size}) for index ($index) but expected $boardSize")
			}
		}
		rows = listOf(
			*(0 until boardSize)
				.map { index ->
					inputRows[index].toList()
				}.toTypedArray()
		)
	}

	fun check(value: Int): Boolean {
		var isContained = false
		rows.forEachIndexed { rowIndex, row ->
			row.forEachIndexed { columnIndex, columnValue ->
				if (columnValue == value) {
					rowSelections.computeIfAbsent(rowIndex) { mutableSetOf() }
						.add(value)
					columnSelections.computeIfAbsent(columnIndex) { mutableSetOf() }
						.add(value)
					isContained = true
				}
			}
		}
		return isContained
	}

	fun sumUnmarked(): Int =
		rows.foldIndexed(0) { rowIndex, rowAccumulator, row ->
			rowAccumulator + row.filter { value ->
				rowSelections[rowIndex]?.contains(value)?.not() ?: false
			}.fold(0) { accumulator, value ->
				accumulator + value
			}
		}

	fun hasBingo(): Boolean = rowSelections.any { entry ->
		entry.value.size == boardSize
	} || columnSelections.any { entry ->
		entry.value.size == boardSize
	}

	companion object {
		private val boardRowFormat = Regex("""\s*(\d+)\s+(\d+)\s+(\d+)\s+(\d+)\s+(\d+)\s*""")

		fun of(input: List<String>): List<Board> {
			val boardRows = mutableListOf<List<Int>>()
			val boards = mutableListOf<Board>()
			for (rowIndex in 1 until input.size) {
				if (input[rowIndex].isNotBlank()) {
					val matcher = boardRowFormat.matchEntire(input[rowIndex])
					val boardRow = listOf(
						matcher?.groupValues!![1].toInt(),
						matcher.groupValues[2].toInt(),
						matcher.groupValues[3].toInt(),
						matcher.groupValues[4].toInt(),
						matcher.groupValues[5].toInt()
					)
					boardRows.add(boardRow)
					if (boardRows.size == 5) {
						boards.add(Board(boardRows))
						boardRows.clear()
					}
				}
			}
			return boards
		}
	}
}

fun main() {
	val input = readInput("day04/data")
	println("Part1: ${part1(input)}")
	println("Part2: ${part2(input)}")
}
