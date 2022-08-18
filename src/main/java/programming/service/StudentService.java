package programming.service;

import programming.Application;
import programming.bean.Student;
import programming.dao.StudentDao;

public class StudentService {
    private final StudentDao studentDao = new StudentDao();

    public Student findById() {
        System.out.println("Введите ID студента.");
        Integer id = Application.scanner.nextInt();
        Student student = null;
        try {
            student = studentDao.findById(id);
            if (student == null) throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Студент с таким ID не найден");
        }
        return student;
    }

    public void save() {
        Application.scanner.nextLine(); // не работает nextLine без этого
        System.out.println("Введите фамилию студента.");
        String lastName = Application.scanner.nextLine();
        System.out.println("Введите этап.");
        Integer stage = Application.scanner.nextInt();
        Student student = new Student(lastName, stage);
        student = studentDao.save(student);
        System.out.println("Студент " + student.getLastName() + " внесён в базу.");
    }

    public void update() {
        System.out.println("Введите ID студента для обновления.");
        Integer id = Application.scanner.nextInt();
        try {
            Student student = studentDao.findById(id);
            if (student == null) throw new NullPointerException();
            Application.scanner.nextLine(); // не работает nextLine без этого
            System.out.println("Введите новую фамилию студента.");
            String lastName = Application.scanner.nextLine();
            System.out.println("Введите этап.");
            Integer stage = Application.scanner.nextInt();
            student.setLastName(lastName);
            student.setStage(stage);
            studentDao.update(student);
            System.out.println("Студент обновлён");
        } catch (NullPointerException e) {
            System.out.println("Студент с таким ID не найден");
        }
    }

    public void delete() {
        System.out.println("Введите ID студента для удаления из базы");
        Integer id = Application.scanner.nextInt();
        try {
            Student student = studentDao.findById(id);
            if (student == null) throw new NullPointerException();
            studentDao.delete(student);
            System.out.println("Студент удалён");
        } catch (NullPointerException e) {
            System.out.println("Студент с таким ID не найден");
        }
    }

    public Integer countStudentsNumberByLanguageName() {
        System.out.println("Введите название языка");
        String languageName = Application.scanner.nextLine();
        return studentDao.countStudentsNumberByLanguageName(languageName);
    }

    public void print(Student student) {
        System.out.println("студент: " + student.getLastName() + "\n"
                + "этап: " + student.getStage() + "\n"
                + "ментор: " + student.getMentor().getLastName());
    }
}
