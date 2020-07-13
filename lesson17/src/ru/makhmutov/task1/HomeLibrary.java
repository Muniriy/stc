package ru.makhmutov.task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class HomeLibrary {
    private static final Logger log = (Logger) LogManager.getLogger(HomeLibrary.class);
    private static final int MIN_STRING_LENGTH = 2;
    private static final int MAX_STRING_LENGTH = 20;
    private static final int MIN_PAGES = 10;
    private static final int MAX_PAGES = 2000;
    private static final int MIN_YEAR = 1500;
    private static final long serialVersionUID = 1L;

    /**
     * The entry point of HomeLibrary program.
     * The program allows to add the book to the library,
     * show the list of library books, serialize books,
     * and throw exceptions in case of errors
     *
     * @param args Array with parameters of the program
     */
    public static void main(String[] args) {
        int booksNumber = 2;
        String serializedFilePath = "lesson17/src/serialized.dat";
        HomeLibrary homeLibrary = new HomeLibrary();
        List<Book> books = new ArrayList<>(booksNumber);
        homeLibrary.addAllBooks(books, booksNumber, serializedFilePath);
        homeLibrary.readSerializedBooks(books, serializedFilePath);
        homeLibrary.displayBooks(books);
    }

    /**
     * This method allows to add all books to Home Library
     * and serialize information about them
     *
     * @param books              The list of Home Library books
     * @param booksNumber        The number of books in Home Library
     * @param serializedFilePath The path to serialization file
     */
    private void addAllBooks(List<Book> books, int booksNumber, String serializedFilePath) {
        try (OutputStream os = new FileOutputStream(serializedFilePath);
             ObjectOutputStream fout = new ObjectOutputStream(os)) {
            try (Scanner scanner = new Scanner(System.in).useLocale(Locale.ENGLISH)) {
                for (int i = 0; i < booksNumber; i++) {
                    log.info("Book {}:", (i + 1));
                    fout.writeObject(addBook(books, scanner));
                    System.out.println();
                }
            }
        } catch (IOException e) {
            log.error("Error while working with the stream", e);
        }
    }

    /**
     * This method allows to add the book to the Home Library
     *
     * @param books   The list of Home Library books
     * @param scanner The object of Scanner class needed for scanning the number
     * @return book The reference to the added book
     */
    private Book addBook(List<Book> books, Scanner scanner) {
        String authorName = scan(scanner, "author name");
        String authorSurname = scan(scanner, "author surname");
        String bookName = scan(scanner, "book name");
        int issueYear = scan(scanner, MIN_YEAR, LocalDate.now().getYear(), "book issue year");
        int pages = scan(scanner, MIN_PAGES, MAX_PAGES, "book number of pages");
        int bookmark = scan(scanner, 0, pages, "bookmark");
        Book book = new Book(authorName, authorSurname, bookName, issueYear, pages, bookmark);
        books.add(book);
        return book;
    }

    /**
     * This method allows to display the information about all existing books
     *
     * @param books The list of Home Library books
     */
    private void displayBooks(List<Book> books) {
        log.info("Home library contains: ");
        if (!books.isEmpty()) {
            for (int i = 0; i < books.size(); i++) {
                log.info("Book {}: ", (i + 1));
                log.info("\tAuthor name: {}", books.get(i).getAuthorName());
                log.info("\tAuthor surname: {}", books.get(i).getAuthorSurname());
                log.info("\tBook name: {}", books.get(i).getBookName());
                log.info("\tBook issue year: {}", books.get(i).getIssueYear());
                log.info("\tBook pages: {}", books.get(i).getPages());
                log.info("\tBookmark: {}", books.get(i).getBookmark());
                System.out.println();
            }
        } else {
            log.warn("\tThe library is empty");
        }
    }

    /**
     * This method reads serialized information about Home library
     * and ads it to the ArrayList<Book>
     *
     * @param books              The list of Home Library books
     * @param serializedFilePath The path to serialization file
     */
    private void readSerializedBooks(List<Book> books, String serializedFilePath) {
        try (InputStream is = new FileInputStream(serializedFilePath);
             ObjectInputStream in = new ObjectInputStream(is)) {
            while (is.available() > 0) {
                books.add((Book) in.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This methods returns true if the string consists
     * of only English alphabet letters and begins with
     * the capital letter
     *
     * @param name the input String
     * @return true or false
     */
    public boolean isAlphabetSymbol(String name) {
        return name.matches("[A-Z][a-z]+");
    }

    /**
     * This methods returns true if the string consists
     * of only English alphabet letters, digits and spaces
     * and begins with the capital letter
     *
     * @param name the input String
     * @return true or false
     */
    public boolean isApplicableBookName(String name) {
        return name.matches("([A-Z][a-z]+[ ]?)+");
    }

    /**
     * This method allows to read valid input String values.
     *
     * @param scanner The object of Scanner class needed for scanning the number
     * @param type    The string which defines the name of the value
     * @return The obtained value received via scanning
     */
    private String scan(Scanner scanner, String type) {
        String value;
        boolean validityFlag = false;
        log.info("Please add the {}: ", type);
        do {
            value = scanner.nextLine();
            value = value.trim();
            if (type.equals("book name")) {
                if (isApplicableBookName(value) && value.length() >= MIN_STRING_LENGTH && value.length() <= MAX_STRING_LENGTH) {
                    validityFlag = true;
                } else {
                    log.warn("Use string containing only English alphabet symbols with the length not shorter than {} and not longer than {}, " +
                            "where each word begins with the capital letter and separated by single space, try one more time: ", MIN_STRING_LENGTH, MAX_STRING_LENGTH);
                }
            } else {
                if (isAlphabetSymbol(value) && value.length() >= MIN_STRING_LENGTH && value.length() <= MAX_STRING_LENGTH) {
                    validityFlag = true;
                } else {
                    log.warn("Use single word containing only English alphabet symbols with the length not shorter than {} and not longer than {}, " +
                            "and beginning with the capital letter, try one more time: ", MIN_STRING_LENGTH, MAX_STRING_LENGTH);
                }
            }
        } while (!validityFlag);
        return value.trim();
    }

    /**
     * This method allows to read valid input values.
     * The number has to be integer
     *
     * @param scanner       The object of Scanner class needed for scanning the number
     * @param lowerBoundary The lower boundary of the value
     * @param upperBoundary The upper boundary of the value
     * @param type          The string which defines the name of the value
     * @return The obtained value received via scanning
     */
    private int scan(Scanner scanner, int lowerBoundary, int upperBoundary, String type) {
        int value = 0; // the initial value should not be positive to be a barrier for the program
        log.info("Please add the {}: ", type);
        do {
            try {
                value = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                log.warn("Please enter only integer values, try one more time: ");
                scanner.next();
                continue;
            }
            if (value < lowerBoundary || value > upperBoundary) {
                String warnMsg = String.format("Please enter the value in range [%d; %d], try one more time: ",
                        lowerBoundary, upperBoundary);
                log.warn(warnMsg);
            }
        } while (value < lowerBoundary || value > upperBoundary);
        return value;
    }
}
