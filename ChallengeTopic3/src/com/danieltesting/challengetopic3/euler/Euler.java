package com.danieltesting.challengetopic3.euler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Euler {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        List<Double> exponentialList = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("0.0000");

        int nValue=10; // fixed to only first 10 terms of euler, outside the euler method to allow a recursion
        int testCases = 0; //this value must be between 1 and 50

        testCases = scanner.nextInt();

        IntStream.range(1,testCases+1)
                .forEach(i->{
                    exponentialList.add(scanner.nextDouble());
                });

        exponentialList.stream()
                .map(element -> euler(element,nValue-1))
                .forEach( i -> System.out.println(df.format(i)));

    }

    private static double p=1;
    private static double f=1;
//    recursive method
    public static double euler(double x, int n){

        double r;
//        e^x = 1 + (x/1) (1 + (x/2) (1 + (x/3) (........) ) )

        if (n == 0) {
            p = 1;
            f = 1;
            return 1;
        }

        r = euler(x, n - 1);
//        e.g. 20 + (20/1) ( 1+ (20/2) (1 + (20/3) (1+ 20/4)......)))

        p = p * x;

        f = f * n;

        return (r + p / f);

    }


}


