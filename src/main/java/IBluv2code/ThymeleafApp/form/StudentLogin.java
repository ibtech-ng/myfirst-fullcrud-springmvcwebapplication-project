package IBluv2code.ThymeleafApp.form;
public class StudentLogin {

    // define the studentLogin:
    private String userName;
    private String password;

    // constructor:
    public StudentLogin (){

    }
    public StudentLogin(String userName,String password){
        this.userName = userName;
        this.password = password;
    }

    // getters:
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return  password;
    }

    // setters:
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPassword(String password){
        this.password = password;
    }

    //toString:
    @Override
    public String toString() {
        return "StudentLogin{" +
                "useName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
