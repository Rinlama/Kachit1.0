package com.rglama.kachit10.Controller;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rglama.kachit10.Model.DatabaseHelper;
import com.rglama.kachit10.R;

/**
 * Created by MVargas on 5/11/15.
 */
public class SignUp extends Activity{


    DatabaseHelper helper = new DatabaseHelper(this);

    public void onSignClick(View v){

        if (v.getId() == R.id.Bsignupbutton)
        {
            EditText uname = (EditText) findViewById(R.id.TFuname);
            EditText email = (EditText) findViewById(R.id.TFemail);
            EditText password1 = (EditText) findViewById(R.id.TFpassword1);
            EditText password2 = (EditText) findViewById(R.id.TFpassword2);

            String unamestr = uname.getText().toString();
            String emailstr = email.getText().toString();
            String password1str = password1.getText().toString();
            String password2str = password2.getText().toString();


            if (!password1str.equals(password2str)){

                //pop message
                Toast password = Toast.makeText(SignUp.this, "Password don't match", Toast.LENGTH_SHORT);
                password.show();
            }
            else{

                // Insert info into database
                UserAcct u = new UserAcct();
                u.setUname(unamestr);
                u.setEmail(emailstr);
                u.setPassword(password1str);

                helper.insertContacts(u);
            }
        }
    }

}
