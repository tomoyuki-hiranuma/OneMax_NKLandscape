import java.util.Random;

public class Population {
    private Individual[] fPopulation; // 集団
    private Random rand = new Random();
    private int fIndividualSize=10;
    private int fPopulationSize=10;
    private double fMutationProb = 0.01;

    public Population(){
        this.fPopulation = new Individual[fPopulationSize];
        for(int i=0; i<fPopulationSize; i++){
            Individual individual = new Individual(fIndividualSize);
            this.fPopulation[i] = individual;
        }
    }

    public Individual crossOver(Individual parent1, Individual parent2){
        // 交叉点の決定
        int crossPoint = rand.nextInt(fIndividualSize);
        // 子個体
        Individual child = new Individual(fIndividualSize);
        int[] arr = new int[fIndividualSize];
        for(int i = 0; i < fIndividualSize; i++){
            if(i < crossPoint){
                arr[i] = parent1.getArray()[i];
            }else{
                arr[i] = parent2.getArray()[i];
            }
        }
        child.setArray(arr);
        child.calcEvaluate();
        return child;
    }

    public void printPopulation(){
        System.out.println("集団出力");
        for(int i=0; i<this.fPopulation.length; i++){
            this.fPopulation[i].printIndividual();
        }
    }

    // 1世代
    public void doOneGeneration(){
        double MutationProb = rand.nextDouble();
        int index1 = rand.nextInt(fIndividualSize);
        int index2 = rand.nextInt(fIndividualSize);
        while(index1 == index2){
            index2 = rand.nextInt(fIndividualSize);
        }
        Individual parent1 = fPopulation[index1];
        Individual parent2 = fPopulation[index2];
        Individual child = new Individual(crossOver(parent1, parent2));

        // 突然変異
        if(fMutationProb > MutationProb){
            
        }
    }

    public static void main(String[] args){
        Population pop1 = new Population();
        pop1.printPopulation();
    }
}