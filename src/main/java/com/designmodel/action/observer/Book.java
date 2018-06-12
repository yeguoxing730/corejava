package com.designmodel.action.observer;

public class Book {
    //书名
    public String bookName;
    //作者
    public String author;

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [bookName=" + bookName + ", author=" + author + "]";
    }
}
