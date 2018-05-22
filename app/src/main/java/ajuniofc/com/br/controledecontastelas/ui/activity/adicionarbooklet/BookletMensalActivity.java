package ajuniofc.com.br.controledecontastelas.ui.activity.adicionarbooklet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ajuniofc.com.br.controledecontastelas.R;

public class BookletMensalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booklet_mensal);
    }

    public void finishView(View view) {
        finish();
    }

    public void onGoToCompartilhar(View view) {
        startActivity(new Intent(this, CompartilharActivity.class));
        finish();
    }

}
