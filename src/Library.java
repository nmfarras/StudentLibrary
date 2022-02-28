// import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Library {
    private List<Book> bookList;

    public Library(List<Book> bookList){
        this.bookList = bookList;
    }

    public void addBook(Book newBook) {
        bookList.add(newBook);
    }
    
    public List<Book> getBookList() {
        return bookList;
    }

    public void lendBook(Book bookLent) throws BookIsBorrowedException{
        this.bookList = this.bookList.stream()
        .map(currentBook ->{
            if(bookLent.equals(currentBook)&&currentBook.getIsBorrowed()){
                throw new BookIsBorrowedException(bookLent.getBookTitle() 
                          + " is not Available! Book already borrowed!"
                          + "\r\n");
            }
            if(bookLent.equals(currentBook)){
                currentBook.setIsBorrowed(true);
                System.out.println("Thank you for borrowing "+bookLent.getBookTitle());
            }
            return currentBook;
        })
        .collect(Collectors.toList());
    }

    public void receiveBorrowedBook(Book bookReturn) throws BookAlreadyReturnException {
        this.bookList = this.bookList.stream()
        .map(currentBook ->{
            if(bookReturn.equals(currentBook) && !currentBook.getIsBorrowed()){
                throw new BookIsBorrowedException(bookReturn.getBookTitle() 
                          + " is already return!"
                          + "\r\n");
            }
            if(bookReturn.equals(currentBook)){
                currentBook.setIsBorrowed(false);
                System.out.println("Thank you for returning "+bookReturn.getBookTitle());
            }
            return currentBook;
        })
        .collect(Collectors.toList());
    }

   public List<Book> findBook(String criteria, String param){
       if (criteria=="Title") {
           List<Book> searchList = this.bookList.stream()
           .filter(currentBook->currentBook.getBookTitle()==param)
           .collect(Collectors.toList());
           return searchList;
       } else {
           List<Book> searchList = this.bookList.stream()
           .filter(currentBook->currentBook.getAuthList().stream()
             .anyMatch(auth -> auth.getAuthName().equals(param)))
           .collect(Collectors.toList());
           return searchList;
       }
   } 

   
}
