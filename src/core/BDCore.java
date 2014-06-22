package core;

import org.hibernate.Session;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Denis on 22.06.2014.
 */
public class BDCore {

    private static ArrayList<ATask> tmp = new ArrayList<ATask>();

    public static void add(Collection<ATask> task){
        addCollection(task);
    }

    public static void add(Task task){
        tmp.add(task);
        addCollection(tmp);
        tmp.clear();
    }

    public static void add(HistoryTask historyTask){
        tmp.add(historyTask);
        addCollection(tmp);
        tmp.clear();
    }

    private static int taskGotPos = 1;

    public static Task getNextTask(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Task task = (Task)session.get(Task.class,new Integer(taskGotPos));
        taskGotPos++;
        return task;
    }

    public static void remove(Task task){

    }

    private static void addCollection(Collection<ATask> task){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            for(ATask o : task)
                session.save(o);
            session.getTransaction().commit();
            System.out.println("saved!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при работе с базой данных", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
