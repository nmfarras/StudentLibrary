// import java.util.Calendar;

public class Author {
    private String authName;
    // private Calendar birthDate;
    private String birthDate;

    public Author(String authName, String birthDate) {
        this.authName = authName;
        this.birthDate = birthDate;
    }

    public String getAuthName() {
        return authName;
    }

    

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return authName;
    }

    

    
}
