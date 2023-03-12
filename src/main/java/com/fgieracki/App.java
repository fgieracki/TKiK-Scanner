package com.fgieracki;

import com.fgieracki.Exceptions.NotFoundException;

import java.io.*;

@SuppressWarnings("java:S106") //systemOut SonarLint warning
public class App {

    public static void main(String[] args){
        String input;
        Scanner scanner;

        try{
            System.out.println("Type string to scan: ");
            input = readInput();
            scanner = new Scanner(input);
        } catch (Exception e) {
            System.out.println("I/O Error occured. Terminating application");
            return;
        }

        while(Boolean.TRUE.equals(scanner.hasNextChar())){
            TokenDTO token = null;
            try {
                token = scanner.nextToken();
            } catch (NotFoundException e) {
                printString(e.toString());
            }
            if(token == null) continue;
            printString(token.toString());
        }
    }

    private static String readInput() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }

    private static void printString(String string){
        System.out.println(string);
    }


}
