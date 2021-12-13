# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# from collections import defaultdict, deque, namedtuple



def solve1(lines):
    instructions = lines[lines.index('')+1:]
    coords = lines[:lines.index('')]
    for i in range(len(coords)):
        col, row = coords[i].split(',')
        coords[i] = (int(col), int(row))

    for i in instructions[0:1]:
        dir, line = i.split('=')
        dir = dir[-1]
        line = int(line)
        for i in range(len(coords)):
            col, row = coords[i]
            if 'x' == dir: #col
                if col > line:
                    coords[i] = (col - (col-line)*2, row)
            elif 'y' == dir: #row
                if row > line:
                    coords[i] = (col, row - (row-line)*2)

    def get_pair(x):
        a,b = x
        return b

    coords.sort(key=get_pair)

    for dot in coords:
        print(dot)

    print(len(coords))
    print(len(set(coords)))





def solve2(lines):
    pass


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

print('A', solve1(example_input))
print('A', solve1(puzzle_input))
# print('B', solve2(example_input))
# print('B', solve2(puzzle_input))
