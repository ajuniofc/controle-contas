package ajuniofc.com.br.controledecontastelas.onboard.engine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ajuniofc.com.br.controledecontastelas.R;
import ajuniofc.com.br.controledecontastelas.onboard.listeners.PaperOnboardingOnChangeListener;
import ajuniofc.com.br.controledecontastelas.onboard.listeners.PaperOnboardingOnLeftOutListener;
import ajuniofc.com.br.controledecontastelas.onboard.listeners.PaperOnboardingOnRightOutListener;


/**
 * Ready to use PaperOnboarding fragment
 */
public class PaperOnboardingFragment extends Fragment {

    private static final String ELEMENTS_PARAM = "elements";
    private static OnBoardingButton mOnBoardingButton;
    private static String mTitle;
    private static View.OnClickListener mListener;

    private PaperOnboardingOnChangeListener mOnChangeListener;
    private PaperOnboardingOnRightOutListener mOnRightOutListener;
    private PaperOnboardingOnLeftOutListener mOnLeftOutListener;
    private ArrayList<PaperOnboardingPage> mElements;


    public static PaperOnboardingFragment newInstance(ArrayList<PaperOnboardingPage> elements, OnBoardingButton onBoardingButton) {
        mOnBoardingButton = onBoardingButton;
        PaperOnboardingFragment fragment = new PaperOnboardingFragment();
        Bundle args = new Bundle();
        args.putSerializable(ELEMENTS_PARAM, elements);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mElements = (ArrayList<PaperOnboardingPage>) getArguments().get(ELEMENTS_PARAM);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.onboarding_main_layout, container, false);

        // create engine for onboarding element
        PaperOnboardingEngine mPaperOnboardingEngine = new PaperOnboardingEngine(view.findViewById(R.id.onboardingRootView), mElements, mOnBoardingButton,getActivity().getApplicationContext());
        // set listeners
        mPaperOnboardingEngine.setOnChangeListener(mOnChangeListener);
        mPaperOnboardingEngine.setOnLeftOutListener(mOnLeftOutListener);
        mPaperOnboardingEngine.setOnRightOutListener(mOnRightOutListener);

        return view;
    }

    public void setElements(ArrayList<PaperOnboardingPage> elements) {
        this.mElements = elements;
    }

    public ArrayList<PaperOnboardingPage> getElements() {
        return mElements;
    }

    public void setOnChangeListener(PaperOnboardingOnChangeListener onChangeListener) {
        this.mOnChangeListener = onChangeListener;
    }

    public void setOnRightOutListener(PaperOnboardingOnRightOutListener onRightOutListener) {
        this.mOnRightOutListener = onRightOutListener;
    }

    public void setOnLeftOutListener(PaperOnboardingOnLeftOutListener onLeftOutListener) {
        this.mOnLeftOutListener = onLeftOutListener;
    }

}
