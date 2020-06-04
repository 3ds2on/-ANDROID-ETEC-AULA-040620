package com.example.appmenu28052020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Tela3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

            //OBJETOS PARA REFERENCIAR
            Button btnVoltarFem,btnCalcFem;
            final EditText edtAltF;


            //EFETUAR A REFERENCIA DO OBJETO NO XML
            edtAltF = findViewById(R.id.edtAltFem);
            btnCalcFem = findViewById(R.id.btnCalcFem);
            btnVoltarFem = findViewById(R.id.btnVoltarFem);


            //CÓDIGO DO BOTÃO CALCULAR
            btnCalcFem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //TRATAMENTO DE CAMPOS VAZIOS
                    if(edtAltF.getText().toString().isEmpty()){
                        edtAltF.requestFocus();
                        edtAltF.setError("Por gentileza, informe a sua altura!");
                    }else{

                        //CRIANDO VARIAVEIS AUXILIARES
                        float pesoIdeal,AlturaMulher;

                        //CONVERTENDO VALORES DIGITADOS
                        AlturaMulher = Float.parseFloat(edtAltF.getText().toString());

                        //CALCULO PARA O PESO IDEAL
                        pesoIdeal=(62.1f * AlturaMulher)- 44.7f;

                        //CLIMITANDO O NUMERO DE CASAS DECIMAIS
                        DecimalFormat df = new DecimalFormat();

                        //EXIBINDO O RESULTADO COM O  TAST, LIMITANDO DUAS CASAS DECIMAIS APÓS A VIRGULA
                        Toast.makeText(Tela3.this, "Senhora, o seu peso ideal é: " + df.format(pesoIdeal), Toast.LENGTH_LONG).show();
                    }
                }
            });

            //CÓDIGO DO BOTÃO VOLTAR
            btnVoltarFem.setOnClickListener(new View.OnClickListener() {
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