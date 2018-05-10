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

import java.util.ArrayList;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.onboard.engine.OnBoardingButton;
import ajuniofc.com.br.controledecontastelas.onboard.engine.PaperOnboardingFragment;
import ajuniofc.com.br.controledecontastelas.onboard.engine.PaperOnboardingPage;
import ajuniofc.com.br.controledecontastelas.onboard.listeners.PaperOnboardingOnLeftOutListener;

public class OnBoardActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);
        fragmentManager = getSupportFragmentManager();

        final PaperOnboardingFragment onBoardingFragment = PaperOnboardingFragment.newInstance(getDataForOnboarding(), new OnBoardingButton("Go!", new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OnBoardActivity.this, LoginActivity.class));
            }
        }));

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, onBoardingFragment);
        fragmentTransaction.commit();

        onBoardingFragment.setOnLeftOutListener(new PaperOnboardingOnLeftOutListener() {
            @Override
            public void onLeftOut() {
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
}
