package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double grade;
        int x=1, y, z;
        String name;
        HashMap<Integer, Student> hashmap = new HashMap<>();
        ArrayList<Student> list = new ArrayList<>();
        TreeSet<Student> treeComprareName = new TreeSet<>();
        TreeSet<Student> treeCompareAvarage = new TreeSet<>(new ComparatorTreeSet());




        Student s1 = new Student("Adam", 2.5, 5.0, 3.5);
        Student s2 = new Student("Marek", 4.0, 2.0, 4.5);
        Student s3 = new Student("Jan", 1.0, 3.0, 2.5);
        Student s4 = new Student("Piotr", 5.0, 4.5, 3.5);

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);


        treeComprareName.addAll(list);
        treeCompareAvarage.addAll(list);


        while(x!=0) {
            System.out.println("1 - Dodaj ucznia");
            System.out.println("2 - Dodaj ocene");
            System.out.println("3 - Wyswietl liste");
            System.out.println("4 - Sprawdz oceny");
            System.out.println("5 - Dziennik");
            System.out.println("6 - Oceny uczniow");
            System.out.println("0 - Zakoncz");
            x = scanner.nextInt();

            switch (x) {
                case 1:
                    System.out.print("Imie: ");
                    name = scanner.next();
                    list.add(new Student(name));
                    treeComprareName.add(list.get(list.size()-1));
                    treeCompareAvarage.add(list.get(list.size()-1));
                    break;
                case 2:
                    System.out.println("Wybierz ucznia:");
                    for (int i =0; i<list.size(); i++){
                        System.out.println(i + 1 + " - " + list.get(i).getName());
                    }
                    y = scanner.nextInt();
                    System.out.println("Wybierz przedmiot:");
                    System.out.println("1 - " + Subject.FIZYKA);
                    System.out.println("2 - " + Subject.MATEMATYKA);
                    System.out.println("3 - " + Subject.INFORMATYKA);
                    z = scanner.nextInt();
                    System.out.print("Wpisz ocene: ");
                    grade = scanner.nextDouble();
                    list.get(y-1).add_grade(grade, z);
                    break;
                case 3:
                    System.out.println(treeComprareName);
                    break;
                case 4:
                    System.out.println("Wybierz ucznia:");
                    for (int i =0; i<list.size(); i++){
                        System.out.println(i + 1 + " - " + list.get(i).getName());
                    }
                    y = scanner.nextInt();
                    System.out.println(list.get(y-1).getName() + ":\nOceny\n" + list.get(y-1).getHashSubcjet() + "\nSrednie z przedmiotow:\n" + Subject.INFORMATYKA + " = " + list.get(y-1).getInfAvarage() + "\n" + Subject.FIZYKA + " = " + list.get(y-1).getPhysicAvarage() + "\n" + Subject.MATEMATYKA + " = " + list.get(y-1).getMathAvarage() + "\nSrednia ocen = " + list.get(y-1).avarage_grade());
                    break;
                case 5:
                    System.out.println(Student.Diary());
                    break;
                case 6:
                    for (int i=0; i<list.size(); i++){
                        System.out.println(list.get(i).getName());
                        System.out.println(list.get(i).getHashSubcjet());
                    }
            }
        }


    }
}
