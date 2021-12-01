# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# from collections import defaultdict, deque, namedtuple


def solve1(lines):
    return [x > lines[ind - 1] if ind != 0 else False for ind, x in enumerate(lines)].count(True)


def solve2(lines):
    return solve1([lines[ind-2] + lines[ind-1] + lines[ind] for ind, x in enumerate(lines[2:], 2)])


example_input = [int(x) for x in open('example').read().splitlines()]
puzzle_input = [int(x) for x in open('input').read().splitlines()]

print('A', solve1(example_input))
print('A', solve1(puzzle_input))
print('B', solve2(example_input))
print('B', solve2(puzzle_input))
