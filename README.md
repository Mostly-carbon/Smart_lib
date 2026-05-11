# Smart Library System

A console-based university library management system developed for a Data Structures group project.

The system demonstrates the practical implementation of:
- Binary Search Tree (BST)
- Stack
- Recursion
- Abstract Data Type (ADT)
- Information Hiding and Encapsulation

Books are stored in a Binary Search Tree indexed by ISBN for efficient searching, while borrowing history is maintained using a Stack to display the most recent activity first.

---

## Features

- Add new books to the library catalogue
- Search books by ISBN using recursive BST search
- Borrow books from the catalogue
- Store borrowing history using Stack (LIFO)
- View borrowing history
- Menu-driven console interface

---

## Data Structures Used

### Binary Search Tree (BST)
Used to store and manage book records efficiently by ISBN.

Operations:
- Insert Book
- Search Book
- Delete Book

Average search complexity:

```text
O(log n)
```

---

### Stack
Used to maintain borrowing history.

Implements:
```text
LIFO (Last-In-First-Out)
```

Most recently borrowed books appear first.

---

## Project Structure

```text
smart-library-system/
│
├── README.md
├── docs/
│
├── src/
│   ├── model/
│   │   └── Book.java
│   │
│   ├── bst/
│   │   ├── BSTNode.java
│   │   └── BookBST.java
│   │
│   ├── stack/
│   │   ├── StackNode.java
│   │   └── HistoryStack.java
│   │
│   ├── adt/
│   │   └── LibraryADT.java
│   │
│   ├── system/
│   │   └── LibrarySystem.java
│   │
│   ├── ui/
│   │   └── ConsoleMenu.java
│   │
│   └── Main.java
│
└── test/
```

---

## System Workflow

### Add Book
```text
User Input
    ↓
Create Book Object
    ↓
Insert into BST
```

### Search Book
```text
Enter ISBN
    ↓
Recursive BST Search
    ↓
Display Result
```

### Borrow Book
```text
Search BST
    ↓
Remove Book from BST
    ↓
Push into History Stack
```

### View History
```text
Display Stack Contents
(Most Recent First)
```

---

## Object-Oriented Concepts Applied

- Encapsulation
- Abstraction
- Information Hiding
- Modular Design
- Interface-based Architecture

---

## Technologies Used

- Java
- GitHub
- Visual Studio Code

---

## Running the Program

1. Clone the repository
2. Open the project in a Java IDE or VS Code
3. Compile the Java files
4. Run `Main.java`

---

## Team Responsibilities

| Member | Responsibility |
|--------|----------------|
| Member 1 | ADT Design and Architecture |
| Member 2 | BST and Stack Implementation |
| Member 3 | Recursive Search |
| Member 4 | Admin Logic and Console Interface |

---

## Console Interface

```text
===== SMART LIBRARY SYSTEM =====

1. Add Book
2. Search Book
3. Borrow Book
4. View History
5. Exit
```
