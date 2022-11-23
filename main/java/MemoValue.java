import java.time.LocalDateTime;

public class MemoValue {
    public String password;
    private String title;
    private String content;
    private LocalDateTime lastUpdateTime;


    public MemoValue(String title, String content, String password) {
        this.title = title;
        this.content = content;
        this.lastUpdateTime = LocalDateTime.now();
        this.password =password;
    }


    static MemoValue newMemo(String title, String content, String password) {
        return new MemoValue(title,content,password);
    }

    void update(String content) {
        this.content = content;
        this.lastUpdateTime = LocalDateTime.now();
    }


    String getTitle() {
        return title;
    }

    String getContent() {
        return content;
    }

    String getLastUpdatedDatetime() {
        return lastUpdateTime.toString();
    }

}