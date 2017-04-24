# grumpy-squirrels
# Members: Rihui Zheng, Eric Li, Arpita Nag

##Our Help Desk

When you arrive at the help desk, you will be asked to identify yourself as an operator or a user, or if you want to quit.

If you are an operator, you have the options of
   1. View the entire queue, ordered by their priiority
   2. View the user in front of the queue
   3. Provide a solution to the user in front of the queue

If you are a user, you have the options of
   1. If you are a returning user, you can see if the operator have provided a solution. If they have, you can remove yourself from queue.
   2. If you are new, you will be asked to provided information, including your name, problem, and your rank (priority). 0 means you are the boss while 99 means you are a peasant. You would then be put into the queue based on your priority.

The ArrayPriorityQueue we are using sorts new users in the ArrayList based on their priority when they are added into the queue. peekMin and removeMin affects the user in the front of the queue.