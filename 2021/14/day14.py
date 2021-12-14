# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
from collections import defaultdict, deque, namedtuple, Counter

# I couldn't solve today.
# I was thinking of storing already processed values.
# So F('NNCB', 40) == F('NN', 39) + F('NC', 39) + F('CB', 39), then decompose F('NN', 39) in the same way and store the
# answer to F() of each value, hoping that the same F() come up in another tree. But the caching is limited because
# F() is tied to depth as well. So F('NN', 39) is not useful for F('NN', 38). Plus it still required building up the
# full string value which is what breaks the problem.
#
# I did think of storing just storing the counts, but as an optimisation to the F() solution. I did not think of it
# independently of that solution, which is what was needed for the real solution.
#
# So after about 4 hours, I decided to move on and find solutions, so that I could learn.
# - I learnt how to use Counter()
# - the logic on line 46:49 that you can just count each character and then add 1 for the last char of the input string
#   was pretty novel
#
# This is basically Jonathan Paulsons's solution, in my own code https://www.youtube.com/watch?v=7zvA-o47Uo0


def solve(lines, iterations):
    template = lines[0]
    poly = dict()
    for i in lines[2:]:
        pair, insertion = i.split(' -> ')
        poly[pair] = insertion

    pairs = Counter()
    for pair in zip(template[:], template[1:]):
        pairs[''.join(pair)] = 1

    for i in range(iterations):
        new_pairs = Counter()
        for k in pairs:
            new_pairs[k[0]+poly[k]] += pairs[k]
            new_pairs[poly[k]+k[1]] += pairs[k]
        pairs = new_pairs

    distribution = Counter()
    for k in pairs:
        distribution[k[0]] += pairs[k]
    distribution[template[-1]] += 1

    return max(distribution.values()) - min(distribution.values())


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

print('A', solve(example_input, 10))
print('A', solve(puzzle_input, 10))
print('B', solve(example_input, 40))
print('B', solve(puzzle_input, 40))
