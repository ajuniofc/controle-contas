package ajuniofc.com.br.controledecontastelas.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.ui.activity.recuperarsenha.RecuperarSenhaActivity;
import ajuniofc.com.br.controledecontastelas.ui.activity.singup.SingUpActivity;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText edtUser, edtPassword;
    private LinearLayout erroUserLayout, erroPasswordLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUser = findViewById(R.id.login_usuario);
        edtPassword = findViewById(R.id.login_senha);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSplashActicity();
            }
        });

        erroUserLayout = findViewById(R.id.login_erro_usuario);
        erroPasswordLayout = findViewById(R.id.login_erro_password);
    }

    private void goToSplashActicity() {
        String stringUser = edtUser.getText().toString();
        String stringPassword = edtPassword.getText().toString();
        if (isValid(stringUser, stringPassword)){
            startActivity(new Intent(this, SplashScreenActivity.class));
            finish();
        }
    }

    private boolean isValid(String stringUser, String stringPassword) {
        boolean valid = true;
        if (stringPassword.isEmpty()){
            valid = false;
            erroPasswordLayout.setVisibility(View.VISIBLE);
        }else {
            erroPasswordLayout.setVisibility(View.INVISIBLE);
        }
        if (stringUser.isEmpty()){
            valid = false;
            erroUserLayout.setVisibility(View.VISIBLE);
        }else {
            erroUserLayout.setVisibility(View.INVISIBLE);
        }
        return valid;
    }

    public void goToSingUp(View view) {
        startActivity(new Intent(this, SingUpActivity.class));
    }

    public void goToRecuperarSenha(View view) {
        startActivity(new Intent(this, RecuperarSenhaActivity.class));
    }
}
