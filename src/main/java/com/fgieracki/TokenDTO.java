package com.fgieracki;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class TokenDTO {
    String name;
    String value;
    Integer startIndex;

    @Override
    public String toString() {
        return "Token{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", startIndex=" + startIndex +
                '}';
    }
}
