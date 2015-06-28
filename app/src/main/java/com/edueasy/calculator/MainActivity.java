package com.edueasy.calculator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.regex.Pattern;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    private TextView scr;
    private float no1;
    private float no2;
    private String opr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scr = (TextView) findViewById(R.id.textView);
        int idList[] = {R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,
                R.id.button7,R.id.button8,R.id.button9,R.id.button0,R.id.buttonC,R.id.buttondot,
                R.id.buttoneql,R.id.buttonsum,R.id.buttonmin,R.id.buttonmul,R.id.buttondiv};

        for (int id:idList){
            View v = (View)findViewById(id);
            v.setOnClickListener(this);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonC:
                scr.setText("0");
                break;
            case R.id.buttonsum:
                no1 = Float.parseFloat(scr.getText().toString());
                opr = "+";
                scr.setText(scr.getText().toString() + "+");
                break;
            case R.id.buttonmin:
                no1 = Float.parseFloat(scr.getText().toString());
                opr = "-";
                scr.setText(scr.getText().toString() + "-");
                break;
            case R.id.buttonmul:
                no1 = Float.parseFloat(scr.getText().toString());
                opr = "*";
                scr.setText(scr.getText().toString() + "*");
                break;
            case R.id.buttondiv:
                no1 = Float.parseFloat(scr.getText().toString());
                opr = "/";
                scr.setText(scr.getText().toString() + "/");
                break;
            case R.id.buttoneql:
                String string = scr.getText().toString();
                String[] parts = string.split(Pattern.quote(opr));
                no2 = Float.parseFloat(parts[1]);
                if(opr.equals("+")){
                    scr.setText(Float.toString(no1 + no2));
                }
                if(opr.equals("-")){
                    scr.setText(Float.toString(no1 - no2));
                }
                if(opr.equals("*")){
                    scr.setText(Float.toString(no1 * no2));
                }
                if(opr.equals("/")){
                    scr.setText(Float.toString(no1 / no2));
                }
                break;
            default:
                if(scr.getText().toString().equals("0")) {
                    scr.setText(((Button) v).getText().toString());
                }else{
                    scr.setText(scr.getText().toString() + ((Button) v).getText().toString());
                }
                break;
        }
    }
}
