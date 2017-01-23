#CodingBat String-2
#URL: http://codingbat.com/python/String-2

#double_char('The') → 'TThhee'
#double_char('AAbb') → 'AAAAbbbb'
#double_char('Hi-There') → 'HHii--TThheerree'

def double_char(str):
  rtn = ""
  for i in range(0, len(str)):
    rtn += str[i : i + 1] + str[i : i + 1]
  return rtn

#count_code('aaacodebbb') → 1
#count_code('codexxcode') → 2
#count_code('cozexxcope') → 2

def count_code(str):
  cnt = 0
  for i in range(0, len(str) - 3):
    if str[i : i + 2] == "co" and str[i + 3 : i + 4] == "e":
      cnt += 1
  return cnt

#count_hi('abc hi ho') → 1
#count_hi('ABChi hi') → 2
#count_hi('hihi') → 2

def count_hi(str):
  cnt = 0
  total = 0
  while cnt < len(str):
    if str[cnt : cnt + 2] == "hi":
      total += 1
    cnt += 1
  return total

#end_other('Hiabc', 'abc') → True
#end_other('AbC', 'HiaBc') → True
#end_other('abc', 'abXabc') → True

def end_other(a, b):
  a = a.lower()
  b = b.lower()
  if len(a) > len(b):
    if a[len(a) - len(b) : len(a)] == b:
      return True
    else:
      return False
  elif len(a) < len(b):
    if b[len(b) - len(a) : len(b)] == a:
      return True
    else:
      return False
  else:
    if a == b:
      return True
    else:
      return False

#cat_dog('catdog') → True
#cat_dog('catcat') → False
#cat_dog('1cat1cadodog') → True

def cat_dog(str):
  cnt = 0
  dogs = 0
  cats = 0
  while cnt < len(str) - 2:
    if str[cnt : cnt + 3] == "dog":
      dogs += 1
      cnt += 3
    elif str[cnt : cnt + 3] == "cat":
      cats += 1
      cnt += 3
    else:
      cnt+= 1
  if dogs == cats:
    return True
  else:
    return False

#xyz_there('abcxyz') → True
#xyz_there('abc.xyz') → False
#xyz_there('xyz.abc') → True

def xyz_there(str):
  if str == "xyz" or str[0 : 3] == "xyz":
    return True
  cnt = 1
  while cnt < len(str):
    if str[cnt : cnt + 3] == "xyz" and str[cnt - 1 : cnt] != ".":
      return True
    cnt += 1
  return False
