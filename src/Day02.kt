import kotlin.streams.toList

fun main() {
    fun getPointsPart1(elfShape: String, myShape: String) : Int {
        var points = 0
        if (elfShape == "A" && myShape == "X") {
            points = 1 + 3
        } else if (elfShape == "A" && myShape == "Y") {
            points = 2 + 6
        } else if (elfShape == "A" && myShape == "Z") {
            points = 3
        } else if (elfShape == "B" && myShape == "X") {
            points = 1
        } else if (elfShape == "B" && myShape == "Y") {
            points = 2 + 3
        } else if (elfShape == "B" && myShape == "Z") {
            points = 3 + 6
        } else if (elfShape == "C" && myShape == "X") {
            points = 1 + 6
        } else if (elfShape == "C" && myShape == "Y") {
            points = 2
        } else if (elfShape == "C" && myShape == "Z") {
            points = 3 + 3
        }
        return points
    }

    fun getPointsPart2(elfShape: String, myShape: String) : Int {
        var points = 0
        if (elfShape == "A" && myShape == "X") {
            points = 3
        } else if (elfShape == "A" && myShape == "Y") {
            points = 1 + 3
        } else if (elfShape == "A" && myShape == "Z") {
            points = 2 + 6
        } else if (elfShape == "B" && myShape == "X") {
            points = 1
        } else if (elfShape == "B" && myShape == "Y") {
            points = 2 + 3
        } else if (elfShape == "B" && myShape == "Z") {
            points = 3 + 6
        } else if (elfShape == "C" && myShape == "X") {
            points = 2
        } else if (elfShape == "C" && myShape == "Y") {
            points = 3 + 3
        } else if (elfShape == "C" && myShape == "Z") {
            points = 1 + 6
        }
        return points
    }

    /*
    * First column: A for Rock, B for Paper, and C for Scissors.
    * Second column: X for Rock, Y for Paper, and Z for Scissors.
    * The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
    * plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
    * */

    fun part1(input: List<String>): Int {
        return input.stream()
                .map { line -> line.split(" ") }
                .map { shapes -> getPointsPart1(shapes[0], shapes[1]) }
                .toList().sum()
    }

    /*
    * First column: A for Rock, B for Paper, and C for Scissors.
    * Second column: X you lose: 0 points, Y you draw: 3 points, and Z you win: 6 points.
    * The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
    * plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
    * */

    fun part2(input: List<String>): Int {
        return input.stream()
                .map { line -> line.split(" ") }
                .map { shapes -> getPointsPart2(shapes[0], shapes[1]) }
                .toList().sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
