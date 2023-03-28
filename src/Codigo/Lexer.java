package Codigo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lexer {
    
    private static final String[] PALAVRAS_CHAVE = {"if", "else", "while", "for", "int", "float", "double", "char", "void"};
    private static final String[] OPERADORES = {"+", "-", "*", "/", "=", ">", "<", "!", "&", "|", "%", "++", "--"};
    private static final String[] DELIMITADORES = {";", "{", "}", "(", ")", "[", "]"};
    
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("../arquivo.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (String token : tokens) {
                    if (isPalavraChave(token)) {
                        System.out.println(token + " - PALAVRA CHAVE");
                    } else if (isOperador(token)) {
                        System.out.println(token + " - OPERADOR");
                    } else if (isDelimitador(token)) {
                        System.out.println(token + " - DELIMITADOR");
                    } else if (isIdentificador(token)) {
                        System.out.println(token + " - IDENTIFICADOR");
                    } else if (isNumero(token)) {
                        System.out.println(token + " - NUMERO");
                    } else {
                        System.out.println(token + " - TOKEN INVALIDO");
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static boolean isPalavraChave(String token) {
        for (String palavraChave : PALAVRAS_CHAVE) {
            if (token.equals(palavraChave)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean isOperador(String token) {
        for (String operador : OPERADORES) {
            if (token.equals(operador)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean isDelimitador(String token) {
        for (String delimitador : DELIMITADORES) {
            if (token.equals(delimitador)) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean isIdentificador(String token) {
        return token.matches("[a-zA-Z][a-zA-Z0-9]*");
    }
    
    private static boolean isNumero(String token) {
        return token.matches("-?[0-9]+\\.?[0-9]*");
    }
}