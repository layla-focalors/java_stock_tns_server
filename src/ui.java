import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;


public class ui {
    public static boolean isValidEmail(String email) {
        boolean err = false;
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        if(m.matches()) {
            err = true;
        }
        return err;
    }
    public static void main(String[] args) throws IOException {
        boolean login = true;
        boolean exit = false;
        String email = "test@artsnoa.com";
        String password = "1234";
        boolean isaccount = true;
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
                        if(isValidEmail(user_email)){
                            System.out.println("이메일 유효성 검사 통과!");
                        }else {
                            System.out.println("올바르지 않은 이메일 형식입니다.");
                            System.out.println("다시 시도해주세요!");
                            break;
                        }
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
                        if(isValidEmail(find_email)){
                            System.out.println("이메일 유효성 검사 통과!");
                        }else {
                            System.out.println("올바르지 않은 이메일 형식입니다.");
                            System.out.println("다시 시도해주세요!");
                            break;
                        }
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
                        System.out.println("--------------거래소--------------");
                        if(!login){
                            System.out.println("로그인 후 이용해주세요!");
                            break;
                        }else{
                            if(!isaccount){
                                System.out.println("계좌를 개설해주세요!");
                                break;
                            }else {
                                stock_Trade_news();
                                System.out.println("------------------------------");
                                System.out.println("거래할 종목을 입력해주세요!");
                                System.out.println("1. 사성전자(sasung.com)");
                                System.out.println("2. 아이플(iapple.com");
                                System.out.println("3. 인텐그룹(inten.com");
                                System.out.println("4. 구골(gooogle.com");
                                System.out.println("5. 설탕그룹(SugarGroup)");
                                System.out.println("7. 빌그레 그룹(BillGates)");
                                System.out.println("8. 에이플 닷컴(Aplus.com");
                                System.out.println("9. 치킨닷컴(Cheekin.com)");
                                System.out.println("10. 옥베이(oKBay)");
                                String user_trade = sc.next();
                            }
                        }
                        break;
                    case 3:
                        exit = true;
                        break;
                    case 4:
                        System.out.println("--------------회원가입--------------");
                        System.out.println("email을 입력해주세요!");
                        String new_email = sc.next();
                        if(isValidEmail(new_email)){
                            System.out.println("이메일 유효성 검사 통과!");
                        }else {
                            System.out.println("올바르지 않은 이메일 형식입니다.");
                            System.out.println("다시 시도해주세요!");
                            break;
                        }
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
                        case 0:
                            login = false;
                            break;
                        case 1:
                            System.out.println("계정 정보 수정");
                            break;
                        case 2:
                            System.out.println("거래소 이동하기");
                            System.out.println("--------------거래소--------------");
                            if(!login){
                                System.out.println("로그인 후 이용해주세요!");
                                break;
                            }else{
                                if(!isaccount){
                                    System.out.println("계좌를 개설해주세요!");
                                    break;
                                }else {
                                    String ups = stock_Trade_news();
                                    String trade_stock = ups.split("\\^")[0];
                                    String trade_level = ups.split("\\^")[1];
//                                    System.out.println(trade_stock);
//                                    System.out.println(trade_level);
//                                   level - 0 = 상승, 1 하락 ( 2배 처리
//                                   추후 구현 ( 업데이트 )
//                                   )
                                    System.out.println("거래할 종목을 입력해주세요!");
                                    System.out.println("1. 사성전자(sasung.com) |" + get_price(1));
                                    System.out.println("2. 아이플(iapple.com |" + get_price(2));
                                    System.out.println("3. 인텐그룹(inten.com |" + get_price(3));
                                    System.out.println("4. 구골(gooogle.com |" + get_price(4));
                                    System.out.println("5. 설탕그룹(SugarGroup) |" + get_price(5));
                                    System.out.println("6. 빌그레 그룹(BillGates) |" + get_price(6));
                                    System.out.println("7. 에이플 닷컴(Aplus.com |" + get_price(7));
                                    System.out.println("8. 치킨닷컴(Cheekin.com) |" + get_price(8));
                                    System.out.println("9. 옥베이(oKBay) |" + get_price(9));
                                    int user_trade = Integer.parseInt(sc.next());
                                    switch (user_trade){
                                        case 1:
                                            boolean isexit = false;
                                            do{
                                                int issasung = 3;
                                                System.out.println("----------------------------------------");
//                                            파일에 종목별로 기록함! 0은 없음 ! 1은 거래수량
                                                System.out.println("사성전자 거래창");
                                                System.out.println("사성전자 현재가 : " + get_price(1));
                                                if(issasung > 0){
                                                    System.out.println("사성전자 잔고 : " + (get_price(1) * issasung));
                                                }
                                                System.out.println("계좌 잔고 : " + balance);
                                                System.out.println("원하는 옵션을 선택해주세요!");
                                                System.out.println("1. 매수");
                                                System.out.println("2. 매도");
                                                System.out.println("3. 거래소로 돌아가기");
                                                int user_trade_option = sc.nextInt();
                                                switch (user_trade_option) {
                                                    case 1 -> {
                                                        System.out.println("----------------------------------------");
                                                        System.out.println("매수할 수량을 입력해주세요!");
                                                        int user_trade_amount = sc.nextInt();
                                                        System.out.println("매수 주문 : 사성전자 " + user_trade_amount + "주" + ", 예상금액 : " + (get_price(1) * user_trade_amount));
                                                        int total_price = get_price(1) * user_trade_amount;
                                                        if (total_price >= balance) {
                                                            System.out.println("잔액이 부족합니다!");
                                                        } else {
                                                            System.out.println("----------------------------------------");
                                                            System.out.println("매수 주문이 완료되었습니다!");
                                                            balance -= total_price;
                                                            issasung += user_trade_amount;
                                                            System.out.println("사성전자 잔고 : " + (get_price(1) * issasung));
                                                            System.out.println("계좌 잔고 : " + balance);
                                                        }
                                                    }
                                                    case 2 -> {
                                                        System.out.println("----------------------------------------");
                                                        System.out.println("매도할 수량을 입력해주세요!");
                                                        int user_trade_amount2 = sc.nextInt();
                                                        System.out.println("매도 주문 : 사성전자 " + user_trade_amount2 + "주" + ", 예상금액 : " + (get_price(1) * user_trade_amount2));
                                                        int total_price2 = get_price(1) * user_trade_amount2;
                                                        if (user_trade_amount2 >= issasung) {
                                                            System.out.println("매도하려는 수량이 보유 수량보다 많습니다!");
                                                        } else {
                                                            System.out.println("----------------------------------------");
                                                            System.out.println("매도 주문이 완료되었습니다!");
                                                            balance += total_price2;
                                                            issasung -= user_trade_amount2;
                                                            System.out.println("사성전자 잔고 : " + get_price(1) * issasung);
                                                            System.out.println("계좌 잔고 : " + balance);
                                                        }
                                                    }
                                                    case 3 -> {
                                                        System.out.println("거래소로 돌아가기");
                                                        isexit = false;
                                                    }
                                                    default -> System.out.println("잘못된 입력입니다!");
                                                }
                                            }while (!isexit);

                                        case 2:
                                            System.out.println("아이플 거래창");
                                            break;
                                        case 3:
                                            System.out.println("인텐그룹 거래창");
                                            break;
                                        case 4:
                                            System.out.println("구골 거래창");
                                            break;
                                        case 5:
                                            System.out.println("설탕그룹 거래창");
                                            break;
                                        case 6:
                                            System.out.println("빌그레 그룹 거래창");
                                            break;
                                        case 7:
                                            System.out.println("에이플 닷컴 거래창");
                                            break;
                                        case 8:
                                            System.out.println("치킨닷컴 거래창");
                                            break;
                                        case 9:
                                            System.out.println("옥베이 거래창");
                                            break;
                                        default:
                                            System.out.println("잘못된 종목입니다!");
                                            break;
                                    }
                                }
                            }
                        case 3:
                            exit = true;
                            break;
                        default:
                            System.out.println("잘못된 입력입니다.");
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
    private static Integer get_price(int stock_number) {
        try {
            FileInputStream fileStream = null;
            fileStream = new FileInputStream("C:\\Users\\starl\\IdeaProjects\\Jvc_JavaStock\\src\\stock_price\\default.txt");
            byte[] readBuffer = new byte[fileStream.available()];
            ArrayList<String> list = new ArrayList<>();
            while (fileStream.read(readBuffer) != -1) {
            }
            list.add(new String(readBuffer));
//            int gds = list.get(0).split("\\^")[0];
            int price = Integer.parseInt(list.get(0).split("\\^")[stock_number]);
            fileStream.close();
            return price;
        } catch (IOException e) {
            System.out.println("오류! 402 : 해당 종목명을 불러오는데 실패했습니다!");
        }
        return null;
    }
    private static String stock_Trade_news() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int odin = random.nextInt(2);
        if(odin == 0) {
            try {
                FileInputStream fileStream = null;
                fileStream = new FileInputStream("C:\\Users\\starl\\IdeaProjects\\Jvc_JavaStock\\src\\news\\up.txt");
                byte[] readBuffer = new byte[fileStream.available()];
                ArrayList<String> list = new ArrayList<>();
                while (fileStream.read(readBuffer) != -1) {
                }
                list.add(new String(readBuffer));
                String aps = list.get(0).split("\\^")[0];
                fileStream.close();
                ArrayList lists = new ArrayList();
                String str = "사성전자, 아이플, 인텐그룹, 구골, 설탕그룹, 빌그레 그룹, 에이플 닷컴, 치킨닷컴, 옥베이";
                ArrayList<String> stocks = new ArrayList<>(Arrays.asList(str.split("\\s*,\\s*")));
                random.setSeed(System.currentTimeMillis());
                int length = stocks.size();
                int rdx = random.nextInt(length);
                System.out.printf("[트레이드 뉴스] : %s %s\n", stocks.get(rdx), aps);
                String return_method = stocks.get(rdx) + "^" + odin;
                return return_method;
            } catch (IOException e) {
                System.out.println("------------------------------");
            }
        }else {
            try {
                FileInputStream fileStream = null;
                fileStream = new FileInputStream("C:\\Users\\starl\\IdeaProjects\\Jvc_JavaStock\\src\\news\\down.txt");
                byte[] readBuffer = new byte[fileStream.available()];
                ArrayList<String> list = new ArrayList<>();
                while (fileStream.read(readBuffer) != -1) {
                }
                list.add(new String(readBuffer));
                String aps = list.get(0).split("\\^")[0];
                fileStream.close();
                ArrayList lists = new ArrayList();
                String str = "사성전자, 아이플, 인텐그룹, 구골, 설탕그룹, 빌그레 그룹, 에이플 닷컴, 치킨닷컴, 옥베이";
                ArrayList<String> stocks = new ArrayList<>(Arrays.asList(str.split("\\s*,\\s*")));
                random.setSeed(System.currentTimeMillis());
                int length = stocks.size();
                int rdx = random.nextInt(length);
                System.out.printf("[트레이드 뉴스] : %s %s\n", stocks.get(rdx), aps);
                String return_method = stocks.get(rdx) + "^" + odin;
                return return_method;
            } catch (IOException e) {
                System.out.println("------------------------------");
            }
        }
        return null;
    }
}

