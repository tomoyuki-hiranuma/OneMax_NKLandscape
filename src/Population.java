import java.util.Random;

public class Population {
    private Individual[] fPopulation; // 集団
    private Random rand = new Random();
    private int fIndividualSize = 10;
    private int fPopulationSize = 10;
    private double fMutationProb = 0.01;
    private double fCrossProb = 0.6;

    public Population(int individualSize, int populationSize){
        this.fIndividualSize = individualSize;
        this.fPopulationSize = populationSize;

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
        Individual child = new Individual(parent1);
        int[] arr = new int[fIndividualSize];
        double[] couple = new double[fIndividualSize];
        for(int i = 0; i < fIndividualSize; i++){
            if(i < crossPoint){
                arr[i] = parent1.getArray()[i];
                couple[i] = parent1.getCouple()[i];
            }else{
                arr[i] = parent2.getArray()[i];
                couple[i] = parent2.getCouple()[i];
            }
        }
        for(int i = 0; i < child.getArray().length; i++){
            child.setElement(i, arr[i]);
            child.setCouple(i, couple[i]);
        }
        child.calcEvaluate();
        return child;
    }

    public void select(Individual res){
        Individual minIndividual = this.fPopulation[0];
        int minIndex = 0;
        for(int i = 0; i < this.fPopulation.length; i++){
            if(minIndividual.getEvaluate() > this.fPopulation[i].getEvaluate()){
                minIndividual = this.fPopulation[i];
                minIndex = i;
            }
        }
        if(minIndividual.getEvaluate() > res.getEvaluate()){
            System.out.println("index:" + minIndex + "と交換");
            this.fPopulation[minIndex] = minIndividual;
        }
    }

    public void select(Population pop){

    }

    public void sortByEvaluation(){
        // Bubble Sort
        for(int i = 0; i < this.fPopulation.length - 1 ; i++){
            for(int j = i+1 ; j < this.fPopulation.length; j++){
                if(this.fPopulation[i].getEvaluate() > this.fPopulation[j].getEvaluate()){
                    Individual tmp = this.fPopulation[i];
                    this.fPopulation[i] = this.fPopulation[j];
                    this.fPopulation[j] = tmp;
                }
            }
        }
    }

    public void printPopulation(){
        System.out.println("集団出力");
        for(int i=0; i<this.fPopulation.length; i++){
            this.fPopulation[i].printIndividual(i);
        }
    }

    // 1世代
    public void doOneGeneration(){
        System.out.println("世代更新");
        // 子集団
        Population children = new Population(fIndividualSize, fPopulationSize);

        for(int i = 0; i < children.fIndividualSize; i++){
            // if(rand.nextDouble() < fCrossProb){
                int index1 = rand.nextInt(fIndividualSize);
                int index2 = rand.nextInt(fIndividualSize);
                while(index1 == index2){
                    index2 = rand.nextInt(fIndividualSize);
                }
                Individual parent1 = fPopulation[index1];
                Individual parent2 = fPopulation[index2];
                Individual child = new Individual(crossOver(parent1, parent2));
                System.out.println(index1 + "と" + index2 + "との交叉");
                child.printArray();
                // 突然変異
                if(rand.nextDouble() < fMutationProb){

                }
                children.setIndividual(i, child);
            // }
        }
        children.sortByEvaluation();
        children.printPopulation();
        // select(children);
    }

    public void setIndividual(int index, Individual individual){
        this.fPopulation[index] = individual;
    }

    public Individual getIndividual(int index){
        return this.fPopulation[index];
    }
    

    public static void main(String[] args){
        int populationSize = 10;
        int individualSize = 10;
        Population pop1 = new Population(individualSize, populationSize);
        pop1.printPopulation();
        pop1.sortByEvaluation();
        pop1.doOneGeneration();
        pop1.printPopulation();
    }
}