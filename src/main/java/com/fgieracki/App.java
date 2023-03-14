package com.fgieracki;

import com.fgieracki.Exceptions.NotFoundException;

import java.io.*;

import static com.fgieracki.utils.Color.*;

@SuppressWarnings("java:S106") //systemOut SonarLint warning
public class App {

    public static void main(String[] args){
        String input;
        Scanner scanner;

        try{
            printString("Type string to scan: ");
            input = readInput();
            scanner = new Scanner(input);
        } catch (Exception e) {
            printError("I/O Error occured. Terminating application");
            return;
        }

        while(Boolean.TRUE.equals(scanner.hasNextChar())){
            TokenDTO token = null;
            try {
                token = scanner.nextToken();
            } catch (NotFoundException e) {
                printError(ANSI_RED + e.toString() + ANSI_RESET);
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
        System.out.println(ANSI_CYAN + string + ANSI_RESET);
    }

    private static void printError(String string){
        System.out.println(ANSI_RED + string + ANSI_RESET);
    }


}
