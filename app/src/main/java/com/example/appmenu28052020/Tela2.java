package com.example.appmenu28052020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Tela2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        //OBJETOS PARA REFERENCIAR
        Button btnCalcMasc, btnVoltaMasc;
        final EditText AlturaH;

        //EFETUAR A REFERENCIA DO OBJETO NO XML
        AlturaH = findViewById(R.id.editAltMasc);
        btnCalcMasc = findViewById(R.id.btnCalcMasc);
        btnVoltaMasc = findViewById(R.id.btnVoltaMasc);

        //CÓDIGO DO BOTÃO CALCULAR
        btnCalcMasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TRATAMENTO DE CAMPOS VAZIOS
                if (AlturaH.getText().toString().isEmpty()) {
                    AlturaH.requestFocus();
                    AlturaH.setError("Por gentileza, informe a sua altura!");
                } else {

                    //CRIANDO VARIAVEIS AUXILIARES
                    float pesoIdeal, AlturaHomem;

                    //CONVERTENDO VALORES DIGITADOS
                    AlturaHomem = Float.parseFloat(AlturaH.getText().toString());

                    //CALCULO PARA O PESO IDEAL
                    pesoIdeal = (72.7f * AlturaHomem) - 58f;

                    //CLIMITANDO O NUMERO DE CASAS DECIMAIS
                    DecimalFormat df = new DecimalFormat();

                    //EXIBINDO O RESULTADO COM O  TAST, LIMITANDO DUAS CASAS DECIMAIS APÓS A VIRGULA
                    Toast.makeText(Tela2.this, "Senhor, o seu peso ideal é: " + df.format(pesoIdeal), Toast.LENGTH_LONG).show();
                }
            }
        });

        //CÓDIGO DO BOTÃO VOLTAR
        btnVoltaMasc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //CÓDIGO PARA BLOQUEAR O VOLTAR DO CELULAR
    @Override
    public void onBackPressed() {
        Toast.makeText(this,"Senhor, para voltar, clique no botão!",Toast.LENGTH_SHORT).show();
    }

}