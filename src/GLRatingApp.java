import fb_scraper.GlPageScraper;

public class GLRatingApp {

    public static void main(String[] args){
        GlPageScraper scraper = new GlPageScraper();
        try{
            scraper.scrapFlavours();
        } catch(InterruptedException e ) {
            System.err.print(e);
        }
    }
}
