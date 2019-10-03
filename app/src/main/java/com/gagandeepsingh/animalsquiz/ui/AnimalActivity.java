package com.gagandeepsingh.animalsquiz.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.gagandeepsingh.animalsquiz.R;
import com.gagandeepsingh.animalsquiz.model.Page;
import com.gagandeepsingh.animalsquiz.model.Story;


public class AnimalActivity extends AppCompatActivity {

    public static final String TAG = AnimalActivity.class.getSimpleName();
    private ImageView mImageView;
    private Story mStory = new Story();
   private Page mCurrentPage;
    private EditText mAnimalEditText;
    private Button mPlayButton;
    private TextView mTextView;
    private RadioGroup mRadioGroup;
    private RadioButton mFirstRB, mSecondRB, mThirdRB, mFourthRB, mFifthRB;

    private TextView mAnimalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        mImageView = (ImageView) findViewById(R.id.imageView);
        mAnimalEditText = (EditText) findViewById(R.id.animalEditText);
        mTextView = (TextView) findViewById(R.id.textView);
        mPlayButton = (Button) findViewById(R.id.playbtn);

        mRadioGroup = (RadioGroup) findViewById(R.id.RGroup);
        mAnimalTextView = (TextView) findViewById(R.id.animalTextView);

        mFirstRB = (RadioButton) findViewById(R.id.radioButton);
        mSecondRB = (RadioButton) findViewById(R.id.radioButton2);
        mThirdRB = (RadioButton) findViewById(R.id.radioButton3);
        mFourthRB = (RadioButton) findViewById(R.id.radioButton4);
        mFifthRB = (RadioButton) findViewById(R.id.radioButton5);

        mAnimalEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    mTextView.setText(mAnimalEditText.getText().toString());
                    handled = true;
                    mAnimalEditText.setText("");
                }
                return handled;
            }
        });

        Intent intent = getIntent();
        int num = intent.getIntExtra("values", -1);
        loadPage(num);

        Context context = getApplicationContext();
        CharSequence text = "!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, mCurrentPage.getAnimalName() + text, duration);
        toast.show();

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

     private void loadPage(int choice) {
        mCurrentPage = mStory.getPage(choice);

        Drawable drawable = getResources().getDrawable(mCurrentPage.getImageId());
        mImageView.setImageDrawable(drawable);
    }

}
