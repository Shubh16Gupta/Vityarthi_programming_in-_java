# 🔐 CodeVault – DSA Problem Tracking & Progress Management System

> **Track. Solve. Improve.**

CodeVault is a **console-based Java application** designed to help students organize, track, and analyze their **Data Structures and Algorithms (DSA)** practice.

The application provides a centralized system for managing coding problems, tracking solving progress, recording attempts, searching and filtering problems, viewing statistics, and receiving rule-based recommendations.

The project is developed using **Core Java and Object-Oriented Programming principles**, with a modular architecture and local file-based data persistence.

---

## 📌 Table of Contents

- [Overview](#-overview)
- [Problem Statement](#-problem-statement)
- [Objectives](#-objectives)
- [Key Features](#-key-features)
- [Functional Modules](#-functional-modules)
- [Technology Stack](#-technology-stack)
- [System Architecture](#-system-architecture)
- [Project Structure](#-project-structure)
- [Application Workflow](#-application-workflow)
- [Data Model](#-data-model)
- [How the Recommendation System Works](#-how-the-recommendation-system-works)
- [Prerequisites](#-prerequisites)
- [Installation & Setup](#-installation--setup)
- [Running the Application](#-running-the-application)
- [Application Menu](#-application-menu)
- [Testing](#-testing)
- [Sample Workflow](#-sample-workflow)
- [Screenshots](#-screenshots)
- [Design & Documentation](#-design--documentation)
- [Java Concepts Demonstrated](#-java-concepts-demonstrated)
- [Non-Functional Requirements](#-non-functional-requirements)
- [Future Enhancements](#-future-enhancements)
- [Project Information](#-project-information)
- [Author](#-author)
- [License](#-license)

---

# 📖 Overview

Preparing for Data Structures and Algorithms requires solving a large number of problems across different topics and difficulty levels.

As the number of problems increases, students often face difficulties such as:

- Remembering which problems have been solved
- Tracking repeated attempts
- Finding problems from a particular topic
- Monitoring overall DSA progress
- Identifying topics that need more practice
- Selecting the next problem to solve

**CodeVault** addresses these problems by providing a lightweight command-line system where students can maintain their personal DSA practice records.

The application allows users to:

```text
Register → Login → Add Problems → Track Attempts
       ↓
Search / Filter Problems
       ↓
Mark Problems Solved / Unsolved
       ↓
View Progress & Statistics
       ↓
Get Recommendations
```

CodeVault is intentionally designed as a **CLI application**, making it executable directly from a terminal without requiring a graphical environment or external server.

---

# 🎯 Problem Statement

Students commonly practice DSA problems across multiple platforms and may maintain their progress using notebooks, spreadsheets, bookmarks, or memory.

These approaches can make it difficult to maintain a centralized record of:

- Problems attempted
- Problems solved
- Number of attempts
- Problem topics
- Difficulty levels
- Overall progress
- Topic-wise performance

CodeVault provides a centralized console-based solution for storing and processing this information.

---

# 🎯 Objectives

The main objectives of CodeVault are:

1. To provide a centralized DSA problem tracking system.
2. To allow users to create and manage their profiles.
3. To organize problems according to topic and difficulty.
4. To track solved and unsolved problems.
5. To record attempts made on individual problems.
6. To provide search and filtering functionality.
7. To calculate DSA progress and statistics.
8. To identify areas with comparatively lower progress.
9. To recommend suitable unsolved problems.
10. To demonstrate Core Java and Object-Oriented Programming concepts through a practical application.

---

# ✨ Key Features

## 👤 User Management

- User registration
- User login
- Credential validation
- User profile
- Logout functionality

## 🧩 Problem Management

- Add DSA problems
- View all problems
- Search problems
- Filter by topic
- Filter by difficulty

## 📈 Progress Tracking

- Mark a problem as solved
- Mark a problem as unsolved
- Record attempts
- Calculate completion percentage

## 📊 Statistics

- Total number of problems
- Solved problems
- Unsolved problems
- Total attempts
- Topic-wise statistics
- Difficulty-wise information

## 💡 Recommendation Engine

- Analyzes existing problem data
- Identifies lower-progress topics
- Finds suitable unsolved problems
- Provides a rule-based recommendation

## 💾 Data Persistence

- Stores application data locally
- Loads existing data when the application starts
- Saves changes for future sessions

## 🛡️ Input Validation

- Validates menu choices
- Validates problem IDs
- Validates topics
- Validates difficulty
- Handles invalid input

---

# 🧩 Functional Modules

CodeVault is divided into multiple meaningful modules.

### 1. User Management

Responsible for:

```text
Registration
Login
Logout
Profile
Credential Validation
```

Main classes:

```text
User.java
UserManager.java
```

---

### 2. Problem Management

Responsible for:

```text
Add Problem
View Problems
Search Problem
Filter by Topic
Filter by Difficulty
```

Main classes:

```text
Problem.java
ProblemManager.java
```

---

### 3. Progress Tracking

Responsible for:

```text
Mark Solved
Mark Unsolved
Record Attempts
Calculate Progress
```

Main class:

```text
ProgressTracker.java
```

---

### 4. Statistics & Analytics

Responsible for processing stored problem information and generating useful statistics.

Main class:

```text
Statistics.java
```

---

### 5. Recommendation

Responsible for analyzing problem progress and recommending an unsolved problem.

Main class:

```text
RecommendationEngine.java
```

---

### 6. Data Persistence

Responsible for storing and retrieving application information.

Main class:

```text
FileManager.java
```

---

### 7. Input Validation

Responsible for validating user input before processing.

Main class:

```text
InputValidator.java
```

---

# 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| Java | Primary programming language |
| Core Java | Application development |
| OOP | Modular object-oriented design |
| Java Collections | Managing problem/user data |
| File I/O | Local data persistence |
| Exception Handling | Runtime error management |
| Git | Version control |
| GitHub | Source code hosting |
| Terminal / CLI | Application interface |

---

# 🏗️ System Architecture

CodeVault follows a modular architecture.

```text
                         ┌───────────────┐
                         │     USER      │
                         └───────┬───────┘
                                 │
                                 ▼
                         ┌───────────────┐
                         │   CLI /       │
                         │   Console     │
                         └───────┬───────┘
                                 │
                                 ▼
                         ┌───────────────┐
                         │     Main      │
                         │    .java      │
                         └───────┬───────┘
                                 │
              ┌──────────────────┼──────────────────┐
              │                  │                  │
              ▼                  ▼                  ▼
       ┌─────────────┐    ┌─────────────┐    ┌──────────────┐
       │    User     │    │   Problem   │    │   Progress   │
       │   Manager   │    │   Manager   │    │   Tracker    │
       └─────────────┘    └─────────────┘    └──────┬───────┘
              │                  │                  │
              └──────────────────┼──────────────────┘
                                 │
                                 ▼
                    ┌────────────────────────┐
                    │ Statistics & Analytics │
                    └────────────┬───────────┘
                                 │
                                 ▼
                    ┌────────────────────────┐
                    │ Recommendation Engine  │
                    └────────────┬───────────┘
                                 │
                                 ▼
                         ┌───────────────┐
                         │ File Manager  │
                         └───────┬───────┘
                                 │
                                 ▼
                         ┌───────────────┐
                         │ Local Storage │
                         └───────────────┘
```

---

# 📁 Project Structure

```text
CodeVault/
│
├── README.md
├── statement.md
├── .gitignore
│
├── src/
│   └── codevault/
│       ├── Main.java
│       ├── User.java
│       ├── Problem.java
│       ├── UserManager.java
│       ├── ProblemManager.java
│       ├── ProgressTracker.java
│       ├── Statistics.java
│       ├── RecommendationEngine.java
│       ├── FileManager.java
│       └── InputValidator.java
│
├── data/
│   └── .gitkeep
│
├── docs/
│   ├── architecture/
│   │   └── system-architecture.png
│   │
│   ├── diagrams/
│   │   ├── use-case-diagram.png
│   │   ├── workflow-diagram.png
│   │   ├── sequence-diagram.png
│   │   ├── class-diagram.png
│   │   └── storage-design.png
│   │
│   └── screenshots/
│       ├── 01-main-menu.png
│       ├── 02-registration.png
│       ├── 03-login.png
│       ├── 04-add-problem.png
│       ├── 05-view-problems.png
│       ├── 06-search-filter.png
│       ├── 07-progress.png
│       ├── 08-statistics.png
│       └── 09-recommendation.png
│
└── report/
    └── CodeVault_Project_Report.pdf
```

---

# 🔄 Application Workflow

The general application workflow is:

```text
START
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
Register         Login
                  │
                  ▼
            Validate Credentials
                  │
             ┌────┴────┐
             │         │
           Invalid    Valid
             │         │
             ▼         ▼
          Error     Dashboard
                       │
                       ▼
                Select Operation
                       │
       ┌───────────────┼────────────────┐
       │               │                │
       ▼               ▼                ▼
    Problems        Progress        Analytics
       │               │                │
       └───────────────┼────────────────┘
                       │
                       ▼
                 Update / Read Data
                       │
                       ▼
                  Save Changes
                       │
                       ▼
                Continue / Logout
                       │
                       ▼
                      END
```

---

# 🗃️ Data Model

CodeVault uses local file-based storage rather than a relational database.

## User

A user contains information such as:

```text
User
├── userId
├── name
├── username
└── password
```

## Problem

A problem contains:

```text
Problem
├── problemId
├── title
├── topic
├── difficulty
├── solved
└── attempts
```

Conceptual relationship:

```text
┌──────────────┐
│     USER     │
├──────────────┤
│ userId       │
│ name         │
│ username     │
│ password     │
└──────┬───────┘
       │
       │ owns
       │
       │ 1 : N
       ▼
┌──────────────┐
│   PROBLEM    │
├──────────────┤
│ problemId    │
│ title        │
│ topic        │
│ difficulty   │
│ solved       │
│ attempts     │
└──────────────┘
```

---

# 💡 How the Recommendation System Works

CodeVault uses a **rule-based recommendation approach**.

It does not use machine learning.

The recommendation process is:

```text
Problem Collection
       │
       ▼
Calculate Topic Progress
       │
       ▼
Identify Lower-Progress Topic
       │
       ▼
Find Unsolved Problems
       │
       ▼
Select Suitable Problem
       │
       ▼
Display Recommendation
```

For example:

```text
Array          → 80% solved
String         → 70% solved
Linked List    → 60% solved
Tree           → 40% solved
Graph          → 20% solved
DP             → 10% solved
```

The system can use the lower-progress areas when selecting an appropriate unsolved problem.

This provides a simple personalized practice mechanism while keeping the implementation within the scope of Core Java.

---

# 📋 Supported DSA Topics

CodeVault supports the following topics:

```text
1. Array
2. String
3. Linked List
4. Stack
5. Queue
6. Tree
7. Graph
8. DP
9. Sorting
10. Searching
```

---

# 🎚️ Difficulty Levels

Problems can be categorized into:

```text
Easy
Medium
Hard
```

---

# 💻 Prerequisites

Before running CodeVault, make sure the following are installed:

### Java Development Kit

JDK 17 or a compatible newer JDK is recommended.

Check your Java installation:

```bash
java -version
```

Check the Java compiler:

```bash
javac -version
```

### Git

Check Git:

```bash
git --version
```

No database server, web server, or GUI framework is required.

---

# 🚀 Installation & Setup

## 1. Clone the Repository

```bash
git clone https://github.com/[YOUR-GITHUB-USERNAME]/CodeVault.git
```

Replace `[YOUR-GITHUB-USERNAME]` with your GitHub username.

---

## 2. Enter the Project Directory

```bash
cd CodeVault
```

---

## 3. Compile the Source Code

For the package-based project structure:

```bash
mkdir -p out
javac -d out src/codevault/*.java
```

If the project is compiled successfully, no compilation errors should be displayed.

---

# ▶️ Running the Application

After compilation, execute:

```bash
java -cp out codevault.Main
```

The application will start in the terminal.

You should see:

```text
========================================
              CODEVAULT
          Track. Solve. Improve.
========================================
1. Register
2. Login
3. Exit
Enter choice:
```

---

# 📋 Application Menu

After successful login, the user is presented with the main dashboard.

```text
========================================
Welcome, [Username]!

1. Add Problem
2. View All Problems
3. Search Problem
4. Filter by Topic
5. Filter by Difficulty
6. Mark Problem Solved
7. Record Attempt
8. Mark Problem Unsolved
9. View Progress
10. View Statistics
11. Get Recommendation
12. Profile
13. Logout
```

---

# 🧪 Testing

The application should be tested through normal and invalid user inputs.

## Functional Tests

| Test | Description | Expected Result |
|---|---|---|
| Registration | Register with valid details | Account created |
| Login | Enter valid credentials | Dashboard displayed |
| Invalid Login | Enter incorrect credentials | Error displayed |
| Add Problem | Enter valid problem details | Problem stored |
| View Problems | Select View All Problems | Problems displayed |
| Search | Enter problem keyword | Matching problems displayed |
| Topic Filter | Select a topic | Relevant problems displayed |
| Difficulty Filter | Select difficulty | Relevant problems displayed |
| Mark Solved | Enter valid problem ID | Status changed to solved |
| Record Attempt | Enter valid problem ID | Attempt count increases |
| Mark Unsolved | Enter valid problem ID | Status changed |
| Progress | Select progress | Progress information displayed |
| Statistics | Select statistics | Statistical information displayed |
| Recommendation | Select recommendation | Problem recommendation displayed |
| Profile | Select profile | User information displayed |
| Logout | Select logout | Returned to main menu |

---

# ⚠️ Input Validation Tests

The application also handles invalid inputs.

Examples include:

```text
Invalid menu choice
Invalid topic
Invalid difficulty
Invalid problem ID
Empty input
Incorrect login credentials
Invalid numerical input
```

Example:

```text
Enter choice: 99

Invalid choice.
Please try again.
```

---

# 🔁 Sample Workflow

A typical CodeVault session can look like:

```text
1. Register
      ↓
Enter name
      ↓
Enter username
      ↓
Enter password
      ↓
Registration Successful
      ↓
2. Login
      ↓
Enter username
      ↓
Enter password
      ↓
Login Successful
      ↓
Add Problem
      ↓
Enter title
      ↓
Select topic
      ↓
Select difficulty
      ↓
Problem Added
      ↓
Record Attempt
      ↓
Mark Problem Solved
      ↓
View Progress
      ↓
View Statistics
      ↓
Get Recommendation
      ↓
Logout
```

---

# 📸 Screenshots

Screenshots demonstrating the application are stored in:

```text
docs/screenshots/
```

Recommended screenshots include:

### Main Menu

![Main Menu](docs/screenshots/01-main-menu.png)

### Registration

![Registration](docs/screenshots/02-registration.png)

### Login

![Login](docs/screenshots/03-login.png)

### Add Problem

![Add Problem](docs/screenshots/04-add-problem.png)

### View Problems

![View Problems](docs/screenshots/05-view-problems.png)

### Search / Filter

![Search and Filter](docs/screenshots/06-search-filter.png)

### Progress

![Progress](docs/screenshots/07-progress.png)

### Statistics

![Statistics](docs/screenshots/08-statistics.png)

### Recommendation

![Recommendation](docs/screenshots/09-recommendation.png)

> Screenshots should be updated with actual screenshots from the final version of the application.

---

# 📐 Design & Documentation

Detailed project documentation and design artifacts are available in the `docs/` directory.

The project includes:

### System Architecture

```text
docs/architecture/system-architecture.png
```

### Use Case Diagram

```text
docs/diagrams/use-case-diagram.png
```

### Workflow Diagram

```text
docs/diagrams/workflow-diagram.png
```

### Sequence Diagram

```text
docs/diagrams/sequence-diagram.png
```

### Class Diagram

```text
docs/diagrams/class-diagram.png
```

### Storage Design

```text
docs/diagrams/storage-design.png
```

---

# ☕ Java Concepts Demonstrated

CodeVault demonstrates several important Core Java concepts.

## Object-Oriented Programming

The project uses classes and objects to represent entities such as:

```text
User
Problem
```

---

## Encapsulation

Data belonging to objects is maintained within the respective classes and accessed through appropriate methods.

---

## Abstraction

Different system responsibilities are represented through separate classes.

For example:

```text
ProblemManager
ProgressTracker
Statistics
FileManager
```

---

## Java Collections

Collections are used to maintain and process groups of users and problems.

Examples include dynamic collections such as `ArrayList`.

---

## File Handling

Java file I/O is used to maintain persistent application data.

---

## Exception Handling

The application handles invalid input and common runtime errors.

---

## Modular Programming

The project separates responsibilities into multiple classes instead of implementing the complete application inside a single class.

---

## Searching and Filtering

The application implements logical processing for:

```text
Search by title/keyword
Filter by topic
Filter by difficulty
```

---

## Data Processing

The Statistics and Recommendation components process stored problem data to generate meaningful output.

---

# ⚙️ Non-Functional Requirements

## Usability

The application provides a simple numbered menu system suitable for command-line users.

## Performance

The application is designed to efficiently process a personal collection of DSA problems.

## Reliability

The system validates user input and handles common invalid operations.

## Maintainability

The application is divided into multiple classes with clearly defined responsibilities.

## Error Handling

Invalid input, incorrect IDs, and unsupported options are handled through validation and error messages.

## Resource Efficiency

The application requires minimal system resources and does not require an external server or database.

---

# 🔮 Future Enhancements

Possible future improvements include:

### 🗄️ Database Integration

Integration with MySQL or another database using JDBC.

### 🖥️ Graphical Interface

Development of a GUI using JavaFX or another Java-based framework.

### 📊 Advanced Analytics

Additional analytics such as:

- Topic mastery
- Difficulty progression
- Average attempts
- Solving trends
- Daily/weekly activity

### 🔥 Coding Streak

Track daily DSA practice and maintain coding streaks.

### 🤖 Advanced Recommendation

The rule-based recommendation system could be extended using more detailed user activity and historical performance.

### 🌐 Online Platform Integration

Future versions could integrate with coding platforms through supported APIs.

### ☁️ Cloud Storage

User data could be synchronized across multiple devices.

---

# 📚 Project Documentation

The complete project report is available at:

```text
report/CodeVault_Project_Report.pdf
```

The report contains:

```text
1. Cover Page
2. Introduction
3. Problem Statement
4. Objectives
5. Functional Requirements
6. Non-Functional Requirements
7. System Architecture
8. Design Diagrams
9. Design Decisions & Rationale
10. Implementation Details
11. Screenshots / Results
12. Testing Approach
13. Challenges Faced
14. Learnings & Key Takeaways
15. Future Enhancements
16. Conclusion
17. References
```

---

# 📂 Repository Requirements

This project follows a modular repository structure containing:

- Root-level README
- Project statement
- Java source code
- Local storage directory
- Architecture documentation
- UML/design diagrams
- Application screenshots
- Project report

The application is executable directly from the command line.

---

# 👨‍💻 Project Information

| Attribute | Details |
|---|---|
| Project Name | CodeVault |
| Project Type | Console-Based Java Application |
| Domain | DSA Practice Management |
| Programming Language | Java |
| Interface | Command Line |
| Architecture | Modular OOP |
| Storage | Local File-Based Storage |
| Recommendation | Rule-Based |
| Version Control | Git |
| Repository | GitHub |
| Course | Programming in Java |
| University | VIT Bhopal University |
| Academic Year | 2026–2027 |

---

# 👤 Author

## Shubh Gupta

**B.Tech Computer Science and Engineering – Artificial Intelligence and Machine Learning**

**VIT Bhopal University**

GitHub:  
`https://github.com/Shubh16Gupta`

---

# 📜 License

This project was developed as an academic project for educational purposes.

---

# ⭐ CodeVault

> **Track your problems. Measure your progress. Improve your DSA journey.**

---
