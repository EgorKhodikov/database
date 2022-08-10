package programming.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
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

    public ProgrammingLanguage findLanguageByMentorId(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        ProgrammingLanguage programmingLanguage = null;
        try {
            Criteria criteria = session.createCriteria(Mentor.class);
            criteria.add(Restrictions.eq("id", id));
            programmingLanguage = ((Mentor)criteria.uniqueResult()).getProgrammingLanguage();
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return programmingLanguage;
    }

    public List<String> findLanguageNamesListFromMentors() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<String> languageNames = null;
        try {
            Criteria criteria = session.createCriteria(Mentor.class);
            criteria.createAlias("programmingLanguage", "programmingLanguage");
            criteria.setProjection(Projections.distinct(Projections.property("programmingLanguage.languageName")));
            languageNames = criteria.list();
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return languageNames;
    }
}
