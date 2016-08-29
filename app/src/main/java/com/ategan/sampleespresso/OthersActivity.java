package com.ategan.sampleespresso;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

public class OthersActivity extends AppCompatActivity {

    private TextView swtichStatus;
    private TextView radioButtonStatus;
    private RadioButton radioButton;
    private Switch aSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);
        initView();
    }

    private void initView() {
        ActivityUtil.initToolbar(this, R.id.toolbar);
        swtichStatus = (TextView) findViewById(R.id.switch_status);
        radioButtonStatus = (TextView) findViewById(R.id.radio_button_status);


        aSwitch = (Switch) findViewById(R.id.switch1);
        updateSwitchStatus(aSwitch.isChecked());
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                updateSwitchStatus(b);
            }
        });


        radioButton = (RadioButton) findViewById(R.id.radio_button);
        updateRadioButtonStatus(radioButton.isChecked());
        radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                updateRadioButtonStatus(b);
            }
        });
    }

    private void updateSwitchStatus(boolean isOn) {
        String status = getString(R.string.switch_status_text);
        swtichStatus.setText(String.format(status, isOn ? getString(R.string.on) : getString(R.string.off)));
    }

    private void updateRadioButtonStatus(boolean isOn) {
        String status = getString(R.string.radio_button_status_text);
        radioButtonStatus.setText(String.format(status, isOn ? getString(R.string.on) : getString(R.string.off)));
    }

}
