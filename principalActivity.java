package br.edu.flf.pdm.calculaimc;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class PrincipalActivity extends Activity {

    private EditText peso;
    private EditText altura;
    private EditText imc;
    Button calcular;
    Button limpar;
    Double doublePeso;
    Double doubleAltura;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        peso = (EditText)findViewById(R.id.pesoEditText);
        altura = (EditText)findViewById(R.id.alturaEditText);
        imc = (EditText)findViewById(R.id.imcEditText);
        imc.setFocusable(false);
        imc.setFocusableInTouchMode(false);

        calcular = (Button)findViewById(R.id.calcularButton);
        limpar = (Button)findViewById(R.id.limparButton);

        calcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickMain(calcular);
            }
        });
        limpar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onClickMain(limpar);
            }
        });
    }

    public void onClickMain (View v){
        // getId() returns the id of the clicked view.
        if(v.getId() == R.id.calcularButton){
            //you clicked the calcula button

            String stringPeso = peso.getText().toString();
            try
            {
                doublePeso = new Double(stringPeso).doubleValue();
            }
            catch (NumberFormatException e)
            {
                // handle the exception
            }

            String stringAltura = altura.getText().toString();
            try
            {
                doubleAltura = new Double(stringAltura).doubleValue();
            }
            catch (NumberFormatException e)
            {
                // handle the exception
            }

            Double result = doublePeso/ java.lang.Math.pow(doubleAltura,2);

            imc.setText(result.toString());

        }else if(v.getId() == R.id.limparButton){
            //you clicked the limpar button

            peso.setText(" ");
            altura.setText(" ");
            imc.setText(" ");
        }
    }
}
