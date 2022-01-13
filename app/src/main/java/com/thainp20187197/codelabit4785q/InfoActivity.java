package com.thainp20187197.codelabit4785q;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.thainp20187197.codelabit4785q.model.User;

public class InfoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        User user = (User) bundle.get("user");

        Picasso.get().load(user.getAvatar().getPhotoUrl()).into((ImageView) findViewById(R.id.userPhotoImageView));
        ((TextView) findViewById(R.id.userNameTextView)).setText(user.getName());
        ((TextView) findViewById(R.id.userUsernameTextView)).setText(user.getUsername());
        ((TextView) findViewById(R.id.userEmailTextView)).setText(user.getEmail());
        ((TextView) findViewById(R.id.userPhoneTextView)).setText(user.getPhone());
        ((TextView) findViewById(R.id.userSuiteTextView)).setText(user.getAddress().getSuite());
        ((TextView) findViewById(R.id.userStreetTextView)).setText(user.getAddress().getStreet());
        ((TextView) findViewById(R.id.userCityTextView)).setText(user.getAddress().getCity());
        ((TextView) findViewById(R.id.userZipcodeTextView)).setText(user.getAddress().getZipcode());
        ((TextView) findViewById(R.id.userLatitudeTextView)).setText(Double.toString(user.getAddress().getLatitude()));
        ((TextView) findViewById(R.id.userLongitudeTextView)).setText(Double.toString(user.getAddress().getLongitude()));
        ((TextView) findViewById(R.id.userCompanyNameTextView)).setText(user.getCompany().getName());
        ((TextView) findViewById(R.id.userCatchPhraseTextView)).setText(user.getCompany().getCatchPhrase());
        ((TextView) findViewById(R.id.userBsTextView)).setText(user.getCompany().getBs());
    }
}
