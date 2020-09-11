/*
    0806作成: Tomoyuki Hiranuma
    基本的な概要を実装
    Populationクラスで交叉や突然変異を実装

    calcEvaluateをいちいち記述しなくてもどこかで実行することでMainでの無駄が省けそう
*/

import java.util.Random;

public class Individual {
    private int[] fArray; // 個体の持ってる配列（遺伝子）
    private int fNumberOfSize; // 遺伝子サイズ
    private Random rand = new Random();
    private int fEvaluate=0; // 評価値

    // コンストラクタ
    public Individual(int numberOfSize) {
        this.fArray = new int[numberOfSize];
        this.fNumberOfSize = numberOfSize;
        for(int i=0;i<this.fNumberOfSize;i++){
            int element = rand.nextInt(2);
            this.fArray[i] = element;
        }
        calcEvaluate();
    }

    // コピーコンストラクタ
    public Individual(Individual individual){
        this.fArray = new int[individual.fArray.length];
        this.fEvaluate = individual.fEvaluate;
        for(int i=0; i<individual.fArray.length; i++){
            this.fArray[i] = individual.fArray[i];
        }
    }

    // 評価値計算
    public void calcEvaluate(){
        int sum = 0;
        for(int i=0;i<this.fArray.length; i++){
            sum += this.fArray[i];
        }
        this.fEvaluate = sum;
    }

    public void printArray(){
        for(int i=0;i<this.fArray.length;i++){
            System.out.print(this.fArray[i]+" ");
        }
        System.out.println();
    }

    public void printIndividual(){
        System.out.print("array: ");
        for(int i=0; i<this.fArray.length; i++){
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
    public int getEvaluate(){
        return this.fEvaluate;
    }

    public static void main(String args[]){
        // int individualSize = 100;

    }
    
}