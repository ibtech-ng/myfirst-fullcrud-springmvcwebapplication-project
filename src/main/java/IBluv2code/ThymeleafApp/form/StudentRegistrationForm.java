package IBluv2code.ThymeleafApp.form;

import IBluv2code.ThymeleafApp.profile.Profile;
import jakarta.persistence.*;
import org.hibernate.mapping.List;

import java.util.ArrayList;

@Entity
@Table(name = "studentregistrationform")
public class StudentRegistrationForm {
    // define-field-for-the-RegistrationForm:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nickname")
    private String nickName;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passWord;


    // define the constructor:
   public  StudentRegistrationForm(){

   }
   //argument- constructor:
    public  StudentRegistrationForm(String nickName,String userName,String passWord ){
       this.nickName = nickName;
       this.userName = userName;
       this.passWord = passWord;
    }

    //getters:
    public int getId(){
       return id;
    }
    public String getNickName(){
       return nickName;
    }
    public String getUserName(){
       return userName;
    }
    public String getPassWord(){
       return  passWord;
    }

    // setters:
    public void setId(int id){
       this.id = id;
    }

    public  void setNickName(String nickName){
        this.nickName = nickName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord){
       this.passWord = passWord;
    }

    //toString:

    @Override
    public String toString() {
        return "StudentRegistrationForm{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
