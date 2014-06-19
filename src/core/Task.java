package core;

import java.util.Date;
import javax.persistence.*;

/**
 * Created by Denis on 19.06.2014.
 */

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="task_id")
    private int id;

    @Column(name="task_a")
    private int a;
    @Column(name="task_b")
    private int b;
    @Column(name="task_c")
    private int c;
    @Column(name="task_action")
    private int action;
    @Column(name="task_added")
    private Date _added;

    public Task(){
        a = 0;
        b = 0;
        c = 0;
        action = 0;
    }

    public Task(int a,int b,int c,int action){
        this.a = a;
        this.b = b;
        this.c = c;
        this.action = action;
    }

    public void setA(int a){
        this.a = a;
    }

    public void setB(int b){
        this.b = b;
    }

    public void setC(int c){
        this.c = c;
    }

    public void setAction(int action){
        this.action = action;
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }

    public int getC(){
        return c;
    }

    public int getAction(){
        return action;
    }
}
