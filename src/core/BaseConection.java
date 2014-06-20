package core;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.swing.*;

/**
 * Created by Denis on 20.06.2014.
 */
public class BaseConection {
    public static void addTask(Task task){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(task);
            session.getTransaction().commit();
            System.out.println("Task saved!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
// TODO code is the same
    public static void addHistory(HistoryTask historyTask){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(historyTask);
            session.getTransaction().commit();
            System.out.println("historyTask saved!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
