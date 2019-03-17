import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebCrawlerImpl implements WebCrawler {
    @Override
    public void crawl(String url, int depth) throws IOException {
        URL urlPage = new URL(url);
        Scanner scanner = new Scanner(urlPage.openStream());
        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            System.out.println(line);

            while ("[ ]*<img[a-zA-Z\\\\/. ]*src=\\\"([a-zA-Z\\\\/.])*\\\"[a-zA-Z\\\\/. ]*>[ ]*".matches(line.replaceAll("\\?", "").replaceAll("\\)", "").replaceAll("\\(", "").replaceAll("\\{", "").replaceAll("\\[", "").replaceAll("}", "").replaceAll("]", ""))) {
                int start = line.indexOf("<img");
                int end = line.indexOf(">", start);
                String img = line.substring(start, end);

                System.out.println(img);

                line = line.substring(end);
            }
        }
        scanner.close();
    }
}
