Perfect 👌
If you can **identify which of these 5 patterns a question belongs to within 30 seconds**, recursion becomes mechanical.

Below are **clear question patterns + examples** for each category.

---

# 1️⃣ Linear Recursion Pattern

> One recursive call → problem size reduces linearly

### Template

```java
if(base condition) return;
return f(n-1);
```

### Recognizable Pattern

* “Do something for n”
* “Process from left to right”
* Only **one recursive call**
* No branching

---

### 🔹 Typical Questions

* Factorial of N
* Fibonacci (basic version)
* Sum of first N numbers
* Reverse a string
* Check palindrome
* Print 1 to N
* Power(x, n)

---

### 🧠 Interview Variants

* Binary Search (recursive version)
* Reverse Linked List (recursive)
* Delete middle of stack
* Sort stack using recursion

---

### When to Use

When:

* Each call depends only on smaller subproblem
* No choices involved
* No branching tree

---

# 2️⃣ Take / Not Take Pattern (Binary Decision Tree)

> Each element → 2 choices

### Template

```java
// Take
recurse(i+1)

// Not Take
recurse(i+1)
```

### Recognizable Pattern

* “Generate all subsets”
* “Count subsets”
* “Target sum”
* “Subsequence”

Time Complexity → O(2^n)

---

### 🔹 Typical Questions

* Print all subsequences
* Count subsequences with sum K
* Subset Sum
* Partition Equal Subset Sum
* Target Sum (Leetcode 494)
* Count subsets with given difference
* Generate all subsets

---

### 🧠 Interview Variants

* Assign + or - signs to reach target
* Equal partition
* Count ways to divide array
* Minimum subset difference

---

### When to Use

When:

* Each element has exactly 2 choices
* Include or exclude
* Subset-type question

---

# 3️⃣ For Loop + Backtracking Pattern

> Multiple choices at each level

### Template

```java
for(all choices){
    choose
    recurse
    unchoose
}
```

### Recognizable Pattern

* “Generate all combinations”
* “Choose k elements”
* “Partition string”
* “Try all possible cuts”

Time Complexity → Usually exponential

---

### 🔹 Typical Questions

* Combination Sum I
* Combination Sum II
* Subsets II (with duplicates)
* Palindrome Partitioning
* Letter Combinations of Phone Number
* Generate Parentheses
* Restore IP Address

---

### 🧠 Interview Variants

* Partition string into valid words
* Choose k numbers summing to n
* Word Break (backtracking version)

---

### When to Use

When:

* You must try **all possible next choices**
* Not just binary include/exclude
* Choices come from a range (i → n)

---

# 4️⃣ Swap-Based Permutation Pattern

> Fix position → try all remaining elements

### Template

```java
for(i = ind → n){
    swap(ind, i)
    recurse(ind+1)
    swap(ind, i)
}
```

### Recognizable Pattern

* “Generate all permutations”
* “Rearrange elements”
* “Order matters”

Time Complexity → O(n!)

---

### 🔹 Typical Questions

* Print all permutations
* Permutations II (with duplicates)
* Kth permutation
* Next permutation (iterative version)
* Rearrange string characters

---

### 🧠 Interview Variants

* Permute string
* Unique permutations
* Find kth lexicographic permutation
* Count beautiful arrangements

---

### When to Use

When:

* Position matters
* All elements must be used
* Order changes answer

---

# 5️⃣ Grid Movement + Visited Pattern

> Move in 4 or 8 directions

### Template

```java
for(each direction){
    if(valid){
        mark visited
        recurse
        unmark visited
    }
}
```

### Recognizable Pattern

* Maze
* Matrix traversal
* Island problems
* Word search
* Flood fill

---

### 🔹 Typical Questions

* Rat in a Maze
* Word Search
* Number of Islands
* Flood Fill
* Surrounded Regions
* Rotten Oranges
* Path with obstacles
* All paths from (0,0) to (n-1,n-1)

---

### 🧠 Interview Variants

* Shortest path in binary matrix
* Count distinct islands
* Word Search II
* Path with maximum gold

---

### When to Use

When:

* Grid input
* Movement in directions
* Need visited[][] array
* Need boundary checks

---

# 🧠 How To Identify Pattern In 10 Seconds

| If Question Says    | Pattern                 |
| ------------------- | ----------------------- |
| “All subsets”       | Take / Not Take         |
| “Count subsets”     | Take / Not Take         |
| “All combinations”  | For loop + backtracking |
| “Choose k numbers”  | For loop + backtracking |
| “All permutations”  | Swap-based              |
| “Rearrange array”   | Swap-based              |
| “Matrix traversal”  | Grid + visited          |
| “Maze”              | Grid + visited          |
| “Print from 1 to N” | Linear recursion        |

---

# 🔥 Most Important for Interviews

If you're preparing for MAANG:

Focus priority order:

1. Take/Not Take
2. For loop + backtracking
3. Grid movement
4. Permutations
5. Linear recursion (basic)

Because interviews mostly test:

* Exponential branching logic
* Constraint handling
* Pruning
* Optimization (DP later)

---

# 🚀 Next Step For You

Since you already implemented most of these in your class:

Now practice mixed pattern questions like:

* Word Search II (Grid + Backtracking)
* Partition to K Equal Subsets (Backtracking + pruning)
* Target Sum (Recursion → DP)
* M Coloring Problem (Constraint + recursion)
* Beautiful Arrangement (Permutation + pruning)

---

