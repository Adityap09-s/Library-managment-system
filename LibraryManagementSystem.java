import java.util.*;

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + " | Title: " + title + " | Author: " + author + " | Issued: " + (isIssued ? "Yes" : "No"));
    }
}

public class LibraryManagementSystem {
    private static List<Book> library = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Remove Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    removeBook();
                    break;
                case 6:
                    System.out.println("Thank you for using the library system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        Book newBook = new Book(nextId++, title, author);
        library.add(newBook);
        System.out.println("Book added successfully.");
    }

    private static void viewBooks() {
        if (library.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("\nList of Books:");
            for (Book book : library) {
                book.displayInfo();
            }
        }
    }

    private static void issueBook() {
        System.out.print("Enter book ID to issue: ");
        int id = scanner.nextInt();

        for (Book book : library) {
            if (book.id == id) {
                if (!book.isIssued) {
                    book.isIssued = true;
                    System.out.println("Book issued successfully.");
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void returnBook() {
        System.out.print("Enter book ID to return: ");
        int id = scanner.nextInt();

        for (Book book : library) {
            if (book.id == id) {
                if (book.isIssued) {
                    book.isIssued = false;
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("This book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void removeBook() {
        System.out.print("Enter book ID to remove: ");
        int id = scanner.nextInt();

        Iterator<Book> iterator = library.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.id == id) {
                iterator.remove();
                System.out.println("Book removed successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
