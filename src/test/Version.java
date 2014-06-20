package test;

/**
 * Created by Denis on 19.06.2014.
 */
import core.BaseConection;
import core.HibernateUtil;
import core.HistoryTask;
import core.Task;
import org.hibernate.SessionFactory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Version {

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;


        String url = "jdbc:postgresql://localhost/postgres";
        String user = "postgres";
        String password = "super";

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT VERSION()");

            if (rs.next()) {
                System.out.println("fr@ :"+rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(Version.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(Version.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }

        try{
            SessionFactory sf = HibernateUtil.getSessionFactory();

        } catch (Exception e){
            System.out.println("HibernateUtil getSessionFactory failed!");
        }

        for (int i=0;i<10;i++) {
            Task task = new Task(1, i + 2, i - 3, 4);
            BaseConection.addTask(task);

            HistoryTask historyTask = new HistoryTask(new Task(10,20,30,40), 100);
            BaseConection.addHistory(historyTask);
        }

        java.util.Collection tasks = BaseConection.getAllTasks();

        int t=0;

    }
}
