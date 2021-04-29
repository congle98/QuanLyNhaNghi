package Person;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Customer  implements Serializable {
    private String name;
    private int IDCard;
    private String email;
    private LocalDate dateOfBirth;
    public Customer() {
    }

    public Customer(String name, int IDCard, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.IDCard = IDCard;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIDCard() {
        return IDCard;
    }

    public void setIDCard(int IDCard) {
        this.IDCard = IDCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        LocalDate date = dateOfBirth;

        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return "Tên khách hàng: "+name+", Ngày sinh: "+formattedDate+", Số chứng minh thư: "+IDCard+", Email: "+email;
    }
}
