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
import java.util.stream.Collectors;

public class MentorDao implements Dao<Mentor> {
    @Override
    public Mentor save(Mentor mentor) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = null;
        try {
            id = (Integer) session.save(mentor);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        mentor = findById(id);
        return mentor;
    }

    @Override
    public Mentor findById(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Mentor mentor = session.get(Mentor.class, id);
        session.close();
        return mentor;
    }

    @Override
    public void update(Mentor mentor) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(mentor);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Mentor mentor) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(mentor);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
    }

    public String findLanguageByMentorId(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String languageName = null;
        try {
            Criteria criteria = session.createCriteria(Mentor.class);
            criteria.add(Restrictions.eq("id", id));
            List<Mentor> mentors = criteria.list();
            ProgrammingLanguage programmingLanguage = mentors.get(0).getProgrammingLanguage();
            languageName = programmingLanguage.getLanguageName();
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return languageName;
    }

    public List<String> findLanguageNameListFromMentors() {
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
