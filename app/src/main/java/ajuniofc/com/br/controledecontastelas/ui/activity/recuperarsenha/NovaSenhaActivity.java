package ajuniofc.com.br.controledecontastelas.ui.activity.recuperarsenha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.ui.activity.home.HomeActivity;

public class NovaSenhaActivity extends AppCompatActivity {
    private EditText novaSenha;
    private LinearLayout erroLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_senha);
        novaSenha = findViewById(R.id.nova_senha);
        erroLayout = findViewById(R.id.nova_senha_erro);
    }

    public void onNext(View view) {
        String stringSenha = novaSenha.getText().toString();
        if (stringSenha.isEmpty() || stringSenha.length() <8){
            erroLayout.setVisibility(View.VISIBLE);
        }else {
            erroLayout.setVisibility(View.INVISIBLE);
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
    }
}
