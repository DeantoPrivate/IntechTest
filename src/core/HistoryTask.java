package core;

/**
 * Created by Denis on 19.06.2014.
 */
public class HistoryTask extends Task{

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
