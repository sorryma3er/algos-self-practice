from collections import deque

# in Python we normally use 双向队列类 dequeue as queue to use;
# Even though the queue.Queue() is the pure queue class, but not recommended;

# Init
que: deque[int] = deque()

# Add elt goes into the queue
que.append(1)
que.append(3)
que.append(2)
que.append(5)
que.append(4)

# Accessing the front of the queue
head: int = que[0]

# elt goes out from the queue, normally also happens at the front
pop: int = que.popleft()

# Get the size of this queue
size: int = len(que)

# emptyness check
is_empty: bool = len(que) == 0
