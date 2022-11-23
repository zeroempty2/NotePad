
import java.util.Objects;
import java.util.Scanner;

public class MemoListValue {
    private int memoLength = 0;
    private final MemoValue[] memoVlues;
    private final int Memo_SIZE = 20;

    public MemoListValue() {
        this.memoVlues = new MemoValue[Memo_SIZE];
    }

    public void createMemo() {
        System.out.println("");
        if (Memo_SIZE == this.memoLength) {
            System.out.println("메모가 꽉찼습니다");
            System.out.println("");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("제목을 작성해주세요");
        String title = scanner.nextLine();

        System.out.println("본문을 작성해주세요");
        String content = scanner.nextLine();

        System.out.println("비밀번호를 입력해 주세요");
        String password = scanner.nextLine();

        memoVlues[this. memoLength++] = MemoValue.newMemo(title, content, password);


        System.out.println("메모가 작성되었습니다");
        System.out.println("");
    }


    public void readMemo () {
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("확인할 메모의 번호를 입력해주세요");
        int selectedNumber = scanner.nextInt();
        MemoValue memoValue = memoVlues[selectedNumber];
        if (null == memoValue) {
            System.out.println("작성된 메모가 없습니다");
            System.out.println("");
            return;
        }
        System.out.println("");
        String headLine = String.format("번호:%d 제목:%s", selectedNumber, memoValue.getTitle());
        System.out.println(headLine);
        System.out.println(memoValue.getLastUpdatedDatetime());
        System.out.println(memoValue.getContent());
        System.out.println("");
    }



    public void updateMemo() {
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("수정하실 메모의 번호를 입력해주세요");
        int selectedNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("수정하실 메모의 비밀번호를 입력해주세요");
        String password = scanner.nextLine();

        System.out.println("본문을 작성해주세요");
        String content = scanner.nextLine();

        MemoValue memoValue = memoVlues[selectedNumber];
        if (Objects.equals(memoVlues[selectedNumber].password, password)) {
            if (null == memoValue) {
                System.out.println("존재하지 않는 메모입니다");
                return;
            }
            memoValue.update(content);

            System.out.println("메모가 수정되었습니다");
            System.out.println("");

        } else {
            System.out.println("비밀번호가 일치하지 않습니다");
        }
    }


    public void deleteMemo() {
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        System.out.println("삭제하실 메모의 번호를 입력해주세요");
        int selectedNumber = Integer.parseInt(scanner.nextLine());

        MemoValue memoValue = memoVlues[selectedNumber];
        if (null == memoValue) {
            System.out.println("존재하지 않는 메모입니다");
            return;
        }

        System.out.println("삭제하실 메모의 비밀번호를 입력해주세요");
        String password = scanner.nextLine();


        if (Objects.equals(memoVlues[selectedNumber].password, password)) {

            memoVlues[selectedNumber] = null;


            System.out.println("메모가 삭제되었습니다");
            System.out.println("");

        } else {
            System.out.println("비밀번호가 일치하지 않습니다");
        }
    }


    public void showMemoList () {
        System.out.println("");
        if (0 == this.memoLength) {
            System.out.println("작성된 메모가 없습니다");
            System.out.println("");
            return;
        }
        for (int i = 0; i < this.memoLength; i++) {
            MemoValue memoValue = memoVlues[i];

            String headLine = String.format("번호:%d 제목:%s 작성날짜:%s", i, memoValue.getTitle(),
                    memoValue.getLastUpdatedDatetime());
            System.out.println(headLine);
        }
        System.out.println("");
    }

}