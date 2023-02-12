package com.selfstudy.studentSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class studentSystem {
    public static void main(String[] args) {
        String[] actions = {"添加学生", "删除学生", "修改学生", "查询学生", "退出"};
        ArrayList<Student> list = new ArrayList<>();

        loop: while (true) {
            showWelcom(actions);
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1" -> addStudent(list);
                case "2" -> deleteStudent(list);
                case "3" -> updateStudent(list);
                case "4" -> queryStudent(list);
                case "5" -> {
                    System.out.println(actions[4]);
                    // break loop; // 跳出指定循环体
                    System.exit(0);
                }
                default -> System.out.println("没有该选项,请重新输入");
            }
        }
    }

    public static void showWelcom(String[] actions) {
        System.out.println("**********欢迎来到我的学生管理系统**********");
        for (int i = 0; i < actions.length; i++) {
            System.out.printf("\"%s\": %s", i+1, actions[i]);
            System.out.println();
        }
        System.out.println("请输入您的选择:");
    }

    public static void addStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        String id;
        while (true) {
            System.out.println("请输入id: ");
            id = sc.next();
            // 判断id是否存在
            boolean flag = contains(list, id);
            if (flag) {
                System.out.println("该id已存在,请重新输入! ");
                continue;
            } else {
                break;
            }
        }
        System.out.println("请输入姓名: ");
        String name = sc.next();
        System.out.println("请输入年龄");
        int age = sc.nextInt();

        System.out.println("请输入地址");
        String address = sc.next();

        Student stu = new Student(id, name, age, address);
        list.add(stu);

        System.out.println("添加学生成功! ");

    }

    public static void deleteStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入id: ");
        String id = sc.next();
        int index = findIndex(list, id);
        if(index > -1) {
            list.remove(index);
            System.out.println("删除成功!");
        } else {
            System.out.println("该id不存在!");
        }
    }

    public static void updateStudent(ArrayList<Student> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入id: ");
        String id = sc.next();
        // 判断id是否存在
        int index = findIndex(list, id);
        if (index > -1) {
            System.out.println("请输入姓名: ");
            String name = sc.next();
            System.out.println("请输入年龄");
            int age = sc.nextInt();
            System.out.println("请输入地址");
            String address = sc.next();
            Student stu = new Student(id, name, age, address);
            list.set(index, stu);
            System.out.printf("修改学生成功: ");
            showInfo(stu);
        } else {
            System.out.println("该id不存在!");
        }
    }

    public static void queryStudent(ArrayList<Student> list) {
        if (list.size() == 0) {
            System.out.println("当前无学生信息,请添加后再查询");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            showInfo(stu);
        }
    }
    public static void showInfo(Student stu) {
        System.out.println("id\t\t姓名\t年龄\t地址");
        System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() +
                "\t" + stu.getAddress());
    }
    public static boolean contains(ArrayList<Student> list, String id) {
        return findIndex(list, id) > -1;
    }
    public static int findIndex(ArrayList<Student> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}