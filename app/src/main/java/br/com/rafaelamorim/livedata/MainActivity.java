package br.com.rafaelamorim.livedata;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import kotlin.reflect.KFunction;

public class MainActivity extends AppCompatActivity {

    private MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar o ViewModel
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        // Obter uma referência ao TextView
        final TextView textView = findViewById(R.id.textView);

        // Observar a LiveData
        myViewModel.getText().observe(this, novoValor -> {
            // Atualizar a UI quando os dados mudarem
            textView.setText(novoValor);
        });

        // Simular uma atualização nos dados (poderia ser uma resposta de API, por exemplo)
        myViewModel.updateText("Novo texto para a UI");
    }
}