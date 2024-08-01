package com.zipcodewilmington.looplabs;

import java.util.*;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {


    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Integer[] removed = new Integer[0];
        for (Integer element : this.array) {
            if (getNumberOfOccurrences(element) < maxNumberOfDuplications) {
                int index = removed.length;
                removed = Arrays.copyOf(removed, index+1);
                removed[index] = element;
            }
        }
        return removed;
    }


    public Integer getNumberOfOccurrences(int valueToEvaluate) {
        int counter = 0;
        for (int element : array){
            if (element == valueToEvaluate){
                counter++;
            }
        }
        return counter;
    }




    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int n = this.array.length;
        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            counts[i] = 0; // mkae count array
            for (int j = 0; j < n; j++) {
                if (this.array[i].equals(this.array[j])) {
                    counts[i]++;
                }
            }
        }
        // create new array with the right size
        Integer[] result = new Integer[n];
        int resultIndex = 0;
        for (int i = 0; i < n; i++) {
            if (counts[i] != exactNumberOfDuplications) {
                result[resultIndex++] = this.array[i];
            }
        }
        // Step 3: copy to new array of same size
        return Arrays.copyOf(result, resultIndex);
    }

}

