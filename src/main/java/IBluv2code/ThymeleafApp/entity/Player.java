package IBluv2code.ThymeleafApp.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "player")
public class Player {

    // define the field:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phoneNumber;

    // constructor:
    public Player (){

    }
    public Player (String firstName,String lastName,String email,String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }
    // getters:
    public int getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public  String getLastName(){
        return lastName;
    }
    public String getEmail(){
        return email;
    }
    public String getPhoneNumber(){
        return  phoneNumber;
    }

    // setters:
    public void setId(int id){
        this.id = id;
    }
    public  void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public  void  setLastName(String lastName){
        this.lastName = lastName;
    }
    public  void setEmail(String email){
        this.email = email;
    }
    public  void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    // toString:

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
