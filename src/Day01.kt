fun main() {
    fun getCaloriesByElf(input: List<String>) : MutableList<Int> {
        val mutableList = mutableListOf<Int>()
        var totalCalories = 0
        for (cal in input) {
            if (cal == "") {
                mutableList.add(totalCalories)
                totalCalories = 0
            } else {
                totalCalories += cal.toInt()
            }
        }
        if (totalCalories > 0) {
            mutableList.add(totalCalories)
        }
        mutableList.sort()
        return mutableList;
    }

    fun part1(input: List<String>): Int {
        return getCaloriesByElf(input).max()
    }

    fun part2(input: List<String>): Int {
        return getCaloriesByElf(input).reversed().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
