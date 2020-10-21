package com.example.electiva1ejercicio2;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.electiva1ejercicio2.Models.User;
import android.widget.*;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    EditText EditUsername, EditPassword;
    Button BtnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditUsername = (EditText) findViewById(R.id.EditUsername);
        EditPassword = (EditText) findViewById(R.id.EditPassword);
    }


    public void validateUser(View view)
    {
        User dataUser = new User();
        dataUser.setUsername(EditUsername.getText().toString().trim());
        dataUser.setPassword(EditPassword.getText().toString().trim());

        if (!isNullOrBlank(dataUser.getUsername()) && !isNullOrBlank(dataUser.getPassword()))
        {
          if (ValidatePassword(dataUser.getUsername(), dataUser.getPassword()))
          {
              Intent intent = new Intent(this, Activity2.class);
              Toast.makeText(this, "inicio de sesion exitoso", Toast.LENGTH_LONG).show();
              startActivity(intent);
          }else
              {
                  Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
              }
        }else
          {
              Toast.makeText(this, "a ocurrido un error, por favor revise que los campos esten llenos", Toast.LENGTH_LONG).show();
          }

    }

    public boolean ValidatePassword(String Username,String Password)
    {
        boolean Result = false;
        if (Username.equals("ELE1") && Password.equals("SECC01"))
        {
            Result = true;
        }
        return  Result;
    }

    public static boolean isNullOrBlank(String param) {
        return param == null || param.trim().length() == 0;
    }

}
