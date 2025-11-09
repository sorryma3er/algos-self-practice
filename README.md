# Algorithms Practice Repository

This repository contains self-practice implementations of algorithms and data structures in **Python**, **Java**, and **C#**.  
The purpose of this project is to build a strong understanding of fundamental problem-solving patterns and data structure design through hands-on coding practice.

---

## Directory Overview

### 1. Data_Structure_Review/
This directory contains core data structure implementations written for review and reinforcement of fundamental concepts.  

Each subfolder contains source code files in one or more languages (mainly Python and Java), along with small test programs demonstrating usage.

### 2. Problems/
This directory includes individual algorithm problems, each stored in its own folder.  
Each problem folder generally contains:
- One or more implementations of the same problem in Python, Java, or C#  
- Focus on time and space complexity efficiency  
- Clear function-oriented or class-based solutions

The goal is to maintain a consistent naming convention and a comparable style across languages for easier study and reference.

---

## Example Usage

### Java Example (Queue Implementation)
```java
LinkedListQueue queue = new LinkedListQueue();
queue.push(10);
queue.push(20);
System.out.println(queue.peek());
System.out.println(queue.pop());
System.out.println(queue.isEmpty());