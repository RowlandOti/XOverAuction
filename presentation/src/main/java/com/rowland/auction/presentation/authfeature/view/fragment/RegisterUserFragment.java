package com.rowland.auction.presentation.authfeature.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rowland.auction.presentation.R;
import com.rowland.auction.presentation.authfeature.view.activity.AuthActivity;
import com.rowland.auction.presentation.view.fragment.ABaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link ABaseFragment} subclass.
 */
public class RegisterUserFragment extends ABaseFragment {

    // Class log identifier
    public final static String LOG_TAG = RegisterUserFragment.class.getSimpleName();

    private onRegisterFinishBtnClickListener mRegisterFinishBtnClickListener;

    public interface onRegisterFinishBtnClickListener {
        void onRegisterFinishClicked(Bundle args);

        void onCallLoginClicked(Bundle args);
    }

    @Bind(R.id.img_regcover)
    ImageView imgRegcover;
    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.et_email)
    EditText etEmail;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.rl_progress)
    RelativeLayout rlProgress;
    @Bind(R.id.rl_retry)
    RelativeLayout rlRetry;
    @Bind(R.id.bt_retry)
    Button btRetry;
    @Bind(R.id.bt_register)
    Button btRegister;
    @Bind(R.id.tv_login)
    TextView tvLogin;


    public RegisterUserFragment() {
        setRetainInstance(true);
    }

    // Actual method to use to create new fragment instance externally
    public static RegisterUserFragment newInstance(@Nullable Bundle args) {
        RegisterUserFragment fragmentInstance = new RegisterUserFragment();
        if (args != null) {
            fragmentInstance.setArguments(args);
        }
        return fragmentInstance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View fragmentView = inflater.inflate(R.layout.fragment_register_user, container, false);
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isValidEditTextData(etUsername, etEmail, etPassword)) {
                    return;
                }
                Bundle args = new Bundle();
                args.putString(AuthActivity.AUTHUSERNAME, etUsername.getText().toString().trim());
                args.putString(AuthActivity.AUTHEMAIL, etEmail.getText().toString().trim());
                args.putString(AuthActivity.AUTHPASSWORD, etPassword.getText().toString().trim());
                mRegisterFinishBtnClickListener.onRegisterFinishClicked(args);
            }
        });
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString(AuthActivity.AUTHEMAIL, etEmail.getText().toString().trim());
                mRegisterFinishBtnClickListener.onCallLoginClicked(args);
            }
        });
    }

    // Called after fragment is attached to activity
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Ensure attached activity has implemented the callback interface.
        try {
            // Acquire the implemented callback
            mRegisterFinishBtnClickListener = (onRegisterFinishBtnClickListener) context;
        } catch (ClassCastException e) {
            // If not, it throws an exception
            throw new ClassCastException(context.toString() + " must implement onRegisterFinishBtnClickListener");
        }
    }

    // Called after fragment is detached from activity
    @Override
    public void onDetach() {
        // Avoid leaking,
        mRegisterFinishBtnClickListener = null;
        super.onDetach();
    }
}
