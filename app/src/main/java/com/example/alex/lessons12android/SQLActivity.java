package com.example.alex.lessons12android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.alex.lessons12android.database.DataBaseMaster;
import com.example.alex.lessons12android.models.User;

import java.util.List;

public class SQLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        User user = new User();
        user.name = "Vaska";
        DataBaseMaster.getInstance(this).addUser(user);

        List<User> query = DataBaseMaster.getInstance(this).getAllUsersQuery();
        //Log.d()

        List<User> raw = DataBaseMaster.getInstance(this).getAllUsersRAW();

    }

}
