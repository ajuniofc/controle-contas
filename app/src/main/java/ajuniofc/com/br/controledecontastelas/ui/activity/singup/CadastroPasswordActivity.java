package ajuniofc.com.br.controledecontastelas.ui.activity.singup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.ui.activity.HomeActivity;

public class CadastroPasswordActivity extends AppCompatActivity {
    private LinearLayout erroLayout;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_password);

        edtPassword = findViewById(R.id.cadastro_password);
        erroLayout = findViewById(R.id.cadastro_erro_password);
    }

    public void onNext(View view) {
        String stringNome = edtPassword.getText().toString();
        if (stringNome.isEmpty() || stringNome.length() < 3){
            erroLayout.setVisibility(View.VISIBLE);
        }else {
            erroLayout.setVisibility(View.INVISIBLE);
            startActivity(new Intent(this, HomeActivity.class));
        }
    }

    public void goBackToEmail(View view) {
        finish();
    }
}
