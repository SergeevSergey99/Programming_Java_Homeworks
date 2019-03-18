import java.io.IOException;
import java.net.MalformedURLException;

public interface WebCrawler {
    Page crawl(String url, int depth) throws IOException;
}