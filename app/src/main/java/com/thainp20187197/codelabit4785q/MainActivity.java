package com.thainp20187197.codelabit4785q;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.thainp20187197.codelabit4785q.model.Address;
import com.thainp20187197.codelabit4785q.model.Avatar;
import com.thainp20187197.codelabit4785q.model.Company;
import com.thainp20187197.codelabit4785q.model.User;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {
    ArrayList<User> users;
    ListView userListView;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userListView = findViewById(R.id.userListView);
        userListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                        User user = (User) parent.getItemAtPosition(position);
                        intent.putExtra("user", user);
                        startActivity(intent);
                    }
                }
        );

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            new GetUsers().execute();
        }

        users = new ArrayList<>();
        userAdapter = new UserAdapter(users);
        userListView.setAdapter(userAdapter);
    }

    private void LoadUsers(String jsonResponse) {
        users.clear();
        try {
            JSONArray jsonUsers = new JSONArray(jsonResponse);
            for (int i = 0; true; i++) {
                if (jsonUsers.isNull(i)) break;
                JSONObject jsonUser = jsonUsers.getJSONObject(i);
                JSONObject jsonAvatar = jsonUser.getJSONObject("avatar");
                JSONObject jsonAddress = jsonUser.getJSONObject("address");
                JSONObject jsonGeo = jsonAddress.getJSONObject("geo");
                JSONObject jsonCompany = jsonUser.getJSONObject("company");
                users.add(new User(
                        jsonUser.getInt("id"),
                        jsonUser.getString("name"),
                        jsonUser.getString("username"),
                        jsonUser.getString("email"),
                        new Avatar(
                                "https://lebavui.github.io" + jsonAvatar.getString("thumbnail"),
                                "https://lebavui.github.io" + jsonAvatar.getString("photo")),
                        new Address(
                                jsonAddress.getString("street"),
                                jsonAddress.getString("suite"),
                                jsonAddress.getString("city"),
                                jsonAddress.getString("zipcode"),
                                jsonGeo.getString("lat"),
                                jsonGeo.getString("lng")
                        ),
                        jsonUser.getString("phone"),
                        jsonUser.getString("website"),
                        new Company(
                                jsonCompany.getString("name"),
                                jsonCompany.getString("catchPhrase"),
                                jsonCompany.getString("bs")
                        )
                ));
            }
        } catch (Exception ex)
        {
            Log.v("TAG", "Error!");
        }
        userAdapter.notifyDataSetChanged();
    }

    private class GetUsers extends AsyncTask<Void, Void, String> {
        ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setMessage("GET-ing data");
            dialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("https://lebavui.github.io/jsons/users.json");
                HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                StringBuilder builder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                return builder.toString();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.v("TAG", s);
            LoadUsers(s);
            dialog.dismiss();
        }
    }
}