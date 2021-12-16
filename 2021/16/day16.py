# import bisect
# import fileinput
# import hashlib
# import heapq
# import itertools
# import json
# import re
# import heapq
# from collections import defaultdict, deque, namedtuple, Counter


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
        packets.append({
            'version': version,
            'type': type,
            'message': value
        })
        packet_remainder = literal_remainder
    # operator
    else:
        packets.append({
            'version': version,
            'type': type
        })
        length_type_id = message[0:1]
        if length_type_id == '0':
            len_sub_packets = int(message[1:16], 2)
            sub_packets = message[16:16+len_sub_packets]
            packet_remainder = message[16+len_sub_packets:]
            while sub_packets != '':
                sub_packet, sub_packet_remainder = process(sub_packets)
                sub_packets = sub_packet_remainder
                packets += sub_packet
        elif length_type_id == '1':
            num_sub_packets = int(message[1:12], 2)
            sub_packets = message[12:]
            for i in range(num_sub_packets):
                sub_packet, sub_packet_remainder = process(sub_packets)
                sub_packets = sub_packet_remainder
                packets += sub_packet
            packet_remainder = sub_packet_remainder
        else:
            print('corrupt')
    return packets, packet_remainder

def solve1(line):
    transmission = ''
    for l in line:
        transmission += bin(int(l, 16))[2:].zfill(4)
    print(transmission)

    packets, remainer = process(transmission)
    print(packets)
    return sum([x['version'] for x in packets])
    # print(line)
    # print(bin(line))  # decimal
    # print(hex(0b100))  # binary
    # print(bin(0o77))  # octal
    # print(bin(0XF))  # hexadecimal


# for line in lines:
    #     print(line)


def solve2(lines):
    pass

example_input = open('example').read().splitlines()
puzzle_input = open('input').read().splitlines()

# print('A', solve1('D2FE28'))
# print('A', solve1('38006F45291200'))
# print('A', solve1('EE00D40C823060'))
# print('A', solve1('8A004A801A8002F478'))
# print('A', solve1('620080001611562C8802118E34'))
# print('A', solve1('C0015000016115A2E0802F182340'))
# print('A', solve1('A0016C880162017C3686B18A3D4780'))
print('A', solve1(puzzle_input))
# print('B', solve2(example_input))
# print('B', solve2(puzzle_input))
