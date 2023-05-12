import java.util.Scanner;

public class Main {

    public static void signIn(String userName,String password)throws UserNameException,PasswordException{
        if(!userName.equals("admin")){
            throw new UserNameException("用户名错误");
        } if(!password.equals("123456")){
            throw new PasswordException("密码错误");
        }
        System.out.println("登录成功");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String u=s.nextLine();
        String p=s.nextLine();
        System.out.println("请输入用户名");
        System.out.println("请输入密码");
        try{
            signIn(u,p);
        }catch(UserNameException e){
            e.printStackTrace();
        }catch(PasswordException e){
            e.printStackTrace();
        }
    }
}
