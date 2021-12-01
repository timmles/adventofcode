# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# from collections import defaultdict, deque, namedtuple


def solve1(lines):
    measurement = None
    count = 0
    for line in lines:
        if measurement is not None and measurement < int(line):
            count = count+1
        measurement = int(line)
    return count


def solve2(lines):
    map = []
    for i in range(2,len(lines)):
        map.append(int(lines[i-2]) + int(lines[i-1]) + int(lines[i]))
    return solve1(map)


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

print('A', solve1(example_input))
print('A', solve1(puzzle_input))
print('B', solve2(example_input))
print('B', solve2(puzzle_input))
