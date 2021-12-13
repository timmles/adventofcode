# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# from collections import defaultdict, deque, namedtuple

def get_pair1(x):
    a,b = x
    return a
def get_pair2(x):
    a,b = x
    return b

def print_board(coords):
    max_col = max([get_pair1(x) for x in coords])
    max_row = max([get_pair2(x) for x in coords])
    dots = [['.' for i in range(max_col+1)] for i in range(max_row+1)]
    coords = set(coords)
    for coord in coords:
        col, row = coord
        dots[row][col] = '#'

    for dot in dots:
        print(dot)

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

    return len(set(coords))

def solve2(lines):
    instructions = lines[lines.index('')+1:]
    coords = lines[:lines.index('')]
    for i in range(len(coords)):
        col, row = coords[i].split(',')
        coords[i] = (int(col), int(row))

    for i in instructions:
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

    print_board(coords)


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

print('A', solve1(example_input))
print('A', solve1(puzzle_input))
print('B', solve2(example_input))
print('B', solve2(puzzle_input)) # UEFZCUCJ
