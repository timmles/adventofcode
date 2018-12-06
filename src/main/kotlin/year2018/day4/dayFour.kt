package year2018.day4

import year2018.day3.Claim

class DayFour {
    fun createSleepShift(sleepInputRaw: List<String>): List<Sleep> {
        val regexTime = Regex("\\[(.*)\\]")
        val sleepInput = sleepInputRaw.sortedBy { regexTime.find(it)!!.groupValues[1] }

        val regexGuard = Regex("Guard #(\\d*)")
        val regexAsleep = Regex(":(\\d\\d)] falls asleep")
        val regexWake = Regex(":(\\d\\d)] wakes up")


        var currentGuardId:Int = 0
        var currentSleepTime:Int = 0
        var sleeps:MutableList<Sleep> = mutableListOf()

        sleepInput.forEach {
            val matchGuard = regexGuard.find(it)
            if (matchGuard != null) {
                currentGuardId = matchGuard.groupValues[1].toInt()
            }

            val matchAsleep = regexAsleep.find(it)
            if (matchAsleep != null) {
                currentSleepTime = matchAsleep.groupValues[1].toInt()
            }

            val matchWake = regexWake.find(it)
            if (matchWake != null) {
                val wake = matchWake.groupValues[1].toInt()
                sleeps.add(Sleep(currentGuardId, currentSleepTime, wake))
            }
        }

        return sleeps.toList()
    }

    fun findSleepiestGuard(sleeps: List<Sleep>): Int {
        val guards: MutableMap<Int, Int> = mutableMapOf<Int, Int>()

        sleeps.forEach {
            val guardSleep = guards.getOrPut(it.id, {0})
            guards.put(it.id, guardSleep + (it.wake - it.asleep))
        }

        return guards.maxBy { it.value }!!.key
    }

    fun findSleepiestMinute(sleeps: List<Sleep>): Map.Entry<Int, Int> {
        val minutes: MutableMap<Int, Int> = mutableMapOf<Int, Int>()

        sleeps.forEach {
            for (i in it.asleep..it.wake-1) {
                val sleepCounts = minutes.getOrPut(i, {0})
                minutes.put(i, sleepCounts + 1)
            }
        }

        return minutes.maxBy { it.value }!!
    }

    fun findSleepiestGuardMinuteByGuard(sleeps: List<Sleep>): Int {
        val sleepiestGuard = findSleepiestGuard(sleeps)
        val sleepiestMinute = findSleepiestMinute(sleeps.filter { it.id == sleepiestGuard })

        return sleepiestMinute.key * sleepiestGuard
    }

    fun findSleepiestGuardMinuteByMinute(sleeps: List<Sleep>): Int {

        val guardIds = sleeps.map { it.id }.distinct()

        val maxBy = guardIds.map { guardId ->
            val sleepiestMinute = findSleepiestMinute(sleeps.filter { it.id == guardId })
            Triple<Int, Int, Int>(guardId, sleepiestMinute.key, sleepiestMinute.value)
        }.maxBy { it.third }!!

        return maxBy.first * maxBy.second
    }


}

class Sleep(
        val id: Int,
        val asleep: Int,
        val wake: Int
)