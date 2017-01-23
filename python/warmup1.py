#CodingBat Warmup-1
#URL: http://codingbat.com/python/Warmup-1

#sleep_in(False, False) → True
#sleep_in(True, False) → False
#sleep_in(False, True) → True

def sleep_in(weekday, vacation):
  return not weekday or vacation

#diff21(19) → 2
#diff21(10) → 11
#diff21(21) → 0

def diff21(n):
  diff = abs(21 - n)
  if n > 21:
    return diff * 2
  else:
    return diff

#near_hundred(93) → True
#near_hundred(90) → True
#near_hundred(89) → False

def near_hundred(n):
  if 10 >= abs(100 - n) or 10 >= abs(200 - n):
    return True
  else:
    return False

#missing_char('kitten', 1) → 'ktten'
#missing_char('kitten', 0) → 'itten'
#missing_char('kitten', 4) → 'kittn'

def missing_char(str, n):
  return str[0 : n] + str[n + 1 :]

#monkey_trouble(True, True) → True
#monkey_trouble(False, False) → True
#monkey_trouble(True, False) → False

def monkey_trouble(a_smile, b_smile):
  return a_smile == b_smile

#parrot_trouble(True, 6) → True
#parrot_trouble(True, 7) → False
#parrot_trouble(False, 6) → False

def parrot_trouble(talking, hour):
  if talking:
    if hour > 20 or 7 > hour:
      return True
    else:
      return False
  else:
    return False

#pos_neg(1, -1, False) → True
#pos_neg(-1, 1, False) → True
#pos_neg(-4, -5, True) → True

def pos_neg(a, b, negative):
  if negative:
    if (a < 0 and b < 0):
      return True
    else:
      return False
  else:
    if (a > 0 and 0 > b) or (a < 0 and 0 < b):
      return True
    else:
      return False

#front_back('code') → 'eodc'
#front_back('a') → 'a'
#front_back('ab') → 'ba'

def front_back(str):
  if len(str) == 1:
    return str
  return str[-1 :] + str[1 : -1] + str[: 1]

#sum_double(1, 2) → 3
#sum_double(3, 2) → 5
#sum_double(2, 2) → 8

def sum_double(a, b):
  if (a == b):
    return 2 * (a + b)
  return a + b

#makes10(9, 10) → True
#makes10(9, 9) → False
#makes10(1, 9) → True

def makes10(a, b):
  if (a + b == 10 or a == 10 or b == 10):
    return True
  return False

#not_string('candy') → 'not candy'
#not_string('x') → 'not x'
#not_string('not bad') → 'not bad'

def not_string(str):
  if str.startswith("not"):
    return str
  return "not " + str

#front3('Java') → 'JavJavJav'
#front3('Chocolate') → 'ChoChoCho'
#front3('abc') → 'abcabcabc'

def front3(str):
  rtn = ""
  for i in range(0, 3):
    rtn += str[: 3]
  return rtn
