# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
from collections import defaultdict, deque, namedtuple


def solve1(lines):
    nodes = defaultdict(lambda: [])
    paths = []
    for line in lines:
        node, edge = line.split('-')
        nodes[node].append(edge)
        nodes[edge].append(node)

    def search(node, path):
        path.append(node)
        if node == 'end':
            paths.append(path)
            return

        for x in nodes[node]:
            if x == x.upper() or x == x.lower() and x not in path:
                search(x, path.copy())

    search('start', [])
    # for x in paths:
    #     print(x)
    return len(paths)

def solve2(lines):
    nodes = defaultdict(lambda: [])
    paths = []
    for line in lines:
        node, edge = line.split('-')
        nodes[node].append(edge)
        nodes[edge].append(node)

    lowers = [x for x in nodes if x == x.lower()]

    def search(node, path):
        path.append(node)
        if node == 'end':
            paths.append(path)
            return

        for x in nodes[node]:
            if x == x.upper() or x == x.lower() and (x != 'start' and path.count(x) < limit(path)):
                search(x, path.copy())

    def limit(path):
        max2 = max([path.count(x) for x in lowers])
        if max2 == 2:
            return 1
        else:
            return 2

    search('start', [])
    # for x in paths:
    #     print(x)
    return len(paths)


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

print('A', solve1(example_input))
print('A', solve1(puzzle_input))
print('B', solve2(example_input))
print('B', solve2(puzzle_input))
