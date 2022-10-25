package Dto;

public class boardDto {
    private String Title;
    private String content;

    public boardDto(String title, String content) {
        Title = title;
        this.content = content;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "boardDto{" +
                "Title='" + Title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
