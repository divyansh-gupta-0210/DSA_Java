Your `ArraysPractise` class is actually a **mini DSA handbook for arrays**. 🔥
It covers almost all major array patterns asked in coding interviews.

I’ll break this into:

1. ✅ Important DSA patterns observed
2. 🎯 What type of questions each pattern solves
3. 📚 What you should practice under each pattern

---

# ✅ 1. Two Pointer Pattern

### Seen in:

* `twoSum`
* `removeDuplicates`
* `sort012` (Dutch National Flag)
* `moveZerosToEnd`
* `leftRotate`
* `reverse`
* `intersectionOf2SortedArray`
* `unionOf2SortedArray`
* `threeSum`
* `fourSum`

### 🔥 Pattern Types

### (A) Opposite Direction Two Pointers

Used when array is sorted.

Example:

```java
int i = 0, j = n-1;
while(i < j)
```

### When to use:

✅ Sorted arrays
✅ Pairs / triplets / combinations
✅ Removing duplicates
✅ Partitioning

Interview Trigger Words

1. “sorted array”

2. “pair sum”

3. “triplets”

4. “merge”

5. “remove duplicates”

Used in:

* Two Sum
* 3Sum
* 4Sum
* Container type problems

### (B) Same Direction Sliding Window

Used in:

* `longestSubarraySum`
* `moveZerosToEnd`

---

### 🎯 Practice For:

* Pair sum problems
* Triplet sum
* Remove duplicates in sorted array
* Move elements to end
* Partitioning problems
* Sliding window maximum length problems

---

# ✅ 2. Sliding Window Pattern

### Seen in:

* `longestSubarraySum`
* `maxConsecutiveOnes`

### 🔥 Key Idea:

Maintain a window `[i, j]` and expand/shrink.

```java
while(sum > target) {
    sum -= arr[i];
    i++;
}
```

### When to use:

✅ Contiguous subarray
✅ Max/min length
✅ Positive numbers

Trigger Words:

1. “longest subarray”
2. “window”
3. “sum equals K”
4. “at most K”

### 🎯 Practice For:

* Longest subarray with sum K
* Maximum consecutive 1s
* Subarrays with at most K distinct elements
* Minimum window substring (advanced)
* Count subarrays with given condition

---

# ✅ 3. Prefix Sum + Hashing

### Seen in:

* `numberOfSubarraysWithSumK`
* (commented in `longestSubarraySum`)
* `countSubarraysWithXORasK`

### 🔥 Pattern:

Use prefix sum + hashmap to reduce O(n²) → O(n)

```java
preSum += arr[i]
if(map.containsKey(preSum - k))
```

### Pattern Idea:

Instead of recomputing sums → store past prefix values.

Trigger Words:

1. “count subarrays”

2. “sum equals K”

3. “xor equals K”

4. “number of ways”

### 🎯 Practice For:

* Count subarrays with sum K
* Longest subarray with sum K (with negatives)
* Subarray XOR K
* Equal 0s and 1s
* Binary array sum problems

This is VERY important for interviews.

---

# ✅ 4. Kadane’s Algorithm Pattern

### Seen in:

* `maxSubarray`

```java
sum = max(sum + arr[i], arr[i])
```

### 🎯 Practice For:

* Maximum subarray sum
* Maximum product subarray
* Circular subarray sum
* Submatrix maximum sum (advanced 2D Kadane)

---

# ✅ 5. Modified Kadane (Prefix & Suffix Trick)

### Seen in:

* `maximumProductSubarray`

Using:

```java
pre *= arr[i]
suf *= arr[n-i-1]
```

Handles negatives and zeros.

### 🎯 Practice:

* Max product subarray
* Variants involving sign flipping

---

# ✅ 6. Dutch National Flag Algorithm

### Seen in:

* `sort012`

Three pointers:

```java
low, mid, high
```

### 🎯 Practice:

* Sort 0,1,2
* Partition array
* QuickSort partition logic
* Segregate positive & negative

Very common in interviews.

---

# ✅ 7. Moore’s Voting Algorithm

### Seen in:

* `majorityElement`
* `MajorityElementII`

### 🔥 Pattern:

Used when element appears:

* > n/2
* > n/3

### 🎯 Practice:

* Majority element 1
* Majority element 2
* Problems involving frequency > n/k

---

# ✅ 8. Merge Sort Based Counting Pattern

### Seen in:

* `countInversions`
* `reversePairs`

This is **EXTREMELY important** for interviews.

### 🔥 Core Idea:

While merging sorted halves, count cross pairs.

Used for:

* Inversions
* Reverse pairs (arr[i] > 2*arr[j])
* Count smaller after self

### 🎯 Practice:

* Count inversions
* Reverse pairs
* Count smaller numbers after self
* Important for Google-level questions

---

# ✅ 9. Greedy Scan From Right

### Seen in:

* `leadersInAnArray`

```java
Traverse from right and track max
```

### 🎯 Practice:

* Leaders in array
* Stock span
* Next greater element (with stack)
* Right side max problems

---

# ✅ 10. Next Permutation Pattern

### Seen in:

* `nextPermutation`

### 🔥 Steps:

1. Find first decreasing element
2. Find next greater element from right
3. Swap
4. Reverse suffix

### 🎯 Practice:

* Next permutation
* Previous permutation
* Permutation problems

Very common FAANG question.

---

# ✅ 11. Matrix Manipulation Patterns

### Seen in:

* `rotateMatrix`
* `setMatrixZeros`
* `spiralMatrix`

### 🔥 Common Matrix Patterns:

1. Transpose + Reverse
2. Boundary traversal
3. Use row/col markers

### 🎯 Practice:

* Rotate image (Leetcode famous)
* Set matrix zeroes
* Spiral traversal
* Search in sorted matrix

---

# ✅ 12. HashSet for Sequence Detection

### Seen in:

* `longestConsecutiveSequence`

### Pattern:

```java
if(!set.contains(num-1)) start counting
```

### 🎯 Practice:

* Longest consecutive sequence
* Detect duplicates
* Cycle detection type problems

---

# ✅ 13. Mathematical Pattern (Formula Based)

### Seen in:

* `missingNumber`
* `missingNumberAndRepeatedNumber`
* `pascalsTriangle`

Uses:

* n(n+1)/2
* XOR trick
* Combination formula

### 🎯 Practice:

* Missing number
* Repeat & missing
* Pascal’s triangle
* Combinatorics problems

---

# ✅ 14. Gap Method (Shell Sort Style)

### Seen in:

* `mergeTwoSortedArrays`

Very advanced in-place merge pattern.

### 🎯 Practice:

* Merge sorted arrays without extra space
* In-place merging

---

# 🎯 What You Should Practice Based on This

If preparing for placements / FAANG:

### 🔵 Must Master (Core Array Topics)

* Sliding window
* Prefix sum + hashmap
* Kadane
* Two pointers
* 3Sum / 4Sum
* Merge sort counting
* Dutch flag
* Majority element

### 🟡 Intermediate Level

* Matrix problems
* Next permutation
* Longest consecutive sequence
* In-place merge

### 🔴 Advanced

* Reverse pairs
* Subarray XOR
* Variations of Kadane
* Merge-sort based counting

---

# 🚀 What This Codebase Tells About Your Preparation Level

You have covered:

✔ All fundamental array patterns
✔ Both brute, better, optimal approaches
✔ Good interview coverage

What you should now focus on:

* Pattern recognition speed
* Edge case handling
* Time complexity clarity
* Writing clean code in 20–25 minutes

---
