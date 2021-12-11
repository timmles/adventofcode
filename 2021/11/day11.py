# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# from collections import defaultdict, deque, namedtuple
import copy


def print_board(lines):
    R = len(lines)
    C = len(lines[0])
    for r in range(R):
        for c in range(C):
            print(str(lines[r][c]), end='')
        print()
    print()

def solve1(lines):
    flashes = 0
    # print_board(lines)
    for i in range(100):

        R = len(lines)
        C = len(lines[0])
        for r in range(R):
            for c in range(C):
                lines[r][c] += 1

        flash = True
        while flash:
            flash = False
            for r in range(R):
                for c in range(C):
                    if isinstance(lines[r][c]  , int) and lines[r][c] > 9:
                        flash = True
                        flashes += 1
                        if 0 <= r-1 < R and 0 <= c-1 < C and isinstance(lines[r-1][c-1], int): lines[r-1][c-1] +=1
                        if 0 <= r-1 < R and 0 <= c   < C and isinstance(lines[r-1][c]  , int): lines[r-1][c]   +=1
                        if 0 <= r-1 < R and 0 <= c+1 < C and isinstance(lines[r-1][c+1], int): lines[r-1][c+1] +=1
                        if 0 <= r   < R and 0 <= c-1 < C and isinstance(lines[r][c-1]  , int): lines[r][c-1]   +=1
                        if 0 <= r   < R and 0 <= c   < C and isinstance(lines[r][c]    , int): lines[r][c]     = 'D'
                        if 0 <= r   < R and 0 <= c+1 < C and isinstance(lines[r][c+1]  , int): lines[r][c+1]   +=1
                        if 0 <= r+1 < R and 0 <= c-1 < C and isinstance(lines[r+1][c-1], int): lines[r+1][c-1] +=1
                        if 0 <= r+1 < R and 0 <= c   < C and isinstance(lines[r+1][c]  , int): lines[r+1][c]   +=1
                        if 0 <= r+1 < R and 0 <= c+1 < C and isinstance(lines[r+1][c+1], int): lines[r+1][c+1] +=1

        # print_board(lines)

        R = len(lines)
        C = len(lines[0])
        for r in range(R):
            for c in range(C):
                if lines[r][c] == 'D': lines[r][c] = 0

        # print_board(lines)

    return flashes


def solve2(lines):
    flashes = 0
    step = 0
    # print_board(lines)
    while True:
        step += 1
        R = len(lines)
        C = len(lines[0])
        for r in range(R):
            for c in range(C):
                lines[r][c] += 1

        flash = True
        while flash:
            flash = False
            for r in range(R):
                for c in range(C):
                    if isinstance(lines[r][c]  , int) and lines[r][c] > 9:
                        flash = True
                        flashes += 1
                        if 0 <= r-1 < R and 0 <= c-1 < C and isinstance(lines[r-1][c-1], int): lines[r-1][c-1] +=1
                        if 0 <= r-1 < R and 0 <= c   < C and isinstance(lines[r-1][c]  , int): lines[r-1][c]   +=1
                        if 0 <= r-1 < R and 0 <= c+1 < C and isinstance(lines[r-1][c+1], int): lines[r-1][c+1] +=1
                        if 0 <= r   < R and 0 <= c-1 < C and isinstance(lines[r][c-1]  , int): lines[r][c-1]   +=1
                        if 0 <= r   < R and 0 <= c   < C and isinstance(lines[r][c]    , int): lines[r][c]     = 'D'
                        if 0 <= r   < R and 0 <= c+1 < C and isinstance(lines[r][c+1]  , int): lines[r][c+1]   +=1
                        if 0 <= r+1 < R and 0 <= c-1 < C and isinstance(lines[r+1][c-1], int): lines[r+1][c-1] +=1
                        if 0 <= r+1 < R and 0 <= c   < C and isinstance(lines[r+1][c]  , int): lines[r+1][c]   +=1
                        if 0 <= r+1 < R and 0 <= c+1 < C and isinstance(lines[r+1][c+1], int): lines[r+1][c+1] +=1

        # print_board(lines)

        R = len(lines)
        C = len(lines[0])
        for r in range(R):
            for c in range(C):
                if lines[r][c] == 'D': lines[r][c] = 0

        # print_board(lines)
        count = 0
        for line in lines:
            count += sum(line)
        if count == 0:
            break
    return step


example_input = open('example').read().splitlines()
for i in range(len(example_input)):
    example_input[i] = [int(x) for x in example_input[i]]

puzzle_input = open('input').read().splitlines()
for i in range(len(puzzle_input)):
    puzzle_input[i] = [int(x) for x in puzzle_input[i]]

print('A', solve1(copy.deepcopy(example_input)))
print('A', solve1(copy.deepcopy(puzzle_input)))
print('B', solve2(copy.deepcopy(example_input)))
print('B', solve2(copy.deepcopy(puzzle_input)))
