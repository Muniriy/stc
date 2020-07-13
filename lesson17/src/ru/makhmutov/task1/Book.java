package ru.makhmutov.task1;

import java.io.Serializable;

public class Book implements Serializable {
    private final String authorName;
    private final String authorSurname;
    private final String bookName;
    private final int issueYear;
    private final int pages;
    private final int bookmark;

    public Book(String authorName, String authorSurname, String bookName, int issueYear, int pages, int bookmark) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.bookName = bookName;
        this.issueYear = issueYear;
        this.pages = pages;
        this.bookmark = bookmark;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public String getBookName() {
        return bookName;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public int getPages() {
        return pages;
    }

    public int getBookmark() {
        return bookmark;
    }


}
