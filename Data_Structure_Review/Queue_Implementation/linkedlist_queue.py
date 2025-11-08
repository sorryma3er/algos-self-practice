class ListNode:
    def __init__(self, val: int) -> None:
        self._val: int = val
        self._next: ListNode | None = None


class LinkedListQueue:
    """Linked list based queue implementation"""
    
    def __init__(self):
        """Constructor method"""
        self._head: ListNode | None = None # head node
        self._tail: ListNode | None = None # tail node
        self._size: int = 0
        
    def size(self) -> int:
        """Get the size of queue"""
        return self._size
    
    def is_empty(self) -> bool:
        """Check the queue is empty or not"""
        #return self.size() == 0
        return not self._head
    
    def push(self, val: int) -> None:
        """Push a new elt with val into queue"""
        # new a node to be ready to push
        new_node: ListNode = ListNode(val)
        # if the queue is empty, then let head, tail point to this new_node
        if self._head is None or self._tail is None:
            self._head = new_node
            self._tail = new_node
        # if not empty, then append this new_node after _tail
        else:
            self._tail._next = new_node
            self._tail = new_node
        self._size += 1
        
    def peek(self) -> int:
        """Access the head of queue and return its val"""
        if self._head is None:
            raise IndexError("Queue is empty!")
        return self._head._val
    
        
    def pop(self) -> int:
        """Pop an elt from the head and output its val"""
        num:int = self.peek()
        # delete the head node
        if self._head is None:
            raise IndexError("Queue is empty!")
        self._head = self._head._next
        self._size -= 1
        return num
    
    def to_list(self) -> list[int]:
        """Return a list version for printing"""
        queue:list[int] = []
        curr = self._head
        while curr:
            queue.append(curr._val)
            curr = curr._next
        return queue
            
if __name__ == "__main__":
    # 1️⃣  create a queue
    q = LinkedListQueue()
    print("Initially empty?", q.is_empty())       # True
    print("Initial size:", q.size())              # 0
    print("Queue state:", q.to_list())            # []

    # 2️⃣  enqueue some items
    for num in [10, 20, 30, 40]:
        q.push(num)
        print(f"After push({num}) →", q.to_list())

    # 3️⃣  inspect head without removing
    print("Peek head:", q.peek())                 # 10
    print("Current size:", q.size())              # 4

    # 4️⃣  dequeue two items
    print("Pop:", q.pop())                        # removes 10
    print("After pop:", q.to_list(), "OMFG")
    print("Pop:", q.pop())                        # removes 20
    print("After pop:", q.to_list())
    print("Current head:", q.peek())              # 30
    print("Current size:", q.size())              # 2

    # 5️⃣  enqueue again (tests tail update)
    q.push(50)
    print("After push(50):", q.to_list())         # [30, 40, 50]

    # 6️⃣  empty completely
    while not q.is_empty():
        print("Dequeued:", q.pop(), "→", q.to_list())

    print("Empty?", q.is_empty())                 # True
    print("Final size:", q.size())                # 0
