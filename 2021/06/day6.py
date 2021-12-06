# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
from collections import defaultdict


def solve_naive(lines, lifecycle):
    fish = defaultdict(lambda: 0)

    for x in lines:
        fish[x] += 1

    for i in range(lifecycle):
        count_zeros = lines.count(0)
        lines = [x - 1 if x != 0 else 6 for x in lines]
        for x in range(count_zeros):
            lines.append(8)
    return len(lines)


def solve_optimised(lines, lifecycle):
    fish = defaultdict(lambda: 0)

    for x in lines:
        fish[x] += 1

    for i in range(lifecycle):
        count_zeros = fish[0]
        fish[0] = fish[1]
        fish[1] = fish[2]
        fish[2] = fish[3]
        fish[3] = fish[4]
        fish[4] = fish[5]
        fish[5] = fish[6]
        fish[6] = fish[7]
        fish[7] = fish[8]
        fish[6] += count_zeros
        fish[8] = count_zeros

    return sum(list(fish.values()))


def solve_optimised_condensed(lines, lifecycle):
    fish = defaultdict(lambda: 0)

    for x in lines:
        fish[x] += 1

    for i in range(lifecycle):
        count_zeros = fish[0]
        for i in range(8):
            fish[i] = fish[i+1]
        fish[6] += count_zeros
        fish[8] = count_zeros

    return sum(list(fish.values()))


def solve_shifting(lines, lifecycle):
    fish = [0, 0, 0, 0, 0, 0, 0, 0, 0]

    for x in lines:
        fish[x] += 1

    for i in range(lifecycle):
        count_zeros = fish[0]
        fish = fish[1:]
        fish.append(0)
        fish[6] += count_zeros
        fish[8] = count_zeros

    return sum(fish)


example_input = open('example').read().splitlines()[0]
example_input = example_input.split(',')
example_input = [int(x) for x in example_input]
puzzle_input = open('input').read().splitlines()[0]
puzzle_input = puzzle_input.split(',')
puzzle_input = [int(x) for x in puzzle_input]

print('A', solve_naive(example_input, 80))
print('A', solve_shifting(example_input, 80))
print('A', solve_shifting(puzzle_input, 80))
print('B', solve_shifting(example_input, 256))
print('B', solve_shifting(puzzle_input, 256))
