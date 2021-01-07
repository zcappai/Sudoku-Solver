# Sudoku Solver
This repository contains a program that takes an input of a sudoku puzzle and solves it. If the sudoku is unsolvable, the program will inform the user with an error message.

The program uses a depth-first search algorithm called Backtracking and recursion to solve the sudoku. This brute-force approach solves the puzzle by visiting the empty cells in order, filling in digits sequentially, or backtracking when the number is found to be not valid.

The program would solve the input puzzle by iterating through the numbers 1 to 9, inclusive, and checking if each number is allowed to be placed in the current empty cell. If the number is allowed (checking the row, column, and quadrant of the empty cell), then the number is placed in the current cell and the algorithm advances to the next cell using a recursive call of the backtracking method and repeats the process. If a cell is discovered where none of the 9 digits is allowed, then the algorithm leaves that cell blank and moves back to the previous cell. The value in that cell is then incremented by one. This is repeated until the allowed value in the last empty cell is discovered, at which point the solved sudoku is printed to the console.

### Languages:
<a href="#"><img align="left" alt="Java" height="25px" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" /></a>
