import java.util.ArrayList;
import java.util.List;

class Page {
    String url;
    String title;
    List<Page> links = new ArrayList<>();
    List<Page> backLinks = new ArrayList<>();
    List<Image> images = new ArrayList<>();

    Page(String url) {
        this.url = url;
    }
}
