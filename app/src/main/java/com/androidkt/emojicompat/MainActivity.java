package com.androidkt.emojicompat;

import android.os.Bundle;
import android.support.text.emoji.EmojiCompat;
import android.support.text.emoji.widget.EmojiButton;
import android.support.text.emoji.widget.EmojiEditText;
import android.support.text.emoji.widget.EmojiTextView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.apache.commons.lang3.StringEscapeUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final String MESSAGE1 = "see-no-evil \uD83D\uDE48";
    private static final String MESSAGE2 = "here-no-evil \uD83D\uDE49";
    private static final String MESSAGE3 = "speak-no-evil \uD83D\uDE4A";;


    @BindView(R.id.editText)
    EmojiEditText editText;

    @BindView(R.id.button)
    EmojiButton button;

    @BindView(R.id.textView)
    EmojiTextView textView;

    @BindView(R.id.normalTextView)
    TextView normalTextView;

    public static String getEmojiByUnicode(int unicode) {
        return Character.toString((char) unicode);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        textView.setText(MESSAGE1);
        editText.setText(MESSAGE2);
        button.setText(MESSAGE3);


        // Regular TextView without EmojiCompat support; you have to manually process the text
        EmojiCompat.get().registerInitCallback(new EmojiCompat.InitCallback() {
            @Override
            public void onInitialized() {
                final EmojiCompat compat = EmojiCompat.get();
                normalTextView.setText(
                        compat.process("Normal TextView \uD83D\uDE48\uD83D\uDE49\uD83D\uDE4A"));
            }
        });
    }
}
