/*
    0806作成: Tomoyuki Hiranuma
    基本的な概要を実装
    Populationクラスで交叉や突然変異を実装

    calcEvaluateをいちいち記述しなくてもどこかで実行することでMainでの無駄が省けそう
*/

import java.util.Random;

public class Individual {
    private int[] fArray; // 個体の持ってる配列（遺伝子）
    private double fEvaluate=0; // 評価値
    private double[] fCouple;

    // コンストラクタ
    public Individual(int numberOfSize) {
        Random rand = new Random();
        this.fArray = new int[numberOfSize];
        this.fCouple = new double[numberOfSize];
        for(int i = 0; i < this.fArray.length ; i++){
            int element = rand.nextInt(2);
            this.fArray[i] = element;
            this.fCouple[i] = rand.nextDouble();
        }
        calcEvaluate();
    }

    // コピーコンストラクタ
    public Individual(Individual individual){
        this.fArray = new int[individual.fArray.length];
        this.fEvaluate = individual.fEvaluate;
        this.fCouple = new double[individual.fArray.length];
        for(int i=0; i<individual.fArray.length; i++){
            this.fArray[i] = individual.fArray[i];
            this.fCouple[i] = individual.fCouple[i];
        }
    }

    // 評価値計算
    public void calcEvaluate(){
        double sum = 0;
        for(int i=0;i<this.fCouple.length; i++){
            sum += this.fCouple[i];
        }
        this.fEvaluate = sum / (double)this.fCouple.length;
    }

    public void printArray(){
        for(int i=0;i<this.fArray.length;i++){
            System.out.print(this.fArray[i]+" ");
        }
        System.out.println();
    }

    public void printIndividual(int index){
        System.out.print("array[" + index + "]: ");
        for(int i = 0; i < this.fArray.length; i++){
            System.out.print(this.fArray[i] + " ");
        }
        System.out.println();
        System.out.print("Evaluate value: ");
        System.out.println(this.fEvaluate);
    }

    public void setArray(int[] array){
        this.fArray = new int[array.length];
        for(int i=0 ;i<array.length; i++){
            this.fArray[i] = array[i];
        }
    }
    public int[] getArray(){
        return this.fArray;
    }
    public void setEvaluate(int evaluate){
        this.fEvaluate = evaluate;
    }
    public double getEvaluate(){
        return this.fEvaluate;
    }
    public void setElement(int index, int x){
        this.fArray[index] = x;
    }
    public int getElement(int index){
        return this.fArray[index];
    }

    public double[] getCouple(){
        return this.fCouple;
    }
    public void setCouple(int index, double x){
        this.fCouple[index] = x;
    }

    public static void main(String args[]){
        // int individualSize = 100;

    }
    
}