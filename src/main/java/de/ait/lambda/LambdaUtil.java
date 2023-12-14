package de.ait.lambda;

import java.util.Arrays;
import java.util.List;

public class LambdaUtil {
    //(arguments) -> (body)
    public static void main(String[] args) {

        List <String> stringList= Arrays.asList("Hallo", "Java", "Deutschland");
        List<Integer> integerList = stringList.stream().map(String::length).toList();
        System.out.println(integerList);

    }
}
