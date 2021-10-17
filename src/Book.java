// import java.util.ArrayList;
import java.util.List;

public class Book {
    private String bookTitle;
    private List<Author> authList;
    private String publishDate;
    private Boolean isBorrowed;

    public Book(String bookTitle,List<Author> authList, String publishDate){
        this.bookTitle = bookTitle;
        this.authList = authList;
        this.publishDate = publishDate;
        this. isBorrowed = false;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public Boolean getIsBorrowed() {
        return isBorrowed;
    }

    public void setIsBorrowed(Boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public List<Author> getAuthList() {
        return authList;
    }

    @Override
    public String toString() {
        return "Title: " + bookTitle 
               + "\r\nAuthor(s): " + authList
               + "\r\nPublish date: " + publishDate 
               +  "\r\nIsBorrowed: " + isBorrowed + "\r\n";
    }

    
}
