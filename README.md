
# 🃏 Monte Carlo Blackjack Simulation

Welcome to a probability-based Blackjack simulator built in Java!  
This project uses **Monte Carlo methods** to model and analyze thousands of rounds of Blackjack, simulating various strategies to better understand the statistical outcomes of this popular casino game.

---

## 🎯 Project Objective

The main goal of this project is to **explore randomness and strategy through simulation**. Using the Monte Carlo method, the program repeatedly plays Blackjack hands to analyze:

- Win/loss/draw probabilities
- Optimal decisions based on current hand state
- Statistical outcomes across thousands of iterations

---

## 🛠 Features

- ✅ Full implementation of Blackjack game mechanics  
- 🔁 Monte Carlo simulation engine to run thousands of game trials  
- 🧮 Models custom strategies and calculates winning probabilities  
- 📦 Modular OOP design: `Card`, `Deck`, `Hand`, `Blackjack`, `Simulation`  
- 🧪 JUnit test coverage for all key components  
- 📄 Results are saved to a file (`mygames.txt`) and/or printed to console  

---

## 📁 File Structure

```
src/
├── Card.java           # Represents an individual playing card
├── Deck.java           # Manages and shuffles a deck of cards
├── Hand.java           # Contains logic for calculating hand values
├── Blackjack.java      # Implements the rules and flow of a Blackjack round
├── Simulation.java     # Runs the Monte Carlo simulation
├── ArrayList.java      # Custom ArrayList implementation
├── mygames.txt         # Stores game outcomes
├── *Tests.java         # JUnit test classes for all components
```

```
extension/
├── Card.java           # Represents an individual playing card
├── Deck.java           # Manages and shuffles a deck of cards
├── Hand.java           # Contains logic for calculating hand values
├── Blackjack.java      # Implements the rules and flow of a Blackjack round
├── Interactive.java    # Implements an interactive game where players are able to make choices in real-time
├── Simulation.java     # Runs the Monte Carlo simulation
├── ArrayList.java      # Custom ArrayList implementation
├── mygames.txt         # Stores game outcomes
├── *Tests.java         # JUnit test classes for all components
```

---

## 🧪 How to Run the Simulation

### Step 1: Compile the code

```bash
cd src
javac *.java
```

### Step 1A: Compile the code: extension

```bash
cd extension
javac *.java
```

### Step 2: Run the simulation

```bash
java Simulation
```

### Step 3: View results

- Check the terminal output
- Or open `mygames.txt` to analyze game outcomes

---

## 🧪 Tests

This project includes tests for:

- Card creation and value
- Deck shuffling and dealing
- Hand total calculations and Blackjack logic
- Game round outcomes
- ArrayList utility class

To run tests, use a JUnit-compatible Java IDE or command-line test runner.

---

## 🧠 Concepts Explored

- Monte Carlo Simulation  
- Probability theory  
- Object-Oriented Programming (OOP)  
- Java collections and custom data structures  
- Simulation-based game strategy  
- Test-driven development with JUnit  

---

## 📄 Report

A full breakdown of logic, experiment design, outcomes, and mathematical reasoning is available in the included PDF report:  
📘 `Project1 Report.pdf`

---

## 👨‍💻 Author

**Azeem Gbolahan**  
Student of Computer Science & Economics  
Colby College

---

## 🚀 Let’s Connect

If you're interested in simulations, probability, or building better strategies through code — feel free to reach out or fork the project!
