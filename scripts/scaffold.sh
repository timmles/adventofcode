#!/bin/bash

# get args as "year day" or default to current
year=${1:-$(date +'%-Y')}
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

kotlin_file=$PARENT_PATH/../$year/src/main/kotlin/day$day/day$day.kt
tests_file=$PARENT_PATH/../$year/src/test/kotlin/day$day/day${day}tests.kt
input_file=$PARENT_PATH/../$year/src/test/resources/day$day.txt

mkdir -p $(dirname "$kotlin_file")
mkdir -p $(dirname "$tests_file")
mkdir -p $(dirname "$input_file")

cat << EOF > $kotlin_file
package year$year.day$day

class Placeholder(val input: List<String>) {

  fun doWork(): Int {
    return 0
  }
}

EOF

cat << EOF > $tests_file
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
    val input = Common.getFile("day$day.txt").readLines()
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
    val input = Common.getFile("day$day.txt").readLines()
    assertEquals(1, Placeholder(input).doWork())
  }
}

EOF

# scaffold input
http --body https://adventofcode.com/$year/day/$day/input "Cookie:session=$(prop advent.session)" > $input_file

git add $input_file $tests_file $kotlin_file
idea $input_file $tests_file $kotlin_file
