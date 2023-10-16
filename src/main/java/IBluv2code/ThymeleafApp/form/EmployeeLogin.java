package IBluv2code.ThymeleafApp.form;
public class EmployeeLogin {

    //define the field:
    private String userName;
    private String passWord;
    //constructor:
    public EmployeeLogin(){

    }
    public EmployeeLogin(String userName,String passWord){
        this.userName = userName;
        this.passWord = passWord;

    }

    //getters:
    public String getUserName(){
        return userName;
    }
    public String getPassWord(){
        return passWord;
    }


    // setters:
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPassWord(String passWord){
        this.passWord = passWord;
    }

    //toString:
    @Override
    public String toString() {
        return "EmployeeLogin{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
