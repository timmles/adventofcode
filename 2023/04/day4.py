# import bisect
# import fileinput
# import hashlib
# import heapq
import itertools
# import json
# import re
# import heapq
# from collections import defaultdict, deque, namedtuple, Counter


def solve1(lines):
    total = 0
    for line in lines:
        values = line.split(": ")[1]
        winning, mine = values.split(" | ")

        winning_nums = [int(x) for x in winning.split(" ") if x != '' ]
        mine_nums = [int(x) for x in mine.split(" ") if x != '' ]

        wins = [x for x in mine_nums if x in winning_nums]

        sumval = 0
        if len(wins) > 0:
            sumval = 1
            for _ in range(len(wins)-1):
                sumval *= 2
        total += sumval


        print(sumval)
        # print(winning_nums)
        # print(mine_nums)
        # print(wins)
    return total


def solve2(lines):
    total = 0
    cards = [0] * len(lines)

    for i, line in zip(itertools.count(), lines):
        values = line.split(": ")[1]
        winning, mine = values.split(" | ")

        winning_nums = [int(x) for x in winning.split(" ") if x != '' ]
        mine_nums = [int(x) for x in mine.split(" ") if x != '' ]

        cards[i] = len([x for x in mine_nums if x in winning_nums])

    sumvals = [0] * len(lines)
    for x, card in zip(itertools.count(), cards):
        sumvals[x] += 1
        for j in range(cards[x]):
            sumvals[x+j+1] += sumvals[x]

    return sum(sumvals)


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

# print('A', solve1(example_input))
# print('A', solve1(puzzle_input))
print('B', solve2(example_input))
print('B', solve2(puzzle_input))
