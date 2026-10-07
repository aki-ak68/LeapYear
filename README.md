# Leap Year Kata

A simple **Leap Year Kata** implemented using **Java 17**, **Maven**, and **JUnit 6**.

This project follows a **Test-Driven Development (TDD)** approach using the **Red → Green → Refactor** cycle. The implementation was developed incrementally by first writing tests, implementing the minimum required logic, and then refactoring while keeping all tests passing.

---

## Overview

The purpose of this kata is to determine whether a given year is a leap year according to the Gregorian calendar rules.

The project also validates the input year and rejects zero or negative values.

### Key Objectives

* Implement leap year business rules
* Follow Test-Driven Development
* Write unit tests using JUnit
* Handle edge cases
* Validate invalid input
* Refactor without changing existing behavior
* Maintain a clean and meaningful Git history

---

## Requirements

A year is a leap year if:

1. The year is divisible by **400**.
2. The year is divisible by **4** but not divisible by **100**.

Otherwise, the year is not a leap year.

### Examples

| Year | Result  | Reason                          |
| ---- | ------- | ------------------------------- |
| 2000 | `true`  | Divisible by 400                |
| 2400 | `true`  | Divisible by 400                |
| 2016 | `true`  | Divisible by 4 and not by 100   |
| 2012 | `true`  | Divisible by 4 and not by 100   |
| 1900 | `false` | Divisible by 100 but not by 400 |
| 1800 | `false` | Divisible by 100 but not by 400 |
| 2017 | `false` | Not divisible by 4              |
| 2018 | `false` | Not divisible by 4              |

---

## Input Validation

The application accepts only positive years.

| Input  | Expected Behavior                 |
| ------ | --------------------------------- |
| `2000` | Valid                             |
| `2024` | Valid                             |
| `0`    | Throws `IllegalArgumentException` |
| `-1`   | Throws `IllegalArgumentException` |

Invalid years are rejected before the leap year calculation is performed.

---

## Technology Stack

* **Java 17**
* **Maven**
* **JUnit 6**
* **IntelliJ IDEA**
* **Git**

---

## Project Structure

```text
leap-year-kata/
├── pom.xml
├── README.md
└── src/
    ├── main/
    │   └── java/
    │       └── LeapYear.java
    │
    └── test/
        └── java/
            └── LeapYearTest.java
```

### Main Class

`LeapYear.java`

Contains the business logic for determining whether a year is a leap year.

### Test Class

`LeapYearTest.java`

Contains unit tests covering leap year rules, century years, divisible-by-400 years, and invalid input.

---

# Test-Driven Development Approach

The project was implemented using the **TDD Red → Green → Refactor** cycle.

The implementation was built incrementally rather than writing the complete solution at once.

---

## Step 1 – Project Setup

The Maven project was created with Java 17 and JUnit configured for unit testing.

The project was structured with separate production and test source directories.

The initial goal was to create a clean foundation for implementing the kata using TDD.

---

## Step 2 – Write the First Failing Test

The first test was written for a year that is not divisible by four.

For example:

```text
2017 → false
```

At this point, the required production logic had not been implemented.
### TDD State

