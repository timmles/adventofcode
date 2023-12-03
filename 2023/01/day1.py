# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
import re
# import heapq
# from collections import defaultdict, deque, namedtuple, Counter


def solve1(lines):
    linesum = 0
    for line in lines:
        digit1 = re.search(r"\d", line)
        digit2 = re.search(r"\d", line[::-1])
        first = line[digit1.start()]
        last = line[::-1][digit2.start()]
        linesum += int(first+last)
    return linesum


def translate(digit):
    if "one" == digit:
        return "1"
    elif "two" == digit:
        return "2"
    elif "three" == digit:
        return "3"
    elif "four" == digit:
        return "4"
    elif "five" == digit:
        return "5"
    elif "six" == digit:
        return "6"
    elif "seven" == digit:
        return "7"
    elif "eight" == digit:
        return "8"
    elif "nine" == digit:
        return "9"
    return digit

def solve2(lines):
    linesum = 0
    for line in lines:
        number_re = "one|two|three|four|five|six|seven|eight|nine"
        digit1 = re.search(r"\d|"+number_re, line)
        digit2 = re.search(r"\d|"+number_re[::-1], line[::-1])

        digit1 = translate(digit1.group())
        digit2 = translate(digit2.group()[::-1])

        linesum += int(digit1+digit2)
    return linesum


example1_input = open('example1').read().splitlines()
example2_input = open('example2').read().splitlines()
puzzle_input = open('input').read().splitlines()

print('A', solve1(example1_input))
print('A', solve1(puzzle_input))
print('B', solve2(example2_input))
print('B', solve2(puzzle_input))
