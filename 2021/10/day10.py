# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
from collections import defaultdict, deque, namedtuple


def solve(lines):
    total = []
    errors = {
        ')': 0,
        ']': 0,
        '}': 0,
        '>': 0,
    }
    opposite = {
        ')': '(',
        ']': '[',
        '}': '{',
        '>': '<',
    }
    for line in lines:
        ok = True
        q = deque()
        for c in line:
            match c:
                case '(': q.append('(')
                case '[': q.append('[')
                case '{': q.append('{')
                case '<': q.append('<')
                case _:
                    pop = q.pop()
                    if pop != opposite[c]:
                        ok = False
                        errors[c] += 1
                        continue

        if ok:
            autocomplete = 0
            q.reverse()
            for c in q:
                autocomplete *= 5
                match c:
                    case '(': autocomplete += 1
                    case '[': autocomplete += 2
                    case '{': autocomplete += 3
                    case '<': autocomplete += 4
            total.append(autocomplete)

    a = errors[')'] * 3 + errors[']'] * 57 + errors['}'] * 1197 + errors['>'] * 25137

    total.sort()
    b = total[len(total)//2]

    return a, b


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

example = solve(example_input)
puzzle = solve(puzzle_input)
print('A', example[0])
print('A', puzzle[0])
print('B', example[1])
print('B', puzzle[1])
