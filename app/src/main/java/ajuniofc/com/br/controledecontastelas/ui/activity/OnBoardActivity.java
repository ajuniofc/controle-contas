package ajuniofc.com.br.controledecontastelas.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ramotion.paperonboarding.PaperOnboardingFragment;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnLeftOutListener;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.ui.fragment.OnBoardFragment;

public class OnBoardActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private TextView go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        go = findViewById(R.id.idGo);
        fragmentManager = getSupportFragmentManager();

        final PaperOnboardingFragment onBoardingFragment = PaperOnboardingFragment.newInstance(getDataForOnboarding());

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, onBoardingFragment);
        fragmentTransaction.commit();

        onBoardingFragment.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                go.setVisibility(View.VISIBLE);
//                startActivity(new Intent(OnBoardActivity.this, LoginActivity.class));
//                finish();
            }
        });

        onBoardingFragment.setOnLeftOutListener(new PaperOnboardingOnLeftOutListener() {
            @Override
            public void onLeftOut() {
                go.setVisibility(View.INVISIBLE);
            }
        });
    }

    private ArrayList<PaperOnboardingPage> getDataForOnboarding() {
        // prepare data
        PaperOnboardingPage scr1 = new PaperOnboardingPage("Facilite", "Todas as suas contas em um só lugar",
                Color.parseColor(getResources().getString(0+R.color.cinzaEscuro)), R.drawable.ic_list_120dp, R.drawable.ic_lista_2);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Compartilhe", "Gerencie suas contas em grupo",
                Color.parseColor(getResources().getString(0+R.color.verde_claro)), R.drawable.ic_share_120dp, R.drawable.ic_compartilhar);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("Sincronize", "Mantenha todo mundo atualizado",
                Color.parseColor(getResources().getString(0+R.color.colorPrimary)), R.drawable.ic_sync_120dp, R.drawable.ic_sincronizado_2);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);
        return elements;
    }

    public void next(View view) {
        startActivity(new Intent(OnBoardActivity.this, LoginActivity.class));
        finish();
    }
}
