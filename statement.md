# CodeVault – DSA Problem Tracking & Progress Management System

## 1. Problem Statement

Data Structures and Algorithms (DSA) is an important part of computer science education, coding interviews, competitive programming, and software development preparation. Students typically solve a large number of DSA problems across different topics such as Arrays, Strings, Linked Lists, Stacks, Queues, Trees, Graphs, Dynamic Programming, Sorting, and Searching.

As the number of practice problems increases, manually tracking them becomes difficult. Students may forget which problems they have already solved, how many attempts they made, which topics they have practiced, and which areas require additional attention.

Using notebooks, spreadsheets, bookmarks, or separate platform histories also makes it difficult to maintain a single, structured view of DSA preparation.

The absence of a simple and centralized practice-tracking system can lead to:

- Difficulty maintaining a record of solved and unsolved problems.
- Difficulty tracking repeated attempts.
- Difficulty searching for previously practiced problems.
- Difficulty filtering problems by topic or difficulty.
- Lack of a clear overview of overall DSA progress.
- Difficulty identifying topics with comparatively lower progress.
- Difficulty deciding which problem to practice next.

**CodeVault** is proposed as a console-based Java application to address these problems. It provides a centralized environment where users can store DSA problems, organize them by topic and difficulty, track solving status and attempts, analyze progress, and receive rule-based problem recommendations.

The system focuses on **managing the user's DSA practice journey rather than solving the DSA problems themselves**.

---

# 2. Project Scope

CodeVault focuses on providing a lightweight, command-line-based DSA practice management system for individual users.

The current scope includes the following areas:

### 2.1 User Management

The system allows users to:

- Register an account.
- Log in using their credentials.
- Access their personal CodeVault dashboard.
- View their profile.
- Log out of the application.

### 2.2 DSA Problem Management

Users can maintain their personal collection of DSA problems by:

- Adding new problems.
- Viewing all stored problems.
- Searching for problems.
- Filtering problems by topic.
- Filtering problems by difficulty.

### 2.3 Progress Tracking

The system allows users to:

- Mark problems as solved.
- Mark problems as unsolved.
- Record attempts for individual problems.
- Monitor overall solving progress.

### 2.4 Statistics and Analytics

CodeVault processes stored problem information to provide:

- Total problem count.
- Solved problem count.
- Unsolved problem count.
- Attempt information.
- Completion percentage.
- Topic-wise progress.
- Difficulty-wise information.

### 2.5 Recommendation

The system provides a basic rule-based recommendation mechanism.

It analyzes the user's existing problem data and identifies areas with comparatively lower progress. It then attempts to recommend an appropriate unsolved problem from those areas.

### 2.6 Local Data Persistence

The application uses local file-based storage so that relevant application data can be saved and loaded across different executions.

### 2.7 Current Limitations

The current version intentionally remains a **console-based Java application**.

The project does not currently include:

- A graphical user interface.
- A web interface.
- A remote database.
- Cloud synchronization.
- Automatic integration with online coding platforms.
- Machine-learning-based recommendations.
- Automatic submission or execution of solutions on coding platforms.

These features may be considered for future versions.

---

# 3. Target Users

The primary target users of CodeVault are students and individuals who regularly practice Data Structures and Algorithms.

## 3.1 DSA Students

Students learning fundamental data structures and algorithms can use CodeVault to maintain a structured record of their practice.

## 3.2 Coding Interview Aspirants

Students preparing for technical interviews can use the application to track solved problems, attempts, topics, and difficulty levels.

## 3.3 Competitive Programming Beginners

Beginners can use CodeVault to organize their practice and gradually monitor their progress across different DSA topics.

## 3.4 Self-Learners

Individuals learning DSA independently can use the application as a personal problem-tracking system.

---

# 4. High-Level Features

The major features of CodeVault are:

## 4.1 User Registration and Login

Users can create an account and authenticate themselves before accessing their personal dashboard.

---

## 4.2 Add DSA Problem

Users can add a problem by providing information such as:

- Problem title
- Topic
- Difficulty

Each problem is maintained as a separate problem record.

---

## 4.3 View All Problems

Users can display all problems currently stored in their collection.

---

## 4.4 Search Problems

Users can search for problems using a title or relevant keyword.

---

## 4.5 Filter by Topic

Problems can be filtered according to DSA topics such as:

- Array
- String
- Linked List
- Stack
- Queue
- Tree
- Graph
- Dynamic Programming
- Sorting
- Searching

---

## 4.6 Filter by Difficulty

Problems can be categorized and filtered using:

