package cpen221practice;

import java.util.ArrayList;

class NaturalNumber {

    private int num;

    public NaturalNumber(int num){
        if(num<=0){
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.num = num;
    }

    ArrayList factors(){
        ArrayList factorList = new ArrayList();
        if(num!=0) {
            for (int i = 2; i < num / 2 + 1; i++) {
                if ((double) num / i- Math.floor(num / i) == 0) {
                    factorList.add(i);
                }
            }
        }

        return factorList;
    }

    Classification getClassification(){
        ArrayList factorList = this.factors();
        int sum =1;


        for(int i = 0; i<factorList.size(); i++){
            sum+= (int)factorList.get(i);
        }

        Classification classification = Classification.PERFECT;
        if(sum<num)
            classification = Classification.DEFICIENT;
        else if(sum>num)
            classification = Classification.ABUNDANT;
        else
            classification = Classification.PERFECT;
        if(num==1){
            classification = Classification.DEFICIENT;
        }

        return classification;
    }


}
