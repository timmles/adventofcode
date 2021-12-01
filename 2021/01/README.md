
```python
# Part 1:

sum(x < y for x, y in zip(nums, nums[1:]))

# Part 2:

sum(x < y for x, y in zip(nums, nums[3:]))
```
https://www.reddit.com/r/adventofcode/comments/r66vow/2021_day_1_solutions/hmrggq3/?sort=top

> Here's a handy trick: you don't need to do 1 for ... if ..., because booleans cast to ints when summed. So you can instead say sum(x<y for x, y in zip(nums, nums[1:]) )
