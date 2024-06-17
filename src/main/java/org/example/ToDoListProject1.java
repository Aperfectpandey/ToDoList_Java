package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

//1>Define Task.Java with CLasses,Constructor.
//2>Define TaskManager.java with fields,methods.
//3>Main class with main(),displayMenu(),handleUserInput().
class Task{
    private int id;
    private String description;
    private boolean isComplete;

    public Task(int id,String desc){
        this.id=id;
        this.description=desc;
        this.isComplete=false;
    }
    //Encapsulation concepts with getter and Setter.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isComplete=" + isComplete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task task)) return false;
        return id == task.id && isComplete == task.isComplete && Objects.equals(description, task.description);
    }
    //Note:Equals & HashCode are mostly overridden because when the collection of hash is from HashSet,HashMap,HashCode().
    @Override
    public int hashCode() {
        return Objects.hash(id, description, isComplete);
    }
}
//TaskManager.class
class TaskManager{
    private List<Task> tasks;
    private int nextId;

    public TaskManager(){
        this.tasks=new ArrayList<>();
        this.nextId=1; //This we are doing internally. Things are added into it in the background.
    }
    public void addTask(String descp){
        Task newTask=new Task(nextId++,descp);
        tasks.add(newTask);
    }
    public void viewTask(){
        if(tasks.isEmpty()){
            System.out.println("No Task available");
        }else{
            for(Task tsk:tasks){
                System.out.println(tsk);
            }
        }
    }
    public void removeTask(int id){
        tasks.removeIf(tsk->tsk.getId()==id);
    }
}
public class ToDoListProject1 {
    private static TaskManager taskManager=new TaskManager(); //Single instances of that department(static) that is private to the company(class) and cannot be accessed by outsiders(other classes).
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        boolean exit=false;
        while (!exit){
            displayMenu(); //To display Things on the Controller class Like list of itmes in the menu.
            int ch=sc.nextInt();
            switch(ch){
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTask();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    exit=true;
                    break;
                default:
                    System.out.println("Invalid choice,Please try again");
            }
        }
    }
    private static void displayMenu(){
        System.out.println("To-Do List Application");
        System.out.println("1. Add Task");
        System.out.println("2. View Task");
        System.out.println("3. Remove Task");
        System.out.println("4. Exit");
        System.out.println("Enter your choice:");
    }
    private static void addTask(){
        System.out.println("Enter Task Description:");
        String desc=sc.nextLine();
        sc.nextLine();
        taskManager.addTask(desc);
        System.out.println("Task Added.");
    }
    private static void viewTask(){
        taskManager.viewTask();
    }
    private static void removeTask(){
        System.out.println("Enter task id to remove:");
        int id=sc.nextInt();
        sc.nextLine();  //consumes newLine.
        taskManager.removeTask(id);
        System.out.println("Task Removed.");
    }
}
