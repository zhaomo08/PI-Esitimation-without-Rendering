import java.awt.*;

/**
 * @author jiacheng
 * @date 27/6/23 11:37 pm Tuesday
 * @description :
 */
public class MonteCarloExperiment {

    private int squareside;

    private int N;

    private int outputInterval = 100;

    public MonteCarloExperiment(int squareside,int N){
        if (squareside <= 0 || N <= 0){
            throw new IllegalArgumentException("squareSide and N must larger the Zero");
        }
        this.squareside = squareside;
        this.N = N;
    }


    public void  setOutputInterval(int interval){
        if (interval < 0){
            throw new IllegalArgumentException("interval  must larger the Zero");
        }
        this.outputInterval = interval;
    }

    public void  run(){
        Circle circle = new Circle(squareside/2,squareside/2 ,squareside/2);
        MonteCarloPiData data = new MonteCarloPiData(circle);
        for (int i = 0; i < N; i++) {
            if (i % outputInterval ==0){
                System.out.println(data.estimatePi());
            }
            int x = (int) (Math.random() * squareside);
            int y = (int) (Math.random() * squareside);
            data.addPoint(new Point(x,y));
        }
    }

    public static void main(String[] args) {

        int squareSide = 800;
        int N = 10000000;

        MonteCarloExperiment exp = new MonteCarloExperiment(squareSide,N);

        exp.setOutputInterval(100000);
        exp.run();




    }
}
