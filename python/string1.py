#CodingBat String-1
#URL: http://codingbat.com/python/String-1

#hello_name('Bob') → 'Hello Bob!'
#hello_name('Alice') → 'Hello Alice!'
#hello_name('X') → 'Hello X!'

def hello_name(name):
  return "Hello " + name + "!"

#make_out_word('<<>>', 'Yay') → '<<Yay>>'
#make_out_word('<<>>', 'WooHoo') → '<<WooHoo>>'
#make_out_word('[[]]', 'word') → '[[word]]'

def make_out_word(out, word):
  return out[: 2] + word + out[-2 :]

#first_half('WooHoo') → 'Woo'
#first_half('HelloThere') → 'Hello'
#first_half('abcdef') → 'abc'

def first_half(str):
  mid = len(str) / 2
  return str[0 : mid]

#non_start('Hello', 'There') → 'ellohere'
#non_start('java', 'code') → 'avaode'
#non_start('shotl', 'java') → 'hotlava'

def non_start(a, b):
  return a[1 :] + b[1 :]

#make_abba('Hi', 'Bye') → 'HiByeByeHi'
#make_abba('Yo', 'Alice') → 'YoAliceAliceYo'
#make_abba('What', 'Up') → 'WhatUpUpWhat'

def make_abba(a, b):
  return a + b + b + a

#extra_end('Hello') → 'lololo'
#extra_end('ab') → 'ababab'
#extra_end('Hi') → 'HiHiHi'

def extra_end(str):
  return str[-2 :] + str[-2 :] + str[-2 :]

#without_end('Hello') → 'ell'
#without_end('java') → 'av'
#without_end('coding') → 'odin'

def without_end(str):
  return str[1 : -1]

#left2('Hello') → 'lloHe'
#left2('java') → 'vaja'
#left2('Hi') → 'Hi'

def left2(str):
  return str[2 :] + str[: 2]

#make_tags('i', 'Yay') → '<i>Yay</i>'
#make_tags('i', 'Hello') → '<i>Hello</i>'
#make_tags('cite', 'Yay') → '<cite>Yay</cite>'

def make_tags(tag, word):
  return "<" + tag + ">" + word + "</" + tag + ">"

#first_two('Hello') → 'He'
#first_two('abcdefg') → 'ab'
#first_two('ab') → 'ab'

def first_two(str):
  if len(str) < 2:
    return str
  return str[: 2]

#combo_string('Hello', 'hi') → 'hiHellohi'
#combo_string('hi', 'Hello') → 'hiHellohi'
#combo_string('aaa', 'b') → 'baaab'

def combo_string(a, b):
  if len(a) < len(b):
    short = a
    long = b
  else:
    short = b
    long = a
  return short + long + short
