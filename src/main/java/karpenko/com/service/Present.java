package karpenko.com.service;

/**
 * Created by Олег on 31.01.2017.
 */

import java.util.ArrayList;


interface Present {

    /**
     *
     * @return возвращает цену за букет
     */
    int price();

    /**
     *
     * @param fromNum искать от
     * @param toNum искать до
     * @return возвращает найденные объекты в заданном диапазоне
     */
    ArrayList find(int fromNum, int toNum);


}
