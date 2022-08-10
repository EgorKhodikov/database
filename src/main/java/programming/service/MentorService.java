package programming.service;

import programming.Application;
import programming.bean.Mentor;
import programming.dao.MentorDao;

import java.util.List;

public class MentorService {
    private final MentorDao mentorDao = new MentorDao();

    public Mentor findById() {
        System.out.println("Введите ID ментора.");
        Integer id = Application.scanner.nextInt();
        Mentor mentor = null;
        try {
            mentor = mentorDao.findById(id);
            if (mentor == null) throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Ментор с таким ID не найден");
        }
        return mentor;
    }

    public void save() {
        Application.scanner.nextLine(); // не работает nextLine без этого
        System.out.println("Введите фамилию ментора.");
        String lastName = Application.scanner.nextLine();
        Mentor mentor = new Mentor(lastName);
        mentor = mentorDao.save(mentor);
        System.out.println("Ментор " + mentor.getLastName() + " внесён в базу.");
    }

    public void update() {
        System.out.println("Введите ID ментора для обновления.");
        Integer id = Application.scanner.nextInt();
        try {
            Mentor mentor = mentorDao.findById(id);
            if (mentor == null) throw new NullPointerException();
            Application.scanner.nextLine(); // не работает nextLine без этого
            System.out.println("Введите новую фамилию ментора.");
            String lastName = Application.scanner.nextLine();
            mentor.setLastName(lastName);
            mentorDao.update(mentor);
            System.out.println("Ментор обновлён");
        } catch (NullPointerException e) {
            System.out.println("Ментор с таким ID не найден");
        }
    }

    public void delete() {
        System.out.println("Введите ID ментора для удаления из базы");
        Integer id = Application.scanner.nextInt();
        try {
            Mentor mentor = mentorDao.findById(id);
            if (mentor == null) throw new NullPointerException();
            mentorDao.delete(mentor);
            System.out.println("Ментор удалён");
        } catch (NullPointerException e) {
            System.out.println("Ментор с таким ID не найден");
        }
    }

    public Mentor findMentorByLanguageId() {
        System.out.println("Введите ID языка");
        Integer id = Application.scanner.nextInt();
        Mentor mentor = null;
        try {
            mentor = mentorDao.findMentorByLanguageId(id);
            if (mentor == null) throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Ни один ментор не привязан к данному языку программирования");
        }
        return mentor;
    }

    public List<String> findMentorNamesListByStudentStages() {
        System.out.println("Введите этап студентов");
        Integer stage = Application.scanner.nextInt();
        List<String> mentorNames = null;
        try {
            mentorNames = mentorDao.findMentorNamesListByStudentStages(stage);
            if (mentorNames.get(0) == null) throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Введено не правильное значение этапа либо на данном этапе нет студентов");
        }
        return mentorNames;
    }

    public Mentor findByIdHql() {
        System.out.println("Введите ID ментора");
        Integer id = Application.scanner.nextInt();
        Mentor mentor = null;
        try {
            mentor = mentorDao.findByIdHql(id);
            if (mentor == null) throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Ментор с таким ID не найден");
        }
        return mentor;
    }
}
