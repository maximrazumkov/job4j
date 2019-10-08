package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book programming = new Book("Clean code", 200);
        Book cook = new Book("How Cook", 150);
        Book stories = new Book("Interesting stories", 300);
        Book greenMile = new Book("Green mile", 450);

        Book[] books = new Book[4];
        books[0] = programming;
        books[1] = cook;
        books[2] = stories;
        books[3] = greenMile;

        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getCount());
        }

        Book tempBook = books[0];
        books[0] = books[3];
        books[3] = tempBook;

        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getCount());
        }

        for (Book book : books) {
            if ("Clean code".equals(book.getName())){
                System.out.println(book.getName() + " - " + book.getCount());
            }
        }

    }
}
