package ua.edu.ucu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

public class SmartArrayApp {

    public static Integer[]
            filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {
                
        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };

        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
            findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        MyPredicate year = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student)t).getYear() == 2;
            }
        };
        MyPredicate gpa = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Student)t).getGPA() >= 4;
            }
        };
        MyComparator bySurname = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String surname1 = ((Student)o1).getSurname();
                String surname2 = ((Student)o2).getSurname();
                int res = String.CASE_INSENSITIVE_ORDER.compare(
                        surname1, surname2
                );
                if (res == 0) {
                    res = surname1.compareTo(surname2);
                }
                return res;
            }
        };
        MyFunction getName = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return ((Student)t).getName();
            }
        };
        MyFunction toStr = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return (String)(((Student)t).getName() + ((Student) t).getSurname());
            }
        };

        SmartArray studentSmartArray = new BaseArray(students);
        studentSmartArray = new FilterDecorator(studentSmartArray, year);
        studentSmartArray = new FilterDecorator(studentSmartArray, gpa);
        studentSmartArray = new SortDecorator(studentSmartArray, bySurname);
        studentSmartArray = new DistinctDecorator(studentSmartArray, getName);
        Object[] studentsArray =  studentSmartArray.toArray();

        String[] result = new String[studentSmartArray.size()];
        for (int i = 0; i < studentSmartArray.size(); ++i) {
            Object student = studentsArray[i];
            result[i] = (String)(((Student)student).getSurname() + " " +
                    ((Student) student).getName());
        }

        return result;
    }
}
