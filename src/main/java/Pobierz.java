import org.jsoup.Jsoup;
        import org.jsoup.nodes.Document;
        import org.jsoup.nodes.Element;
        import java.io.IOException;

public class Pobierz {
    private Document dokument = null;

    public Pobierz(String url){
        try{
            this.dokument = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Element strona(){
        return this.dokument.getAllElements().first();
    }
    public String kontent(String cQ, int i){
        return strona().select(cQ).get(i).text();
    }
    @Override
    public String toString() {
        return "Scrapper{" +
                "dokument=" + dokument +
                '}';
    }
}