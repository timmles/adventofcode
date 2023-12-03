# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# import heapq
# from collections import defaultdict, deque, namedtuple, Counter

class RGB:
    r = 0
    g = 0
    b = 0

    def __repr__(self):
        return f"{self.r}, {self.g}, {self.b}"

def build_set(set):
    x = RGB()

    items = set.split(", ")
    for item in items:
        num, color = item.split(" ")

        match color:
            case "red": x.r = int(num)
            case "green": x.g = int(num)
            case "blue": x.b = int(num)

    return x

def solve1(lines):
    max = RGB()
    max.r = 12
    max.g = 13
    max.b = 14

    possible_sum = 0
    for game in lines:
        game_id, sets = game.split(": ")
        game_id = game_id.lstrip("Game ")

        sets = sets.split("; ")
        result = map(build_set, sets)

        newlist = [rgb for rgb in result if rgb.r > max.r or rgb.g > max.g or rgb.b > max.b]

        if len(newlist) == 0:
            possible_sum += int(game_id)
    return possible_sum

def solve2(lines):


    sum = 0
    for game in lines:
        maxSet = RGB()
        game_id, sets = game.split(": ")
        game_id = game_id.lstrip("Game ")

        sets = sets.split("; ")
        result = map(build_set, sets)

        for set in result:
            maxSet.r = max(maxSet.r, set.r)
            maxSet.g = max(maxSet.g, set.g)
            maxSet.b = max(maxSet.b, set.b)

        sum += maxSet.r * maxSet.g * maxSet.b
    return sum


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

print('A', solve1(example_input))
print('A', solve1(puzzle_input))
print('B', solve2(example_input))
print('B', solve2(puzzle_input))
