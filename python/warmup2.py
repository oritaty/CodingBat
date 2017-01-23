#CodingBat Warmup-2
#URL: http://codingbat.com/python/Warmup-2

#string_times('Hi', 2) → 'HiHi'
#string_times('Hi', 3) → 'HiHiHi'
#string_times('Hi', 1) → 'Hi'

def string_times(str, n):
  rtn = ""
  for x in range(0, n):
    rtn += str
  return rtn

#string_splosion('Code') → 'CCoCodCode'
#string_splosion('abc') → 'aababc'
#string_splosion('ab') → 'aab'

def string_splosion(str):
  rtn = ""
  for i in range(0, len(str) + 1):
    rtn += str[:i]
  return rtn

#array_front9([1, 2, 9, 3, 4]) → True
#array_front9([1, 2, 3, 4, 9]) → False
#array_front9([1, 2, 3, 4, 5]) → False

def array_front9(nums):
  if len(nums) < 4:
    length = len(nums)
  else:
    length = 4
  for i in range(0, length):
    if nums[i] == 9:
      return True
  return False

#front_times('Chocolate', 2) → 'ChoCho'
#front_times('Chocolate', 3) → 'ChoChoCho'
#front_times('Abc', 3) → 'AbcAbcAbc'

def front_times(str, n):
  rtn = ""
  for i in range(0, n):
    rtn += str[:3]
  return rtn

#last2('hixxhi') → 1
#last2('xaxxaxaxx') → 1
#last2('axxxaaxx') → 2

def last2(str):
  target = str[len(str) - 2:]
  cnt = 0
  for i in range(0, len(str) - 2):
    if str[i : i + 2] == target:
      cnt += 1
  return cnt

#array123([1, 1, 2, 3, 1]) → True
#array123([1, 1, 2, 4, 1]) → False
#array123([1, 1, 2, 1, 2, 3]) → True

def array123(nums):
  arr = [False] * 3
  for i in range(0, len(nums)):
    if nums[i] == 1 and arr[0] == False:
      arr[0] = True
    elif nums[i] == 2 and arr[1] == False:
      arr[1] = True
    elif nums[i] == 3 and arr[2] == False:
      arr[2] = True
    if arr[0] == True and arr[1] == True and arr[2] == True:
      return True
  return False

#string_bits('Hello') → 'Hlo'
#string_bits('Hi') → 'H'
#string_bits('Heeololeo') → 'Hello'

def string_bits(str):
  rtn = ""
  cnt = 0
  while cnt < len(str):
    rtn += str[cnt]
    cnt += 2
  return rtn

#array_count9([1, 2, 9]) → 1
#array_count9([1, 9, 9]) → 2
#array_count9([1, 9, 9, 3, 9]) → 3

def array_count9(nums):
  cnt = 0
  for i in range(0, len(nums)):
    if nums[i] == 9:
      cnt += 1
  return cnt

#string_match('xxcaazz', 'xxbaaz') → 3
#string_match('abc', 'abc') → 2
#string_match('abc', 'axc') → 0

def string_match(a, b):
  if len(a) < len(b):
    length = len(a)
  else:
    length = len(b)
  cnt = 0
  for i in range(0, length - 1):
    if a[i : i + 2] == b[i : i + 2]:
      cnt += 1
  return cnt
