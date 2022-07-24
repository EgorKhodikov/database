package programming.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import programming.bean.Mentor;
import programming.bean.Student;
import programming.util.HibernateSessionFactoryUtil;

public class MentorDao implements Dao<Mentor>{
    @Override
    public Mentor save(Mentor mentor) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Integer id = (Integer) session.save(mentor);
            mentor = findById(id);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return mentor;
    }

    @Override
    public Mentor findById(Integer id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Mentor.class, id);
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
}
