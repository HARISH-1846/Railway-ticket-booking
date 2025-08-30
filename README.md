# Railway-ticket-booking
🚆 Java Railway Ticket Booking System
A console-based Railway Ticket Booking System written in Java that allows users to book, cancel, and view ticket availability for different berth types (Lower, Middle, Upper), along with RAC and Waiting List management. The system handles berth allocation dynamically and maintains user data for efficient booking and cancellation.

🎯 Features
Book a ticket with berth preference (L/M/U)
Automatic fallback to available berths, RAC, or waiting list if preference is unavailable
Cancel ticket and auto-promote RAC and WL passengers
View available tickets
View all booked tickets
Realistic berth management using position tracking
🧠 Concepts Used
Java Classes and Objects
Data Structures:
List, Queue, Map, ArrayList, LinkedList, HashMap
Encapsulation and Modular Design
Scanner for CLI input
📁 File Structure
JAVA RAILWAY TICKET BOOKING/
├── Main.java # User interface with menu options
├── TicketBooker.java # Core logic for booking, cancellation, availability
├── Passenger.java # Passenger class with booking details
└── README.md


---

## 🧪 Sample Booking Scenario

1. Choose a berth preference: `Lower`, `Middle`, `Upper`
2. If not available, fallback:
   - ➡ RAC Ticket
   - ➡ Waiting List
3. Booked ticket includes:
   - Passenger ID
   - Name, Age, Allotted Berth, Position Number

---

## 🖥️ How to Run

1. Make sure all `.java` files are in the same folder.
2. Compile all files:

```bash
javac Main.java TicketBooker.java Passenger.java
java Main

---
📋 Menu Options:
1. Book Ticket
2. Cancel Ticket
3. Available Ticket
4. Booked Ticket
5. Exit
---
📌 Berth & Ticket Configuration:
21 Lower Berths
21 Middle Berths
21 Upper Berths
18 RAC tickets
10 Waiting List spots
---
✅ Example Output
Enter Passenger Name:
Harish
Enter Berth Preference (Lower/Middle/Upper):
Lower
Enter Age:
25
Berth Preference is available
Lower Berth is available
Ticket Booked Successfully
---
