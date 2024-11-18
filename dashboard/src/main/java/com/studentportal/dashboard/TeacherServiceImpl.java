package com.studentportal.dashboard;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Teacher findByRollNoAndBarcode(String roll_no, String barcode) {
        return teacherRepository.findByRollNoAndBarcode(roll_no, barcode);
    }

    @Override
    public boolean validateTeacher(String roll_no, String barcode) {
        Teacher teacher = teacherRepository.findByRollNoAndBarcode(roll_no, barcode);
        return teacher != null;
    }

    @Override
    public List<Long> getStudentCountByTeacherUdise(String teacherUdise) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Long> studentCounts = new ArrayList<>();


        try (Session hibernateSession = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            String totalStudentsHql = "SELECT COUNT(s) FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise IS NOT NULL AND t.udise = :teacherUdise)";

            Query<Long> totalStudentsQuery = hibernateSession.createQuery(totalStudentsHql, Long.class);
            totalStudentsQuery.setParameter("teacherUdise", teacherUdise);
            Long totalStudentCount = totalStudentsQuery.uniqueResult();

            String englishStudentsHql = "SELECT COUNT(s) FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = :teacherUdise) AND s.subject = :subject";
            Query<Long> enslishStudentsQuery = session.createQuery(englishStudentsHql, Long.class);
            enslishStudentsQuery.setParameter("teacherUdise", teacherUdise);
            enslishStudentsQuery.setParameter("subject", "ENGLISH");
            Long englishStudentCount = enslishStudentsQuery.uniqueResult();

            String gkStudentsHql = "SELECT COUNT(s) FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = :teacherUdise) AND s.subject = :subject";
            Query<Long> gkStudentsQuery = session.createQuery(gkStudentsHql, Long.class);
            gkStudentsQuery.setParameter("teacherUdise", teacherUdise);
            gkStudentsQuery.setParameter("subject", "GENERAL KNOWLEDGE");
            Long gktudentCount = gkStudentsQuery.uniqueResult();

            String mathsStudentsHql = "SELECT COUNT(s) FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = :teacherUdise) AND s.subject = :subject";
            Query<Long> mathsStudentsQuery = session.createQuery(mathsStudentsHql, Long.class);
            mathsStudentsQuery.setParameter("teacherUdise", teacherUdise);
            mathsStudentsQuery.setParameter("subject", "MATHEMATICS");
            Long mathsStudentCount = mathsStudentsQuery.uniqueResult();

            String scienceStudentsHql = "SELECT COUNT(s) FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = :teacherUdise) AND s.subject = :subject";
            Query<Long> scienceStudentsQuery = session.createQuery(scienceStudentsHql, Long.class);
            scienceStudentsQuery.setParameter("teacherUdise", teacherUdise);
            scienceStudentsQuery.setParameter("subject", "SCIENCE");
            Long scienceStudentCount = scienceStudentsQuery.uniqueResult();

            String ssStudentsHql = "SELECT COUNT(s) FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = :teacherUdise) AND s.subject = :subject";
            Query<Long> ssStudentsQuery = session.createQuery(ssStudentsHql, Long.class);
            ssStudentsQuery.setParameter("teacherUdise", teacherUdise);
            ssStudentsQuery.setParameter("subject", "SOCIAL SCIENCE");
            Long ssStudentCount = ssStudentsQuery.uniqueResult();

            String sevenStudentsHql = "SELECT COUNT(s) FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = :teacherUdise) AND s.className = :className";
            Query<Long> sevenStudentsQuery = session.createQuery(sevenStudentsHql, Long.class);
            sevenStudentsQuery.setParameter("teacherUdise", teacherUdise);
            sevenStudentsQuery.setParameter("className", "7");
            Long sevenStudentCount = sevenStudentsQuery.uniqueResult();

            String eightStudentsHql = "SELECT COUNT(s) FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = :teacherUdise) AND s.className = :className";
            Query<Long> eightStudentsQuery = session.createQuery(eightStudentsHql, Long.class);
            eightStudentsQuery.setParameter("teacherUdise", teacherUdise);
            eightStudentsQuery.setParameter("className", "8");
            Long eightStudentCount = eightStudentsQuery.uniqueResult();

            String nineStudentsHql = "SELECT COUNT(s) FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = :teacherUdise) AND s.className = :className";
            Query<Long> nineStudentsQuery = session.createQuery(nineStudentsHql, Long.class);
            nineStudentsQuery.setParameter("teacherUdise", teacherUdise);
            nineStudentsQuery.setParameter("className", "9");
            Long nineStudentCount = nineStudentsQuery.uniqueResult();

            String tenStudentsHql = "SELECT COUNT(s) FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = :teacherUdise) AND s.className = :className";
            Query<Long> tenStudentsQuery = session.createQuery(tenStudentsHql, Long.class);
            tenStudentsQuery.setParameter("teacherUdise", teacherUdise);
            tenStudentsQuery.setParameter("className", "10");
            Long tenStudentCount = tenStudentsQuery.uniqueResult();

            String elevenStudentsHql = "SELECT COUNT(s) FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = :teacherUdise) AND s.className = :className";
            Query<Long> elevenStudentsQuery = session.createQuery(elevenStudentsHql, Long.class);
            elevenStudentsQuery.setParameter("teacherUdise", teacherUdise);
            elevenStudentsQuery.setParameter("className", "11");
            Long elevenStudentCount = elevenStudentsQuery.uniqueResult();


            studentCounts.add(totalStudentCount);
            studentCounts.add(englishStudentCount);
            studentCounts.add(gktudentCount);
            studentCounts.add(scienceStudentCount);
            studentCounts.add(mathsStudentCount);
            studentCounts.add(ssStudentCount);
            studentCounts.add(sevenStudentCount);
            studentCounts.add(eightStudentCount);
            studentCounts.add(nineStudentCount);
            studentCounts.add(tenStudentCount);
            studentCounts.add(elevenStudentCount);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return studentCounts;
    }


    public List<User> getAllStudents(String teacherUdise) {
        Session session = sessionFactory.openSession();
        List<User> studentDataList = null;

        try {
            String studentDataHql = "FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise =: teacherUdise)";

            Query<User> studentDataQuery = session.createQuery(studentDataHql, User.class);
            studentDataQuery.setParameter("teacherUdise", teacherUdise);
            studentDataList = studentDataQuery.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentDataList;
    }

    public List<User> getEnglishStudents(String teacherUdise) {
        Session session = sessionFactory.openSession();
        List<User> studentDataList = null;

        try {
            String englishStudentsHql = "FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = : teacherUdise) AND s.subject = :subject";
            Query<User> englishStudentsQuery = session.createQuery(englishStudentsHql, User.class);
            englishStudentsQuery.setParameter("teacherUdise", teacherUdise);
            englishStudentsQuery.setParameter("subject", "ENGLISH");
            studentDataList = englishStudentsQuery.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentDataList;
    }

    public List<User> getGKStudents(String teacherUdise) {
        Session session = sessionFactory.openSession();
        List<User> studentDataList = null;

        try {
            String englishStudentsHql = "FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = : teacherUdise) AND s.subject = :subject";
            Query<User> englishStudentsQuery = session.createQuery(englishStudentsHql, User.class);
            englishStudentsQuery.setParameter("teacherUdise", teacherUdise);
            englishStudentsQuery.setParameter("subject", "GENERAL KNOWLEDGE");
            studentDataList = englishStudentsQuery.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentDataList;
    }

    public List<User> getScienceStudents(String teacherUdise) {
        Session session = sessionFactory.openSession();
        List<User> studentDataList = null;

        try {
            String englishStudentsHql = "FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = : teacherUdise) AND s.subject = :subject";
            Query<User> englishStudentsQuery = session.createQuery(englishStudentsHql, User.class);
            englishStudentsQuery.setParameter("teacherUdise", teacherUdise);
            englishStudentsQuery.setParameter("subject", "SCIENCE");
            studentDataList = englishStudentsQuery.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentDataList;
    }

    public List<User> getMathsStudents(String teacherUdise) {
        Session session = sessionFactory.openSession();
        List<User> studentDataList = null;

        try {
            String englishStudentsHql = "FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = : teacherUdise) AND s.subject = :subject";
            Query<User> englishStudentsQuery = session.createQuery(englishStudentsHql, User.class);
            englishStudentsQuery.setParameter("teacherUdise", teacherUdise);
            englishStudentsQuery.setParameter("subject", "MATHEMATICS");
            studentDataList = englishStudentsQuery.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentDataList;
    }

    public List<User> getSSStudents(String teacherUdise) {
        Session session = sessionFactory.openSession();
        List<User> studentDataList = null;

        try {
            String englishStudentsHql = "FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = : teacherUdise) AND s.subject = :subject";
            Query<User> englishStudentsQuery = session.createQuery(englishStudentsHql, User.class);
            englishStudentsQuery.setParameter("teacherUdise", teacherUdise);
            englishStudentsQuery.setParameter("subject", "SOCIAL SCIENCE");
            studentDataList = englishStudentsQuery.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentDataList;
    }

    public List<User> getSeventhStudents(String teacherUdise) {
        Session session = sessionFactory.openSession();
        List<User> studentDataList = null;

        try {
            String englishStudentsHql = "FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = : teacherUdise) AND s.className = :className";
            Query<User> englishStudentsQuery = session.createQuery(englishStudentsHql, User.class);
            englishStudentsQuery.setParameter("teacherUdise", teacherUdise);
            englishStudentsQuery.setParameter("className", "7");
            studentDataList = englishStudentsQuery.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentDataList;
    }

    public List<User> getEighthStudents(String teacherUdise) {
        Session session = sessionFactory.openSession();
        List<User> studentDataList = null;

        try {
            String englishStudentsHql = "FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = : teacherUdise) AND s.className = :className";
            Query<User> englishStudentsQuery = session.createQuery(englishStudentsHql, User.class);
            englishStudentsQuery.setParameter("teacherUdise", teacherUdise);
            englishStudentsQuery.setParameter("className", "8");
            studentDataList = englishStudentsQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentDataList;
    }

    public List<User> getNineStudents(String teacherUdise) {
        Session session = sessionFactory.openSession();
        List<User> studentDataList = null;

        try {
            String englishStudentsHql = "FROM User s WHERE s.udise IN (SELECT t.udise FROM Teacher t WHERE t.udise = : teacherUdise) AND s.className = :className";
            Query<User> englishStudentsQuery = session.createQuery(englishStudentsHql, User.class);
            englishStudentsQuery.setParameter("teacherUdise", teacherUdise);
            englishStudentsQuery.setParameter("className", "9");
            studentDataList = englishStudentsQuery.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentDataList;
    }
}


