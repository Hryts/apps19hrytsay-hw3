package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        for (int i = 0; i < smartArray.size(); ++i) {
            array[i] = func.apply(array[i]);
        }
    }
}
