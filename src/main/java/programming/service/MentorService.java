package programming.service;

import org.hibernate.Session;
import programming.Application;
import programming.bean.Mentor;
import programming.dao.MentorDao;

import java.util.List;

public class MentorService {
    private final MentorDao mentorDao = new MentorDao();

    public void findById() {
        System.out.println("Введите ID ментора.");
        Integer id = Application.scanner.nextInt();
        try {
            Mentor mentor = mentorDao.findById(id);
            if (mentor == null) throw new NullPointerException();
            System.out.println(mentor.toString());
        } catch (NullPointerException e) {
            System.out.println("Ментор с таким ID не найден");
        }
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

    public void findLanguageByMentorId() {
        System.out.println("Введите ID ментора");
        Integer id = Application.scanner.nextInt();
        try {
            String languageName = mentorDao.findLanguageByMentorId(id);
            if (languageName == null) throw new NullPointerException();
            System.out.println(languageName);
        } catch (NullPointerException e) {
            System.out.println("Ни один язык программирования не привязан к данному ментору");
        }
    }

    public void findLanguageNameListFromMentors() {
        List<String> languageNames = mentorDao.findLanguageNameListFromMentors();
        languageNames.forEach(System.out::println);
    }

    public void findByHql() {
        System.out.println("Введите ID ментора");
        Integer id = Application.scanner.nextInt();
        Session session = mentorDao.getSession();
        try {
            Mentor mentor = mentorDao.findByHql(id, session);
            if (mentor == null) throw new NullPointerException();
            System.out.println(mentor);
        } catch (NullPointerException e) {
            System.out.println("Ментор с таким ID не найден");
        }
        session.close();
    }
}
