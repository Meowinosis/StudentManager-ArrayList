package manager;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentManager implements IManager<Student>{
    public List<Student> list;
    public StudentManager(){
        list= new ArrayList<>();
        Student student = new Student("Phon",new double[] {1,2,3},true);
        Student student1 = new Student("Tuan",new double[] {2,3,4},true);
        Student student2 = new Student("Phon",new double[] {5,6,7},true);
        Student student3 = new Student("Ha",new double[] {5,6,7},false);
        list.add(student);
        list.add(student1);
        list.add(student2);
        list.add(student3);
    }
    @Override
    public void add(Student student) {
        list.add(student);
    }

    @Override
    public void edit(int code, Student student) {
        for(Student st: list){
            if(st.getId() == code){
                st.setName(student.getName());
                st.setGender(student.isGender());
                st.setScore(student.getScore());
                return;
            }
        }
    }

    @Override
    public void remove(int id) {
        for(Student student: list){
            if(student.getId() == id){
                list.remove(student);
                return;
            }
        }
    }

    @Override
    public List<Student> findAll() {
        return list;
    }

    public Student findStudentById(int id){
        for(Student student: list){
            if (student.getId()==id){
                return student;
            }
        }
        return null;
    }

    public List<Student> findStudentsByName(String name){
        List<Student> students = new ArrayList<>();
        for (Student student: list){
            if(student.getName().contains(name)){
                students.add(student);
            }
        }
        return students;
    }

    public List<Student> findHighestStudentAvg(){
        List<Student> students = new ArrayList<>();
        double max = list.get(0).getAvgScore();
        for (Student student: list){
            if(max < student.getAvgScore()){
                max= student.getAvgScore();
            }
        }
        for (Student student: list){
            if(student.getAvgScore() == max){
                students.add(student);
            }
        }
        return students;
    }
}
