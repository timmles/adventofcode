# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# import heapq
# from collections import defaultdict, deque, namedtuple, Counter


def solve1(lines):
    numbers = []
    for line in lines:
        exec('numbers.append('+line+')')

    actions = []
    def reduce(number):
        numbers[0]
        numbers[1]

    reduce(numbers)
    print(numbers)


def solve2(lines):
    pass


arr = [[[[[9,8],1],2],3],4]





class Node:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.val = key

# A function to do inorder tree traversal
def printInorder(root):

    if root:

        # First recur on left child
        printInorder(root.left)

        # then print the data of node
        print(root.val),

        # now recur on right child
        printInorder(root.right)

# Driver code
root1 = Node(1)
root1.left = Node(2)
root1.right = Node(3)
root1.left.left = Node(4)
root1.left.right = Node(5)
printInorder(root1)


root2 = Node(-1)
def fill(root2, data):
    if type(data[0]) is list:
        root2.left = Node(data[0])
    if type(data[1]) is list:
        root2.left = Node(data[0])
    root2 = ''


fill(root2, arr)
# def test(num):
#     if type(num.one) is list:
#         test(num.one)
#     if type(num.two) is list:
#         test(num.two)
#     if num.two.point == 8:
#         print(left())









# print(node)
# test(node)
# print(node)


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

# print('A', solve1('[[[[[9,8],1],2],3],4]'))
# print('A', solve1(example_input))
# print('A', solve1(puzzle_input))
# print('B', solve2(example_input))
# print('B', solve2(puzzle_input))
