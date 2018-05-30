import java.util.ArrayList;

public class Teacher {
    String username;
    String password;
    public String Username(){
            return username;
    }

    public Boolean CheckPwd(String password){
        return this.password == password;
    }

    ArrayList<Student> students;
}
