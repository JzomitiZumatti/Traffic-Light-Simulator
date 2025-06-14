# Traffic Light Simulator – Stage 4: Like a clockwork

---

## 🧠 Description

Creating a whole system at once is challenging, so we will start with a simple stopwatch in the new thread.

Let's assume that our program has three possible states:

Not Started — the state until the initial settings have been provided;
Menu — the state we worked with earlier. It shows possible options and processes the user's input;
System — the state that shows the user information about our traffic light, such as time from startup and initial settings for now.
When the user provided input for initial settings (both the number of roads and the interval), create a new thread to implement the System state. Name it as QueueThread by calling its setName() method with the corresponding string argument. The actions this newly-created thread should perform for now each second are:

Increasing the variable that corresponds to the amount of time since the "system startup" each second (1000 milliseconds);
(if in System state) Printing the system information.
Let's add new functionality to the Open system menu option. By choosing 3 option in Menu, the program switches to the System state, and the main thread waits for input from the user. To return to the Menu state, the user should press Enter, in other words, an empty string should be provided as input.

Example of system information output:

```text
! 3s. have passed since system startup !
! Number of roads: 1 !
! Interval: 1 !
! Press "Enter" to open menu !
```
---

## 🎯 Objectives

Implement the System state as described above and set its thread name as `QueueThread`. While your program is in the System state, the output should contain the following information, updated (printing out) each second:

- The line that shows the time since the program's start (contains only one integer — the number of seconds);
- The line that indicates the number of roads provided by the user (includes the `number` substring and only one integer — the same value that was provided in the settings);
- The line that shows the interval provided by the user (contains the `interval` substring and only one integer — the same value that was provided in the settings);
- The line that asks the user to press Enter to open the menu (should contain the `Enter` substring)
- 
When the user provided an empty input, the program should switch back to the Menu state and show the previously implemented menu.
