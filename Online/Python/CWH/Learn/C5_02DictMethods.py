marks={"Moksh":98,"Ginni":97, "Aadish":100, "Kruti":99, "list1":[1,2,3]}
print("length of the dictionary is:", len(marks))

#marks.items(): returns the list of key-value pair in the form of tuple
print("marks.items() gives:",marks.items())

#marks.keys(): returns the list of keys in the dictionary
print("marks.keys() gives:",marks.keys())

#marks.values(): returns the list of values in the dictionary
print("marks.values() gives:",marks.values())

#marks.update(new_key_value_pair): Updates the dictionary with the supplied key-value pair
print("marks.update({'Pratap': 101}) adds the new pair to the dictionary"),marks.update({"Pratap": 101})
marks.update({"Moksh":100}) #this will update the value in already existing key
print("new dictionary is:",marks)

#marks.get(key): returns the value specified to the key
print("marks.get(Moksh) gives:",marks.get("Moksh")) #if no such key is poresent then we will get "None"

#etc....

