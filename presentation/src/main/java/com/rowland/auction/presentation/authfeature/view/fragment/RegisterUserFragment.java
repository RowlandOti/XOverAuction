package com.rowland.auction.presentation.authfeature.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.rowland.auction.presentation.R;
import com.rowland.auction.presentation.view.fragment.ABaseFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link ABaseFragment} subclass.
 */
public class RegisterUserFragment extends ABaseFragment {

    private onRegisterFinishBtnClickListener registerFinishBtnClickListener;
    private String username;
    private String email;
    private String passWord;

    public interface onRegisterFinishBtnClickListener {
        void onRegisterFinishClicked(String username, String email, String passWord);
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


    public RegisterUserFragment() {
        setRetainInstance(true);
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
                if (!isValidEditTextData(etUsername, etEmail,etPassword)) {
                    return;
                }
                username = etUsername.getText().toString().trim();
                email = etEmail.getText().toString().trim();
                passWord = etPassword.getText().toString().trim();
                registerFinishBtnClickListener.onRegisterFinishClicked(username, email, passWord);
            }
        });
    }
}
