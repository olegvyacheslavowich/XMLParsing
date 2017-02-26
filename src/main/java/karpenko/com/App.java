package karpenko.com;

import karpenko.com.parsersfactory.impl.StAXFactory;
import karpenko.com.starter.Start;
import karpenko.com.xmlparsing.BouquetViewer;
import karpenko.com.parsersfactory.ParsersFactory;
import karpenko.com.parsersfactory.impl.SAXFactory;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;

;

/**
 * Цветочница. Определить иерархию цветов. Создать несколько объек-
 * тов-цветов. Собрать букет (используя аксессуары) с определением его
 * стоимости. Провести сортировку цветов в букете на основе уровня све-
 * жести. Найти цветок в букете, соответствующий заданному диапазону
 * длин стеблей
 */
public class App {
    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

        Start.compare();

    }
}
