package com.example.electiva1ejercicio2;

import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.electiva1ejercicio2.Models.Numbers;

public class Activity2 extends AppCompatActivity {

    EditText EditNum1,EditNum2;
    TextView TextVOperacion,TextVResultado;
    Button BtnSeleccionOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        EditNum1 = (EditText) findViewById(R.id.EditNum1);
        EditNum2 = (EditText) findViewById(R.id.EditNum2);
        TextVOperacion = (TextView) findViewById(R.id.TextVOperacion);
        TextVResultado = (TextView) findViewById(R.id.TextVResultado);
        BtnSeleccionOperacion = (Button) findViewById(R.id.BtnSeleccionOperacion);
        MostrarData();

    }

    public void StartActivity3(View view)
    {
        Numbers data = new Numbers();
        data.setNumber1(Integer.parseInt(EditNum1.getText().toString()));
        data.setNumber2(Integer.parseInt(EditNum2.getText().toString()));

        if (data.getNumber1() > 0 &&  String.valueOf(data.getNumber1()) != null )
        {
            if (data.getNumber2() > 0  && String.valueOf(data.getNumber2()) != null )
            {
                Intent intent = new Intent(this, Activity3.class);
                intent.putExtra(getString(R.string.Data1), data.getNumber1());
                intent.putExtra(getString(R.string.Data2), data.getNumber2());
                startActivity(intent);
            }else
            {
                this.EditNum1.setError("Este campo es obligatorio y Los numeros deben ser mayores a 0");
            }

        }else{
            this.EditNum2.setError("Este campo es obligatorio y Los numeros deben ser mayores a 0");
        }

    }

    public void MostrarData()
    {
        Intent intent = getIntent();
        if (intent != null)
        {
            if(intent.getStringExtra(getString(R.string.NameOperation)) != null)
            {

                TextVOperacion.setText("Operación: " +intent.getStringExtra(getString(R.string.NameOperation)));
                TextVResultado.setText("Resultado: " + Integer.toString(intent.getIntExtra(getString(R.string.ResultOperation),0)));
            }

        }
    }


}
