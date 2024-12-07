def solve1(lines)
  sum = 0
  re_mul=/(mul\(\d{1,3},\d{1,3}\))/
  re_dig=/mul\((\d{1,3}),(\d{1,3})\)/
  lines.each do |line|
    line.scan(re_mul).each do |re_match|
      if re_match != nil
        scan = re_match[0].scan(re_dig)
        first, second = scan[0]

        if first != nil and second != nil
          sum += Integer(first) * Integer(second)
        end
      end
    end
  end
  return sum
end

def solve2(lines)
  domul = true
  sum = 0
  re_mul=/((mul\(\d{1,3},\d{1,3}\)|do\(\)|don't\(\)))/ #'
  re_dig=/mul\((\d{1,3}),(\d{1,3})\)/
  lines.each do |line|
    line.scan(re_mul).each do |re_match|
      if re_match != nil
        if re_match[0] == 'do()'
          domul = true
        elsif re_match[0] == "don't()"
          domul = false
        else
          if domul
            scan = re_match[0].scan(re_dig)
            first, second = scan[0]
    
            if first != nil and second != nil
              sum += Integer(first) * Integer(second)
            end
          end
        end
      end
    end
  end
  return sum

end


example1_input = File.readlines('example1')
example2_input = File.readlines('example2')
puzzle_input = File.readlines('input')

puts "A #{solve1 example1_input}"
puts "A #{solve1 puzzle_input}"
puts "B #{solve2 example2_input}"
puts "B #{solve2 puzzle_input}"
