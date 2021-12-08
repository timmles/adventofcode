# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# from collections import defaultdict, deque, namedtuple

def fuel1(lines, mid):
    return sum([abs(x - mid) for x in lines])


def fuel2(lines, mid):
    return sum([(abs(x - mid)+1)/2 * (abs(x - mid)) for x in lines])


def solve(lines, fuel_func):
    mid = sum(lines)//len(lines)
    while True:
        left = fuel_func(lines, mid-1)
        here = fuel_func(lines, mid)
        right = fuel_func(lines, mid+1)

        if left >= here <= right:
            break
        elif left < here:
            mid -= 1
        elif right < here:
            mid += 1
        else:
            print('wat')
    return fuel_func(lines, mid)


example_input = [int(val) for x in open('example').read().splitlines() for val in x.split(',')]
puzzle_input = [int(val) for x in open('input').read().splitlines() for val in x.split(',')]

print('A', solve(example_input, fuel1))
print('A', solve(puzzle_input, fuel1))
print('B', solve(example_input, fuel2))
print('B', solve(puzzle_input, fuel2))
