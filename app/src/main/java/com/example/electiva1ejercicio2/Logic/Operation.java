package com.example.electiva1ejercicio2.Logic;

import com.example.electiva1ejercicio2.Models.Numbers;

public class Operation {

    public static int Sumar(Numbers Data)
    {
        int result = 0;
        result = Data.getNumber1() + Data.getNumber2();
        return result;
    }

    public static int Restar(Numbers Data)
    {
        int result = 0;
        result = Data.getNumber1() - Data.getNumber2();
        return result;
    }

    public static int Multiplicar(Numbers Data)
    {
        int result = 0;
        result = Data.getNumber1() * Data.getNumber2();
        return result;
    }

    public static int Dividir(Numbers Data)
    {
        int result = 0;
        result = Data.getNumber1() / Data.getNumber2();
        return result;
    }
}