- Easy
- Medium
- Hard

---

## 4.7 Track Solving Status

Users can maintain whether a problem is:

```text
Solved
Unsolved
```

---

## 4.8 Record Attempts

Users can record attempts made while solving a problem.

This provides additional information about their problem-solving history.

---

## 4.9 Progress Tracking

The application calculates and displays information about the user's overall DSA practice progress.

For example:

```text
Total Problems
Solved Problems
Unsolved Problems
Completion Percentage
```

---

## 4.10 Statistics

The system processes stored data to provide useful statistics, including topic-wise and difficulty-wise information.

---

## 4.11 Recommendation Engine

The application contains a rule-based recommendation component that uses the user's existing problem data to identify areas requiring additional practice and recommend an unsolved problem.

---

## 4.12 Local Data Persistence

The application saves relevant information locally so that data can be retrieved when the application is started again.

---

# 5. Major Functional Modules

CodeVault is divided into multiple functional modules.

### Module 1 – User Management

Responsible for:

```text
Registration
Login
Profile
Logout
```

Primary classes:

```text
User.java
UserManager.java
```

### Module 2 – Problem Management

Responsible for:

```text
Add Problem
View Problems
Search
Topic Filtering
Difficulty Filtering
```

Primary classes:

```text
Problem.java
ProblemManager.java
```

### Module 3 – Progress & Analytics

Responsible for:

```text
Mark Solved
Mark Unsolved
Record Attempts
Calculate Progress
Generate Statistics
```

Primary classes:

```text
ProgressTracker.java
Statistics.java
```

### Supporting Components

```text
Main.java
RecommendationEngine.java
FileManager.java
InputValidator.java
```

These components coordinate application execution, recommendations, persistence, and validation.

---

# 6. Expected User Workflow

The intended high-level workflow is:

```text
Start Application
       │
       ▼
Load Existing Data
       │
       ▼
Main Menu
       │
       ├───────────────┐
       │               │
       ▼               ▼
   Register           Login
                       │
                       ▼
              Validate Credentials
                       │
                       ▼
                   Dashboard
                       │
                       ▼
               Select Operation
                       │
        ┌──────────────┼──────────────┐
        │              │              │
        ▼              ▼              ▼
     Problems       Progress      Analytics
        │              │              │
        └──────────────┼──────────────┘
                       │
                       ▼
                  Process Data
                       │
                       ▼
                  Save Changes
                       │
                       ▼
                 Continue / Logout
```

---

# 7. Project Objective

The overall objective of CodeVault is to demonstrate how Core Java and Object-Oriented Programming concepts can be applied to develop a practical software solution for managing DSA practice.

The project aims to combine:

```text
User Management
        +
Problem Management
        +
Progress Tracking
        +
Statistics
        +
Recommendation
        +
File Persistence
        +
Input Validation
```

into one modular command-line application.

---

# 8. Technology Scope

The project is implemented using:

- Java
- Core Java APIs
- Object-Oriented Programming
- Java Collections
- File Input/Output
- Exception Handling
- Input Validation
- Git
- GitHub

The application is designed to run directly from a terminal without requiring a graphical user interface, web server, or external database.

---

# 9. Out of Scope

The following capabilities are outside the scope of the current version:

1. Automatic execution of submitted DSA solutions.
2. Online judge functionality.
3. Real-time synchronization with coding platforms.
4. Cloud-based user accounts.
5. Multi-user online collaboration.
6. Machine-learning-based prediction.
7. Web-based dashboard.
8. Mobile application.
9. Graphical user interface.
10. Online database infrastructure.

These capabilities can be explored as future enhancements.

---

# 10. Success Criteria

The project will be considered successful when the application can:

- Allow a user to register and log in.
- Allow authenticated users to add DSA problems.
- Display stored problems.
- Search and filter problems.
- Track solved and unsolved status.
- Record problem attempts.
- Calculate meaningful progress information.
- Generate statistics from stored data.
- Provide a rule-based recommendation.
- Save and load application data.
- Handle common invalid inputs without crashing.
- Run successfully through the command line.

---

# 11. Summary

CodeVault is a **console-based DSA Problem Tracking and Progress Management System** developed using Core Java.

It addresses the problem of maintaining and analyzing DSA practice records by providing a centralized system for:

```text
Manage → Track → Analyze → Improve
```

The project focuses on modular design, object-oriented programming, data processing, file persistence, input validation, and a practical command-line user experience.

The system is designed primarily for students and DSA learners who want a structured way to manage their problem-solving journey.
