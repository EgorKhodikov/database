package programming.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import programming.bean.Student;
import programming.util.HibernateSessionFactoryUtil;

public class StudentDao implements Dao<Student> {

    @Override
    public Student save(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = null;
        try {
            id = (Integer) session.save(student);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return findById(id);
    }

    @Override
    public Student findById(Integer id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    @Override
    public void update(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(student);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(student);
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
    }

    public Integer countStudentsNumberByLanguageName(String languageName) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Integer studentsCount = null;
        try {
            Criteria criteria = session.createCriteria(Student.class);
            criteria.createAlias("programmingLanguage", "programmingLanguage");
            criteria.add(Restrictions.eq("programmingLanguage.languageName", languageName));
            criteria.setProjection(Projections.rowCount());
            studentsCount = Integer.parseInt(criteria.uniqueResult().toString());
        } catch (HibernateException e) {
            transaction.rollback();
        }
        transaction.commit();
        session.close();
        return studentsCount;
    }
}
