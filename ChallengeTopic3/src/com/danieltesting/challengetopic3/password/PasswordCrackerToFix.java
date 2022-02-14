package com.danieltesting.challengetopic3.password;

import java.io.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PasswordCrackerToFix {



////////////////////////////////////////////////////////////////////////////////////////////////
//              THIS ONE IS NOT WORKING, I LEFT IT HERE TO HAVE A REFERENCE
//              SO I CAN FIX IT IN THE FUTURE, MY MAIN PROBLEM WAS THE USE
//              OF STREAM, THE OTHER EXAMPLE WITH THE SOLUTION ONLY USES
//              STREAMS FOR THE SOME LOOPS

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = 0;

        try {
            testCases = Integer.parseInt(bufferedReader.readLine().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        IntStream.range(0,testCases)
                .forEach(i->{
                    try {

                        int numberOfPasswords = Integer.parseInt(bufferedReader.readLine().trim());

                        List <String> passwords = Stream.of(Pattern.compile(" ").split(bufferedReader.readLine().toLowerCase().trim())).collect(Collectors.toList());

                        String loggingAttempt = bufferedReader.readLine().toLowerCase().trim();

                        String result = cracker(passwords,loggingAttempt);

                        System.out.println(result);

                        crackerResult = null;

                    }
                    catch (IOException ohNo){
                        throw new RuntimeException(ohNo);
                    }
                });

    }

    private static String crackerResult = "";
    public static String cracker(List<String> passwords, String loginAttempt){


//        if (loginAttempt.length()==0){
//            return crackerResult;
//        }

//        passwords.forEach( password -> {
//            if (loginAttempt.startsWith(password)){
//                crackerResult += password+" "+cracker(passwords,loginAttempt.substring(password.length()));
//                return crackerResult;
//            }
//        });
        System.out.println("attempt "+loginAttempt+" length"+loginAttempt.length());

        if (passwords.stream().noneMatch(password -> loginAttempt.contains(password))){
            return "WRONG PASSWORD";
        }

        return (loginAttempt.length()==0) ? "" : "hello";

//        if (loginAttempt.length()==0){
//            System.out.println("result");
//            return crackerResult;
//        }




    }


}
