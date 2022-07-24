package programming.service;

import programming.Application;
import programming.bean.Mentor;
import programming.dao.MentorDao;

public class MentorService {
    private final MentorDao mentorDao = new MentorDao();

    public void findById() {
        System.out.println("Введите ID ментора.");
        Integer id = Application.scanner.nextInt();
        Mentor mentor = mentorDao.findById(id);
        System.out.println(mentor.toString());
    }

    public void save() {
        System.out.println("Введите фамилию ментора.");
        String lastName = Application.scanner.nextLine();
        Mentor mentor = new Mentor(lastName);
        mentor = mentorDao.save(mentor);
        System.out.println("Ментор " + mentor.getLastName() + " внесён в базу.");
    }

    public void update() {
        System.out.println("Введите ID ментора для обновления.");
        Integer id = Application.scanner.nextInt();
        System.out.println("Введите новую фамилию ментора.");
        String lastName = Application.scanner.nextLine();
        Mentor mentor = mentorDao.findById(id);
        mentor.setLastName(lastName);
        mentorDao.update(mentor);
    }

    public void delete() {
        System.out.println("Введите ID ментора для удаления из базы");
        Integer id = Application.scanner.nextInt();
        Mentor mentor = mentorDao.findById(id);
        mentorDao.delete(mentor);
    }
}
