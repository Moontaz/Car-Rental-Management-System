# Car Rental Management System

The Car Rental Management System is a Java application designed to manage a fleet of cars, 
providing functionalities for data insertion, retrieval, and deletion. 
This system uses a simple MVC (Model-View-Controller) architecture, Binary Tree data structure, and stores car information in a CSV file.

## Features

### 1. Insert Data

Add new cars to the system with detailed information, including:

- ID
- Plate Number
- Brand
- Color
- Seat Capacity
- Transmission Type
- Cost per Day

### 2. Read Data

Read car information from a CSV file to populate the system.

### 3. Display Data

View the details of all cars in the system, including each car's ID, plate number, brand, color, seat capacity, transmission type, and cost per day.

### 4. Search

Search for cars based on various criteria:

- ID
- Plate Number
- Brand
- Color
- Seat Capacity
- Transmission Type
- Cost per Day

### 5. Delete Data

Remove a car from the system and update the CSV file.

## Project Structure

The project is organized into the following packages:

- **model**: Contains the [`Car`](CarRentalManagementSystem\src\model\car.java) and [`TodoModel`](CarRentalManagementSystem\src\model\TodoModel.java) classes representing the car and todo model.
- **repository**: Manages data storage and retrieval with the [`TodoRepository`](CarRentalManagementSystem\src\repository) class.
- **service**: Implements business logic with the [`TodoService`](CarRentalManagementSystem\src\service) class.
- **controller**: Handles user input and application flow with the [`Controller`](CarRentalManagementSystem\src\controller) class.
- **database**: Database file.

## Getting Started

Follow these steps to run the Car Rental Management System:

### 1. Clone the repository:

   ```bash
   git clone https://github.com/Moontaz/CarRentalManagementSystem.git
   ```

### 2. Change database path:
   Change CSV file path or [`mydata.csv`](CarRentalManagementSystem/src/mydata.csv) path on [`TodoView.java`](CarRentalManagementSystem\src\view\TodoView.java) file on line 397
### 3. Run main file:
   run [`main.java`](CarRentalManagementSystem\src\Main.java)
