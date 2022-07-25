package programming.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import programming.bean.ProgrammingLanguage;
import programming.util.HibernateSessionFactoryUtil;

public class ProgrammingLanguageDao implements Dao<ProgrammingLanguage> {
    @Override
    public ProgrammingLanguage save(ProgrammingLanguage programmingLanguage) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = null;
        try {
            id = (Integer) session.save(programmingLanguage);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        programmingLanguage = findById(id);
        return programmingLanguage;
    }

    @Override
    public ProgrammingLanguage findById(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        ProgrammingLanguage programmingLanguage = session.get(ProgrammingLanguage.class, id);
        session.close();
        return programmingLanguage;
    }

    @Override
    public void update(ProgrammingLanguage programmingLanguage) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(programmingLanguage);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(ProgrammingLanguage programmingLanguage) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(programmingLanguage);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
    }
}
