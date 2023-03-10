package com.fgieracki;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

@Getter
@Setter
public class TokenDB {
    private final Set<Token> tokenSet = new HashSet<>();
    
    public void addToken(Token token) {
        tokenSet.add(token);
    }

    public Set<Token> getTokens() {
        return tokenSet;
    }

    public TokenDB(){
        //numbers
        addToken(new Token(Pattern.compile("\\d+"), "NUMBER"));
        //left bracket
        addToken(new Token(Pattern.compile("\\("), "LEFT_BRACKET"));
        //right bracket
        addToken(new Token(Pattern.compile("\\)"), "RIGHT_BRACKET"));
        //plus
        addToken(new Token(Pattern.compile("\\+"), "PLUS"));
        //minus
        addToken(new Token(Pattern.compile("-"), "MINUS"));
        //multiply
        addToken(new Token(Pattern.compile("\\*"), "MULTIPLY"));
        //divide
        addToken(new Token(Pattern.compile("/"), "DIVIDE"));
        //power
        addToken(new Token(Pattern.compile("\\^"), "POWER"));
        //left brace
        addToken(new Token(Pattern.compile("\\{"), "LEFT_BRACE"));
        //right brace
        addToken(new Token(Pattern.compile("}"), "RIGHT_BRACE"));
        //semicolon
        addToken(new Token(Pattern.compile(";"), "SEMICOLON"));
        //comma
        addToken(new Token(Pattern.compile(","), "COMMA"));
        //assignment
        addToken(new Token(Pattern.compile("="), "ASSIGNMENT"));
    }
}
