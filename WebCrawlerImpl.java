import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawlerImpl implements WebCrawler {
    @Override
    public Page crawl(String url, int depth) throws IOException {
        Page page = new Page(url);


        URL urlPage = new URL(url);
        Scanner scanner = new Scanner(urlPage.openStream());
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (page.title == null && Pattern.compile("<title>").matcher(line).find()){
                page.title = line.substring(line.indexOf("<title>") + 7,line.indexOf("</title>"));
            }
//            System.out.println(line);
            if (line.startsWith("function"))continue;
//            while (Pattern.compile("[ ]*<img[a-zA-Z\\\\/. ]*src=\\\"([a-zA-Z\\\\/.])*\\\"[a-zA-Z\\\\/. ]*>[ ]*").matcher(line).find()){//.replaceAll("\\?", "").replaceAll("\\)", "").replaceAll("\\(", "").replaceAll("\\{", "").replaceAll("\\[", "").replaceAll("}", "").replaceAll("]", ""))) {
            while (Pattern.compile("<img").matcher(line).find()) {//.replaceAll("\\?", "").replaceAll("\\)", "").replaceAll("\\(", "").replaceAll("\\{", "").replaceAll("\\[", "").replaceAll("}", "").replaceAll("]", ""))) {
                int start = line.indexOf("<img");
                int end = line.indexOf(">", start);
                String img = line.substring(start, end + 1);

                int startImg = img.indexOf("src=\"");
                int endImg = img.indexOf("\"", startImg + 5);
                String imgLink = img.substring(startImg + 5, endImg);

  //              System.out.println(img);
    //            System.out.println(imgLink);
                Pattern pattern = Pattern.compile("\\w+\\.png|\\w+\\.jpg|\\w+\\.jpeg|\\w+\\.bmp");
                Matcher matcher = pattern.matcher(imgLink);
      /*          if (matcher.find()) {
                    System.out.println("True");
                    System.out.println(matcher.start());
                    System.out.println(matcher.end());
                    System.out.println(imgLink.substring(matcher.start(), matcher.end()));
                }
      */
                page.images.add(new Image(imgLink, (matcher.find())? imgLink.substring(matcher.start(), matcher.end()):imgLink, page.url));
                line = line.substring(end);
            }
            while (Pattern.compile("<a").matcher(line).find()) {//.replaceAll("\\?", "").replaceAll("\\)", "").replaceAll("\\(", "").replaceAll("\\{", "").replaceAll("\\[", "").replaceAll("}", "").replaceAll("]", ""))) {
                int startLink = line.indexOf("href=\"");
                int endLink = line.indexOf("\"", startLink + 6);
                String Link = line.substring(startLink + 6, endLink);

                if (Link.startsWith("/") || Link.equals(page.url))
                    page.backLinks.add(new Page(Link));
                else {
                    if (depth > 0) page.links.add(crawl(Link, depth - 1));
                    else page.links.add(new Page(Link));
                }
                line = line.substring(endLink);
            }
        }
        scanner.close();
    return page;
    }
}
