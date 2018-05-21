package ajuniofc.com.br.controledecontastelas.ui.activity.recuperarsenha;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import ajuniofc.com.br.controledecontastelas.R;

public class CodigoSegurancaActivity extends AppCompatActivity {
    private EditText codigo;
    private LinearLayout erroLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_seguranca);
        codigo = findViewById(R.id.codigo_seguranca_codigo);
        erroLayout = findViewById(R.id.codigo_seguranca_erro);
    }

    public void finishView(View view) {
        finish();
    }

    public void onNext(View view) {
        String textCodigo = codigo.getText().toString();
        if (!textCodigo.isEmpty() && textCodigo.length() >= 4){
            erroLayout.setVisibility(View.INVISIBLE);
            startActivity(new Intent(this, NovaSenhaActivity.class));
            finish();
        }else {
            erroLayout.setVisibility(View.VISIBLE);
        }
    }

    public void endTime(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(getLayoutInflater().inflate(R.layout.codigo_expirado, null));
        builder.setPositiveButton("Nova Forma", onNovaForma());
        builder.setNegativeButton("Reenviar Código", onReenviar());
        final AlertDialog alertDialog = builder.create();

        alertDialog.setOnShowListener( new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface arg0) {
                int color = ContextCompat.getColor(CodigoSegurancaActivity.this, R.color.colorAccent);
                alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(color);
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(color);
            }
        });

        alertDialog.show();
    }

    private DialogInterface.OnClickListener onReenviar() {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(CodigoSegurancaActivity.this, "Código reenviado", Toast.LENGTH_LONG).show();
            }
        };
    }

    @NonNull
    private DialogInterface.OnClickListener onNovaForma() {
        return new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        };
    }
}
