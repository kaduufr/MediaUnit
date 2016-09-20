package com.example.a03777501.mediaunit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nota01 , nota02;
    TextView lblResultado;
    Button btnCalcular, btnLimpar;
    double n1 , n2 , resul;
    String ap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nota01 = (EditText) findViewById(R.id.nota01);
        nota02 = (EditText) findViewById(R.id.nota02);
        lblResultado = (TextView) findViewById(R.id.lblResultado);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);

        btnCalcular.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                try {
                    n1 = Double.parseDouble(nota01.getText().toString());
                    n2 = Double.parseDouble(nota02.getText().toString());

                    resul = ((n1 * 4) + (n2 * 6)) / 10;

                    if (resul >= 6) {
                        ap = "Voce Esta Aprovado";
                    }
                    ;
                    if (resul < 6 && resul >= 4) {
                        ap = "Voce Esta de Recuperação";
                    }
                    ;
                    if (resul < 4) {
                        ap = "Voce Foi Reprovado";
                    }
                    ;
                    lblResultado.setText(String.valueOf(resul));
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Resultado");
                    builder.setMessage("=> Sua Media foi: " + resul + "\n\n=> A media geral é: 6.0" + "\n\n" + ap);

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //do things
                        }
                    });

                    AlertDialog alert = builder.create();
                    alert.show();
                    nota01.requestFocus();
                } catch (NumberFormatException a) {
                    lblResultado.setText(String.valueOf(("Digite suas notas!")));
                }
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                nota01.setText(String.valueOf(""));
                nota02.setText(String.valueOf(""));
                lblResultado.setText(String.valueOf("Resultado"));
                nota01.requestFocus();
            }
        });
    }
}
