class ListBasedStack:
    """A stack implementation based on list"""
    
    def __init__(self) -> None:
        """Construct methods"""
        self._stack: list[int] = []
    
    def size(self) -> int:
        """Get the size of the stack"""
        return len(self._stack)
    
    def is_empty(self) -> bool:
        """Check the stack emptyness"""
        return self._stack == []
    
    def push(self, val: int) -> None:
        """Insert into the last position of list"""
        self._stack.append(val)
        
    def pop(self) -> int:
        """Get the last elt in this list as the pop operation"""
        if self.is_empty():
            raise IndexError("Stack is empty!")
        return self._stack.pop()
    
    def peek(self) -> int:
        """Check the top of the stack"""
        if self.is_empty():
            raise IndexError("Stack is empty!")
        return self._stack[-1]  # LIFO!
    
    def to_list(self) -> list[int]:
        """Just return the list"""
        return self._stack
            
if __name__ == "__main__":
    my_stack = ListBasedStack()
    for x in [10, 20, 30]:
        my_stack.push(x)
    print("Stack =", my_stack.to_list())      # [10, 20, 30]
    print("peek:", my_stack.peek())           # 30
    print("pop :", my_stack.pop())            # 30
    print("after pop =", my_stack.to_list())  # [10, 20]
    print("size:", my_stack.size())           # 2