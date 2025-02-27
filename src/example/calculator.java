package example;
import java.util.Scanner; // scanner 를 사용하기 위해 추가

public class calculator {
    public static void main(String[] args) {
        System.out.println("Hello, calculator!");

        Scanner sc = new Scanner(System.in);
        int firstNum, secondNum;
        char operator;  // 사칙연산 기호를 저장하는 변수

        while (true) {
            System.out.println("두개의 양의 정수를 입력하세요 (0포함): ");

            if (sc.hasNextInt()) {          //입력값이 정수인지 확인
                firstNum = sc.nextInt();
                if (firstNum >= 0) {       //첫번째가 올바르다면 두번째 값이 정수인지 혹인
                    secondNum = sc.nextInt();
                    if (secondNum >= 0) {     //두번째도 올바르다면 반복 종료
                        break;
                    } else {
                        System.out.println("두 번째 숫자는 음수는 입력할 수 없습니다. 다시 입력하세요.");
                    }
                } else {
                    System.out.println("첫 번째 숫자는 음수는 입력할 수 없습니다. 다시 입력하세요.");
                }
            } else {
                System.out.println("숫자가 아닙니다. 다시 입력하세요.");
                sc.nextLine(); //잘못된 입력 제거
            }
        }

        // 사칙연산 기호 입력
        while (true) {
            System.out.println("사칙연산 기호를 입력하세요 (+,-,*,/):");
            operator = sc.next().charAt(0); //첫번째 문자만 입력받기

            //유효한 코드인지 확인
            if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                break; //유효한 기호일 경우 반복 종료
            } else {
                System.out.println("잘못된 기호입니다. 다시 입력하세요"); //외의 기호일 경우 다시 입력 유도
            }
        }

        // 연산 결과 변수 (switch 사용& 0 나누기 예외처리)
        double result = 0;

        switch (operator) {
            case '+':
        result = firstNum + secondNum;
        break;
        case '-':
            result = firstNum - secondNum;
            break;
        case '*':
                result = firstNum * secondNum;
                break;
        case '/':
            if (secondNum == 0) { //[오류 처리] 0으로 나누는 경우 방지
                System.out.println("나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.");
                sc.close(); //메모리 누수 방지
                return;
            }
            result = (double) firstNum / secondNum;
            break;
            default:
                System.out.println("잘못된 연산자입니다.");
                sc.close();
                return;

        }

    //연산 결과 출력
    System.out.println("결과: "+result);
    sc.close();
    }
}