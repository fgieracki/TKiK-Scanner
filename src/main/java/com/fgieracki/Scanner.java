package com.fgieracki;

import com.fgieracki.Exceptions.NotFoundException;

public class Scanner {
    private final String input;
    private final TokenDB tokens;
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
        if(index >= input.length()){
            return null;
        }

        inputCache = "" + input.charAt(index++);
        if(getMatchingToken(inputCache) == null){
            throw new NotFoundException("index="
                    + (index+1-inputCache.length())
                    + " Value='"
                    + inputCache + "'");
        }

        while(getMatchingToken(inputCache) != null && index < input.length()){
            inputCache += input.charAt(index++);
        }

        if(getMatchingToken(inputCache) != null){
            TokenDTO token = getMatchingToken(inputCache);
            inputCache = "";
            return token;
        }

        else if(getMatchingToken(inputCache.substring(0, inputCache.length()-1)) != null){
            TokenDTO token = getMatchingToken(inputCache.substring(0, inputCache.length()-1));
            index--;
            inputCache = "";
            return token;
        }

        else{
            throw new NotFoundException("Token on a given index: "
                    + (index-1-inputCache.length())
                    + " was not found. (Value: '"
                    + inputCache + "')");
        }
    }

    private TokenDTO getMatchingToken(String string){
        for (Token token : tokens.getTokens()) {
            if (string.matches(token.getPattern().toString())) {
                return new TokenDTO(token.name, string, index-string.length());
            }
        }
        return null;
    }
}
