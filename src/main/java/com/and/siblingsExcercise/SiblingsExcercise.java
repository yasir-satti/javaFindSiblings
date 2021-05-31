package com.and.siblingsExcercise;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;


import javax.management.openmbean.ArrayType;

public class SiblingsExcercise {

    /**
     * The following is the method where the solution shall be written
     */

     public static String solution(String inputString) throws NumberFormatException {
        ArrayList<String> extractedInputDigits = new ArrayList<String>(); 
        List<String> SiblingsValuesGenerated = new ArrayList<String>();
        String result = "";

        if(inputString.length() > 0){        
            extractedInputDigits = extractDigitsFromInput(inputString, inputString.length());
            if(!extractedInputDigits.isEmpty()){
                extractedInputDigits.sort(Comparator.reverseOrder());
                SiblingsValuesGenerated = computeSiblings(extractedInputDigits, extractedInputDigits, extractedInputDigits.size());
                result = String.join(",", SiblingsValuesGenerated);
            } else {
                result = "Input does not contain digits!!";
            }
        } else {
            result = "Input is empty!!";
        }
    return result;
    }

    private static ArrayList<String> extractDigitsFromInput(String input, int inputLength){
        String digits = "0123456789";
        ArrayList<String> result = new ArrayList<String>();

        for (int count = 0; count < inputLength; count++){
            if(digits.indexOf(input.charAt(count)) > -1){
                result.add(Character.toString(input.charAt(count)));
            }
        }
        return result;
    }

    private static List<String> computeSiblings(ArrayList<String> digitsToComputeSiblingsFor, ArrayList<String> digitsToComputeSiblingsForOrg, int lengthOfdigitsToComputeSiblingsFor) throws NumberFormatException {
        List<String> result = new ArrayList<String>();

        if (lengthOfdigitsToComputeSiblingsFor > 2){
            result = computeSiblingsWithMoreThanTwoDigitsString(digitsToComputeSiblingsFor, digitsToComputeSiblingsForOrg, lengthOfdigitsToComputeSiblingsFor);
        } else {
            result = computeSiblingsWithTwoDigitsString(digitsToComputeSiblingsFor, digitsToComputeSiblingsForOrg, lengthOfdigitsToComputeSiblingsFor);
        }
        return result;
    }

    private static List<String> computeSiblingsWithMoreThanTwoDigitsString(ArrayList<String> digitsToComputeSiblingsFor, ArrayList<String> digitsToComputeSiblingsForOrg, int lengthOfdigitsToComputeSiblingsFor){
        List<String> computedSiblings = new ArrayList<String>();
        String digitPop;
        List<String> result = new ArrayList<>();

        for (int count = 0;count < lengthOfdigitsToComputeSiblingsFor;count++){ 
            digitPop = digitsToComputeSiblingsForOrg.get(count); 
            digitsToComputeSiblingsFor = (ArrayList<String>)digitsToComputeSiblingsForOrg.clone(); 
            digitsToComputeSiblingsFor.remove(count);
            computedSiblings = computeSiblings(digitsToComputeSiblingsFor, digitsToComputeSiblingsFor, lengthOfdigitsToComputeSiblingsFor - 1);
            for (String digitSibling : computedSiblings){
                result.add(digitPop + digitSibling);
            }
        }
        return result;
    }

    private static List<String> computeSiblingsWithTwoDigitsString(ArrayList<String> digitsToComputeSiblingsFor, ArrayList<String> digitsToComputeSiblingsForOrg, int lengthOfdigitsToComputeSiblingsFor){
        String siblingFromTwoDigits = new String();
        String reverseSiblingFromTwoDigits = new String();
        List<String> result = new ArrayList<>();

        siblingFromTwoDigits = String.join("", digitsToComputeSiblingsFor);
        result.add(siblingFromTwoDigits);
        for(int count = siblingFromTwoDigits.length() - 1; count >= 0; count--){
            reverseSiblingFromTwoDigits = reverseSiblingFromTwoDigits + siblingFromTwoDigits.charAt(count);
        }
        result.add(reverseSiblingFromTwoDigits);
        return result;
    }

    public static void main(String args[]) {

        System.out.println(solution("326"));
        System.out.println();
        System.out.println(solution("A3B2C6D"));
        System.out.println();
        System.out.println(solution("02518"));
        System.out.println();
        System.out.println(solution("ABCD"));
        System.out.println();
        System.out.println(solution("122"));
        System.out.println();
        System.out.println(solution("203"));
        
        }
}
