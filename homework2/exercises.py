import random
import math
from cryptography.fernet import Fernet
import requests

def change(cents):
    if cents<0:
        raise ValueError('amount cannot be negative')
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
        self.calc()
    def widen(self, scale):
        self.radius=scale*self.radius
        self.calc()
    def stretch(self, scale):
        self.height=scale*self.height
        self.calc()
    def calc(self):
        self.volume= math.pi*self.height*self.radius**2
        self.surface_area = (2*self.radius*self.height + 2*self.radius**2)*math.pi

def powers(base, limit):
    power = 0
    result = 1
    while result <= limit:
        result = base ** power
        if result <= limit:
            yield result
        power=power+1

def say(*args):
    if args:
        res = args[0]
        def recursor(*a):
            nonlocal res
            if a:
                res = res+' '+a[0]
                return recursor
            else:
                return res
        return recursor
    else:
        return ''

def interleave(list1, *args):
    finalList=list1.copy()
    i=1
    for item in args:
        if i<len(finalList):
            finalList.insert(i,item)
        else:
            finalList.append(item)
        i+=2
    return finalList

def make_crypto_functions(key):
    cipher_obj=Fernet(key)
    def encrypt(msg):return cipher_obj.encrypt(msg)
    def decrypt(encrypted):return cipher_obj.decrypt(encrypted)
    return (encrypt, decrypt)

def top_ten_scorers(teams):
    players_Over_15_Games=[]
    for team in teams.keys():
        for player in teams.get(team):
            teamName=team
            name=player[0]
            games=player[1]
            score=player[2]
            if games>=15:
                ppg=score/games
                players_Over_15_Games.append({'name': name, 'ppg': ppg, 'team': teamName})
    results = sorted(players_Over_15_Games, key=lambda x: x.get('ppg'), reverse=True)
    results=results[0:10]
    return results

def studio_ghibli_characters(**kwargs):
    if len(kwargs)!=2 or not ('hair_color' in kwargs and 'gender' in kwargs):
        return "Error. Need only hair_color and gender as parameters"
    else:
        dic= requests.get('https://ghibliapi.herokuapp.com/people/').json()
        gender=kwargs['gender']
        hair=kwargs['hair_color']
        results=[]
        for person in dic:
            if person.get('gender')==gender and person.get('hair_color')==hair:
                results.append({'name': person.get('name'), 'gender': person.get('gender'), 'age': person.get('age'), 'eye_color': person.get('eye_color'), 'hair_color': person.get('hair_color')})

        return(results)
    
