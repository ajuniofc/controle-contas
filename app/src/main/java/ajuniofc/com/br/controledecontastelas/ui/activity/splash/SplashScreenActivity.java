package ajuniofc.com.br.controledecontastelas.ui.activity.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Calendar;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.model.Bill;
import ajuniofc.com.br.controledecontastelas.model.Booklet;
import ajuniofc.com.br.controledecontastelas.model.BookletType;
import ajuniofc.com.br.controledecontastelas.model.CurrentDebt;
import ajuniofc.com.br.controledecontastelas.ui.activity.home.HomeActivity;

public class SplashScreenActivity extends AppCompatActivity {
    private RelativeLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        layout = findViewById(R.id.splash);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashScreenActivity.this, HomeActivity.class));
            }
        });

        Booklet booklet = new Booklet("Casa", "Contas de casa", Calendar.getInstance(), BookletType.SPARSE, new ArrayList<Bill>());
        CurrentDebt currentDebt = new CurrentDebt("CEB", "Conta de energia", Calendar.getInstance(), 78.90);
        booklet.getBills().add(currentDebt);
        EventBus.getDefault().postSticky(booklet);
    }
}
