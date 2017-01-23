#CodingBat List-2
#URL: http://codingbat.com/python/List-2

#count_evens([2, 1, 2, 3, 4]) → 3
#count_evens([2, 2, 0]) → 3
#count_evens([1, 3, 5]) → 0

def count_evens(nums):
  cnt = 0
  for i in range(0, len(nums)):
    if nums[i] % 2 == 0:
      cnt += 1
  return cnt

#sum13([1, 2, 2, 1]) → 6
#sum13([1, 1]) → 2
#sum13([1, 2, 2, 1, 13]) → 6

def sum13(nums):
  if len(nums) == 0:
    return 0
  cnt = 0
  total = 0
  while cnt < len(nums):
    if nums[cnt] == 13:
      cnt += 2
    else:
      total += nums[cnt]
      cnt += 1
  return total

#big_diff([10, 3, 5, 6]) → 7
#big_diff([7, 2, 10, 9]) → 8
#big_diff([2, 10, 7, 2]) → 8

def big_diff(nums):
  mx = nums[0]
  mn = nums[0]
  for i in range(1, len(nums)):
    mx = max(mx, nums[i])
    mn = min(mn, nums[i])
  return mx - mn

#sum67([1, 2, 2]) → 5
#sum67([1, 2, 2, 6, 99, 99, 7]) → 5
#sum67([1, 1, 6, 7, 2]) → 4

def sum67(nums):
  cnt = 0
  total = 0
  while cnt < len(nums):
    if nums[cnt] == 6:
      cnt = next7(nums, cnt) + 1
    else:
      total += nums[cnt]
      cnt += 1
  return total

def next7(nums, current_index):
  while nums[current_index] != 7:
    current_index += 1
  return current_index

#centered_average([1, 2, 3, 4, 100]) → 3
#centered_average([1, 1, 5, 5, 10, 8, 7]) → 5
#centered_average([-10, -4, -2, -4, -2, 0]) → -3

def centered_average(nums):
  mn = nums[0]
  mx = nums[0]
  total = nums[0]
  for i in range(1, len(nums)):
    mn = min(mn, nums[i])
    mx = max(mx, nums[i])
    total += nums[i]
  return (total - mx - mn) / (len(nums) - 2)

#has22([1, 2, 2]) → True
#has22([1, 2, 1, 2]) → False
#has22([2, 1, 2]) → False

def has22(nums):
  for i in range(0, len(nums) - 1):
    if nums[i] == 2 and nums[i + 1] == 2:
      return True
  return False
