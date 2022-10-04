package com.java8practise.terminaloperations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class CompareHashMapsUsingStreams {

    public static Map<String, String> asiaCapital1 = new HashMap<>();
    public static Map<String, String> asiaCapital2 = new HashMap<>();
    public static Map<String, String> asiaCapital3 = new HashMap<>();

    public static Map<String, String[]> asiaCityArray1 = new HashMap<>();
    public static Map<String, String[]> asiaCityArray2 = new HashMap<>();


    public static void initializeMaps() {
        asiaCapital1.put("India", "Delhi");
        asiaCapital1.put("Srilanka", "Columbo");

        asiaCapital2.put("Srilanka", "Columbo");
        asiaCapital2.put("India", "Delhi");

        asiaCapital3.put("Japan", "Tokyo");
        asiaCapital3.put("India", "Delhi");


    }

    public static void compareTwoHashMapsWithoutStreams() {

        initializeMaps();
        if (asiaCapital1.equals(asiaCapital2)) {
            System.out.println("asiaCapital1 and asiaCapital2 Maps are same");
        } else {
            System.out.println("asiaCapital1 and asiaCapital2 Maps are not same");
        }

        if (asiaCapital1.equals(asiaCapital3)) {
            System.out.println("asiaCapital1 and asiaCapital3 Maps are same");
        } else {
            System.out.println("asiaCapital1 and asiaCapital3 Maps are not same");
        }

    }

    public static void compareTwoHashMapsUsingStreams() {
        initializeMaps();

        Predicate<Map.Entry<String, String>> predicate = (entry) -> {
            return entry.getValue().equals(asiaCapital2.get(entry.getKey()));
        };
        boolean isMapsSame = asiaCapital1.entrySet()
                .stream()
                .allMatch(predicate);
        System.out.println("Is asiaCapital1 and asiaCapital2 stream check is same? Ans:  " + isMapsSame);


        Predicate<Map.Entry<String, String>> predicateWithoutReturn = (entry) -> entry.getValue().equals(asiaCapital2.get(entry.getKey()));
        isMapsSame = asiaCapital3.entrySet()
                .stream()
                .allMatch(predicateWithoutReturn);
        System.out.println("Is asiaCapital3 and asiaCapital2 stream check is same? Ans:  " + isMapsSame);


        boolean isMapsSame1 = asiaCapital1.entrySet()
                .stream()
                .allMatch((entry) ->
                        entry.getValue().equals(asiaCapital2.get(entry.getKey())));
        System.out.println("Is asiaCapital1 and asiaCapital2 stream check is same? Inline Predicate Ans:  " + isMapsSame1);

    }

    public static void CompareTwoHashMapsWhereValuesIsArray() {
        //Arrays

        asiaCityArray1.put("Japan", new String[]{"Tokyo", "Osaka"});
        asiaCityArray1.put("South Korea", new String[]{"Seoul", "Busan"});

        asiaCityArray2.put("South Korea", new String[]{"Seoul", "Busan"});
        asiaCityArray2.put("Japan", new String[]{"Tokyo", "Osaka"});


        //When arrays are there .equal will not work as value is an object. Even both arrays are the same it returns false
        System.out.println("Is asiaCityArray1 is equal to asiaCityArray2 , Result :  " + asiaCityArray1.equals(asiaCityArray2));

        //Implement using streams

        boolean resultValue = asiaCityArray1.entrySet()
                .stream()
                .allMatch(e ->
                        Arrays.equals(e.getValue(), asiaCityArray2.get(e.getKey())));

        System.out.println("Is asiaCityArray1 is same as asiaCityArray2 using Stream Arrays : " + resultValue);


    }


    public static void main(String[] args) {
        compareTwoHashMapsWithoutStreams();
        compareTwoHashMapsUsingStreams();

        CompareTwoHashMapsWhereValuesIsArray();
    }


}

/*


asiaCapital1 and asiaCapital2 Maps are same
asiaCapital1 and asiaCapital3 Maps are not same
Is asiaCapital1 and asiaCapital2 stream check is same? Ans:  true
Is asiaCapital3 and asiaCapital2 stream check is same? Ans:  false
Is asiaCapital1 and asiaCapital2 stream check is same? Inline Predicate Ans:  true
Is asiaCityArray1 is equal to asiaCityArray2 , Result :  false
Is asiaCityArray1 is same as asiaCityArray2 using Stream Arrays : false


 */