package com.danieltesting.challengetopic3.password;


import java.util.*;
import java.util.stream.IntStream;

public class PasswordCracker {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();

        IntStream.range(0, testCases)
                .forEach(test -> {
                    int numberOfPasswords = scanner.nextInt();

                    Set<String> passwords = new HashSet<String>();

                    Map<String,Boolean> map = new HashMap<String, Boolean>();

                    IntStream.range(0, numberOfPasswords)
                            .forEach(password -> {
                                passwords.add(scanner.next());
                            });

                    String loginAttempt = scanner.next();
                    boolean matchNumber = cracker(loginAttempt, passwords, "", map);
                    if (!matchNumber){
                        System.out.println("WRONG PASSWORD");
                    }

                });
    }

    private static boolean cracker (String loginAttempt, Set<String> passwords, String path, Map<String,Boolean> map){

        if ( loginAttempt == null || loginAttempt.length() == 0){
            System.out.println(path.trim());
            return true;
        }

        if (map.containsKey(loginAttempt)){
            return map.get(loginAttempt);
        }

//        I didn't know how to make this with passwords.forEach(), specifically the "continue;"
        for(String word : passwords){
            if (!loginAttempt.startsWith(word)) continue;
            if (cracker(loginAttempt.substring(word.length()),passwords,path + word + " ",map)){
                map.put(loginAttempt,true);
                return true;
            }
        }

        map.put(loginAttempt,false);
        return false;
    }

}
