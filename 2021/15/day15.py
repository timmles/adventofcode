# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# from collections import defaultdict, deque, namedtuple, Counter


def solve1(orig_lines, grid):
    for i in range(len(orig_lines)):
        orig_lines[i] = [int(x) for x in orig_lines[i]]

    start = (0, 0)
    actual_R = len(orig_lines)
    actual_C = len(orig_lines[0])
    R = actual_R*grid
    C = actual_C*grid
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

    def get_lines(neighbor):
        grid_r = neighbor[0] // actual_R
        grid_c = neighbor[1] // actual_C
        actual_r = neighbor[0] % actual_R
        actual_c = neighbor[1] % actual_C
        actual_value = orig_lines[actual_r][actual_c] + grid_r + grid_c
        if actual_value > 9:
            actual_value = actual_value % 9
        return actual_value

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

                tentative_g_score = g_score[current] + get_lines(neighbor)

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

print('A', solve1(example_input,1))
# print('A', solve1(puzzle_input,1))
print('B', solve1(example_input, 5))
print('B', solve1(puzzle_input, 5))
