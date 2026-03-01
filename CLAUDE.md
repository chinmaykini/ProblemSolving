# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview

A collection of standalone Java algorithm and data structure problems. Each `.java` file is a self-contained solution with its own `main` method — there is no shared build system, framework, or package structure.

## Build & Run

There is no build tool (Maven, Gradle, etc.). Files are compiled and run directly with `javac`/`java`:

```bash
javac KadaneAlgo.java
java KadaneAlgo
```

The Eclipse `.project` and `.classpath` files treat the repo root as both source and output directory. No packages are used — all classes are in the default package.

## Conventions

- One problem per file, named after the algorithm or problem (e.g., `KadaneAlgo.java`, `BoggleSolver.java`).
- Each file contains a single public class matching the filename with a `public static void main` entry point.
- No external dependencies — only the Java standard library.
- Test inputs are hardcoded in `main` methods; there is no test framework.

## Algorithm Quality Scores

| # | File | Score /10 | Notes |
|---|------|:---------:|-------|
| 1 | IsomorphicWords.java | 9 | Correct bidirectional mapping, clean logic, O(n) |
| 2 | DutchNationalFlag.java | 9 | Textbook 3-way partition, O(n) time, O(1) space |
| 3 | KthFrequentWord.java | 8 | Good min-heap approach for top-K, clean design |
| 4 | ReverseWords.java | 8 | Solid in-place word reversal, O(n) |
| 5 | PermutationsOfSet.java | 8 | Correct cartesian product, well-commented |
| 6 | PermutationString.java | 8 | Two approaches (swap + loop), both correct |
| 7 | ReverseString.java | 8 | Good iterative + recursive, minor inefficiency in recursive (string concat) |
| 8 | ProductArray.java | 8 | Correct left/right product approach, could optimize space |
| 9 | KthSmallest.java | 8 | Good QuickSelect with randomized pivot |
| 10 | Guards.java | 8 | Clean BFS implementation, good boundary handling |
| 11 | BalancedParathesis.java | 8 | Correct stack-based validation, good edge case checks |
| 12 | XOR.java | 7 | Elegant O(n)/O(1) but no edge case handling |
| 13 | PowerSet.java | 7 | Correct but exponential space (expected), well-commented |
| 14 | ConWays.java | 7 | Working Game of Life with toroidal wrap, moderate clarity |
| 15 | TaskAssignToServers.java | 7 | Good PriorityQueue greedy, acknowledges limitations |
| 16 | AllPossibleCodes.java | 7 | Correct recursive decoding, misses '0' edge cases |
| 17 | PrettyNumberFormatting.java | 7 | Works for formatting bytes, weak on 0/negative |
| 18 | RPN.java | 7 | Correct evaluator, no division-by-zero or error handling |
| 19 | Power.java | 7 | Fast exponentiation O(log n), multiple approaches shown |
| 20 | NumberBaseRespresenation.java | 7 | Correct conversion, trailing comma in output |
| 21 | KadaneAlgo.java | 7 | O(n) but fails on all-negative arrays |
| 22 | PrimeFactors.java | 7 | Correct O(sqrt n), no handling for 0/1/negatives |
| 23 | DistanceBetweenWords.java | 7 | Works but fragile edge case logic |
| 24 | RotatedSortedArray.java | 6 | Bug: `right = mid+1` should be `mid-1`, can infinite loop |
| 25 | QueueUsingStack.java | 6 | Works but O(n) enqueue via recursion; two-stack approach is better |
| 26 | NumberEnglishRepresentation.java | 6 | Mostly works, zero case broken, typo "ninteen" |
| 27 | ArithmaticProgression.java | 6 | Correct for happy path, no input validation, unused imports |
| 28 | ATOI.java | 5 | Bug: `arr.length<0` always false, no whitespace/'+' handling |
| 29 | CoinFlip.java | 5 | Correct but cryptic variable names, hard to follow |
| 30 | RomanNumerals.java | 5 | `integerToRoman()` not implemented, incomplete numeral map |
| 31 | FactorCombinations.java | 5 | Unusual approach, may produce duplicates |
| 32 | CombinationsAlphabet.java | 4 | Confusing `lastIndexOf` logic, likely buggy |
| 33 | Enumoperations.java | 3 | Skeletal/incomplete, off-by-one bug, empty method stubs |
| 34 | BoggleSolver.java | N/A | Entire file is commented out |
