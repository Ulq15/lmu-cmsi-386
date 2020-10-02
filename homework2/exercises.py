import random
import math

def change(cents):
    quarters = int(cents/25)
    cents=cents - (quarters*25)
    dimes = int(cents/10)
    cents=cents - (dimes*10)
    nickles = int(cents/5)
    cents=cents - (nickles*5)
    pennies = cents
    tuple=(quarters, dimes, nickles, pennies)
    return tuple

def stretched(string):
    string = ''.join(string.split())
    stretchedStr=''
    for x in range(len(string)):
        for y in range(x+1):
            stretchedStr = stretchedStr + string[x]
    return stretchedStr

def scramble(string):
    sr = ''.join(random.sample(string, len(string)))
    return sr


class Cylinder:
    def __init__(self, **kwargs):
        self.radius = 1
        self.height = 1
        for key, val in kwargs.items():
            if key=='radius' or key=='height':
                setattr(self, key, val)
        vol= math.pi*self.radius*self.radius*self.height
        self.volume = vol
        surface = (2*math.pi*self.radius*self.height)+(2*math.pi*self.radius*self.radius)
        self.surface_area=surface
    def widen(self, scale):
        self.radius=scale*self.radius
    def stretch(self, scale):
        self.height=scale*self.height

def powers(base, limit):
    power = 0
    result = 1
    while result <= limit:
        result = base ** power
        if result <= limit:
            yield result
        power=power+1

def say(x):
    return lambda y=None: x if y is None else say(x+' '+y)

