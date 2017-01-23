#CodingBat Logic-1
#URL: http://codingbat.com/python/Logic-1

#cigar_party(30, False) → False
#cigar_party(50, False) → True
#cigar_party(70, True) → True

def cigar_party(cigars, is_weekend):
  if is_weekend:
    if cigars >= 40:
      return True
    else:
      return False
  else:
    if cigars >= 40 and cigars <= 60:
      return True
    else:
      return False

#caught_speeding(60, False) → 0
#caught_speeding(65, False) → 1
#caught_speeding(65, True) → 0

def caught_speeding(speed, is_birthday):
  if is_birthday:
    speed -= 5
  if speed <= 60:
    return 0
  elif speed <= 80:
    return 1
  else:
    return 2

#love6(6, 4) → True
#love6(4, 5) → False
#love6(1, 5) → True

def love6(a, b):
  sum = a + b
  diff = abs(a - b)
  if a == 6 or b == 6 or sum == 6 or diff == 6:
    return True
  else:
    return False

#date_fashion(5, 10) → 2
#date_fashion(5, 2) → 0
#date_fashion(5, 5) → 1

def date_fashion(you, date):
  if (you >= 8 and date >= 3) or (date >= 8 and you >= 3):
    return 2
  elif you <= 2 or date <= 2:
    return 0
  else:
    return 1

#sorta_sum(3, 4) → 7
#sorta_sum(9, 4) → 20
#sorta_sum(10, 11) → 21

def sorta_sum(a, b):
  sum = a + b
  if sum >= 10 and sum <= 19:
    return 20
  else:
    return sum

#in1to10(5, False) → True
#in1to10(11, False) → False
#in1to10(11, True) → True

def in1to10(n, outside_mode):
  if outside_mode:
    if n <= 1 or n >= 10:
      return True
    else:
      return False
  else:
    if n >= 1 and n <= 10:
      return True
    else:
      return False

#squirrel_play(70, False) → True
#squirrel_play(95, False) → False
#squirrel_play(95, True) → True

def squirrel_play(temp, is_summer):
  if is_summer:
    if temp <= 100 and temp >= 60:
      return True
    else:
      return False
  else:
    if temp <= 90 and temp >= 60:
      return True
    else:
      return False

#alarm_clock(1, False) → '7:00'
#alarm_clock(5, False) → '7:00'
#alarm_clock(0, False) → '10:00'

def alarm_clock(day, vacation):
  if vacation:
    if day == 0 or day == 6:
      return "off"
    else:
      return "10:00"
  else:
    if day == 0 or day == 6:
      return "10:00"
    else:
      return "7:00"

#near_ten(12) → True
#near_ten(17) → False
#near_ten(19) → True

def near_ten(num):
  if num % 10 <= 2 or num % 10 >= 8:
    return True
  else:
    return False
