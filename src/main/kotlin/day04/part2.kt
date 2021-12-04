package day04

/**
 * On the other hand, it might be wise to try a different strategy: let the giant squid win.
 *
 * You aren't sure how many bingo boards a giant squid could play at once, so rather than waste time counting its arms,
 * the safe thing to do is to figure out which board will win last and choose that one. That way, no matter which boards
 * it picks, it will win for sure.
 *
 * In the above example, the second board is the last to win, which happens after 13 is eventually called and its middle
 * column is completely marked. If you were to keep playing until this point, the second board would have a sum of
 * unmarked numbers equal to 148 for a final score of 148 * 13 = 1924.
 *
 * Figure out which board will win last. Once it wins, what would its final score be?
 */
fun part2(input: List<String>): Int {
	val drawSequence = input[0].splitToSequence(",").map { it.toInt() }
	val boards = Board.of(input).toMutableList()
	var lastWinner: Board? = null
	val winningDraw = drawSequence.last { drawing ->
		val winningBoard = boards.filter { board ->
			board.check(drawing)
		}.find { board ->
			board.hasBingo()
		}
		if (winningBoard != null) {
			lastWinner = winningBoard
			boards.removeIf { board -> board.hasBingo() }
		}
		winningBoard != null
	}
	val bingoBoardSum = lastWinner?.sumUnmarked() ?: 0

	return winningDraw * bingoBoardSum
}
