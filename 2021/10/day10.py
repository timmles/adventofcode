# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
from collections import defaultdict, deque, namedtuple


def solve1(lines):
    errors = {
        ')': 0,
        ']': 0,
        '}': 0,
        '>': 0,
    }
    opposite = {
        ')' : '(',
        ']' : '[',
        '}' : '{',
        '>' : '<',
    }
    for line in lines:
        q = deque()
        for c in line:
            match c:
                case '(': q.append('(')
                case '[': q.append('[')
                case '{': q.append('{')
                case '<': q.append('<')
                case _:
                    if q.pop() != opposite[c]:
                        errors[c] += 1
                        continue
    return errors[')'] * 3 + errors[']'] * 57 + errors['}'] * 1197 + errors['>'] * 25137

def solve2(lines):
    total = []
    errors = {
        ')': 0,
        ']': 0,
        '}': 0,
        '>': 0,
    }
    opposite = {
        ')' : '(',
        ']' : '[',
        '}' : '{',
        '>' : '<',
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
        if ok:
            autocomplete = 0
            print(q)
            q.reverse()
            for c in q:
                autocomplete *= 5
                match c:
                    case '(': autocomplete += 1
                    case '[': autocomplete += 2
                    case '{': autocomplete += 3
                    case '<': autocomplete += 4
            print(autocomplete)
            total.append(autocomplete)

    total.sort()

    return total[len(total)//2]


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

# print('A', solve1(example_input))
# print('A', solve1(puzzle_input))
print('B', solve2(example_input))
print('B', solve2(puzzle_input))
