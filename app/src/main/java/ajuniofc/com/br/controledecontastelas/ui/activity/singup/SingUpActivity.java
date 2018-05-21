package ajuniofc.com.br.controledecontastelas.ui.activity.singup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import ajuniofc.com.br.controledecontastelas.R;

public class SingUpActivity extends AppCompatActivity {
    private LinearLayout erroLayout;
    private EditText edtNome;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        edtNome = findViewById(R.id.cadastro_nome);
        erroLayout = findViewById(R.id.cadastro_erro_nome);
        next = findViewById(R.id.cadastro_nome_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringNome = edtNome.getText().toString();
                if (stringNome.isEmpty() || stringNome.length() < 3){
                    erroLayout.setVisibility(View.VISIBLE);
                }else {
                    erroLayout.setVisibility(View.INVISIBLE);
                    startActivity(new Intent(SingUpActivity.this, CadastroEmailActivity.class));
                }
            }
        });
    }

    public void finishView(View view) {
        finish();
    }

}
