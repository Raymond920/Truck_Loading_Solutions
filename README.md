> [!NOTE]
> This project is academic coursework for UECS2453	PROBLEM SOLVING WITH DATA STRUCTURES AND ALGORITHMS module.
> 
# Truck Loading Solutions

This project provides a solution for optimizing truck loading using various bin packing algorithms. It aims to minimize the number of trucks required to transport a given set of parcels, each with a specific weight.

## Features and Functionality

*   **Bin Packing Algorithms:** Implements several bin packing algorithms, including:
    *   First Fit
    *   First Fit Decreasing
    *   Best Fit
    *   Best Fit Decreasing
    *   Next Fit
*   **Parcel Loading:** Loads parcel data from a CSV file (`src/parcels.csv`).  The CSV file should contain parcel name, weight, and type separated by commas. The first line of the CSV file is treated as a header and skipped.
*   **Truck Management:** Simulates trucks with a defined load limit.
*   **Algorithm Comparison:**  Compares the performance of different algorithms based on execution time and the total number of trucks needed.
*   **Detailed Results:** Displays the parcels loaded into each truck, the total weight of each truck, and the overall weight of all parcels.
*   **User Interface:** Provides a command-line interface for users to:
    *   Enter truck load limit.
    *   Compare different bin packing algorithms.
    *   View the truck list for a selected algorithm, showing which parcels are assigned to each truck.

## Technology Stack

*   **Java:**  The project is written in Java.
*   **Data Structures:** Utilizes Java's built-in data structures like `Queue`, `List`, `ArrayList`, `Stack`, and `Iterator`.

## Prerequisites

*   **Java Development Kit (JDK):** Ensure you have a JDK installed (version 8 or higher is recommended).
*   **Text Editor or IDE:** A text editor or IDE for viewing and editing the code. (e.g., IntelliJ IDEA, Eclipse, VS Code)

## Installation Instructions

1.  **Clone the repository:**

    ```bash
    git clone https://github.com/Raymond920/Truck_Loading_Solutions.git
    cd Truck_Loading_Solutions
    ```

2.  **Compile the Java code:**

    ```bash
    javac src/edu/utar/binpacking/*.java src/edu/utar/binpacking/algorithms/*.java src/edu/utar/binpacking/dataStructures/*.java src/edu/utar/binpacking/UserInterface.java
    ```
    Alternatively, you can compile from the project root using the following command if your classpath is not set correctly:
   ```bash
   javac -d . src/edu/utar/binpacking/*.java src/edu/utar/binpacking/algorithms/*.java src/edu/utar/binpacking/dataStructures/*.java src/edu/utar/binpacking/UserInterface.java
   ```
   This command compiles all the Java files and places the `.class` files into the corresponding directory structure mirroring the package structure.

## Usage Guide

1.  **Prepare Parcel Data:** Ensure that the `src/parcels.csv` file exists and contains parcel data in the correct format (name, weight, type). For example:

    ```csv
    Parcel Name,Weight (kg),Type
    Parcel A,10.5,Fragile
    Parcel B,7.2,Durable
    Parcel C,15.0,Fragile
    Parcel D,5.8,Durable
    ```

2.  **Run the Application:**

    ```bash
    java edu.utar.binpacking.UserInterface
    ```

3.  **Interact with the User Interface:**

    *   The application will prompt you to enter the truck load limit in kilograms.  Enter a valid numerical value.  The system will validate to ensure that the load limit is larger than the largest parcel weight found in the `parcels.csv` file.
    *   The application will then run a comparison of all the bin packing algorithms, displaying their execution time and the number of trucks required.
    *   Finally, you'll be prompted to select an algorithm to view the detailed truck list.  Enter the corresponding number.  Entering `0` will exit the application.

## API Documentation

This project does not expose an external API.  It provides a command-line interface for interactive use. However, the core classes and their functionalities can be understood as follows:

*   **`edu.utar.binpacking.UserInterface`**:  The main class that drives the application. It handles user input, algorithm selection, and result display.  The `start()` method is the entry point for the application logic.
*   **`edu.utar.binpacking.algorithms.BinPackingAlgorithm`**:  An interface that defines the contract for all bin packing algorithms.  Key methods include `Pack()`, `getName()`, `getExecutionTime()`, and `getTruckList()`.
*   **`edu.utar.binpacking.algorithms.AbstractBinPackingAlgorithm`**: An abstract class that implements the `BinPackingAlgorithm` interface and provides common functionality such as execution time tracking and truck list management.  The `pack()` method (lowercase 'p') must be implemented by concrete algorithm classes.
*   **`edu.utar.binpacking.algorithms.*`**: Concrete classes such as `FirstFitAlgorithm`, `BestFitAlgorithm`, `NextFitAlgorithm` (and their decreasing variants) implement the bin packing logic.  They inherit from `AbstractBinPackingAlgorithm`.
*   **`edu.utar.binpacking.dataStructures.ParcelController`**: Manages the loading of parcels from the CSV file. `getAllParcels()` provides access to the parcels.
*   **`edu.utar.binpacking.dataStructures.Truck`**: Represents a truck with a defined load limit.
*   **`edu.utar.binpacking.dataStructures.Parcel`**: Represents a parcel with a name, weight, and type.

## Contributing Guidelines

Contributions are welcome! To contribute to this project:

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix.
3.  Implement your changes.
4.  Write tests to cover your changes.
5.  Submit a pull request with a clear description of your changes.

## 📜 Contributors

<a href="https://github.com/Raymond920/Truck_Loading_Solutions/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=Raymond920/Truck_Loading_Solutions" />
</a>

## License Information

No license has been specified for this project. All rights are reserved by the owner.

## Contact/Support Information

For questions, issues, or support, please contact Raymond920 through GitHub.
