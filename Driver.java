import java.util.List;

public class Driver {
    private static final String CSV_FILE_PATH = "dataset/bestsellers with categories.csv";
    
    public static void main(String[] args) {
        
        System.out.println("Reading books from CSV file: " + CSV_FILE_PATH);
        List<Book> books = DatasetReader.readBooksFromCSV(CSV_FILE_PATH);
        
        System.out.println("ALL BOOKS");
        displayAllBooks(books);
        System.out.println("Total Books Count:" + books.size());
    }

    private static void displayAllBooks(List<Book> books){
        for (Book book : books) {
            book.printDetails();
        }
    }
}