**RED** — The test failed because the required behavior was not yet implemented.
![Project Screenshot](https://github.com/aki-ak68/LeapYear/blob/d952089440e03a41200bdbc19f1d0c3176143a69/leap-year-kata/FirstTestfail.png)

---

## Step 3 – Implement the Basic Leap Year Rule

The minimum implementation required to satisfy the first test was added.

The initial rule was:

> A year divisible by four is considered a leap year.

Only the required behavior was implemented at this stage.

### TDD State

**GREEN** — The test passed successfully.
![Project Screenshot](https://github.com/aki-ak68/LeapYear/blob/d952089440e03a41200bdbc19f1d0c3176143a69/leap-year-kata/shouldReturnFalseWhenYearIsNotDivisibleByFour_test2.png)
---

## Step 4 – Add Tests for Years Divisible by Four

Additional test cases were added to verify positive leap year scenarios.

Examples:

```text
2008 → true
2012 → true
2016 → true
```

These tests confirmed that years divisible by four are correctly identified as leap years.

### TDD State

**GREEN** — The existing implementation already satisfied these scenarios.
![Project Screenshot](https://github.com/aki-ak68/LeapYear/blob/d952089440e03a41200bdbc19f1d0c3176143a69/leap-year-kata/shouldReturnTrueWhenYearIsDivisibleByFour_test3.png)
---

## Step 5 – Add Tests for Century Years

The next requirement introduced an exception to the basic divisible-by-four rule.

Century years are not automatically leap years.

Test cases were added for:

```text
1700 → false
1800 → false
1900 → false
2100 → false
```

The existing implementation incorrectly considered these years to be leap years because they are divisible by four.

### TDD State

**RED** — The new tests exposed a missing business rule.
![Project Screenshot](https://github.com/aki-ak68/LeapYear/blob/d952089440e03a41200bdbc19f1d0c3176143a69/leap-year-kata/shouldReturnFalseWhenYearIsDivisibleByHundredButNotFourHundred_test4.png)
---

## Step 6 – Implement the Century Year Rule

The implementation was enhanced to handle century years.

The rule became:

> A year divisible by 100 is not a leap year unless it is also divisible by 400.

This change corrected the century-year behavior while preserving the existing leap year behavior.

### TDD State

**GREEN** — All existing tests passed.
![Project Screenshot](https://github.com/aki-ak68/LeapYear/blob/d952089440e03a41200bdbc19f1d0c3176143a69/leap-year-kata/shouldReturnFalseWhenYearIsDivisibleByHundredButNotFourHundred_test5_pass.png)
---

## Step 7 – Add Tests for Years Divisible by 400

Additional tests were added for years divisible by 400.

Examples:

```text
1600 → true
2000 → true
2400 → true
```

These tests verify the exception to the century-year rule.

For example:

```text
1900 → false
2000 → true
```

Both years are divisible by 100, but only 2000 is also divisible by 400.

### TDD State

**GREEN** — The implementation correctly handled these scenarios.
![Project Screenshot](https://github.com/aki-ak68/LeapYear/blob/d952089440e03a41200bdbc19f1d0c3176143a69/leap-year-kata/shouldReturnTrueWhenYearIsDivisibleByFourHundred_test6.png)
---

## Step 8 – Refactor the Implementation

After the required business rules were covered by tests, the implementation was simplified into a clear boolean expression.

The refactoring did not change the expected behavior.

The purpose of this refactoring was to:

* Improve readability
* Simplify the business logic
* Remove unnecessary conditional complexity
* Preserve existing behavior

### TDD State

**GREEN** — All tests continued to pass after refactoring.

This demonstrates how automated tests provide confidence when changing the implementation.
![Project Screenshot](https://github.com/aki-ak68/LeapYear/blob/d952089440e03a41200bdbc19f1d0c3176143a69/leap-year-kata/AfterRefactor_test7_success.png)
---

## Step 9 – Add Tests for Invalid Input

Input validation was introduced as an additional requirement.

Tests were added for:

```text
0  → invalid
-1 → invalid
```

The expected behavior was an `IllegalArgumentException`.

### TDD State

**RED** — The tests initially failed because input validation had not yet been implemented.
![Project Screenshot](https://github.com/aki-ak68/LeapYear/blob/d952089440e03a41200bdbc19f1d0c3176143a69/leap-year-kata/ValidationTest_Test8_fails.png)
---

## Step 10 – Implement Input Validation

The implementation was updated to validate the year before performing the leap year calculation.

Years less than or equal to zero are rejected.

The implementation throws:

```text
IllegalArgumentException
```

for invalid input.

### TDD State

**GREEN** — All functional and validation tests passed successfully.
![Project Screenshot](https://github.com/aki-ak68/LeapYear/blob/d952089440e03a41200bdbc19f1d0c3176143a69/leap-year-kata/FinalTest_pass.png)
---

# Final Business Logic

The final implementation follows these rules:

```text
If year <= 0
    → throw IllegalArgumentException

If year is divisible by 400
    → leap year

Otherwise, if year is divisible by 4
and not divisible by 100
    → leap year

Otherwise
    → not a leap year
```

The business logic is implemented in:

```text
src/main/java/LeapYear.java
```

The unit tests are implemented in:

```text
src/test/java/LeapYearTest.java
```

---

# Test Coverage

The unit tests cover the following scenarios.

### Non-Leap Years

* 2017
* 2018
* 2019

### Leap Years Divisible by Four

* 2008
* 2012
* 2016

### Century Years That Are Not Leap Years

* 1700
* 1800
* 1900
* 2100

### Century Years That Are Leap Years

* 1600
* 2000
* 2400

### Invalid Input

* 0
* Negative year

---

# Running the Tests

Make sure **Java 17** and **Maven** are installed.

From the project root directory, execute:

```bash
mvn clean test
```

Maven compiles the project, executes the JUnit test suite, and reports the test results.

A successful execution ends with:

```text
BUILD SUCCESS
```

The tests can also be executed directly from IntelliJ IDEA by running the `LeapYearTest` class.

The `LeapYear` class does not contain a `main()` method because it is a business-logic class and is tested through unit tests.

---

# Test Execution

The complete test suite was executed successfully using the configured Maven and JUnit setup.

The test execution confirms that all implemented leap year rules and validation scenarios are passing.

---

# Git Commit History

The project was developed through small, focused commits to maintain a clear and meaningful development history.

```text
chore: create leap year kata project

test: add test for non-leap year

feat: implement basic leap year rule

test: add tests for years divisible by four

test: add tests for century years

feat: handle century year leap year rule

test: add tests for years divisible by four hundred

refactor: simplify leap year calculation

test: add tests for invalid year input

feat: validate year input

docs: add leap year kata documentation
```

Each commit represents a focused change during the TDD development process.

---

# TDD Development Flow

The overall development process follows:

```text
Write Test
    ↓
RED
    ↓
Implement Minimum Solution
    ↓
GREEN
    ↓
Add More Test Cases
    ↓
RED
    ↓
Improve Implementation
    ↓
GREEN
    ↓
REFACTOR
    ↓
GREEN
```

This approach keeps the implementation driven by requirements and provides confidence when making changes to the code.

---

# Future Extension

Additional business rules can be introduced in the future.

For example, a future requirement could introduce a rule for years divisible by 4000.

This rule is intentionally **not implemented in the current version** because it is outside the current acceptance criteria.

Any future requirement can be introduced using the same TDD process:

```text
New Requirement
      ↓
Write Failing Test
      ↓
Implement Minimum Solution
      ↓
Make Test Pass
      ↓
Refactor
```

---

# Conclusion

This Leap Year Kata demonstrates a structured approach to developing Java business logic using **Test-Driven Development**.

The project demonstrates:

* Writing tests before implementing new behavior
* Incremental implementation
* Handling business rules and edge cases
* Input validation
* Refactoring safely with automated tests
* Maintaining focused Git commits
* Using Java 17 and Maven
* Building a maintainable and testable solution

The final solution is implemented using **Java 17**, **Maven**, and **JUnit 6**.
