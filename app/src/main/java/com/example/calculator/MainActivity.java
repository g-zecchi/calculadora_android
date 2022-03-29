package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button zero,um,dois,tres,quatro,cinco,seis,sete,oito,nove,ponto,soma,subtracao,multiplicacao,divisao,igual,limpar;

    private TextView expressao,resultado;

    private ImageView apagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IniciarComponentes();
        getSupportActionBar().hide();

        zero.setOnClickListener(this);
        um.setOnClickListener(this);
        dois.setOnClickListener(this);
        tres.setOnClickListener(this);
        quatro.setOnClickListener(this);
        cinco.setOnClickListener(this);
        seis.setOnClickListener(this);
        sete.setOnClickListener(this);
        oito.setOnClickListener(this);
        nove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        limpar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                expressao.setText("");
                resultado.setText("");
            }
        });

        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if(!string.isEmpty()){

                    byte var0 = 0;
                    int var1  = string.length()-1;
                    String TXTexpressao = string.substring(var0,var1);
                    expressao.setText(TXTexpressao);
                }
                resultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Expression expression = new ExpressionBuilder(expressao.getText().toString()).build();
                    double result = expression.evaluate();
                    long longResult = (long) result;

                    if (result == (double) longResult){
                        resultado.setText((CharSequence) String.valueOf(longResult));
                    }else{
                        resultado.setText((CharSequence) String.valueOf(result));
                    }
                }catch (Exception e){

                }


            }
        });
    }

    private void IniciarComponentes(){
        zero = findViewById(R.id.bt_zero);
        um = findViewById(R.id.bt_um);
        dois = findViewById(R.id.bt_dois);
        tres = findViewById(R.id.bt_tres);
        quatro = findViewById(R.id.bt_quatro);
        cinco = findViewById(R.id.bt_cinco);
        seis = findViewById(R.id.bt_seis);
        sete = findViewById(R.id.bt_sete);
        oito = findViewById(R.id.bt_oito);
        nove = findViewById(R.id.bt_nove);
        ponto = findViewById(R.id.bt_ponto);
        soma = findViewById(R.id.bt_soma);
        subtracao = findViewById(R.id.bt_subtracao);
        multiplicacao = findViewById(R.id.bt_multiplicacao);
        divisao = findViewById(R.id.bt_divisao);
        igual = findViewById(R.id.bt_igual);
        limpar = findViewById(R.id.bt_limpar);
        expressao = findViewById(R.id.txt_expressao);
        resultado = findViewById(R.id.txt_resultado);
        apagar = findViewById(R.id.bt_apaga);
    }
    public void AcrescentarExpressao(String string, boolean limpar_dados){
        if(resultado.getText().equals("")){
            expressao.setText(" ");
        }
        if(limpar_dados){
            resultado.setText(" ");
            expressao.append(string);
        }else{
            expressao.append(resultado.getText());
            expressao.append(string);
            resultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_zero:
                AcrescentarExpressao("0", true);
                break;

            case R.id.bt_um:
                AcrescentarExpressao("1", true);
                break;

            case R.id.bt_dois:
                AcrescentarExpressao("2",true);
                break;

            case R.id.bt_tres:
                AcrescentarExpressao("3", true);
                break;

            case R.id.bt_quatro:
                AcrescentarExpressao("4", true);
                break;

            case R.id.bt_cinco:
                AcrescentarExpressao("5",true);
                break;

            case R.id.bt_seis:
                AcrescentarExpressao("6", true);
                break;

            case R.id.bt_sete:
                AcrescentarExpressao("7", true);
                break;

            case R.id.bt_oito:
                AcrescentarExpressao("8",true);
                break;

            case R.id.bt_nove:
                AcrescentarExpressao("9",true);
                break;

            case R.id.bt_ponto:
                AcrescentarExpressao(".",true);
                break;

            case R.id.bt_soma:
                AcrescentarExpressao("+",false);
                break;

            case R.id.bt_subtracao:
                AcrescentarExpressao("-",false);
                break;

            case R.id.bt_multiplicacao:
                AcrescentarExpressao("*",false);
                break;

            case R.id.bt_divisao:
                AcrescentarExpressao("/",false);
                break;
        }
    }
}