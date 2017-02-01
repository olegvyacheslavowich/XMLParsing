package karpenko.com.service;

/**
 * Created by Олег on 31.01.2017.
 */

import java.util.ArrayList;

/**
 * Интерфейс "Подарок" имеет два метода
 * compile - собирает букет из цветов и  упаковки
 * allPrice - возвращает цену за букет
 */
public interface Present {


    public int price();

    public void sort();

    public String find(int fromNum, int toNum);


}
