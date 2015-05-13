package com.rglama.kachit10.Controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.rglama.kachit10.Model.DBAdapter;
import com.rglama.kachit10.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class MainActivity extends ActionBarActivity {
    DBAdapter myDb;
    String name,email,title,address,description;
    Stack <Post>list= new Stack();
    Post post;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openDB();
        onClick_DisplayRecords();
        populate();
        registerClickCallback();


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



    public void AddPostEvent(View view){
        Intent intent = new Intent(this,PostActivity.class);
        startActivity(intent);

    }


    public void onClick_DisplayRecords(){

        Cursor cursor=myDb.getAllRows();


        if (cursor.moveToFirst()){
            do {
                int id = cursor.getInt(0);
                name = cursor.getString(1);
                email = cursor.getString(2);
               title=cursor.getString(3);
               address=cursor.getString(4);
                 description=cursor.getString(5);
//                String message = " ID :" + id + " name: " + name + " studentNumber: " + studentNumber + "Color" + color;
                String message = "Name: " + name + " studentNumber: " + email + "Title :" + title + "address" + address + "Description" + description;
                Log.d("tag ", "Message :" + message);
                 Post post= new Post(name, email, title, address, description);

                  getPost(post);
            }while(cursor.moveToNext());
            cursor.close();
        }

    }


    public void getPost(Post postobj){
       if(postobj!=null) {
            list.push(postobj);
       }
    }


    public void populate(){

        ArrayAdapter<Post> adapter= new ArrayAdapter<Post>(this,R.layout.da,list);
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);



    }


    private void registerClickCallback() {
        ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;
                String message ="You clicked # " + position + ", which is string: " + textView.getText().toString();
            //    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                Post p = (Post) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, p.getAddress().toString(), Toast.LENGTH_LONG).show();
                onBackPressed(p.getAddress().toString());
            }
        });

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


    public void onBackPressed(final String address) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Do you want to track a address?");
        // alert.setMessage("Message");

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                        String uriString="geo:0,0?q="+ address;
                        Uri location= Uri.parse(uriString);
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                        startActivity(mapIntent);



            }
        });

        alert.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });

        alert.show();

    }

    public void OnClickLogin(View view){

        Intent intent = new Intent(this,testLogin.class);
        startActivity(intent);



    }





}
