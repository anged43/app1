package FacciAngelMero.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class Temperatura extends AppCompatActivity {

    Button convertir = null;
    EditText cantidad = null;
    TextView resultado = null;
    Spinner aaa = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);
        convertir = (Button)findViewById(R.id.btc);
        cantidad = (EditText)findViewById(R.id.cantidad);
        resultado = (TextView)findViewById(R.id.resultado);
        aaa = (Spinner)findViewById(R.id.spin);
        String []opciones = {"Seleccione una", "grados C a F", "grados F a C"};
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones);
        aaa.setAdapter(adapter);
        convertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double c = Double.parseDouble(cantidad.getText().toString());
                Double res = null;
                int seleccion = aaa.getSelectedItemPosition();
                switch(seleccion){
                    case 0:
                        res = (c- 32) / 1.8;
                        break;

                    case 1:
                        res = 1.8 * c + 32;
                        break;

                    case 2:
                        res = (c- 32) / 1.8;
                        break;


                }
                resultado.setText(res.toString());
            }
        });
    }
}
