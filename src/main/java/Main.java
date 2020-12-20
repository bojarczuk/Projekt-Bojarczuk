import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Pobierz pobierz = new Pobierz("https://www.audiolite.pl/87-mikrofony-bezprzewodowe");
        ArrayList<String> nazwa = new ArrayList<>();
        ArrayList<String> cena = new ArrayList<>();
        ArrayList<String> opis = new ArrayList<>();
        File file = new File("mikrofony.txt");
        try{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
            for(int i = 0; i < 13; i++){
                nazwa.add(pobierz.kontent(".product-container a.product-name", i) + "\n");
                cena.add(pobierz.kontent(".price.product-price", i) + "\n");
                opis.add(pobierz.kontent(".product-desc", i) + "\n");
            }
            for(int i = 0; i < nazwa.size(); i++){
                writer.append(nazwa.get(i));
                writer.append(cena.get(i));
                writer.append(opis.get(i));
                writer.append("__________________________________\n");
            }
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}