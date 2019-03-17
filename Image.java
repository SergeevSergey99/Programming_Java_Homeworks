import java.util.List;

public class Image {
    private String url;
    private String file;
    private List<String> pages;

    public Image(String url, String file, List<String> pages) {
        this.url = url;
        this.file = file;
        this.pages = pages;
    }
}
