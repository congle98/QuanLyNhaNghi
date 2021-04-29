//package Person;
//
//import java.io.Serializable;
//import java.time.LocalDate;
//
//
//public abstract class Person implements Serializable {
//    private String name;
//    private int IDCard;
//    private String email;
//    private LocalDate dateOfBirth;
//    public Person() {
//    }
//
//    public Person(String name, int IDCard, String email, LocalDate dateOfBirth) {
//        this.name = name;
//        this.IDCard = IDCard;
//        this.email = email;
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getIDCard() {
//        return IDCard;
//    }
//
//    public void setIDCard(int IDCard) {
//        this.IDCard = IDCard;
//    }
//
//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + name + '\'' +
//                ", IDCard=" + IDCard +
//                '}';
//    }
//}
