# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# from collections import defaultdict, deque, namedtuple

def pivot(lines):
    new_lines = []
    for i in range(len(lines[0])):
        str = ''
        for line in lines:
            str += line[i]
        new_lines.append(str)
    return new_lines


def solve1(lines):
    gamma_rate = ''
    epsilon_rate = ''

    for i in range(len(lines[0])):
        str = ''
        for line in lines:
            str += line[i]

        if str.count('0') > str.count('1'):
            gamma_rate += '0'
            epsilon_rate += '1'
        else:
            gamma_rate += '1'
            epsilon_rate += '0'
        # print(gamma_rate, '   ', epsilon_rate)
        # print(line[max(line.count('0'), line.count('1'))])
    return int(gamma_rate, 2) * int(epsilon_rate, 2)


def solve2(lines):
    oxygen_rating = lines[:]
    ox_ind = 0
    while len(oxygen_rating) > 1:
        count_one = pivot(oxygen_rating)[ox_ind].count('1')
        filter_value = '1' if count_one >= len(oxygen_rating)/2 else '0'
        oxygen_rating = list(filter(lambda x: x[ox_ind] == filter_value, oxygen_rating))
        ox_ind += 1

    co2_rating = lines[:]
    co_ind = 0
    while len(co2_rating) > 1:
        count_zero = pivot(co2_rating)[co_ind].count('0')
        filter_value = '0' if count_zero <= len(co2_rating)/2 else '1'
        co2_rating = list(filter(lambda x: x[co_ind] == filter_value, co2_rating))
        co_ind += 1

    return int(oxygen_rating[0], 2) * int(co2_rating[0], 2)


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

print('A', solve1(example_input))
print('A', solve1(puzzle_input))
print('B', solve2(example_input))
print('B', solve2(puzzle_input))
