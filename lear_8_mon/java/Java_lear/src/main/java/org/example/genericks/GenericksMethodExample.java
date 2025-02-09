package org.example.genericks;

public class GenericksMethodExample {

    public <T> T variableParameterAndVariableReturnType(T data) {
        return data;
    }

    public <T> void variableParameterAndVoidReturnType(T data){
        System.out.println(data);
    }

    public <T> String variableParameterAndFixedReturnType(T data) {
       return data.toString();
    };
}