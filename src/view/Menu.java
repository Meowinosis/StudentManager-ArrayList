package view;

import manager.StudentManager;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class Menu {
    StudentManager studentManager = new StudentManager();
    Scanner scanner = new Scanner(System.in);

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("========= Menu Student Manager ====== \n1.Thêm mới học sinh\n2.Sửa học sinh\n3.Xóa học sinh\n4.Tìm kiếm sinh viên\n5.Danh sách học viên cần tìm\n6.Học viên đtb cao nhất\n7.Hiển thị tất cả\n0.Thoát");
            System.out.println("Nhập lựa chọn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuEdit();
                    break;
                case 3:
                    showMenuDelete();
                    break;
                case 4:
                    showMenuFindById();
                    break;
                case 5:
                    showMenuFindByName();
                    break;
                case 6:
                    showMenuStudentsWithHighestAvg();
                    break;
                case 7:
                    showAll();
                    break;

            }
        } while (choice != 0);
    }
    public void showMenuAdd() {
        System.out.println("==== Đây là menu thêm mới ====");
        Student student = inputInfor();
        studentManager.add(student);
        System.out.println("====> Thêm thành công");
    }
    public void showMenuEdit() {
        System.out.println("==== Đây là menu edit ====");
        System.out.println("Nhap id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (studentManager.findStudentById(id) == null){
            System.out.println("không tìm thấy sinh viên");
        }else{
            Student student = inputInfor();
            studentManager.edit(id,student);
            System.out.println("====> Sửa thành công");
        }
    }

    public void showMenuDelete() {
        System.out.println("==== Xóa học sinh ======");
        System.out.println("Nhap id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (studentManager.findStudentById(id) == null){
            System.out.println("không tìm thấy sinh viên");
        }else{
            studentManager.remove(id);
            System.out.println("======> Xóa thành công");
        }
    }

    public void showAll() {
        System.out.println("Danh sách sinh viên là: ");
        List<Student> list = studentManager.findAll();
        for (Student student: list) {
            System.out.println(student);
        }
    }

    public void showMenuFindById(){
        System.out.println("==== Tìm học sinh theo id ======");
        System.out.println("Nhap id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (studentManager.findStudentById(id) == null){
            System.out.println("không tìm thấy sinh viên");
        }else{
            System.out.println(studentManager.findStudentById(id));
        }
    }

    public void showMenuFindByName(){
        System.out.println("==== Tìm học sinh theo tên ======");
        System.out.println("Nhap ten muon tim: ");
        String name = scanner.nextLine();
        List<Student> list = studentManager.findStudentsByName(name);
        if(list.isEmpty()){
            System.out.println("Không tìm thấy sinh viên nào");
        }else{
            for (Student student: list){
                System.out.println(student);
            }
        }
    }

    public void showMenuStudentsWithHighestAvg(){
        System.out.println("==== Học sinh có điểm trung bình cao nhất ======");
        List<Student> list = studentManager.findHighestStudentAvg();
        if(list.isEmpty()){
        }else{
            for (Student student: list){
                System.out.println(student);
            }
        }
    }

    private Student inputInfor(){
        Student student = new Student();
        Scanner sc = new Scanner(System.in);
        boolean flagGender = false;
        System.out.println("Nhap ten:");
        student.setName(sc.nextLine());
        do {
            System.out.println("Nhap gioi tinh:");
            String gender = sc.nextLine();
            if (gender.equalsIgnoreCase("male")) {
                student.setGender(true);
                flagGender = true;
            } else if (gender.equalsIgnoreCase("female")) {
                flagGender = true;
            } else {
                System.out.println("Vui long nhap lai gioi tinh (Male or Female)");
            }
        } while (!flagGender);
        for (int i = 0; i < student.getScore().length; i++) {
            System.out.println("Nhap diem " + (i + 1) + ":");
            double diem = sc.nextDouble();
            student.getScore()[i] = diem;
        }
        sc.nextLine();
        return student;
    }
}
