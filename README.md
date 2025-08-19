# 📚 Amazon Bestsellers Book Management System

A Java-based system for analyzing Amazon's top 50 bestselling books dataset from 2009-2019. This project demonstrates object-oriented programming principles while providing comprehensive book analysis capabilities.

## 📁 Project Structure

```
assign_1/
├── Book.java                    # Book entity class
├── DatasetReader.java           # CSV data reader and parser
├── BookAnalyzer.java            # Analysis and query methods
├── Driver.java                  # Main program entry point
├── dataset/
│   └── bestsellers with categories.csv  # Source dataset
└── README.md                    # This file
```

## 🔧 File Descriptions

### 1. **Book.java**
**Purpose**: Entity class representing a book object
- **Attributes**: name, author, userRating, reviews, price, year, genre
- **Features**: 
  - Constructor with all parameters
  - Getters and setters for all attributes
  - `printDetails()` method for formatted output
- **OOP Principle**: Encapsulation with private fields and public accessors

### 2. **DatasetReader.java**
**Purpose**: CSV file reader and data parser
- **Features**:
  - Reads CSV file and creates Book objects
  - Handles malformed lines gracefully
  - Supports quoted fields in CSV
  - Data validation for all fields
- **Methods**:
  - `readBooksFromCSV(String filePath)` - Main reading method
  - `parseBookFromLine(String line)` - Parses individual CSV lines
  - `parseCSVLine(String line)` - Handles quoted CSV fields

### 3. **BookAnalyzer.java**
**Purpose**: Analysis and query methods for book data
- **Features**: All required analysis tasks implemented
- **Methods**:
  - `getTotalBooksByAuthor()` - Count books by author
  - `printAllAuthors()` - Display all unique authors
  - `getBooksByAuthor()` - Get all books by specific author
  - `getBooksByRating()` - Get books with specific rating
  - `getBookPricesByAuthor()` - Get book names and prices by author

### 4. **Driver.java**
**Purpose**: Main program entry point
- **Features**:
  - Demonstrates basic dataset loading
  - Shows all books in the dataset
  - Displays total book count

## 🚀 How to Use

### Prerequisites
- Java 8 or higher
- CSV dataset file in the correct location

### Compilation
```bash
javac *.java
```

### Running the Program

#### 1. Basic Usage (Driver.java)
```bash
java Driver
```
**Output**: Displays all books in the dataset with detailed information

#### 2. Using BookAnalyzer Methods
```java
// Load the dataset
List<Book> books = DatasetReader.readBooksFromCSV("dataset/bestsellers with categories.csv");

// Example analysis calls
BookAnalyzer.printAllAuthors(books);
int count = BookAnalyzer.getTotalBooksByAuthor("Stephen King", books);
List<Book> authorBooks = BookAnalyzer.getBooksByAuthor("Stephen King", books);
List<Book> ratedBooks = BookAnalyzer.getBooksByRating(4.7, books);
Map<String, Double> prices = BookAnalyzer.getBookPricesByAuthor("Stephen King", books);
```

## 📊 Example Use Cases

### 1. **Author Analysis**
```java
// Find how many books Stephen King has in the dataset
int kingBooks = BookAnalyzer.getTotalBooksByAuthor("Stephen King", books);
System.out.println("Stephen King has " + kingBooks + " books in the dataset");

// Get all books by Stephen King
List<Book> kingBooksList = BookAnalyzer.getBooksByAuthor("Stephen King", books);
for (Book book : kingBooksList) {
    System.out.println(book.getName() + " - Rating: " + book.getUserRating());
}
```

### 2. **Rating Analysis**
```java
// Find all books with 4.8 rating
List<Book> topRatedBooks = BookAnalyzer.getBooksByRating(4.8, books);
System.out.println("Books with 4.8 rating: " + topRatedBooks.size());

// Display sample books
for (int i = 0; i < Math.min(5, topRatedBooks.size()); i++) {
    Book book = topRatedBooks.get(i);
    System.out.println((i+1) + ". " + book.getName() + " by " + book.getAuthor());
}
```

### 3. **Price Analysis**
```java
// Get all book prices by an author
Map<String, Double> prices = BookAnalyzer.getBookPricesByAuthor("Jeff Kinney", books);
double totalValue = 0.0;
for (Map.Entry<String, Double> entry : prices.entrySet()) {
    System.out.println(entry.getKey() + " - $" + entry.getValue());
    totalValue += entry.getValue();
}
System.out.println("Total value: $" + totalValue);
```

### 4. **Dataset Overview**
```java
// Print all authors in the dataset
BookAnalyzer.printAllAuthors(books);

// This will show:
// - All unique authors
// - Total count of unique authors
```

## 📈 Dataset Information

The dataset contains:
- **550 books** from Amazon's bestseller list
- **Time period**: 2009-2019
- **Columns**: Name, Author, User Rating, Reviews, Price, Year, Genre
- **Genres**: Fiction and Non-Fiction
- **Rating range**: 3.3 to 4.9
- **Price range**: $0 to $105

## 🔍 Sample Output

```
===========================================
Book Details:
Name: 10-Day Green Smoothie Cleanse
Author: JJ Smith
User Rating: 4.7/5.0
Number of Reviews: 17350
Price: $8.0
Year: 2016
Genre: Non Fiction
===========================================
```
