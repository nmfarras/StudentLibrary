// Assignment 2 - deadline 17 Oktober 2021 23:59
// Library java program

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        // input author
        Author gOrwell = new Author("George Orwell","25 June 1903");
        Author eABlair = new Author("Eric A. Blair","15 July 1902");

        // add author into array list
        List<Author> authListAnimFarm = new ArrayList<Author>(); // case of ArrayList
        authListAnimFarm.add(gOrwell);

        List<Author> authListDOParisLondon = new ArrayList<Author>(); // case of ArrayList
        authListDOParisLondon.add(gOrwell);
        authListDOParisLondon.add(eABlair);

        // input author and book title into object type Book
        Book animFarm = new Book("Animal Farm", authListAnimFarm, "17 August 1945");
        Book parisLondon = new Book("Down and Out in Paris and London", authListDOParisLondon, "9 January 1933");

        // add book to booklist
        List<Book> bookList = new ArrayList<Book>(); // case of ArrayList
        bookList.add(animFarm);
        bookList.add(parisLondon);

        // input book list to library
        Library library = new Library(bookList);
        
        // ouput test
        // System.out.println(animFarm);
        // System.out.println("----------------------------");
        // System.out.println(parisLondon);
        // System.out.println("----------------------------");

        // show list of current books list (retrieve book list)
        System.out.println("\r\nList of Book");
        System.out.println("----------------------------");
        library.getBookList().stream().forEach(System.out::println);
        System.out.println("----------------------------");

        // add book and show updated books list (retrieve update booklist)
        List<Author> authListAbout = new ArrayList<Author>(); // case of ArrayList
        authListAbout.add(gOrwell);

        Book aboutItAbout = new Book("About It and About", authListAbout, "12 August 1939");

        library.addBook(aboutItAbout); // add book

        System.out.println("\r\n Updated List of Book");
        System.out.println("----------------------------");
        library.getBookList().stream().forEach(System.out::println);
        System.out.println("----------------------------");
        
        // library lending book
        try {
            library.lendBook(parisLondon);
            library.lendBook(animFarm);
            library.lendBook(animFarm);
            
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // library receiving borrowed book
        try {
            library.receiveBorrowedBook(parisLondon);
            library.receiveBorrowedBook(animFarm);
            library.receiveBorrowedBook(animFarm);
            
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        library.lendBook(aboutItAbout);

        library.getBookList().stream().forEach(System.out::println);

        // System.out.println("----------------------------");
        // bookList.stream().forEach(System.out::println);

        System.out.println("----------------------------");
        System.out.println("Filter Case 1: Title");
        System.out.println("----------------------------");
        library.findBook("Title", "Animal Farm").stream().forEach(System.out::println);
        
        System.out.println("----------------------------");
        System.out.println("Filter Case 2: Author");
        System.out.println("----------------------------");
        library.findBook("Author", "Eric A. Blair").stream().forEach(System.out::println);
        // library.findBook("Author", "George Orwell").stream().forEach(System.out::println);
        
    }
}
