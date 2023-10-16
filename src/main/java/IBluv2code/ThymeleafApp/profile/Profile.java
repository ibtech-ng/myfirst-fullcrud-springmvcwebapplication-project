package IBluv2code.ThymeleafApp.profile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Profile {

    // define the profile field:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String  firstName;

    private String lastName;

    //  constructor:
    public Profile(){

    }

    public Profile(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // getters:
    public int getId(){
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }

    // setters:
    public  void setId(int id){
        this.id = id;
    }

    public  void setFirstName(String firstName){
       this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //toString:
    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
