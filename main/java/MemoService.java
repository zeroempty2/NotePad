
import java.util.Scanner;


public class MemoService {
    public static void main(String[] args) {
        MemoListValue memo = new MemoListValue();
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("-----메모장-----");
            System.out.println("1. 메모리스트" );
            System.out.println("2. 메모 보기" );
            System.out.println("3. 메모작성" );
            System.out.println("4. 메모수정" );
            System.out.println("5. 메모삭제" );
            System.out.println("6. 종료" );
            System.out.println("번호를 입력하십시오");

            int enterNumber = scanner.nextInt();


            if (1 == enterNumber){
                memo.showMemoList();
            }
            else if(2 == enterNumber) {
                memo.readMemo();
            }
            else if(3 == enterNumber) {
                memo.createMemo();
            }
            else if(4 == enterNumber) {
                memo.updateMemo();
            }
            else if(5 == enterNumber) {
                memo.deleteMemo();
            }
            else if(6 == enterNumber) {
                break;
            }
            else{
                System.out.println("");
                System.out.println("잘못된 입력입니다");
                System.out.println("번호를 다시 입력해주세요");
                System.out.println("");
            }
        }
    }
}