package programming.service;

import programming.Application;
import programming.bean.ProgrammingLanguage;
import programming.dao.ProgrammingLanguageDao;

import java.util.List;

public class ProgrammingLanguageService {
    private final ProgrammingLanguageDao programmingLanguageDao = new ProgrammingLanguageDao();

    public ProgrammingLanguage findById() {
        System.out.println("Введите ID языка.");
        Integer id = Application.scanner.nextInt();
        ProgrammingLanguage programmingLanguage = null;
        try {
            programmingLanguage = programmingLanguageDao.findById(id);
            if (programmingLanguage == null) throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Язык с таким ID не найден");
        }
        return programmingLanguage;
    }

    public void save() {
        Application.scanner.nextLine(); // не работает nextLine без этого
        System.out.println("Введите название языка.");
        String languageName = Application.scanner.nextLine();
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage(languageName);
        programmingLanguage = programmingLanguageDao.save(programmingLanguage);
        System.out.println("Язык программирования " + programmingLanguage.getLanguageName() + " внесён в базу.");
    }

    public void update() {
        System.out.println("Введите ID языка для обновления.");
        Integer id = Application.scanner.nextInt();
        try {
            ProgrammingLanguage programmingLanguage = programmingLanguageDao.findById(id);
            if (programmingLanguage == null) throw new NullPointerException();
            Application.scanner.nextLine(); // не работает nextLine без этого
            System.out.println("Введите новое название языка.");
            String languageName = Application.scanner.nextLine();
            programmingLanguage.setLanguageName(languageName);
            programmingLanguageDao.update(programmingLanguage);
            System.out.println("Язык обновлён");
        } catch (NullPointerException e) {
            System.out.println("Язык с таким ID не найден");
        }
    }

    public void delete() {
        System.out.println("Введите ID языка для удаления из базы");
        Integer id = Application.scanner.nextInt();
        try {
            ProgrammingLanguage programmingLanguage = programmingLanguageDao.findById(id);
            if (programmingLanguage == null) throw new NullPointerException();
            programmingLanguageDao.delete(programmingLanguage);
            System.out.println("Язык удалён");
        } catch (NullPointerException e) {
            System.out.println("Язык с таким ID не найден");
        }
    }

    public ProgrammingLanguage findLanguageByMentorId() {
        System.out.println("Введите ID ментора");
        Integer id = Application.scanner.nextInt();
        ProgrammingLanguage programmingLanguage = null;
        try {
            programmingLanguage = programmingLanguageDao.findLanguageByMentorId(id);
            if (programmingLanguage == null) throw new NullPointerException();
        } catch (NullPointerException e) {
            System.out.println("Ни один язык программирования не привязан к данному ментору");
        }
        return programmingLanguage;
    }

    public List<String> findLanguageNamesListFromMentors() {
        return programmingLanguageDao.findLanguageNamesListFromMentors();
    }

    public void print(ProgrammingLanguage programmingLanguage) {
        System.out.println("язык: " + programmingLanguage.getLanguageName());
    }
}
