package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{
    public DistinctDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        Object[] res;
        int counter = 0;
        for (int i = 0; i < array.length; ++i) {
            int temp = 0;
            for (int j = i + 1; j < array.length;  ++j) {
                if (func.apply(array[i]).equals(func.apply(array[j]))) {
                    temp = 1;
                }
            }
            if (temp == 0) {
                array[counter++] = array[i];
            }
        }
        array = Arrays.copyOf(array, counter);
    }
}
