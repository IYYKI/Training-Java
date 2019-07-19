package Day5_7_18周四.圆;

public class Round {
    private double R;
    public Round(){

    }
    public Round(double R){
        this.R = R;
    }
    //体积
    public double V(){
        double V = (4d/3*Math.PI*Math.pow(R,3));
        return V;
    }
    //面积
    public double S (){
        double S = (4*Math.PI*Math.pow(R,2));
                return S;
    }
}
