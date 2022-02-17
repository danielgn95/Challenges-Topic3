package com.danieltesting.challengetopic3.password;

import java.util.*;

public class NotMySolution {


    private static Stack<String> passwords;
    private static Set<String> badLoginAttempt;

//    IMPORTANTE: tener cuidado al leer mi explicacion, ya que menciono mucho logginAttempt y badLogginAttempt, ambas son distintas segun el codigo aqui, no confundirlas
//    el logginAttempt is el string de contraseñas sin espacios, el badLogginAttempt es el HastSet donde se guardara una loginAttempt que no coincidio con alguna de las contraseñas


    //    10. este metodo retorna un boolean y recibe un arreglo de String y un String
    private static boolean calc(String[] pass, String loginAttempt) {

//        11. en el primer ciclo no entra aqui, ya que badLoginAttemp es null, asi que ignoramos por ahora
//        15. La primera vez que se reitera este ciclo, no sucede nada realmente, pero a partir del segundo ciclo, ya hay algo guardado en badLogginAttempt debido al paso 20.
//        lo guardado en el badLogginAttempt se basa en esto: si alguna de las contraseñas no coinciden con el loginAttempt, entonces el BadLoginAttempt tendra el mismo String
//        que el loginAttempt, si esto sucede, el medoto caera en este condicional y retornara false, que al final retornara "WRONG PASSWORD"
        if(badLoginAttempt.contains(loginAttempt)) {
            return false;
        }

//        12. este if es para confirmar que aun hay palabras en el loginAttempt, en el primer ciclo si tendremos, asi que ignoramos por ahora
//        16. aqui se puede entrar a partir del segundo ciclo, aqui se entrara cuando todas las contraseñas hayan coincidido con el loginattempt, y finalmente retornara true
//        20. una vez todas las pass hayan sido utilizadas, y el logginAttempt ya no tenga nada, por fin finalizara este ciclo retornando true
        if(loginAttempt.length() == 0) {
            return true;
        }

//        13. Esto si sucede en el primer ciclo, basado en el numero de contraseñas guardadaes en el arreglo pass hacemos lo que dice 14
//        IMPORTANTE este for es el que me genera los ciclos, segun el numero de contraseñas se hara ese mismo numero de ciclos, en el primer ciclo no sucedera nada
//        ya que badloginAttempt es nulo pero a partir del segundo, ya hay cambios por que ya hay algo en el badLogginAttempt segun el paso 20
//        17. Esto sucede a partir del segundo ciclo, si la contraseña no esta en el badLogginAttemp (no entro en paso 15), y si aun hay palabras en el logginAttempt (no entro en
//        paso 16) entonces vuelve a iniciar el ciclo el numero de veces que contraseñas haya, en otras palabras n en la linea del paso 3. del codigo
        for(String p : pass) {

//            14. si el loginattempt comienza con la primer contraseña guardada en el arreglo y el logginattempt menos la contraseña no existe en el HashSet badLogginAttempt (paso 15)
//            o si el logginAttempt aun tiene algo (paso 16) o si ya realizo el ciclo siguiente (paso 17) entonces seguir hacer lo que dice el paso 16. (en el primer ciclo
//            no sucede nada realmente, ya que badLogginAttemp es aun nulo, sin embargo en el paso 15. y 16 explico lo que sucede con esta recurrencia a partir del segundo ciclo.
            if(loginAttempt.startsWith(p) && calc(pass, loginAttempt.substring(p.length()))) {

//                18. si la condicion se cumple, entonces la contraseña con la que inicide el loginattempt sera guardada en el stack. e.g. si la contraseña es AB y el string is ABCD,
//                entonces AB sera guardado en este stack, de esta manera para todas las contraseñas. En otras palabras, este HashStack guarda todas las contraseñas que fueron utilizadas
//                para luego imprimirlas en el resultado del paso 22 y 23
                passwords.push(p);

//                19. este true unicamente sera utilizado en el ultimo ciclo, donde ya no haya mas contraseñas para utilizar
//                NOTA: PASOS 20 SOLO SUCEDE EN EL ULTIMO CICLO QUE SE HAGA.
                return true;
            }
        }

//        20. este HashSet es utilizado para guardar el logignattempt cuando se le haya removido el substring segun la contraseña que se este comprobando, si hay alguna palabra
//        en el loginAttempt que no haga parte del arreglo pass, entonces se guardara el loginattemp sin cambios
        badLoginAttempt.add(loginAttempt);
        return false;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

//        1. leer numero de veces que se hara el crackeo
        int t = in.nextInt();

//        2. ciclo for para el numero de tests, leido en 1.
        for (int i = 0; i < t; i++) {

//            3. numero de contraseñas que se introduciran
            int n = in.nextInt();

//            4. Las contraseñas seran guardadaes en un arreglo de String
            String[] pass = new String[n];

//            5. este ciclo for hace que un string que ingreses separado por espacios se guarde automaticamente como array
//            solo separa el numero indicado en 4. si hay mas, de eso, no los guardara
            for(int j = 0; j < n; j++) {
                pass[j] = in.next();
            }

//            6. Aqui lee el String con todas las contraseñas sin espacios
            String loginnAttempt = in.next();

//            7. este stack en el paso 18. sirve para guardar las contraseñas que ya se usaron
            passwords = new Stack<>();

//            8. este es bastante complejo, en el metodo calc, si ninguna de las contraseñas coincide con el logginattempt en el paso 13 y 14, entonces todo el login attempt
//             sera guardado en este HashSet en el paso 20., luego en el siguiente ciclo del mismo metodo calc, en el paso 15 si el loginString es el mismo que el HashSet,
//             entonces retornara False, que finalmente hara que result del paso 9. sea falso, y retorne "WRONG PASSWORD" en el paso 24.
            badLoginAttempt = new HashSet<>();

//            9. aqui mandas el array de contraseñas y el login attemp al metodo calc que esta arriba
            boolean result = calc(pass, loginnAttempt);

//            21. aqui retornas el resultado del metodo, la unica manera que sea falso, es que el logginAttempt tenga una palabra que no hace parte del arreglo pass
            if(result) {

//                22. aqui lo que haces es sacar cada una de las pass guardadaes en el Set passwords en orden, cuando ya todas hayan salido, ir a paso 23
                while (!passwords.isEmpty()) {
                    System.out.print(passwords.pop() + " ");
                }
//                23. cuando ya no haya contraseñas en el set passwords, imprimira el resultado
                System.out.println();
            } else {
//                24. como mencione en el paso 21, aqui solo se entrara si el resultado es falso.
                System.out.println("WRONG PASSWORD");
            }
        }
    }
}