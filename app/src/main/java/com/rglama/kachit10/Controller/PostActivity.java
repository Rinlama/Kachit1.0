package com.rglama.kachit10.Controller;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.rglama.kachit10.Model.DBAdapter;
import com.rglama.kachit10.R;

public class PostActivity extends ActionBarActivity {
    DBAdapter myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        openDB();

    }
    private void openDB(){
        myDb= new DBAdapter(this);
        myDb.open();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeDB();
    }

    private void closeDB() {
        myDb.close();

    }
    public void deleteAll(){
        myDb.deleteAll();

    }

    public void savePosting(View view){
        EditText NameEditTxt= (EditText) findViewById(R.id.nameEditTxt);
        EditText EmailEditTxt= (EditText) findViewById(R.id.emailEditTxt);
        EditText TitleEditTxt= (EditText) findViewById(R.id.titleEditTxt);
        EditText AddressEditTxt= (EditText) findViewById(R.id.addressEditTxt);
        EditText DescriptionEditTxt= (EditText) findViewById(R.id.descriptionEditTxt);


        String name,email,title,address,description;
        name=NameEditTxt.getText().toString();
        email=EmailEditTxt.getText().toString();
        title=TitleEditTxt.getText().toString();
        address=AddressEditTxt.getText().toString();
        description=DescriptionEditTxt.getText().toString();




            long newID = myDb.insertRow(name, email, title, address, description);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Please enter a correct form field");


    }
//    //display a database
//    public void onClick_DisplayRecords(){
//        Cursor cursor=myDb.getAllRows();
//
//
//        if (cursor.moveToFirst()){
//            do {
//                int id = cursor.getInt(0);
//                String name = cursor.getString(1);
//                int studentNumber = cursor.getInt(2);
//                String color=cursor.getString(3);
//
//
//                String message = " ID : " + id + " name: " + name + " studentNumber: " + studentNumber + "color :" + color + "\n";
//                Log.d("tag ", "Message :" + message);
//            }while(cursor.moveToNext());
//            cursor.close();
//        }
//
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_post, menu);
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
