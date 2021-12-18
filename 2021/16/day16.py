# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# import heapq
# from collections import defaultdict, deque, namedtuple, Counter
import math

def literal(message):
    value = ''
    while True:
        cont = message[0:1]
        segment = message[1:5]
        message = message[5:]
        value += segment

        if cont == '0':
            break
    return int(value, 2), message

def process(transmission):
    packets = []
    version = int(transmission[0:3], 2)
    type = int(transmission[3:6], 2)
    message = transmission[6:]
    packet_remainder = ''
    # literal
    if type == 4:
        value, literal_remainder = literal(message)
        packets.append(value)
        packet_remainder = literal_remainder
    # operator
    else:
        length_type_id = message[0:1]
        if length_type_id == '0':
            len_sub_packets = int(message[1:16], 2)
            sub_packets = message[16:16+len_sub_packets]
            packet_remainder = message[16+len_sub_packets:]
            while sub_packets != '':
                sub_packet, sub_packet_remainder = process(sub_packets)
                sub_packets = sub_packet_remainder
                packets.append(sub_packet)
        elif length_type_id == '1':
            num_sub_packets = int(message[1:12], 2)
            sub_packets = message[12:]
            for i in range(num_sub_packets):
                sub_packet, sub_packet_remainder = process(sub_packets)
                sub_packets = sub_packet_remainder
                packets.append(sub_packet)
            packet_remainder = sub_packet_remainder
        else:
            print('corrupt')

    if type == 4:
        return packets[0], packet_remainder
    elif type == 0:
        return sum(packets), packet_remainder
    elif type == 1:
        return math.prod(packets), packet_remainder
    elif type == 2:
        return min(packets), packet_remainder
    elif type == 3:
        return max(packets), packet_remainder
    elif type == 5:
        return (1 if packets[0] > packets[1] else 0), packet_remainder
    elif type == 6:
        return (1 if packets[0] < packets[1] else 0), packet_remainder
    elif type == 7:
        return (1 if packets[0] == packets[1] else 0), packet_remainder

    assert False

def solve(line):
    transmission = ''
    for l in line:
        transmission += bin(int(l, 16))[2:].zfill(4)

    packets, remainer = process(transmission)
    return packets


def solve2(lines):
    pass

example_input = open('example').read().strip()
puzzle_input = open('input').read().strip()

# assert 6  == solve1('D2FE28')
# assert 9  == solve1('38006F45291200')
# assert 14 == solve1('EE00D40C823060')
# assert 16 == solve1('8A004A801A8002F478')
# assert 12 == solve1('620080001611562C8802118E34')
# assert 23 == solve1('C0015000016115A2E0802F182340')
print(solve('C200B40A82'))
print(solve('04005AC33890'))
print(solve('880086C3E88112'))
print(solve('CE00C43D881120'))
print(solve('D8005AC2A8F0'))
print('A', solve(puzzle_input))
# print('B', solve2(example_input))
# print('B', solve2(puzzle_input))
