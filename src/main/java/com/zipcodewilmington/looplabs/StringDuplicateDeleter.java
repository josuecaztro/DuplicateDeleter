package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    public int getNumberOfOccurrencesString(String valueToEvaluate) {
        int counter = 0;
        for (String element : array){
            if (element.equals(valueToEvaluate)){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        int n = this.array.length;
        int[] counts = new int[n];

        //count occurrences for each string
        for (int i = 0; i < n; i++) {
            counts[i] = 0; // Initialize counts
            for (int j = 0; j < n; j++) {
                if (this.array[i].equals(this.array[j])) {
                    counts[i]++;
                }
            }
        }

        // get strings that appear fewer than maxNumber
        String[] tempResult = new String[n];
        int resultIndex = 0;
        for (int i = 0; i < n; i++) {
            boolean shouldAdd = true;
            if (counts[i] >= maxNumberOfDuplications) {
                shouldAdd = false;
            }
            if (shouldAdd) {
                // make sure string is not in array already
                boolean alreadyAdded = false;
                for (int k = 0; k < resultIndex; k++) {
                    if (tempResult[k].equals(this.array[i])) {
                        alreadyAdded = true;
                        break;
                    }
                }
                if (!alreadyAdded) {
                    tempResult[resultIndex++] = this.array[i];
                }
            }
        }

        // trim array to correct size
        String[] result = new String[resultIndex];
        System.arraycopy(tempResult, 0, result, 0, resultIndex);

        return result;
//        return new String[0];
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] newArr = new String[0];

        for (String x : array){
            if(getNumberOfOccurrencesString(x) != exactNumberOfDuplications){
                int index = newArr.length;
                newArr = Arrays.copyOf(newArr,index+1);
                newArr[index] = x;
            }
        }
        return newArr;
//       return new String[0];
      }

}
