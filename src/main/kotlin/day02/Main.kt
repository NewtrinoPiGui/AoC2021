package day02

import readInput

val moveForward = Regex("""forward\s+(\d+)""")
val moveDown = Regex("""down\s+(\d+)""")
val moveUp = Regex("""up\s+(\d+)""")

data class Position(var horizontal: Int = 0, var depth: Int = 0, var aim: Int = 0)

fun main() {
    val input = readInput("day02/data")
    println("Part1: ${part1(input)}")
    println("Part2: ${part2(input)}")
}
