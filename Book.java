public class Book {
    private String name;
    private String author;
    private double userRating;
    private int reviews;
    private double price;
    private int year;
    private String genre;

    public Book(String name, String author, double userRating, int reviews, double price, int year, String genre) {
        this.name = name;
        this.author = author;
        this.userRating = userRating;
        this.reviews = reviews;
        this.price = price;
        this.year = year;
        this.genre = genre;
    }
    
    // Getter and Setter for name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter and Setter for author
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    // Getter and Setter for userRating
    public double getUserRating() {
        return userRating;
    }
    
    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }
    
    // Getter and Setter for reviews
    public int getReviews() {
        return reviews;
    }
    
    public void setReviews(int reviews) {
        this.reviews = reviews;
    }
    
    // Getter and Setter for price
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    // Getter and Setter for year
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    // Getter and Setter for genre
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public void printDetails() {
        System.out.println("===========================================");
        System.out.println("Book Details:");
        System.out.println("Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("User Rating: " + userRating + "/5.0");
        System.out.println("Number of Reviews: " + reviews);
        System.out.println("Price: $" + price);
        System.out.println("Year: " + year);
        System.out.println("Genre: " + genre);
        System.out.println("===========================================");
    }
}
