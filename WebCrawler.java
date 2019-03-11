public interface WebCrawler {
    Page crawl(String url, int depth);
}