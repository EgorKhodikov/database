package programming.service;

import programming.Application;
import programming.bean.ProgrammingLanguage;
import programming.dao.ProgrammingLanguageDao;

public class ProgrammingLanguageService {
    private final ProgrammingLanguageDao programmingLanguageDao = new ProgrammingLanguageDao();

    public void findById() {
        System.out.println("Введите ID языка.");
        Integer id = Application.scanner.nextInt();
        ProgrammingLanguage programmingLanguage = programmingLanguageDao.findById(id);
        System.out.println(programmingLanguage.toString());
    }

    public void save() {
        System.out.println("Введите название языка.");
        String languageName = Application.scanner.nextLine();
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage(languageName);
        programmingLanguage = programmingLanguageDao.save(programmingLanguage);
        System.out.println("Язык программирования " + programmingLanguage.getLanguageName() + " внесён в базу.");
    }

    public void update() {
        System.out.println("Введите ID языка для обновления.");
        Integer id = Application.scanner.nextInt();
        System.out.println("Введите новое название языка.");
        String languageName = Application.scanner.nextLine();
        ProgrammingLanguage programmingLanguage = programmingLanguageDao.findById(id);
        programmingLanguage.setLanguageName(languageName);
        programmingLanguageDao.update(programmingLanguage);
    }

    public void delete() {
        System.out.println("Введите ID языка для удаления из базы");
        Integer id = Application.scanner.nextInt();
        ProgrammingLanguage programmingLanguage = programmingLanguageDao.findById(id);
        programmingLanguageDao.delete(programmingLanguage);
    }
}
