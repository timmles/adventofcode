# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# from collections import defaultdict, deque, namedtuple


def solve1(lines):
    hoz = 0
    depth = 0

    for line in lines:
        direction, amount = line.split(' ')
        amount = int(amount)
        if direction == 'forward':
            hoz += amount
        if direction == 'down':
            depth += amount
        if direction == 'up':
            depth -= amount

    return hoz*depth


def solve2(lines):
    hoz = 0
    depth = 0
    aim = 0

    for line in lines:
        direction, amount = line.split(' ')
        amount = int(amount)
        if direction == 'forward':
            hoz += amount
            depth += aim*amount
        if direction == 'down':
            aim += amount
        if direction == 'up':
            aim -= amount

    return hoz*depth


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

print('A', solve1(example_input))
print('A', solve1(puzzle_input))
print('B', solve2(example_input))
print('B', solve2(puzzle_input))
