package com.example.electiva1ejercicio2;

import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.electiva1ejercicio2.Logic.Operation;
import com.example.electiva1ejercicio2.Models.Numbers;

import java.io.Console;

public class Activity3 extends AppCompatActivity {

    TextView TextvNum1,TextvNum2;
    RadioGroup RbtGroup1;
    RadioButton RbtSuma,RbtResta,RbtMultiplicacion,RbtDividir;
    Button BtnProcesar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        RbtGroup1 = (RadioGroup) findViewById(R.id.RbtGroup1);
        RbtSuma = (RadioButton) findViewById(R.id.RbtSuma);
        RbtResta= (RadioButton) findViewById(R.id.RbtResta);
        RbtMultiplicacion= (RadioButton) findViewById(R.id.RbtMultiplicacion);
        RbtDividir= (RadioButton) findViewById(R.id.RbtDividir);
        TextvNum1 = (TextView) findViewById(R.id.TextvNum1);
        TextvNum2 = (TextView) findViewById(R.id.TextvNum2);
        BtnProcesar = (Button) findViewById(R.id.BtnProcesar);
        MostrarData();
    }

    public void MostrarData()
    {
        Intent intent = getIntent();
        if (intent != null)
        {
            TextvNum1.setText("Numero 1: " +Integer.toString(intent.getIntExtra(getString(R.string.Data1),0)));
            TextvNum2.setText("Numero 2: " + Integer.toString(intent.getIntExtra(getString(R.string.Data2),0)));
        }
    }

    public void StartActivity2(View view)
    {
        int result =0;
        String Operacion = "";
        Numbers Data = new Numbers();
        Intent Dataintent = getIntent();
        Data.setNumber1(Dataintent.getIntExtra(getString(R.string.Data1),0));
        Data.setNumber2(Dataintent.getIntExtra(getString(R.string.Data2),0));

        int id = RbtGroup1.getCheckedRadioButtonId();
        switch (id)
        {
            case R.id.RbtSuma:
                result = Operation.Sumar(Data);
                Operacion = (String) RbtSuma.getText();
                break;
            case R.id.RbtResta:
                result = Operation.Restar(Data);
                Operacion = (String) RbtResta.getText();
                break;
            case R.id.RbtMultiplicacion:
                result = Operation.Multiplicar(Data);
                Operacion = (String) RbtMultiplicacion.getText();
                break;
            case R.id.RbtDividir:
                result = Operation.Dividir(Data);
                Operacion = (String) RbtDividir.getText();
                break;
            default:
                Toast.makeText(this, "por favor seleccione una opcion", Toast.LENGTH_LONG).show();
                break;
        }

        if (Operacion != "")
        {
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra(getString(R.string.ResultOperation), result);
            intent.putExtra(getString(R.string.NameOperation), Operacion);
            startActivity(intent);
        }

    }

}
