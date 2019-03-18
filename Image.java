import java.util.ArrayList;
import java.util.List;

class Image {
    private String url;
    private String file;
    private List<String> pages  = new ArrayList<>();

    Image(String url, String file, String pages) {
        this.url = url;
        this.file = file;
        this.pages.add(pages);
    }
}
