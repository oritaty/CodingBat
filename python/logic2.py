#CodingBat Logic-2
#URL: http://codingbat.com/python/Logic-2

#make_bricks(3, 1, 8) → True
#make_bricks(3, 1, 9) → False
#make_bricks(3, 2, 10) → True

def make_bricks(small, big, goal):
  for i in range(big, 0, - 1):
    if goal == 5 * i:
      return True
    elif goal > 5 * i:
      goal -= (5 * i)
      break
  if goal <= small:
    return True
  else:
    return False

#no_teen_sum(1, 2, 3) → 6
#no_teen_sum(2, 13, 1) → 3
#no_teen_sum(2, 1, 14) → 3

def no_teen_sum(a, b, c):
  total = 0
  if not is_teen(a):
    total += a
  if not is_teen(b):
    total += b
  if not is_teen(c):
    total += c
  return total

def is_teen(num):
  return num >= 13 and num <= 19 and num != 15 and num != 16

#make_chocolate(4, 1, 9) → 4
#make_chocolate(4, 1, 10) → -1
#make_chocolate(4, 1, 7) → 2

def make_chocolate(small, big, goal):
  for i in range(big, 0, - 1):
    if goal == 5 * i:
      return 0
    elif goal > 5 * i:
      goal -= (5 * i)
      break
  if goal <= small:
    return goal
  else:
    return -1

#lone_sum(1, 2, 3) → 6
#lone_sum(3, 2, 3) → 2
#lone_sum(3, 3, 3) → 0

def lone_sum(a, b, c):
  total = 0
  if a != b and a != c:
    total += a
  if b != a and b != c:
    total += b
  if c != a and c != b:
    total += c
  return total

#round_sum(16, 17, 18) → 60
#round_sum(12, 13, 14) → 30
#round_sum(6, 4, 4) → 10

def round_sum(a, b, c):
  return round_ten(a) + round_ten(b) + round_ten(c)

def round_ten(num):
  right_most = num % 10
  if right_most < 5:
    return num - right_most
  else:
    return num + (10 - right_most)

#lucky_sum(1, 2, 3) → 6
#lucky_sum(1, 2, 13) → 3
#lucky_sum(1, 13, 3) → 1

def lucky_sum(a, b, c):
  total = 0
  if a == 13:
    return 0
  else:
    total += a
  if b == 13:
    return total
  else:
    total += b
  if c == 13:
    return total
  else:
    total += c
  return total

#close_far(1, 2, 10) → True
#close_far(1, 2, 3) → False
#close_far(4, 1, 3) → True

def close_far(a, b, c):
  ab = abs(a - b)
  bc = abs(b - c)
  ca = abs(c - a)
  if ((ab <= 1 and bc > 1 and ca > 1) or (ab > 1 and bc <= 1 and ca > 1)
  or (ab > 1 and bc > 1 and ca <= 1)):
    return True
  else:
    return False
