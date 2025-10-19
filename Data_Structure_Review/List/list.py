"""Initialize a list"""
# no initial val
nums1: list[int] = []

# have initial val
nums: list[int] = [1, 3, 2, 5, 4]


"""The base of list is actually array, so accessing/updating certain idx takes O(1)"""
# access certain idx
num: int = nums[1]

# update
nums[1] = 0


"""Compared to fixed size array, list can freely add elt in O(1) at the end of list, but add/delete at n idx will take O(n)"""
nums.clear()

nums.append(1)
nums.append(3)
nums.append(2)
nums.append(5)
nums.append(4)

# add in the middle --- O(n)
nums.insert(3, 6) # insert 6 at idx 3

# delete certain idx
nums.pop(3)


"""loop through list is similar to walk through array"""
# loop through list via idx
count: int = 0
for i in range(len(nums)):
    count += nums[i]
    
# loop through list via foreach
count: int = 0
for num in nums:
    count += num
    

"""Concatenate lists"""
nums1: list[int] = [6, 8, 7, 10, 9]
nums += nums1 # concatenate nums1 after nums through +


"""Sort the list"""
nums.sort()


"""Use array to implement a list"""
# initial capacity: 10
# count record: declare a size variable to record current elts count, and use this to decide whether expand capacity or not
# expand rule: when adding to the array and its full, expand to 2x size and copy old into new array
class MyList:
    def __init__(self):
        self._capacity: int = 10
        self._arr: list[int] = [0] * self._capacity
        self._size: int = 0
        self._extend_ratio: int = 2
        
    def size(self) -> int:
        return self._size
    
    def capacity(self) -> int:
        return self._capacity
    
    def get(self, idx: int) -> int:
        if idx < 0 or idx >= self._size:
            raise IndexError("Out of range")
        return self._arr[idx]
    
    def set(self, idx: int, val: int):
        if idx < 0 or idx >= self._size:
            raise IndexError("Out of range")
        self._arr[idx] = val
        
    def add(self, num: int):
        if self._size == self._capacity:
            self.extend_capacity()
        self._arr[self._size] = num
        self._size += 1
        
    def insert(self, idx: int, num: int):
        if idx < 0 or idx > self._size:
            raise IndexError("Out of range")
        
        if self._size == self._capacity:
            self.extend_capacity()
            
        for i in range(self._size, idx, -1): # right shift one, so loop from the end(right), note the range
            self._arr[i] = self._arr[i - 1]
        
        self._arr[idx] = num

        self._size += 1
        
    def remove(self, idx: int) -> int:
        if idx < 0 or idx >= self._size:
            raise IndexError("Out of range")
        
        num: int = self._arr[idx]
        
        for i in range(idx, self._size - 1, 1): # left shift one, loop from the left
            self._arr[i] = self._arr[i + 1]
            
        self._size -= 1
        return num
    
    def extend_capacity(self):
        self._arr = self._arr + [0] * self._capacity * (self._extend_ratio - 1) # use + to concatenate two arr
        self._capacity = len(self._arr)
        
    def to_array(self) -> list[int]:
        return self._arr[:self._size]


if __name__ == "__main__":
    my_list = MyList()
    
    # Add elements
    my_list.add(10)
    my_list.add(20)
    my_list.add(30)
    print("After adds:", my_list.to_array())   # [10, 20, 30]
    print("Size:", my_list.size(), "Capacity:", my_list.capacity())
    
    # Insert in the middle
    my_list.insert(1, 15) 
    print("After insert at idx 1:", my_list.to_array())  # [10, 15, 20, 30]
    
    # Get and set
    print("Element at idx 2:", my_list.get(2))           # 20
    my_list.set(2, 99)
    print("After set idx 2 to 99:", my_list.to_array())  # [10, 15, 99, 30]
    
    # Remove an element
    removed = my_list.remove(1)
    print(f"Removed element {removed}")                  # 15
    print("After remove at idx 1:", my_list.to_array())  # [10, 99, 30]
    
    # Force capacity growth
    for i in range(20):
        my_list.add(i)
    print("After many adds, size:", my_list.size(), "capacity:", my_list.capacity())
    print("Final array:", my_list.to_array())