package ru.makhmutov.task1;

import java.io.Serializable;

public class Book implements Serializable {
    private final String authorName;
    private final String authorSurname;
    private final String bookName;
    private final int issueYear;
    private final int pages;
    private final int bookmark;

    /**
     * Constructor for the Book class
     *
     * @param authorName    The author name
     * @param authorSurname The author surname
     * @param bookName      The book name
     * @param issueYear     The book issue date
     * @param pages         Number of pages in the book
     * @param bookmark      The bookmark
     */
    public Book(String authorName, String authorSurname, String bookName, int issueYear, int pages, int bookmark) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.bookName = bookName;
        this.issueYear = issueYear;
        this.pages = pages;
        this.bookmark = bookmark;
    }

    /**
     * This is the getter for the author name
     *
     * @return The author name
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * This is the getter for the author surname
     *
     * @return The author surname
     */
    public String getAuthorSurname() {
        return authorSurname;
    }

    /**
     * This is the getter for the book name
     *
     * @return The book name
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * This is the getter for the book issue date
     *
     * @return The book issue date
     */
    public int getIssueYear() {
        return issueYear;
    }

    /**
     * This is the getter for the book number of pages
     *
     * @return The book number of pages
     */
    public int getPages() {
        return pages;
    }

    /**
     * This is the getter for the book bookmark
     *
     * @return The bookmark
     */
    public int getBookmark() {
        return bookmark;
    }
}
