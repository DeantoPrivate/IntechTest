package core;

import javax.persistence.*;

/**
 * Created by Denis on 19.06.2014.
 */
@Entity
@Table(name="historyTask")
@AttributeOverrides({
        @AttributeOverride(name="a", column=@Column(name="task_a")),
        @AttributeOverride(name="b", column=@Column(name="task_b")),
        @AttributeOverride(name="c", column=@Column(name="task_c")),
        @AttributeOverride(name="action", column=@Column(name="task_action")),
        @AttributeOverride(name="_added", column=@Column(name="task_added"))
})
public class HistoryTask extends Task{

    @Column(name="history_res")
    private int res;

    public HistoryTask(){
        super();
        res = 0;
    }

    public HistoryTask(Task task,int res){
        setA(task.getA());
        setB(task.getB());
        setC(task.getC());
        setAction(task.getAction());

        this.res = res;
    }

    public void setRes(int res){
        this.res = res;
    }

    public int getRes(){
        return res;
    }
}
