s={1,2,3,4,5,54,54,54,"Moksh"}
print("length of the set is:", len(s))
print(type(s))
print(s)

#add(): adds elements to the set
s.add(10)
print("s.add(10) gives:",s)

#remove(): removes elements from the set
s.remove(1)
print("s.remove(1) gives:",s)

#pop(): pop random element from the set and return the popped element
print("s.pop() gives:",s.pop())

#union(): merges two sets
s2={1,4,6}
s3={4,6,7,8,99}
print("s2.union(s3) gives:",s2.union(s3))

#intersection(): finds common elements from two sets
print("s2.intersection(s3) gives:",s2.intersection(s3))