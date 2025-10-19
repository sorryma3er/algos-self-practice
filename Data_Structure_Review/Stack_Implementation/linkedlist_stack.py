class ListNode:
    def __init__(self, val: int):
        self._val: int = val
        self._next: ListNode | None = None

class LinkedListStack:
    """Stack implementation based on linked list"""
    
    def __init__(self):
        """Construct methods"""
        self._head: ListNode | None = None
        self._size: int = 0
        
    def size(self) -> int:
        """Get the size of the stack"""
        return self._size
    
    def is_empty(self) -> bool:
        """Check the stack emptyness"""
        #return self._head == None
        return not self._head
    
    def push(self, val: int):
        """Push a new elt into the stack"""
        new_node: ListNode = ListNode(val)
        new_node._next = self._head
        self._head = new_node
        self._size += 1 #dont forget the size
        
    def pop(self) -> int:
        """Get the top elt in the stack"""
        if self._head is None:
            raise ValueError("Empty Stack!")
        
        num = self._head._val
        self._head = self._head._next
        self._size -= 1
        return num
    
    def peek(self) -> int:
        """Peek the top elt on the stack"""
        if self._head == None:
            raise ValueError("Empty Stack!")
        
        return self._head._val
    
    def to_list(self) -> list[int]:
        arr = []
        curr = self._head
        while curr:
            arr.append(curr._val)
            curr = curr._next
            
        arr.reverse()
        return arr
            
    
if __name__ == "__main__":
    s = LinkedListStack()
    for x in [10, 20, 30]:
        s.push(x)
    print("Stack =", s.to_list())  # [10, 20, 30]  ← 底到顶

    print("peek:", s.peek())       # 30
    print("pop :", s.pop())        # 30
    print("after pop =", s.to_list())  # [10, 20]
    print("size:", s.size())       # 2
        
    