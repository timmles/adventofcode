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
    meta = {}
    meta_id = 0
    arr = {}
    symbols = []

    for row, line in zip(itertools.count(), lines):
        num = ""

        for col, item in zip(itertools.count(), line):
            if item.isdigit():
                num += item
                arr[str(row)+"_"+str(col)] = meta_id
            else:
                if num != '':
                    meta[meta_id] = num
                    meta_id += 1

                num = ""

            if item in "!@#$%^&*()_-+={}[]/":
                symbols.append((row, col))
        if num != '':
            meta[meta_id] = num
            meta_id += 1


    ids_to_sum = []
    for srow, scol in symbols:
        for x,y in [
            (1,0),
            (1,1),
            (0,1),
            (-1,1),
            (-1,0),
            (-1,-1),
            (0,-1),
            (1,-1)
        ]:
            if str(srow+x)+"_"+str(scol+y) in arr:
                ids_to_sum.append(arr[str(srow+x)+"_"+str(scol+y)])

    sum = 0
    for sumid in set(ids_to_sum):
        sum += int(meta[sumid])

    print(ids_to_sum)
    # print(arr)
    return sum

def solve2(lines):
    meta = {}
    meta_id = 0
    arr = {}
    gears = []
    symbols = []

    for row, line in zip(itertools.count(), lines):
        num = ""

        for col, item in zip(itertools.count(), line):
            if item.isdigit():
                num += item
                arr[str(row)+"_"+str(col)] = meta_id
            else:
                if num != '':
                    meta[meta_id] = num
                    meta_id += 1

                num = ""

            if item in "*":
                gears.append((row, col))

            if item in "!@#$%^&*()_-+={}[]/":
                symbols.append((row, col))
        if num != '':
            meta[meta_id] = num
            meta_id += 1


    ids_to_sum = []
    for srow, scol in symbols:
        for x,y in [
            (1,0),
            (1,1),
            (0,1),
            (-1,1),
            (-1,0),
            (-1,-1),
            (0,-1),
            (1,-1)
        ]:
            if str(srow+x)+"_"+str(scol+y) in arr:
                ids_to_sum.append(arr[str(srow+x)+"_"+str(scol+y)])

    gears_to_sum = 0
    for grow, gcol in gears:
        gearsval = []
        for x,y in [
            (1,0),
            (1,1),
            (0,1),
            (-1,1),
            (-1,0),
            (-1,-1),
            (0,-1),
            (1,-1)
        ]:
            if str(grow+x)+"_"+str(gcol+y) in arr:
                gearsval.append(arr[str(grow+x)+"_"+str(gcol+y)])

        if len(set(gearsval)) == 2:
            geartomult = []
            for gearnum in set(gearsval):
                geartomult.append(int(meta[gearnum]))

            gears_to_sum += geartomult[0] * geartomult[1]

    sum = 0
    for sumid in set(ids_to_sum):
        sum += int(meta[sumid])

    print(ids_to_sum)
    # print(arr)
    return gears_to_sum



example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

# print('A', solve1(example_input))
# print('A', solve1(puzzle_input))
print('B', solve2(example_input))
print('B', solve2(puzzle_input))
