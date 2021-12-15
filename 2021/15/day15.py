# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# from collections import defaultdict, deque, namedtuple, Counter


def solve1(lines):
    for i in range(len(lines)):
        lines[i] = [int(x) for x in lines[i]]

    start = (0, 0)
    R = len(lines)
    C = len(lines[0])
    end = (R - 1, C - 1)
    openset = [start]
    closedset = []
    came_from = dict()

    g_score = dict()
    f_score = dict()

    def manhattan(current):
        return (end[0] - current[0]) + (end[1] - current[1])

    g_score[start] = 0
    f_score[start] = manhattan(start)

    while len(openset) > 0:
        def get_f_score(x):
            return f_score[x]
        current = min(openset, key=get_f_score)

        if current == end:
            return g_score[current]

        openset.remove(current)
        closedset.append(current)

        for neighbor in [(current[0] - 1, current[1]), (current[0], current[1] + 1), (current[0] + 1, current[1]), (current[0], current[1] - 1)]:
            if 0 <= neighbor[0] < R and 0 <= neighbor[1] < C:
                if neighbor in closedset:
                    continue

                tentative_g_score = g_score[current] + lines[neighbor[0]][neighbor[1]]

                if neighbor not in openset or tentative_g_score < g_score[neighbor]:
                    came_from[neighbor] = current
                    g_score[neighbor] = tentative_g_score
                    f_score[neighbor] = tentative_g_score + manhattan(neighbor)
                    if neighbor not in openset:
                        openset.append(neighbor)


def solve2(lines):
    pass


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

print('A', solve1(example_input))
print('A', solve1(puzzle_input))
# print('B', solve2(example_input))
# print('B', solve2(puzzle_input))
