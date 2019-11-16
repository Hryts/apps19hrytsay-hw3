package ua.edu.ucu.smartarr;

abstract class SmartArrayDecorator implements SmartArray {

    //    protected SmartArray smartArray;
    private Object[] array;

    public SmartArrayDecorator(SmartArray smartArray) {
//        this.smartArray = smartArray;
        array = smartArray.toArray();
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return array.length;
    }
}
