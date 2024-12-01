def solve1(lines)
    first = Array.new
    second = Array.new
    
    lines.each do |line|
        arr = line.split
        first << arr[0]
        second << arr[1]
    end

    first = first.sort
    second = second.sort
    
    diff = 0
    for idx in 0..first.length-1 do
        diff += (Integer(first[idx]) - Integer(second[idx])).abs
    end
    
    return diff
end

def solve2(lines)
    first = Array.new
    second = Array.new
    
    lines.each do |line|
        arr = line.split
        first << arr[0]
        second << arr[1]
    end
    
    similarity = 0
    second_tally = second.tally

    first.each do |first_num|
        num_tally = second_tally[first_num]
        if num_tally == nil
          num_tally = 0
        end
    
        similarity += num_tally * Integer(first_num)
    end
    
    # for idx in 0..first.length-1 do
        # diff += (Integer(first[idx]) - Integer(second[idx])).abs
    # end
 
    return similarity
end


example_input = File.readlines('example')
puzzle_input = File.readlines('input')

puts "A #{solve1 example_input}"
puts "A #{solve1 puzzle_input}"
puts "B #{solve2 example_input}"
puts "B #{solve2 puzzle_input}"