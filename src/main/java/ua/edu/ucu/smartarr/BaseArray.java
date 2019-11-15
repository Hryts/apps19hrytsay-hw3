package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    Object[] array;

    public BaseArray(Object[] array) {
        this.array = array;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public String operationDescription() {
        return "";
    }

    @Override
    public int size() {
        return array.length;
    }
}
