# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# from collections import defaultdict, deque, namedtuple

def print_board(boards):
    for board in boards:
        for row in board:
            print(row)
        print()


def search_for_winner(boards):
    for idx, board in enumerate(boards):
        for row in board:
            if row.count('x') == 5:
                return idx
        for column in zip(board[0], board[1], board[2], board[3], board[4]):
            if column.count('x') == 5:
                return idx
    return -1

def search_for_all_winners(boards):
    winners = []
    for idx, board in enumerate(boards):
        for row in board:
            if row.count('x') == 5:
                winners.append(idx)
        for column in zip(board[0], board[1], board[2], board[3], board[4]):
            if column.count('x') == 5:
                winners.append(idx)
    return winners


def board_value(board):
    asdf = [list(filter(lambda item: item != 'x', row)) for row in board]
    return sum([sum(row) for row in asdf])


def solve1(input):
    numbers = [int(x) for x in input[0:1][0].split(',')]
    boards_input = input[2:]
    boards = []

    tmp_board = []
    for row in boards_input:
        if row == '':
            boards.append(tmp_board)
            tmp_board = []
        else:
            tmp_board.append([int(x) for x in row.split()])
    boards.append(tmp_board)
    tmp_board = []

    for num in numbers:
        for board in boards:
            for row in range(len(board)):
                board[row] = ['x' if x == num else x for x in board[row]]
        winner_idx = search_for_winner(boards)
        if winner_idx > -1:
            return board_value(boards[winner_idx])*num


def solve2(input):
    numbers = [int(x) for x in input[0:1][0].split(',')]
    boards_input = input[2:]
    boards = []

    tmp_board = []
    for row in boards_input:
        if row == '':
            boards.append(tmp_board)
            tmp_board = []
        else:
            tmp_board.append([int(x) for x in row.split()])
    boards.append(tmp_board)
    tmp_board = []

    for num in numbers:
        for board in boards:
            for row in range(len(board)):
                board[row] = ['x' if x == num else x for x in board[row]]

        while True:
            winner_idx = search_for_winner(boards)
            if winner_idx > -1:
                popped_board = boards.pop(winner_idx)
                if len(boards) == 0:
                    return board_value(popped_board)*num
            else:
                break

    # for num in numbers:
    #     for board in boards:
    #         for row in range(len(board)):
    #             board[row] = ['x' if x == num else x for x in board[row]]
    #     winners_idx = search_for_all_winners(boards)
    #     if len(winners_idx) > 0:
    #         if len(boards) == 1:
    #             return board_value(boards[0])*num
    #         for idx, winner_idx in enumerate(winners_idx):
    #             boards.pop(winner_idx - idx)


example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

# print('A', solve1(example_input))
# print('A', solve1(puzzle_input))
print('B', solve2(example_input))
print('B', solve2(puzzle_input))
