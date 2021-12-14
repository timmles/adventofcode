# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
from collections import defaultdict, deque, namedtuple


def solve1(lines):
    template = lines[0]
    poly = dict()
    for i in lines[2:]:
        pair, insertion = i.split(' -> ')
        poly[pair] = insertion

    for i in range(10):
        insertions = defaultdict(lambda x: '')
        for pair in zip(template[:], template[1:], range(len(template))):
            if ''.join(pair[0:2]) in poly.keys():
                insertions[pair[2]] = poly[''.join(pair[0:2])]
            # for line in lines:
            #     print(line)

        for ind, key in enumerate(insertions):
            template = template[:key+ind+1] + insertions[key] + template[key+1+ind:]

    counts = dict.fromkeys(set(template), 0)
    for i in counts:
        counts[i] = template.count(i)

    return max(counts.values()) - min(counts.values())

def solve2(lines):
    pass


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

print('A', solve1(example_input))
# print('A', solve1(puzzle_input))
# print('B', solve2(example_input))
# print('B', solve2(puzzle_input))
