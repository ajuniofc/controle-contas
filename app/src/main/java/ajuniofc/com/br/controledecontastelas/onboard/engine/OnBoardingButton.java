package ajuniofc.com.br.controledecontastelas.onboard.engine;

import android.view.View;

/**
 * Created by admin on 10/05/2018.
 */

public class OnBoardingButton {
    private String title;
    private View.OnClickListener listener;

    public OnBoardingButton(String title, View.OnClickListener listener) {
        this.title = title;
        this.listener = listener;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }
}
