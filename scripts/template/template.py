# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# from collections import defaultdict, deque, namedtuple


def solve1(lines):
    for line in lines:
        print(line)


def solve2(lines):
    pass


example_input = [int(x) for x in open('example').read().splitlines()]
puzzle_input = [int(x) for x in open('input').read().splitlines()]

print('A', solve1(example_input))
print('A', solve1(puzzle_input))
print('B', solve2(example_input))
print('B', solve2(puzzle_input))
