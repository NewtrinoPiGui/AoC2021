package lib

import java.io.File

/**
 * Reads lines from the given test input txt file.
 */
fun readTestInput(name: String) = File("src/test/resources", "$name.txt").readLines()
