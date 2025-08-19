import java.util.*;

public class BookAnalyzer {
    public static int getTotalBooksByAuthor(String authorName, List<Book> books) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                count++;
            }
        }
        return count;
    }

    public static void printAllAuthors(List<Book> books) {
        Set<String> authors = new HashSet<>();
        
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        
        System.out.println("All Authors in the Dataset:");
        System.out.println();
        
        for (String author : authors) {
            System.out.println(author);
        }
        
        System.out.println("\nTotal number of unique authors: " + authors.size());
    }
    
    public static List<Book> getBooksByAuthor(String authorName, List<Book> books) {
        List<Book> authorBooks = new ArrayList<>();
        
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                authorBooks.add(book);
            }
        }
        
        return authorBooks;
    }
    
    public static List<Book> getBooksByRating(double rating, List<Book> books) {
        List<Book> ratedBooks = new ArrayList<>();
        
        for (Book book : books) {
            if (book.getUserRating() == rating) {
                ratedBooks.add(book);
            }
        }
        
        return ratedBooks;
    }
    
    public static Map<String, Double> getBookPricesByAuthor(String authorName, List<Book> books) {
        Map<String, Double> bookPrices = new LinkedHashMap<>();
        
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(authorName)) {
                bookPrices.put(book.getName(), book.getPrice());
            }
        }
        
        return bookPrices;
    }
}
