import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class ui {
    public static void main(String[] args) {
        boolean login = true;
        boolean exit = false;
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
                int input = sc.nextInt();
                switch (input) {
                    case 0 -> login = true;
                    case 1 -> System.out.println("계정 정보 찾기");
                    case 2 -> System.out.println("거래소 이동하기");
                    case 3 -> exit = true;
                    default -> System.out.println("잘못된 입력입니다.");
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
                        case 0 -> login = true;
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

