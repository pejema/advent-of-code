import kotlin.streams.toList

fun main() {
    val items = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    fun getPriorities(compartment1: String, compartment2: String) : Int {
        return compartment1.toList().stream()
                .filter { item -> compartment2.contains(item) }
                .findFirst()
                .map { item -> items.indexOf(item) + 1 }
                .orElse(0)
    }

    fun getPrioritiesPart2(group: List<String>) : Int {
        return group[0].toList().stream()
                .filter { item -> group[1].contains(item) && group[2].contains(item) }
                .findFirst()
                .map { item -> items.indexOf(item) + 1 }
                .orElse(0)
    }

    fun part1(input: List<String>): Int {
        return input.stream()
                .map { line ->
                    val half = line.length / 2
                    getPriorities(line.substring(0, half), line.substring(half))
                }
                .toList().sum()
    }

    fun part2(input: List<String>): Int {
        return input.chunked(3)
                { group -> getPrioritiesPart2(group) }.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
