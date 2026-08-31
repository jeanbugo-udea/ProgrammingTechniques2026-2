/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.juanfedevmaster.libraryudea;

import java.util.ArrayList;
import java.util.Scanner;
import library.models.Book;
import library.models.Catalog;

/**
 *
 * @author juanfe
 */
public class LibraryUdeA {

    public static void printBook (Book book){
        System.out.println("Title:  " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN:   " + book.getIsbn());
        System.out.println("Amount: " + book.getAmount());
    }

    public static void main(String[] args) {

        Catalog catalog = new Catalog();

        int option = 0;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("1. Register book");
            System.out.println("2. Buy a book");
            System.out.println("3. list books");
            System.out.println("4.  search book");
            System.out.println("5. Exit");

            System.out.println("Enter the option:");
            option = Integer.parseInt(scan.nextLine().trim());

            switch (option) {
                case 1: // Registrar Libro
                    System.out.println("Enter the isbn code:");
                    String isbn = scan.nextLine().trim();
                    System.out.println("Enter the title:");
                    String title = scan.nextLine().trim();
                    System.out.println("Enter the author name:");
                    String author = scan.nextLine().trim();
                    System.out.println("Enter the amount:");
                    int amount = Integer.parseInt(scan.nextLine().trim());
                    catalog.registerBook(isbn, title, author, amount);
                    break;

                case 2: // Vender de Libro
                    System.out.println("Enter the isbn code of the book to buy:");
                    String isbnSell = scan.next();

                    System.out.println("Enter the amount of books:");
                    int amountSell = scan.nextInt();

                    catalog.sellBook(isbnSell, amountSell);

                    break;
                case 3:
                    // Show all books of the catalog.
                    ArrayList<Book> books = catalog.getBooks();
                    if (books.isEmpty()){
                        System.out.println("Catalog is empty: ");
                    }
                    else {
                        System.out.println("***** List Books *****");
                        for (Book book : books) {
                            printBook(book);
                            System.out.println("...............");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Enter the isbn code:");
                    String searchIsbn = scan.nextLine().trim();
                    Book aBook = catalog.findByIsbn(searchIsbn);
                    if (aBook != null) {
                        printBook(aBook);
                    }
                    else{
                        System.out.println("Book not found");
                    }
                    break;

                default:
                    option = 0;
            }

        } while (option != 0);

    }
}
