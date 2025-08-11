import java.util.ArrayList;
import java.util.List;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean issued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return issued; }

    public void issue() { this.issued = true; }
    public void returnBook() { this.issued = false; }

    @Override
    public String toString() {
        return id + " - " + title + " by " + author + (issued ? " (Issued)" : " (Available)");
    }
}

// User class
class User {
    private int id;
    private String name;
    private List<Book> borrowedBooks;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}

// Library class
class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book != null && user != null && !book.isIssued()) {
            book.issue();
            user.borrowBook(book);
            System.out.println("Book '" + book.getTitle() + "' issued to " + user.getName());
        } else {
            System.out.println("Cannot issue book (already issued or not found).");
        }
    }

    public void returnBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book != null && user != null && book.isIssued()) {
            book.returnBook();
            user.returnBook(book);
            System.out.println("Book '" + book.getTitle() + "' returned by " + user.getName());
        } else {
            System.out.println("Cannot return book (not issued or not found).");
        }
    }

    private Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    private User findUser(int id) {
        for (User u : users) {
            if (u.getId() == id) return u;
        }
        return null;
    }
}




public class Task3 {
    
    public static void main(String[] args) {
        Library library = new Library();

        // Add books
        library.addBook(new Book(1, "Java Basics", "Shubham"));
        library.addBook(new Book(2, "Spring Boot Guide", "Abhishek"));
        library.addBook(new Book(3, "Data Structures", "Rahul"));

        // Add users
        library.addUser(new User(101, "Shubham"));
        library.addUser(new User(102, "Rahul"));

        System.out.println("📚 Available Books:");
        library.showBooks();

        // Issue a book
        library.issueBook(2, 101);

        System.out.println("\n📚 After Issuing:");
        library.showBooks();

        // Return a book
        library.returnBook(2, 101);

        System.out.println("\n📚 After Returning:");
        library.showBooks();
    }
}
