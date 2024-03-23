package co.cesde.saludsas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnIniciar;

    Button btnRegistro;
    TextView inputDocumento;
    TextView inputContrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //codigo de selección multiple
        Spinner spinner = findViewById(R.id.sp_documento);
        List<String> opciones = new ArrayList<>();
        opciones.add("Cedula de ciudadania");
        opciones.add("Cedula de extranjeria");
        opciones.add("NIT");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);

        btnIniciar = findViewById(R.id.btn_iniciar);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });

        btnRegistro = findViewById(R.id.btn_crear_cuenta);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crearCuenta();
            }
        });

    }

    public void iniciarSesion(){
        String id = "123456789";
        String password = "123";
        inputDocumento = findViewById(R.id.input_documento);
        inputContrasena = findViewById(R.id.input_contrasena);
        String inputId = String.valueOf(inputDocumento.getText());
        String inputPassword = String.valueOf(inputContrasena.getText());

        if(id.equals(inputId) && password.equals(inputPassword)){
            Intent intent = new Intent(this,UsuarioPrincipal.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Valide su usuario", Toast.LENGTH_SHORT).show();
        }

    }

    public void crearCuenta(){
        Intent intent = new Intent(this,Registro.class);
        startActivity(intent);
    }



}