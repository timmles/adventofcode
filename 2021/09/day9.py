# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# from collections import defaultdict, deque, namedtuple


def solve1(lines):
    puzzle_width = len(lines[0])
    for i in range(len(lines)):
        lines[i] = [int(x) for x in lines[i]]

    lines.insert(0, [9 for i in range(puzzle_width)])
    lines.append([9 for i in range(puzzle_width)])
    for i in range(len(lines)):
        lines[i].insert(0, 9)
        lines[i].append(9)

    for line in lines:
        print(line)

    low_score = 0
    # print(lines[1][1:puzzle_width+1])
    for i in range(1, len(lines)-1):
        for me, up, down, left, right in zip(lines[i][1:puzzle_width+1], lines[i-1][1:puzzle_width+1], lines[i+1][1:puzzle_width+1], lines[i][0:puzzle_width], lines[i][2:puzzle_width+2]):
            if (up > me < down and left > me < right):
                low_score += me+1

    return low_score

def solve2(lines):
    puzzle_width = len(lines[0])
    for i in range(len(lines)):
        lines[i] = [int(x) for x in lines[i]]

    lines.insert(0, [9 for i in range(puzzle_width)])
    lines.append([9 for i in range(puzzle_width)])
    for i in range(len(lines)):
        lines[i].insert(0, 9)
        lines[i].append(9)

    for line in lines:
        print(line)

    low_point = []
    # print(lines[1][1:puzzle_width+1])
    for i in range(1, len(lines)-1):
        for me, up, down, left, right, index in zip(lines[i][1:puzzle_width+1], lines[i-1][1:puzzle_width+1], lines[i+1][1:puzzle_width+1], lines[i][0:puzzle_width], lines[i][2:puzzle_width+2], range(1,puzzle_width+1)):
            if (up > me < down and left > me < right):
                low_point.append([i, index])

    basin = []

    def raycast(i, j, search):
        if lines[i][j] != 9:
            search.append((i, j))

            if (i+1, j) not in search:
                search = raycast(i+1, j, search)
            if (i-1, j) not in search:
                search = raycast(i-1, j, search)
            if (i, j+1) not in search:
                search = raycast(i, j+1, search)
            if (i, j-1) not in search:
                search = raycast(i, j-1, search)

            return search
        else:
            return search

    points = []
    for point in low_point:
        points.append(len(raycast(point[0], point[1], [])))

    points.sort(reverse=True)

    count = 1
    for x in points[0:3]:
        count *= x
    return count


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

# print('A', solve1(example_input))
# print('A', solve1(puzzle_input))
print('B', solve2(example_input))
print('B', solve2(puzzle_input))
