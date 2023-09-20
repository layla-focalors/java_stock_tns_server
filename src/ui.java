import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ui {
    public static void main(String[] args) throws IOException {
        boolean login = false;
        boolean exit = false;
        String email = "test@artsnoa.com";
        String password = "1234";
        boolean isaccount = false;
        int balance = 1000000;
        String account = "1234-1234-1234";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("원하는 명령어를 선택해주세요!\n");
            if(!login){
                System.out.println("0. 로그인");
                System.out.println("1. 계정 정보 찾기");
                System.out.println("2. 거래소 이동하기");
                System.out.println("3. 종료");
                System.out.println("4. 회원가입");
                int input = sc.nextInt();
                switch (input) {
                    case 0:
                        System.out.println("--------------로그인--------------");
                        System.out.println("email을 입력해주세요!");
                        String user_email = sc.next();
                        String umail = null;
                        String upassword = null;
                        try {
                            FileInputStream fileStream = null;
                            fileStream = new FileInputStream("C:\\Users\\starl\\IdeaProjects\\Jvc_JavaStock\\src\\storage\\" + user_email + ".txt");
                            byte[] readBuffer = new byte[fileStream.available()];
                            ArrayList<String> list = new ArrayList<>();
                            while (fileStream.read(readBuffer) != -1) {
                            }
                            list.add(new String(readBuffer));
                            umail = list.get(0).split("\\^")[0];
                            upassword = list.get(0).split("\\^")[1];
                            fileStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("회원가입에 사용한 email을 찾을 수 없습니다.");
                        }
                        System.out.println("password를 입력해주세요!");
                        String user_password = sc.next();
                        if (user_email.equals(umail) && user_password.equals(upassword)) {
                            System.out.println("로그인 성공!");
                            login = true;
                        } else {
                            System.out.println("로그인에 실패하였습니다! 다시 시도해주세요!");
                            login = false;
                        }
                        break;
                    case 1:
                        System.out.println("계정 정보 찾기");
                        System.out.println("회원가입에 사용한 email을 입력해주세요!");
                        String find_email = sc.next();
                        if (find_email.equals(email)) {
                            System.out.println("이메일을 찾았습니다! 변경할 비밀번호를 입력해주세요!");
                            String new_password;
                            new_password = sc.next();
                            password = new_password;
                            System.out.printf("비밀번호가 %s로 변경되었습니다!\n", password);
                            System.out.println("다시 로그인해주세요!");
                            login = false;
                        } else {
                            System.out.println("회원가입에 사용한 email을 찾을 수 없습니다.");
                        }
                        break;
                    case 2:
                        System.out.println("거래소 이동하기");
                        break;
                    case 3:
                        exit = true;
                        break;
                    case 4:
                        System.out.println("--------------회원가입--------------");
                        System.out.println("email을 입력해주세요!");
                        String new_email = sc.next();
                        System.out.println("password를 입력해주세요!");
                        String new_password = sc.next();
                        String user_name = new_email.split("@")[0];
                        try {
                            String data = new_email + "^" + new_password;
                            OutputStream output = new FileOutputStream("C:\\Users\\starl\\IdeaProjects\\Jvc_JavaStock\\src\\storage\\" + new_email + ".txt");
                            byte[] by = data.getBytes();
                            output.write(by);
                            output.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        System.out.printf("email : %s, password : %s로 새로운 계정이 생성되었습니다!\n", new_email, new_password);
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                }
            }else {
                System.out.println("0. 로그아웃");
                System.out.println("1. 계정 정보 수정");
                System.out.println("2. 거래소 이동하기");
                if(isaccount){
                    System.out.println("3. 종료");
                    System.out.printf("로그인한 계좌 번호 : %s, 잔액 : %s\n", account, balance);
                    int input = sc.nextInt();
                    switch (input) {
                        case 0 -> login = false;
                        case 1 -> System.out.println("계정 정보 수정");
                        case 2 -> System.out.println("거래소 이동하기");
                        case 3 -> exit = true;
                        default -> System.out.println("잘못된 입력입니다.");
                    }
                }else{
                    System.out.println("3. 계좌 개설");
                    System.out.println("4. 종료");
                    int input = sc.nextInt();
                    switch (input) {
                        case 0 -> login = false;
                        case 1 -> System.out.println("계정 정보 수정");
                        case 2 -> System.out.println("거래소 이동하기");
                        case 3 -> System.out.println("계좌 개설");
                        case 4 -> exit = true;
                        default -> System.out.println("잘못된 입력입니다.");
                    }
                }
            }
        } while (!exit);
    }
}

