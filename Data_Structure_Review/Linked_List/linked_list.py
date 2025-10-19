class ListNode:
    def __init__(self, val: int):
        self.val: int = val # node val
        self.next: ListNode | None = None # ref to next node
        
"""Initialize Linked List"""
# 1: initialize each node
n0 = ListNode(1)
n1 = ListNode(3)
n2 = ListNode(2)
n3 = ListNode(5)
n4 = ListNode(4)

# 2: connect those nodes together
n0.next = n1
n1.next = n2
n2.next = n3
n3.next = n4


"""Insert After A known Node n0 Into Linked List --- Insert At The Head Takes O(1) time"""
def insert(n0: ListNode, P: ListNode):
    n1 = n0.next
    n0.next = P
    P.next = n1
    
    
"""Delete After A Known Node n0 From Linked List --- Delete From The Head Takes O(1) Time"""
def delete(n0: ListNode):
    if not n0.next:
        return
    # n0 -> n1 -> n2
    n1 = n0.next
    n2 = n1.next
    n0.next = n2
    

"""Access A Node By The Index --- Takes O(n) Time """
def access_by_idx(head: ListNode | None, idx: int) -> ListNode | None:
    for _ in range(idx):
        if not head:
            return None
        head = head.next
    return head


"""Find A Node By The Passing Argument Value --- Takes O(n) Time"""
def find_idx_by_val(head: ListNode | None, target: int) -> int:
    idx: int = 0
    while head:
        if head.val == target:
            return idx
        idx += 1
        head = head.next
    return -1


"""Bidirectional Linked List Construction"""
class BiListNode:
    def __init__(self, val: int):
        self.val: int = val
        self.next: BiListNode | None = None
        self.prev: BiListNode | None = None 
        