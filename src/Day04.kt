import kotlin.streams.toList

fun main() {

    // Example of full range inside other: 1-5,2-4
    fun getRanges(rangesPair: List<String>) : Int {
        val elf1 = rangesPair[0].substringBefore("-").toInt() .. rangesPair[0].substringAfter("-").toInt()
        val elf2 = rangesPair[1].substringBefore("-").toInt() .. rangesPair[1].substringAfter("-").toInt()
        return if (elf1.intersect(elf2).size == elf1.toList().size || elf2.intersect(elf1).size == elf2.toList().size)
            1 else 0
    }

    // Example of overlapped ranges: 2-6,4-8
    fun getOverlappedRanges(rangesPair: List<String>) : Int {
        val elf1 = rangesPair[0].substringBefore("-").toInt() .. rangesPair[0].substringAfter("-").toInt()
        val elf2 = rangesPair[1].substringBefore("-").toInt() .. rangesPair[1].substringAfter("-").toInt()
        return if (elf1.intersect(elf2).isEmpty()) 0 else 1
    }

    fun part1(input: List<String>): Int {
        return input.stream()
                .map { line -> getRanges(line.split(",")) }
                .toList().sum()
    }

    fun part2(input: List<String>): Int {
        return input.stream()
                .map { line -> getOverlappedRanges(line.split(",")) }
                .toList().sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}
