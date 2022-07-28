package programming.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import programming.bean.Mentor;
import programming.bean.ProgrammingLanguage;
import programming.util.HibernateSessionFactoryUtil;

import java.util.List;

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

    public String findMentorByLanguageId(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String mentorLastName = null;
        try {
            Criteria criteria = session.createCriteria(ProgrammingLanguage.class);
            criteria.add(Restrictions.eq("id", id));
            List<ProgrammingLanguage> programmingLanguages = criteria.list();
            Mentor mentor = programmingLanguages.get(0).getMentor();
            mentorLastName = mentor.getLastName();
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return mentorLastName;
    }
}
