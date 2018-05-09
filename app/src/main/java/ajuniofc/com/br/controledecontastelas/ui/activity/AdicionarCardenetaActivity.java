package ajuniofc.com.br.controledecontastelas.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ajuniofc.com.br.controledecontastelas.R;

public class AdicionarCardenetaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_cardeneta);
    }

    public void next(View view) {
        startActivity(new Intent(this, CompartilharActivity.class));
    }
}
