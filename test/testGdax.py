import json, hmac, hashlib, time, requests, base64
from requests.auth import AuthBase

# Create custom authentication for Exchange
class CoinbaseExchangeAuth(AuthBase):
    def __init__(self, api_key, secret_key, passphrase):
        self.api_key = api_key
        self.secret_key = secret_key
        self.passphrase = passphrase

    def __call__(self, request):
        timestamp = str(time.time())
        message = timestamp + request.method + request.path_url + (request.body or '')
        hmac_key = base64.b64decode(self.secret_key)
        signature = hmac.new(hmac_key, message, hashlib.sha256)
        signature_b64 = signature.digest().encode('base64').rstrip('\n')

        request.headers.update({
            'CB-ACCESS-SIGN': signature_b64,
            'CB-ACCESS-TIMESTAMP': timestamp,
            'CB-ACCESS-KEY': self.api_key,
            'CB-ACCESS-PASSPHRASE': self.passphrase,
            'Content-Type': 'application/json'
        })
        return request

api_url = 'https://api.gdax.com/'
auth = CoinbaseExchangeAuth('c32d067fa512cbf416e67bf3d65ca9ea', 'owX5MggqZL9Mjf8QJ/K2GIJjnzYWdfeJxjYeGoSdXlI0eu22hJLkJfvj6Nm6+bwxOZkZjz+rC9ixkmeqGGupRQ==', 'devi')

# Get accounts
# r = requests.get(api_url + 'accounts', auth=auth)
r = requests.get(api_url + 'products/BTC-USD/book', auth=auth)
print r.json()['bids'][0][0]


#Post example
# data = {
#     'type': 'fills',
#     'start_date': str(time.time()),
#     'end_date': str(time.time())
# }
#
# resp = requests.post(api_url+"reports", auth=auth, json=data)
# print resp.json()





# [{"id": "a1b2c3d4", "balance":...

# Place an order
# order = {
#     'size': 1.0,
#     'price': 1.0,
#     'side': 'buy',
#     'product_id': 'BTC-USD',
# }
# r = requests.post(api_url + 'orders', json=order, auth=auth)
# print r.json()