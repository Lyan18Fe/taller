package co.cesde.saludsas;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Registro extends AppCompatActivity {

    Button btnSiguiente;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        //codigo de selección multiple
        Spinner spinner = findViewById(R.id.sp_documento);
        List<String> opciones = new ArrayList<>();
        opciones.add("Cedula de ciudadania");
        opciones.add("Cedula de extranjeria");
        opciones.add("NIT");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        spinner.setAdapter(adapter);

        btnSiguiente=findViewById(R.id.btn_registrar);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siguiente();
            }
        });

    }

    public void siguiente(){
        Toast.makeText(this, "NOS PONDREMOS EN CONTACTO CON TU EMPRESA MIENTRAS RECOGEMOS TODA LA INFORMACION", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}