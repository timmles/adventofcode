def calc_safe(report)
  diff = Array.new
  for i in 0..report.length-2 do
    diff << report[i] - report[i+1] 
  end

  pos = diff.select {|item| item > 0 }
  neg = diff.select {|item| item < 0 }
  zero = diff.select {|item| item == 0 }
  three = diff.select {|item| item.abs > 3 }

  return (pos.length == 0 || neg.length == 0) && zero.length == 0 && three.length == 0
end

def solve1(lines)
  safe = 0
  lines.each do |line|
    report = line.split
    report = report.map {|item| Integer(item)}
    
    if calc_safe(report)
      safe += 1
    end
  end
  return safe
end

def solve2(lines)
  safe = 0
  lines.each do |line|
    report = line.split
    report = report.map {|item| Integer(item)}

    reports = Array.new
    reports << report

    for i in 0..report.length do
      reports << report.select.with_index { |elem, index| index != i }
    end
    
    reports.each do |rpt|
      if calc_safe(rpt)
        safe += 1
        break
      end
    end

  end
  return safe
end


example_input = File.readlines('example')
puzzle_input = File.readlines('input')

puts "A #{solve1 example_input}"
puts "A #{solve1 puzzle_input}"
puts "B #{solve2 example_input}"
puts "B #{solve2 puzzle_input}"
