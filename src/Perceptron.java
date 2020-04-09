public class Perceptron {

    private double learningFactor = 0.5;
    private double weight[];
    private double deviation = 0;
    private int correct;


    public Perceptron(int correct) {
        this.correct = correct;
    }

    public void teach(Data data) {
        if (weight == null)
            randWeight(data.getInfo().length);
        int y = calculateY(data);

        updateWeights(y, data);
        updateDeviation(y, data);
    }

    public void randWeight(int count) {
        weight = new double[count];
        for (int i = 0; i < count; i++) {
            weight[i] = Math.random() * 1;
        }
    }

    public int calculateY(Data data) {
        double net = 0;
        for (int i = 0; i < data.getInfo().length; i++) {
            net += weight[i] * ((double) data.getInfo()[i] / data.countLetters);
        }
        net -= deviation;
        if (net >= 0)
            return 1;
        else
            return 0;
    }

    private void updateDeviation(int y, Data data) {
        int resault = 0;
        if (correct == data.resaultInt)
            resault = 1;
        deviation = deviation - learningFactor * (resault - y);
    }

    public void updateWeights(int y, Data data) {
        int resault = 0;
        if (correct == data.resaultInt)
            resault = 1;
        for (int i = 0; i < data.getInfo().length; i++) {
            weight[i] = weight[i] + learningFactor * (resault - y) * data.getInfo()[i];
        }
    }

}
