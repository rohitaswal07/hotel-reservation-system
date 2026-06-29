# Hotel Reservation Management System

A console-based Hotel Reservation Management System developed using Java and Object-Oriented Programming (OOP) principles. This project allows administrators to manage hotel rooms and customers to book, view, and cancel reservations through a menu-driven interface.

## Features

### Admin Module
- Add new rooms
- Remove existing rooms
- View all rooms
- View all reservations

### User Module
- View available rooms
- Make room reservations
- View reservation details by:
  - Reservation ID
  - Email ID
- Cancel reservations

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList (Java Collections Framework)
- Scanner Class

## Project Structure

```text
HotelApp.java
│
├── HotelReservationSystem.java
├── Room.java
├── Customer.java
└── Reservation.java
```

## Class Overview

### Room
Stores room details such as:
- Room Number
- Room Type
- Price
- Booking Status

### Customer
Stores customer information:
- Name
- Contact Number
- Email ID

### Reservation
Stores reservation details:
- Reservation ID
- Customer Information
- Room Information

### HotelReservationSystem
Handles:
- Admin operations
- User operations
- Room management
- Reservation management

## OOP Concepts Used

- Classes and Objects
- Encapsulation
- Constructors
- Method Calling
- Object Composition

## Sample Workflow

1. Admin adds rooms to the system.
2. User views available rooms.
3. User creates a reservation.
4. Room status changes to booked.
5. User can view reservation details.
6. User can cancel reservation.
7. Room becomes available again.

## Learning Outcomes

Through this project, I gained practical experience in:
- Java Programming
- Object-Oriented Design
- Collections Framework
- Menu-Driven Application Development
- Real-world Problem Solving

## Future Enhancements

- Database Integration (MySQL)
- User Authentication
- Check-In / Check-Out Management
- Payment Integration
- GUI using JavaFX or Swing

