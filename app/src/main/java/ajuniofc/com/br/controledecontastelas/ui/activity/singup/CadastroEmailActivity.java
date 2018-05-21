package ajuniofc.com.br.controledecontastelas.ui.activity.singup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import ajuniofc.com.br.controledecontastelas.R;

public class CadastroEmailActivity extends AppCompatActivity {
    private LinearLayout erroLayout;
    private EditText edtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_email);

        edtEmail = findViewById(R.id.cadastro_email);
        erroLayout = findViewById(R.id.cadastro_erro_email);
    }

    public void onNext(View view) {
        String stringNome = edtEmail.getText().toString();
        if (stringNome.isEmpty() || stringNome.length() < 3){
            erroLayout.setVisibility(View.VISIBLE);
        }else {
            erroLayout.setVisibility(View.INVISIBLE);
            startActivity(new Intent(this, CadastroPasswordActivity.class));
        }
    }

    public void goBackToNome(View view) {
            finish();
    }
}
