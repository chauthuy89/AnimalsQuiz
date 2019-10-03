package com.gagandeepsingh.animalsquiz.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.gagandeepsingh.animalsquiz.R;
import com.gagandeepsingh.animalsquiz.model.ColorsWheel;


public class MainActivity extends AppCompatActivity {

    private RadioGroup mRadioGroup;
    private Button mSubmitButton;
    private TextView mTextView;
    int counter = 0;
    ColorsWheel mColorsWheel = new ColorsWheel();
    private RadioButton mFirstRB, mSecondRB, mThirdRB, mFourthRB, mFifthRB;
    int numbers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstRB = (RadioButton) findViewById(R.id.radioButton);
        mSecondRB = (RadioButton) findViewById(R.id.radioButton2);
        mThirdRB = (RadioButton) findViewById(R.id.radioButton3);
        mFourthRB = (RadioButton) findViewById(R.id.radioButton4);
        mFifthRB = (RadioButton) findViewById(R.id.radioButton5);


        mSubmitButton = (Button) findViewById(R.id.submitButton);
        mTextView = (TextView) findViewById(R.id.animalTextView);
        mRadioGroup = (RadioGroup) findViewById(R.id.RGroup);

        mTextView.append("Lead more than I follow");

       /* HashMap<String, Integer> map = new HashMap<>();
        map.put("Lead more than I follow", 1); */



        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFirstRB.isChecked() || mSecondRB.isChecked() || mThirdRB.isChecked() ||
                        mFourthRB.isChecked() || mFifthRB.isChecked()) {
                    counter++;
                }

                if (counter > 4) {
                    counter = 0;
                    startIntent(numbers);
                }
                textView();

                int colors = mColorsWheel.getColors();
                mSubmitButton.setTextColor(colors);
                mRadioGroup.clearCheck();
            }
        });
    }

    private void startIntent(int nums) {
        Intent intent = new Intent(this, AnimalActivity.class);
        intent.putExtra("values", nums);

        startActivity(intent);
    }

    private void textView() {
        for (int i = 0; i < 5; i++) {
            if (counter == 0 && (mFirstRB.isChecked() || mSecondRB.isChecked() || mThirdRB.isChecked() ||
                    mFourthRB.isChecked() || mFifthRB.isChecked())) {
                mTextView.setText("Lead more than I follow");
                if(mFirstRB.isChecked() || mSecondRB.isChecked()) {
                    numbers = 1;
                    break;
                }
            } else if (counter == 1 && (mFirstRB.isChecked() || mSecondRB.isChecked() || mThirdRB.isChecked() ||
                    mFourthRB.isChecked() || mFifthRB.isChecked())) {
                mTextView.setText("Am the life of the party");
                if(mSecondRB.isChecked()) {
                    numbers = 2;
                }
            } else if (counter == 2 && (mFirstRB.isChecked() || mSecondRB.isChecked() || mThirdRB.isChecked() ||
                    mFourthRB.isChecked() || mFifthRB.isChecked())) {
                mTextView.setText("Enjoy looking good");
                if(mThirdRB.isChecked()) {
                    numbers = 3;
                }
            } else if (counter == 3 && (mFirstRB.isChecked() || mSecondRB.isChecked() || mThirdRB.isChecked() ||
                    mFourthRB.isChecked() || mFifthRB.isChecked())) {
                mTextView.setText("Don't like to draw attention to myself");
                if(mFourthRB.isChecked()) {
                    numbers = 4;
                }
            } else if (counter == 4 && (mFirstRB.isChecked() || mSecondRB.isChecked() || mThirdRB.isChecked() ||
                    mFourthRB.isChecked() || mFifthRB.isChecked())) {
                mTextView.setText("Are relaxed most of the time");
                if(mFifthRB.isChecked()) {
                    numbers = 5;
                }
            } else {
                break;
            }
        }
    }
}
