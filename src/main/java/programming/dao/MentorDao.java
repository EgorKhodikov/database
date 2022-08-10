package programming.dao;

import org.hibernate.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import programming.bean.Mentor;
import programming.bean.Student;
import programming.util.HibernateSessionFactoryUtil;

import java.util.List;

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

    public Mentor findMentorByLanguageId(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Mentor mentor = null;
        try {
            Criteria criteria = session.createCriteria(Mentor.class);
            criteria.add(Restrictions.eq("programmingLanguage.id", id));
            mentor = (Mentor) criteria.uniqueResult();
            Hibernate.initialize(mentor.getProgrammingLanguage());
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return mentor;
    }

    public List<String> findMentorNamesListByStudentStages(Integer stage) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<String> mentorNames = null;
        try {
            Criteria criteria = session.createCriteria(Student.class);
            criteria.add(Restrictions.eq("stage", stage));
            criteria.createAlias("mentor", "mentor");
            criteria.setProjection(Projections.distinct(Projections.property("mentor.lastName")));
            mentorNames = criteria.list();
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return mentorNames;
    }

    public Mentor findByIdHql(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Mentor mentor;
        String hql = "FROM Mentor where id = " + id;
        Query query = session.createQuery(hql);
        mentor = (Mentor) query.uniqueResult();
        Hibernate.initialize(mentor.getProgrammingLanguage());
        session.close();
        return mentor;
    }
}
