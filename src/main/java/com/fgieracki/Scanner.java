package com.fgieracki;

import com.fgieracki.Exceptions.NotFoundException;

public class Scanner {
    private String input;
    private TokenDB tokens;
    private Integer index;
    private String inputCache;

    public Scanner(String input) {
        this.input = input.trim().replaceAll("\\s*", "");
        this.tokens = new TokenDB();
        this.index = 0;
        this.inputCache = "";
    }

    public Boolean hasNextChar(){
        return index < input.length();
    }

    public TokenDTO nextToken() throws NotFoundException {
        if (index >= input.length()) {
            return null;
        }
        inputCache+=input.charAt(index);
        for (Token token : tokens.getTokens()) {
            if (inputCache.matches(token.getPattern().toString())) {
                return new TokenDTO(token.name, inputCache, index++);
            }
        }

        inputCache = "" + input.charAt(index);
        for (Token token : tokens.getTokens()) {
            if (inputCache.matches(token.getPattern().toString())) {
                return new TokenDTO(token.name, inputCache, index++);
            }
        }
        throw new NotFoundException("Token on a given index: " + index++ + " was not found. (Value: '" + inputCache + "')");
    }

}
