# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# import heapq
# from collections import defaultdict, deque, namedtuple, Counter

# target area: x=230..283, y=-107..-57
def move(x,y,dx,dy, max):
    if dx > 0:
        dxd = -1
    elif dx < 0:
        dxd = +1
    else:
        dxd = 0
    if y+dy > y:
        max = y+dy

    return x+dx,y+dy,dx+dxd,dy-1,max


def solve1(lines):
    shots = [(0,0,x,y,0) for x in range(1000) for y in range(-200,1000)]
    hits = []

    target_x = range(230, 284)
    target_y = range(-107, -56)
    while len(shots) > 0:
        next_shots = []
        for s in shots:
            s = move(*s)

            if s[0] > 283 or s[1] < -107:
                pass
                # print('miss')
                # break
            elif s[0] in target_x and s[1] in target_y:
                # print('hit')
                # break
                hits.append(s[4])
            else:
                next_shots.append(s)
        shots = next_shots
    return len(hits)

def solveex(lines):
    shots = [(0,0,x,y,0) for x in range(1000) for y in range(-100,1000)]
    hits = []

    target_x = range(230, 283)
    target_y = range(-107, -57)
    while len(shots) > 0:
        next_shots = []
        for s in shots:
            s = move(*s)

            if s[0] > 283 or s[1] < -107:
                pass
                # print('miss')
                # break
            elif s[0] in target_x and s[1] in target_y:
                # print('hit')
                # break
                hits.append(s[4])
            else:
                next_shots.append(s)
        shots = next_shots
    return len(hits)


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

print('A', solve1(example_input))
# print('A', solve1(puzzle_input))
# print('B', solve2(example_input))
# print('B', solve2(puzzle_input))
