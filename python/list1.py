#CodingBat List-1
#URL: http://codingbat.com/python/List-1

#first_last6([1, 2, 6]) → True
#first_last6([6, 1, 2, 3]) → True
#first_last6([13, 6, 1, 2, 3]) → False

def first_last6(nums):
  if nums[0] == 6 or nums[len(nums) - 1] == 6:
    return True
  else:
    return False

#common_end([1, 2, 3], [7, 3]) → True
#common_end([1, 2, 3], [7, 3, 2]) → False
#common_end([1, 2, 3], [1, 3]) → True

def common_end(a, b):
  if a[0] == b[0] or a[len(a) - 1] == b[len(b) - 1]:
    return True
  else:
    return False

#reverse3([1, 2, 3]) → [3, 2, 1]
#reverse3([5, 11, 9]) → [9, 11, 5]
#reverse3([7, 0, 0]) → [0, 0, 7]

def reverse3(nums):
  rtn = []
  rtn.append(nums[2])
  rtn.append(nums[1])
  rtn.append(nums[0])
  return rtn

#middle_way([1, 2, 3], [4, 5, 6]) → [2, 5]
#middle_way([7, 7, 7], [3, 8, 0]) → [7, 8]
#middle_way([5, 2, 9], [1, 4, 5]) → [2, 4]

def middle_way(a, b):
  rtn = []
  rtn.append(a[1])
  rtn.append(b[1])
  return rtn

#same_first_last([1, 2, 3]) → False
#same_first_last([1, 2, 3, 1]) → True
#same_first_last([1, 2, 1]) → True

def same_first_last(nums):
  if len(nums) < 1:
    return False
  if nums[0] == nums[len(nums) - 1]:
    return True
  else:
    return False

#sum3([1, 2, 3]) → 6
#sum3([5, 11, 2]) → 18
#sum3([7, 0, 0]) → 7

def sum3(nums):
  return nums[0] + nums[1] + nums[2]

#max_end3([1, 2, 3]) → [3, 3, 3]
#max_end3([11, 5, 9]) → [11, 11, 11]
#max_end3([2, 11, 3]) → [3, 3, 3]

def max_end3(nums):
  if nums[0] > nums[2]:
    nums[1] = nums[0]
    nums[2] = nums[0]
  else:
    nums[0] = nums[2]
    nums[1] = nums[2]
  return nums

#make_ends([1, 2, 3]) → [1, 3]
#make_ends([1, 2, 3, 4]) → [1, 4]
#make_ends([7, 4, 6, 2]) → [7, 2]

def make_ends(nums):
  rtn = []
  rtn.append(nums[0])
  rtn.append(nums[len(nums) - 1])
  return rtn

#make_pi() → [3, 1, 4]

def make_pi():
  return [3, 1, 4]

#rotate_left3([1, 2, 3]) → [2, 3, 1]
#rotate_left3([5, 11, 9]) → [11, 9, 5]
#rotate_left3([7, 0, 0]) → [0, 0, 7]

def rotate_left3(nums):
  rtn = []
  rtn.append(nums[1])
  rtn.append(nums[2])
  rtn.append(nums[0])
  return rtn

#sum2([1, 2, 3]) → 3
#sum2([1, 1]) → 2
#sum2([1, 1, 1, 1]) → 2

def sum2(nums):
  if len(nums) == 0:
    return 0
  if len(nums) == 1:
    return nums[0]
  return nums[0] + nums[1]

#has23([2, 5]) → True
#has23([4, 3]) → True
#has23([4, 5]) → False

def has23(nums):
  if nums[0] == 2 or nums[0] == 3 or nums[1] == 2 or nums[1] == 3:
    return True
  else:
    return False
