# 💀 Console Hangman

A robust, ASCII-graphical Hangman game running entirely in the Java console. Features both a single-player mode (against the CPU) and a "pass-and-play" multiplayer mode.

## 🎮 Game Modes
* **1-Player Mode (PvE):** The computer picks a random word from the included `hangmanWordsList.txt` file.
* **2-Player Mode (PvP):** Player 1 enters a secret word, the screen "clears", and Player 2 guesses it.

## 🚀 How to Run
1.  **Clone the repo** (or download the files).
2.  **Run** `Main.java` in your IDE.

## 🛠️ Systems & Architecture
* **Rendering Engine:** Custom ASCII logic (`printHangman`) that dynamically draws the stick figure.
* **Smart Cursor Management:** Handles console cursor alignment to prevent visual glitches.
* **Input Validation:** Uses "Membership Checks" (`indexOf`) so correct guesses aren't punished.
* **Polymorphism:** Handles both File and Keyboard inputs using the same `Scanner` implementation.
