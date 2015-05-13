package com.rglama.kachit10.Controller;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rglama.kachit10.Model.DatabaseHelper;
import com.rglama.kachit10.R;

public class testLogin extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_login);
    }


    DatabaseHelper helper = new DatabaseHelper(this);

    public void onButtonClick(View v){

        if(v.getId() == R.id.SignUpButton){

            EditText a = (EditText)findViewById(R.id.TFusername);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.TFusername);
            String pass = b.getText().toString();

            String password = helper.searchPass(str);

            if (pass.equals(password)) {

                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);

            }
            else {

                Toast temp = Toast.makeText(this, "Invalid Username and Password", Toast.LENGTH_SHORT);
                temp.show();
            }
        }

        if(v.getId() == R.id.Bsignupbutton){

            Intent i = new Intent(this, SignUp.class);
            startActivity(i);
        }

    }

    public void onclickSignup(View view){
        Intent i = new Intent(this, SignupTesting.class);
        startActivity(i);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_login, menu);
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
}
