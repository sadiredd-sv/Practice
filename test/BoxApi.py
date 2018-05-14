#!/usr/bin/python

import requests
import sys

folder_to_create = str(sys.argv[1])
file_to_upload = str(sys.argv[2])


# 1. Create a new folder
headers = {
    'Authorization': 'Bearer D55KzrhsQP0Xmwu2NBsnBOBjw9NkrwNI',
}
data = '{"name":"'+folder_to_create+'", "parent": {"id": "0"}}'
response = requests.post('https://api.box.com/2.0/folders', headers=headers, data=data)



# 2. Get the 'id' of the created folder in step 1 above
response = requests.get('https://api.box.com/2.0/folders/0', headers=headers)
data = response.json()
for n in data['item_collection']['entries']:
    if n['name'] == folder_to_create:
        id = n['id']




# 3. Use the id obtained in step 2 above to upload a file into that new folder
files = {
    'attributes': (None, '{"name":"'+file_to_upload+'", "parent":{"id":"'+id+'"}}'),
    'file': (file_to_upload, open(file_to_upload, 'rb')),
}
response = requests.post('https://upload.box.com/api/2.0/files/content', headers=headers, files=files)