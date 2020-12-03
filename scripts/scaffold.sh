#!/bin/bash

# get args as "year day" or default to current
year=${1:-2020}
day=${2:-$(date +'%-d')}

# read in advent secrets
PARENT_PATH=$(
  cd "$(dirname "${BASH_SOURCE[0]}")"
  pwd -P
)
file="$PARENT_PATH/.advent_secrets"

function prop() {
  grep "${1}" ${file} | cut -d '=' -f2
}

kotlin_dir=$PARENT_PATH/../src/main/kotlin/year$year/day$day
tests_dir=$PARENT_PATH/../src/test/kotlin/year$year/day$day
input_dir=$PARENT_PATH/../src/main/resources/year$year

mkdir -p $kotlin_dir
mkdir -p $tests_dir
mkdir -p $input_dir

cat << EOF > $kotlin_dir/day$day.kt
package year$year.day$day

class Placeholder(val input: List<String>) {

  fun doWork(): Int {
    return 0
  }
}

EOF

cat << EOF > $tests_dir/day${day}tests.kt
package year$year.day$day

import common.Common
import org.junit.Test
import kotlin.test.assertEquals

internal class Day${day}KtTest {

  @Test
  fun example1() {
    val input = """

    """.trimIndent().lines()

    assertEquals(1, Placeholder(input).doWork())
  }

  @Test
  fun question1() {
    val input = Common.getFile("year$year/day$day.txt").readLines()
    assertEquals(1, Placeholder(input).doWork())
  }

  @Test
  fun example2() {
    val input = """

    """.trimIndent().lines()

    assertEquals(1, Placeholder(input).doWork())
  }

  @Test
  fun question2() {
    val input = Common.getFile("year$year/day$day.txt").readLines()
    assertEquals(1, Placeholder(input).doWork())
  }
}

EOF

# scaffold input
http --body https://adventofcode.com/$year/day/$day/input "Cookie:session=$(prop advent.session)" > $input_dir/day$day.txt

