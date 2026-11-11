# Project README

## Table of Contents
1. Introduction
2. Recursive Multithreaded Subset Sum Algorithm
3. Thread Synchronization
4. Data Structure Refactoring to `ArrayList<Integer>`
5. Code Documentation with Javadoc
6. Authors and Git Collaboration Roles
7. License

## 1. Introduction
This project implements a recursive multithreaded Subset Sum algorithm using Java. The algorithm checks if a given target value `b` can be matched by any subset of an array of integers. Two threads, `thread1` and `thread2`, run concurrently to check the array and update shared data.

## 2. Recursive Multithreaded Subset Sum Algorithm
The algorithm uses recursion to explore all possible subsets of the array. Each thread checks if the target value can be matched by any subset starting from a specific index. The threads communicate through a shared `SharedData` object to synchronize their progress and update the flag when the target value is matched.

## 3. Thread Synchronization
Thread synchronization is achieved using synchronized blocks and methods. The `SharedData` class contains a `flag` that indicates whether the target value has been matched. Threads check this flag before proceeding with further computations, ensuring that only one thread updates the shared data when the target value is found.

## 4. Data Structure Refactoring to `ArrayList<Integer>`
The project refactors the use of arrays to `ArrayList<Integer>` in multiple files (`SharedData.java`, `TestThreadCheckArray.java`, `ThreadCheckArray.java`). This change improves flexibility and readability, allowing dynamic resizing of the array without needing to know its size upfront.

## 5. Code Documentation with Javadoc
Javadoc comments are used extensively throughout the project to document classes, methods, and variables. This ensures that other developers can easily understand the purpose and functionality of each part of the code.

```java
/**
 * A class that represents shared data with an integer array and boolean arrays.
 */
public class SharedData {
    // ... class implementation ...
}

/**
 * Represents a thread that checks an array to determine if it can match a given target value.
 */
public class ThreadCheckArray implements Runnable {
    // ... class implementation ...
}
```

## 6. Authors and Git Collaboration Roles

### Authors
- Liron Skverchak
- Leen Abu Salah

### Git Collaboration Roles
- **Student A (Liron Skverchak):** Created the GitHub repository and the initial commit, refactored `SharedData.java` and `ThreadCheckArray.java` on the `main` branch, and generated this `README.md`.
- **Student B (Leen Abu Salah):** Cloned the repository, worked on the `feature/arraylist-refactor-b` branch, refactored `TestThreadCheckArray.java` and `ThreadCheckArray.java`, merged the branch into `main`, and resolved the merge conflict using IntelliJ IDEA's 3-Way Merge tool.

## 7. License
This project is licensed under the 'Braude College Academic License'.