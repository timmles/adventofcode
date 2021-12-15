# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# from collections import defaultdict, deque, namedtuple, Counter
import heapq


def solve(orig_lines, grid):
    for i in range(len(orig_lines)):
        orig_lines[i] = [int(x) for x in orig_lines[i]]

    actual_R = len(orig_lines)
    actual_C = len(orig_lines[0])
    R = actual_R*grid
    C = actual_C*grid
    end = (R - 1, C - 1)
    openset = [(0, 0, 0)]
    visited = [[1e9 for _ in range(C)] for _ in range(R)]

    def get_risk(neighbor):
        grid_r = neighbor[0] // actual_R
        grid_c = neighbor[1] // actual_C
        actual_r = neighbor[0] % actual_R
        actual_c = neighbor[1] % actual_C
        actual_value = orig_lines[actual_r][actual_c] + grid_r + grid_c
        if actual_value > 9:
            actual_value = actual_value % 9
        return actual_value

    while len(openset) > 0:
        current = heapq.heappop(openset)
        dist, r, c = current
        if r == end[0] and c == end[1]:
            return dist

        if dist < visited[r][c]:
            visited[r][c] = dist
        else:
            continue

        for neighbor in [(r - 1, c), (r, c + 1), (r + 1, c), (r, c - 1)]:
            nr, nc = neighbor
            if 0 <= nr < R and 0 <= nc < C:
                tentative_g_score = dist + get_risk(neighbor)
                heapq.heappush(openset, (tentative_g_score, *neighbor))
    print('fail')


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

print('A', solve(example_input, 1))
print('A', solve(puzzle_input, 1))
print('B', solve(example_input, 5))
print('B', solve(puzzle_input, 5))
