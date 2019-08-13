数组队列 dequeue 时间复杂度 O(n)

1. 删除队首元素
2. 剩余数组往前挪一位

解决方案 循环队列

1. 删除队首
2. 维护队首的坐标

front 指向队首   tail 指向下次入队的 index
队列空 front 0  tail 0
入队   front 0  tail ++
出队   front ++ 
...
入队 队尾到达容量上限，队首有空元素  tail 指向队首  tail = (index + 1) % capacity

front == tail 队列为空
(tail + 1) % capacity == front 队列满
capacity 中，浪费一个空间


包含尾指针的链表

链表头             链表尾
队尾 出队           队首  入队 
因为从链表尾删除元素的时间复杂度是O(n)
从链表头删除、添加元素的时间复杂度都是O(1)