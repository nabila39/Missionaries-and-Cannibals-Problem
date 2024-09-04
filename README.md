# Missionaries and Cannibals Problem

## Problem Description

The Missionaries and Cannibals problem is a classic river-crossing puzzle. The goal is to find a way to get three missionaries and three cannibals across a river using a boat that can carry at most two people, under the following constraints:

1. If missionaries are outnumbered by cannibals on either side of the river, the cannibals will eat the missionaries.
2. The boat cannot cross the river by itself; it must carry at least one passenger.
3. The goal is to safely transfer all missionaries and cannibals from the left bank of the river to the right bank.

## State Representation

Each state can be represented as a tuple `(M, C, B)`:

- `M`: Number of missionaries on the left bank.
- `C`: Number of cannibals on the left bank.
- `B`: Boat position (`1` if on the left bank, `0` if on the right bank).

The initial state is `(3, 3, 1)`, and the goal state is `(0, 0, 0)`.

## Solution Approaches

### 1. Breadth-First Search (BFS)

BFS explores the shortest path to the solution level by level, making it suitable for finding the optimal solution in terms of the fewest moves.

**Steps**:
1. Initialize a queue with the initial state `(3, 3, 1)`.
2. Keep track of visited states to avoid revisiting them.
3. For each state, generate all possible valid moves (e.g., move one missionary, move two cannibals).
4. Check the validity of each generated state:
   - Ensure no side of the river has more cannibals than missionaries.
   - Ensure the state hasn't been visited.
5. Add valid states to the queue.
6. Stop when the goal state `(0, 0, 0)` is reached.

**Pseudocode**:
```python
from collections import deque

def bfs(initial_state):
    queue = deque([initial_state])
    visited = set([initial_state])

    while queue:
        state = queue.popleft()

        if state == (0, 0, 0):
            return "Solution Found"

        # Generate possible next states
        for next_state in generate_next_states(state):
            if next_state not in visited and is_valid_state(next_state):
                visited.add(next_state)
                queue.append(next_state)

    return "No Solution"


### 2. Depth-First Search (DFS)

DFS explores as deep as possible along a branch before backtracking. It is not guaranteed to find the shortest solution but will find a solution if one exists.

**Steps**:

1. Use a stack to explore states deeply before backtracking.
2. Start with the initial state and explore each possible valid move.
3. Backtrack when a move leads to an invalid state or a dead end.
4. Stop when the goal state `(0, 0, 0)` is reached.

**Pseudocode**:

```python
def dfs(state, visited=set()):
    if state == (0, 0, 0):
        return "Solution Found"

    visited.add(state)

    for next_state in generate_next_states(state):
        if next_state not in visited and is_valid_state(next_state):
            result = dfs(next_state, visited)
            if result == "Solution Found":
                return result

    visited.remove(state)
    return "No Solution"

### Conclusion

Both BFS and DFS can solve the Missionaries and Cannibals problem. BFS is preferred when the shortest solution path is needed, as it explores all possibilities level by level, ensuring the shortest path is found. On the other hand, DFS might be more efficient for exploring deeper solutions quickly, but it does not guarantee the shortest solution and may require more backtracking.
