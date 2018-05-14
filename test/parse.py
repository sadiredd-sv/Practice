#!/usr/bin/python

import requests


response = requests.get('https://api.coinbase.com/v2/prices/spot?currency=USD')

data = response.json()

print data['data']['amount']