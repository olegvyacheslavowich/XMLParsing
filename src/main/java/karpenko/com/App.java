package karpenko.com;

import karpenko.com.bouquet.Bouquet;
import karpenko.com.flowers.Flower;
import karpenko.com.flowers.FlowersColor;
import karpenko.com.service.BouquetService;
import karpenko.com.xmlparsing.SAXBouquetParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

;

/**
 * Цветочница. Определить иерархию цветов. Создать несколько объек-
 * тов-цветов. Собрать букет (используя аксессуары) с определением его
 * стоимости. Провести сортировку цветов в букете на основе уровня све-
 * жести. Найти цветок в букете, соответствующий заданному диапазону
 * длин стеблей
 */
public class App {
    public static void main(String[] args) {

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser sax = factory.newSAXParser();
            SAXBouquetParser saxParser = new SAXBouquetParser();
            sax.parse(new File("src/resources/xml/bouquet.xml"), saxParser);

            Bouquet bouquet = new Bouquet(saxParser.getFlowers(),saxParser.getPackaging());
            System.out.println(bouquet.toString());

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

    }
}
