package jp.co.jinapp.jinwarikan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    private int ninzuu;
    private int kane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edittext1 = (EditText)findViewById(R.id.edittext1);
        edittext1.addTextChangedListener(this);   //追加

        EditText edittext2 = (EditText)findViewById(R.id.edittext2);
        edittext2.addTextChangedListener(this);   //追加
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {

        TextView textView = (TextView)findViewById(R.id.textview);

        String str;
        Integer i;

        //1
            EditText txt1 = (EditText) findViewById(R.id.edittext1);
            str=txt1.getText().toString();

                try {
                    i = Integer.parseInt(str);
                }catch(NumberFormatException e) {
                    i=0;
                }
            kane=i;


        //2
        EditText txt2 = (EditText) findViewById(R.id.edittext2);
        str=txt2.getText().toString();

                try {
                    i = Integer.parseInt(str);
                }catch(NumberFormatException e) {
                    i=0;
                }
            ninzuu=i;

        if(ninzuu!=0) {
            double ans= (double)kane / ninzuu;
            String mes="人数は " + ninzuu + "です。" + "金額は " + kane + "です。" + "\n\n一人当たり " + ans + "です。";
            textView.setText(mes);
        }else{
            textView.setText(new String("人数を入力せよ。"));
        }

    }

}
