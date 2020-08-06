import java.util.Random;

public class Population {
    private Individual[] fPopulation;
    private Random rand = new Random();
    private int fIndividualSize=5;
    private int fPopulationSize=10;

    public Population(){
        this.fPopulation = new Individual[fPopulationSize];
        for(int i=0; i<fPopulationSize; i++){
            Individual individual = new Individual(fIndividualSize);
            this.fPopulation[i] = individual;
        }
    }

    public void printPopulation(){
        System.out.println("集団出力");
        for(int i=0; i<this.fPopulation.length; i++){
            this.fPopulation[i].printIndividual();
        }
    }

    public static void main(String[] args){
        Population pop1 = new Population();
        pop1.printPopulation();
    }
}