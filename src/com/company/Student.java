package com.company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Student implements Comparable<Student>{
    private String name;
    private ArrayList<Double> grades = new ArrayList<>();
    static private HashMap<String, Double> diary = new HashMap<>();
    private HashMap<Subject, ArrayList<Double>> hashSubcjet = new HashMap<>();
    private ArrayList<Double> listMath = new ArrayList<>();
    private ArrayList<Double> listPhysic = new ArrayList<>();
    private ArrayList<Double> listInf = new ArrayList<>();
    private Double mathAvarage;
    private Double physicAvarage;
    private Double infAvarage;
    private Double avarage;


    public Student(String name) {
        this.name = name;
        avarage = 0.0;
        mathAvarage = 0.0;
        physicAvarage = 0.0;
        infAvarage = 0.0;
        diary.put(name, avarage);
        hashSubcjet.put(Subject.MATEMATYKA, listMath);
        hashSubcjet.put(Subject.FIZYKA, listPhysic);
        hashSubcjet.put(Subject.INFORMATYKA, listInf);
    }

    public Student(String name, Double grade1, Double grade2, Double grade3) {
        this.name = name;
        grades.add(grade1);
        listInf.add(grade1);
        grades.add(grade2);
        listMath.add(grade2);
        grades.add(grade3);
        listPhysic.add(grade3);
        diary.put(name, avarage_grade());
        hashSubcjet.put(Subject.MATEMATYKA, listMath);
        hashSubcjet.put(Subject.FIZYKA, listPhysic);
        hashSubcjet.put(Subject.INFORMATYKA, listInf);
        infAvarage = grade1;
        mathAvarage = grade2;
        physicAvarage = grade3;
    }

    public String getName() {
        return name;
    }

    public double avarage_grade(){
        avarage = 0.0;
        for (int i=0; i<grades.size(); i++){
            avarage+=grades.get(i);
        }
        avarage/=grades.size();
        return avarage;
    }



    public static HashMap Diary(){
        return diary;
    }

    public static Double giveAvarage(String name){
        return diary.get(name);
    }

    public void Student_avarage()
    {
        System.out.println(name);
        System.out.println(diary.get(name));
    }

    public void add_grade(Double grade, int select) {
        if (grade >= 1 && grade <= 6) {
            int temp;
            grades.add(grade);
            diary.remove(name);
            diary.put(name, avarage_grade());
            switch (select){
                case 1:
                    listPhysic.add(grade);
                    physicAvarage = 0.0;
                    for (int i = 0; i<listPhysic.size(); i++)
                        physicAvarage += listPhysic.get(i);
                    physicAvarage /= listPhysic.size();
                    break;
                case 2:
                    listMath.add(grade);
                    mathAvarage = 0.0;
                    for (int i = 0; i<listMath.size(); i++)
                        mathAvarage += listMath.get(i);
                    mathAvarage /= listMath.size();
                    break;
                case 3:
                    listInf.add(grade);
                    infAvarage = 0.0;
                    for (int i = 0; i<listInf.size(); i++)
                        infAvarage += listInf.get(i);
                    infAvarage /=listInf.size();
                    break;
                default:
                    break;
            }

        }
        else
            System.out.println("Zła ocena");
    }


    public HashMap<Subject, ArrayList<Double>> getHashSubcjet() {
        return hashSubcjet;
    }

    public void show_grades(){
        System.out.println(hashSubcjet);
    }

    public Double getMathAvarage() {
        return mathAvarage;
    }

    public Double getPhysicAvarage() {
        return physicAvarage;
    }

    public Double getInfAvarage() {
        return infAvarage;
    }

    @Override
    public String toString() {
        return "Imie= " + name + "\n";
    }




    @Override
    public int compareTo(Student o) {
        int result = this.name.compareTo(o.name);
        return result;
    }
}
