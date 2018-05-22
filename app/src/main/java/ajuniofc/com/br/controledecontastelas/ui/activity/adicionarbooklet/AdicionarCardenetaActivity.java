package ajuniofc.com.br.controledecontastelas.ui.activity.adicionarbooklet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import ajuniofc.com.br.controledecontastelas.R;

public class AdicionarCardenetaActivity extends AppCompatActivity {
    private EditText edtNome;
    private LinearLayout erroLayout;
    private boolean isValid = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_cardeneta);
        edtNome = findViewById(R.id.cadastro_cadernet_nome);
        erroLayout = findViewById(R.id.cadastro_caderneta_erro_nome);
    }

    public void goToCaredenetaRepetida(View view) {
        if (!isValid){
            erroLayout.setVisibility(View.VISIBLE);
            isValid = true;
        }else {
            erroLayout.setVisibility(View.INVISIBLE);
            startActivity(new Intent(this, BookletMensalActivity.class));
            finish();
        }
    }

    public void finishView(View view) {
        finish();
    }
}
