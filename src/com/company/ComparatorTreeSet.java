package com.company;

import java.util.Comparator;

public class ComparatorTreeSet implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.avarage_grade()>o2.avarage_grade()) return 1;
        if(o1.avarage_grade()<o2.avarage_grade()) return -1;
        else return 0;
    }
}
