package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Student {
    private int id;
    private static String firstName;
    private String lastName;
    private int age;
    private long mobileNo;
    private long averageRes;
    private int salary;

    Student() {}

    // Constructor with parameters
    public Student(int id, String firstName, String lastName, int age, long mobileNo, long averageRes, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.mobileNo = mobileNo;
        this.averageRes = averageRes;
        this.salary = salary;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAverageRes() {
        return averageRes;
    }

    public void setAverageRes(long averageRes) {
        this.averageRes = averageRes;
    }

    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getSalary(){ return salary;}
    public void setSalary(int s){this.salary=s;}

    public String getFirstName(){ return firstName;}
   // public void setFirstName(String first){this.firstName=first;}

    @Override
    public String toString(){
        return "Student{"+
                "id="+id+
                ", firstName=" + firstName+
                ",lastName=" +lastName+
                ",age=" +age+
                ",mobileNo="+mobileNo+
                ", averageRes=" +averageRes+
                ", salary=" + salary +
                '}';

    }

}

public class Java8Practice {
    public static void main(String[] args) {
        System.out.println("Mark the number: " + 24.5);
        // Creating the student list
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Rohan", "Mohan", 32, 8826095049L, 2764538294021L, 20200));
        students.add(new Student(2, "Rohan1", "Mohan1", 34, 8826095049L, 2764538294021L, 25200));
        students.add(new Student(3, "Rohan2", "Mohan2", 35, 8826095049L, 2764538294021L, 26200));
        students.add(new Student(4, "Rohan3", "Mohan3", 29, 8826095049L, 2764538294021L, 19200));
        students.add(new Student(5, "Mohit", "Malan", 23, 975647382L, 4536274782L, 59200));

        // Printing student list
        students.forEach(System.out::println);

        // Creating more student lists
        List<Student> list1 = Stream.of(
                new Student(3, "RohanM", "Mohan2", 35, 8826095049L, 2764538294021L, 26200),
                new Student(5, "Mohitt", "Malan", 23, 975647382L, 4536274782L, 59200)
        ).collect(Collectors.toList());

        List<Student> list2 = Stream.of(
                new Student(5, "Mike", "Jackson", 42, 774372929L, 882634554738L, 19350),
                new Student(6, "Mikey", "Jacksons", 21, 774372929L, 882634554738L, 19350)
        ).collect(Collectors.toList());

        List<List<Student>> linkedList=new LinkedList<>();
        linkedList.add(list1);
        linkedList.add(list2);

        System.out.print("\n"); //change a line space between the lines.

        // Finding students aged between 30 and 35
        List<Student> studentsList = students.stream()
                .filter(stu -> stu.getId() > 2 && stu.getId() < 5)
                .collect(Collectors.toList());

        // Printing filtered students
        studentsList.forEach(System.out::println);
        System.out.println("Number of students aged between 30 and 35: " + studentsList.size());

        // Finding students whose mobile numbers do not start with '9'
        List<Student> studentsWithMobileNotStartingWith9 = students.stream()
                .filter(stu -> String.valueOf(stu.getMobileNo()).charAt(0) != '9')
                .collect(Collectors.toList());
        List<Student> listStud=list1.stream().filter(s->String.valueOf(s.getAverageRes()).contains("2L")).collect(Collectors.toList());
        System.out.println("checks the contains() methods:"+list1.size());
        listStud.forEach(System.out::println);
        //Finding value starting with mobile No 9
       // List<Student> studentWithStarting9=
        students.stream().filter(s->String.valueOf(s.getMobileNo()).charAt(0)=='9').collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("Value for mobile no not staring with 9:\n");
      //  System.out.println("Number of students with mobile numbers not starting with '9': " + studentWithStarting9.size());
        // Printing students with mobile numbers not starting with '9'
        studentsWithMobileNotStartingWith9.forEach(System.out::println);
        System.out.println("Number of students with mobile numbers not starting with '9': " + studentsWithMobileNotStartingWith9.size());
        //Sort the salary in descending order and display just find the first name of the Students adding it in Linked List
       //List<String> lisString=linkedList.stream().sorted(Comparator.comparingInt(Student::getSalary).reversed()).map(Student::getFirstName).collect(Collectors.toList());
        List<Student> lisStringVal=linkedList.stream().flatMap(List::stream).collect(Collectors.toList());
        List lisString=lisStringVal.stream().sorted(Comparator.comparingInt(Student::getSalary).reversed()).map(Student::getSalary).collect(Collectors.toList());
        //Sort the salary in descending order and display just find the first name of the Students adding it in Linked List
        int max=0;
        //linkedList=List<List<Student>>1900,1800,2000,2100 //sort the name in descending order based on salary using java7.
        List<String> lis=Arrays.asList("a","b","c","d");
        List<List<String>> lis1=new LinkedList<>();
        lis1.add(lis);
        List<String> allVal=new ArrayList<>();
        for(int i=0;i<lis1.size();i++){
            for(int j=0;j<lis1.get(i).size();j++){
                if(lis1.get(i).get(j).contains("a")) {
                    allVal.add(lis1.get(i).get(j).toLowerCase());
                }
            }
        }
        allVal.forEach(System.out::println);
        allVal.stream().forEach(s->System.out.println("this is:"+s));
    }
}
