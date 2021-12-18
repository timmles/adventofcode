# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# import heapq
# from collections import defaultdict, deque, namedtuple, Counter


def bit_extracted(number, k, p):
    return ((1 << k) - 1) & (number >> p)


def bit_extracted_msb(number, k, p):
    return ((1 << k) - 1) & (number >> int.bit_length(number) - k - p)


def bit_split(number, k):
    return ((1 << int.bit_length(number) - k) - 1) & number


def literal(transmission, cursor):
    value = 0
    while True:
        cont = bit_extracted_msb(transmission, 1, cursor)
        segment = bit_extracted_msb(transmission, 4, cursor + 1)
        value = value << 4
        value += segment

        cursor += 5
        if cont == 0:
            break
    return value, cursor


def process(transmission, cursor):
    # if bit_split(transmission, cursor) == 0:
    #     return [], cursor+1

    # if cursor > int.bit_length(transmission) - 40:
    #     print('😭')
    packets = []
    version = bit_extracted_msb(transmission, 3, cursor)
    type = bit_extracted_msb(transmission, 3, cursor + 3)
    message_cursor = cursor + 6
    packet_end_cursor = 0


    # literal
    if type == 4:
        value, packet_end_cursor = literal(transmission, message_cursor)
        packets.append({
            'version': version,
            'type': type,
            'message': value
        })
    # operator
    else:
        packets.append({
            'version': version,
            'type': type
        })
        length_type_id = bit_extracted_msb(transmission, 1, message_cursor)
        if length_type_id == 0:
            len_sub_packets = bit_extracted_msb(transmission, 15, message_cursor+1)
            sub_packets_cursor = message_cursor+1+15
            packet_end_cursor = message_cursor+1+15+len_sub_packets
            while sub_packets_cursor < message_cursor+1+15+len_sub_packets:
                sub_packet, sub_packets_cursor = process(transmission, sub_packets_cursor)
                # sub_packets = sub_packet_remainder
                packets += sub_packet
        elif length_type_id == 1:
            num_sub_packets = bit_extracted_msb(transmission, 11, message_cursor+1)
            sub_packets_cursor = message_cursor+1+11
            for i in range(num_sub_packets):
                sub_packet, sub_packets_cursor = process(transmission, sub_packets_cursor)
                packets += sub_packet
            packet_end_cursor = sub_packets_cursor # cursor + messages
        else:
            print('corrupt')
    return packets, packet_end_cursor


def solve1(line):
    transmission = '1'
    for l in line:
        transmission += bin(int(l, 16))[2:].zfill(4)

    packets, remainer = process(int(transmission, 2), 1)
    return sum([x['version'] for x in packets])


def solve2(lines):
    pass

example_input = open('example').read().splitlines()
puzzle_input = open('input').read().strip()

# assert 6  == solve1('D2FE28')
# assert 9  == solve1('38006F45291200')
# assert 14 == solve1('EE00D40C823060')
# assert 16 == solve1('8A004A801A8002F478')
# assert 12 == solve1('620080001611562C8802118E34')
# assert 23 == solve1('C0015000016115A2E0802F182340')
# assert 31 == solve1('A0016C880162017C3686B18A3D4780')
assert 883 == solve1(puzzle_input)
# print('B', solve2(example_input))
# print('B', solve2(puzzle_input))
