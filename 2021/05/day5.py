# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
from collections import defaultdict


def print_board(board):
    for y in range(0,10):
        print(board[f'0,{y}'], board[f'1,{y}'], board[f'2,{y}'], board[f'3,{y}'], board[f'4,{y}'], board[f'5,{y}'], board[f'6,{y}'], board[f'7,{y}'], board[f'8,{y}'], board[f'9,{y}'])


def solve1(lines):
    board = defaultdict(lambda: 0)
    for line in lines:
        start, end = [x.strip() for x in line.split('->')]
        x1, y1 = [int(x) for x in start.split(',')]
        x2, y2 = [int(y) for y in end.split(',')]

        if y1 == y2:
            step = 1 if x1 < x2 else -1
            for x_range in range(int(x1), int(x2)+step, step):
                board[f'{x_range},{y1}'] += 1
        elif x1 == x2:
            step = 1 if y1 < y2 else -1
            for y_range in range(int(y1), int(y2)+step, step):
                board[f'{x1},{y_range}'] += 1
    return sum(1 for location in board.values() if location >= 2)


def solve2(lines):
    board = defaultdict(lambda: 0)
    for line in lines:
        start, end = [x.strip() for x in line.split('->')]
        x1, y1 = [int(x) for x in start.split(',')]
        x2, y2 = [int(y) for y in end.split(',')]

        if y1 == y2:
            step = 1 if x1 < x2 else -1
            for x_range in range(int(x1), int(x2)+step, step):
                board[f'{x_range},{y1}'] += 1
        elif x1 == x2:
            step = 1 if y1 < y2 else -1
            for y_range in range(int(y1), int(y2)+step, step):
                board[f'{x1},{y_range}'] += 1
        else:
            stepx = 1 if x1 < x2 else -1
            stepy = 1 if y1 < y2 else -1
            for x, y in zip(range(x1,x2+stepx, stepx), range(y1,y2+stepy, stepy)):
                board[f'{x},{y}'] += 1
    return sum(1 for location in board.values() if location >= 2)


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

print('A', solve1(example_input))
print('A', solve1(puzzle_input))
print('B', solve2(example_input))
print('B', solve2(puzzle_input))
