import java.io.*;
import java.util.*;

public class DatasetReader {

    public static List<Book> readBooksFromCSV(String filePath) {
        List<Book> books = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                Book book = parseBookFromLine(line);
                if (book != null) {
                    books.add(book);
                }
            }
            
        } catch (IOException e) {
            System.err.println("Error reading CSV file: " + e.getMessage());
        }
        
        return books;
    }
    
    private static Book parseBookFromLine(String line) {
        try {
            String[] fields = parseCSVLine(line);
            
            if (fields.length != 7) {
                System.err.println("Skipping malformed line (incorrect number of fields): " + line);
                return null;
            }
            
            String name = fields[0].trim();
            String author = fields[1].trim();
            double userRating = Double.parseDouble(fields[2].trim());
            int reviews = Integer.parseInt(fields[3].trim());
            double price = Double.parseDouble(fields[4].trim());
            int year = Integer.parseInt(fields[5].trim());
            String genre = fields[6].trim();
            
            if (name.isEmpty() || author.isEmpty() || genre.isEmpty()) {
                System.err.println("Skipping malformed line (missing required text fields): " + line);
                return null;
            }
            
            if (userRating < 0 || userRating > 5 || reviews < 0 || price < 0 || year < 1900 || year > 2025) {
                System.err.println("Skipping malformed line (invalid numeric values): " + line);
                return null;
            }
            
            return new Book(name, author, userRating, reviews, price, year, genre);
            
        } catch (Exception e) {
            System.err.println("Error parsing line: " + line + " - " + e.getMessage());
            return null;
        }
    }
    
    private static String[] parseCSVLine(String line) {
        List<String> fields = new ArrayList<>();
        StringBuilder currentField = new StringBuilder();
        boolean inQuotes = false;
        
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                fields.add(currentField.toString());
                currentField = new StringBuilder();
            } else {
                currentField.append(c);
            }
        }
        
        fields.add(currentField.toString());
        
        return fields.toArray(new String[0]);
    }
}
