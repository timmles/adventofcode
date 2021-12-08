# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# from collections import defaultdict, deque, namedtuple


def solve1(lines):
    count = 0
    for line in lines:
        signals, outputs = line.split('|')
        outputs = outputs.split(' ')
        outputs = [len(x) for x in outputs]
        outputs = list(filter(lambda x: x == 2 or x == 4 or x == 3 or x == 7, outputs))
        count += len(outputs)
    return count


def remove_string(str, rem):
    for x in rem:
        str = str.replace(x, '')
    return str


def key_by_value(dict, value):
    for key in dict:
        if dict[key] == value:
            return key


def solve2(lines):
    count = 0
    for line in lines:
        signals, outputs = line.split('|')
        signals = signals.strip().split(' ')
        outputs = outputs.strip().split(' ')

        def string_sort(x):
            l = list(x)
            l.sort()
            return ''.join(l)
        signals = list(map(string_sort, signals))
        signals = {x: -1 for x in signals}
        outputs = list(map(string_sort, outputs))

        for x in signals:
            len1 = len(x)
            if len1 == 2:
                signals[x] = 1
            elif len1 == 4:
                signals[x] = 4
            elif len1 == 3:
                signals[x] = 7
            elif len1 == 7:
                signals[x] = 8

        for key in signals:
            if signals[key] == -1 and len(key) == 5 and len(remove_string(key,key_by_value(signals, 7))) == 2:
                signals[key] = 3

        for key in signals:
            if signals[key] == -1 and len(key) == 6 and len(remove_string(key,key_by_value(signals, 3))) == 1:
                signals[key] = 9

        for key in signals:
            if signals[key] == -1 and len(key) == 5 and len(remove_string(remove_string(key,key_by_value(signals, 3)), key_by_value(signals, 9))) == 0:
                signals[key] = 5

        for key in signals:
            if signals[key] == -1 and len(key) == 5:
                signals[key] = 2

        for key in signals:
            if signals[key] == -1 and len(key) == 6 and len(remove_string(key,key_by_value(signals, 5))) == 1:
                signals[key] = 6

        for key in signals:
            if signals[key] == -1 and len(key) == 6:
                signals[key] = 0

        str = ''
        for x in outputs:
            str += f'{signals[x]}'

        count += int(str)
    return count

example_small = open('example_small').read().splitlines()
example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

print('A', solve1(example_input))
print('A', solve1(puzzle_input))
print('B', solve2(example_small))
print('B', solve2(example_input))
print('B', solve2(puzzle_input))
