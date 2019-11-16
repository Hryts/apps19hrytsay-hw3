package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {

    public FilterDecorator(SmartArray smartArray, MyPredicate mp) {
        super(smartArray);
        int counter = 0;
        Object[] res = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; ++i) {
            if (mp.test(array[i])) {
                res[counter++] = res[i];
            }
        }
        res = Arrays.copyOf(res, counter);
        array = res;
    }
}
