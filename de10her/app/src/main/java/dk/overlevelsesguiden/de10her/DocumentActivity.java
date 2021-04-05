package dk.overlevelsesguiden.de10her;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DocumentActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ArrayList<Document> documents;

    private int documentIndex;

    private TextView title;


    private TextView h1Title;
    private TextView h1Description;
    private TextView h1;

    private TextView h2Title;
    private TextView h2Description;
    private TextView h2;

    private TextView h3Title;
    private TextView h3Description;
    private TextView h3;

    private TextView h4Title;
    private TextView h4Description;
    private TextView h4;

    private TextView h5Title;
    private TextView h5Description;
    private TextView h5;

    private TextView h6Title;
    private TextView h6Description;
    private TextView h6;

    private TextView h7Title;
    private TextView h7Description;
    private TextView h7;

    private TextView h8Title;
    private TextView h8Description;
    private TextView h8;

    private TextView h9Title;
    private TextView h9Description;
    private TextView h9;

    private TextView h10Title;
    private TextView h10Description;
    private TextView h10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);

        documentIndex = getIntent().getIntExtra("documentIndex", 0);

        title = (TextView) findViewById(R.id.title);
        title.setText(getIntent().getStringExtra("title"));

        h1Title = (TextView)findViewById(R.id.h1_title);
        h1Description = (TextView)findViewById(R.id.h1_description);
        h1 = (TextView)findViewById(R.id.h1);
        if (getIntent().getStringExtra("h1") == null || getIntent().getStringExtra("h1").length() == 0){
            h1Title.setVisibility(View.GONE);
            h1Description.setVisibility(View.GONE);
            h1.setVisibility(View.GONE);
        }else {
            h1.setText(getIntent().getStringExtra("h1"));
        }

        h2Title = (TextView)findViewById(R.id.h2_title);
        h2Description = (TextView)findViewById(R.id.h2_description);
        h2 = (TextView)findViewById(R.id.h2);
        if (getIntent().getStringExtra("h2") == null || getIntent().getStringExtra("h2").length() == 0){
            h2Title.setVisibility(View.GONE);
            h2Description.setVisibility(View.GONE);
            h2.setVisibility(View.GONE);
        }else {
            h2.setText(getIntent().getStringExtra("h2"));
        }


        h3Title = (TextView)findViewById(R.id.h3_title);
        h3Description = (TextView)findViewById(R.id.h3_description);
        h3 = (TextView)findViewById(R.id.h3);
        if (getIntent().getStringExtra("h3") == null || getIntent().getStringExtra("h3").length() == 0){
            h3Title.setVisibility(View.GONE);
            h3Description.setVisibility(View.GONE);
            h3.setVisibility(View.GONE);
        }else {
            h3.setText(getIntent().getStringExtra("h3"));
        }

        h4Title = (TextView)findViewById(R.id.h4_title);
        h4Description = (TextView)findViewById(R.id.h4_description);
        h4 = (TextView)findViewById(R.id.h4);
        if (getIntent().getStringExtra("h4") == null || getIntent().getStringExtra("h4").length() == 0){
            h4Title.setVisibility(View.GONE);
            h4Description.setVisibility(View.GONE);
            h4.setVisibility(View.GONE);
        }else {
            h4.setText(getIntent().getStringExtra("h4"));
        }

        h5Title = (TextView)findViewById(R.id.h5_title);
        h5Description = (TextView)findViewById(R.id.h5_description);
        h5 = (TextView)findViewById(R.id.h5);
        if (getIntent().getStringExtra("h5") == null || getIntent().getStringExtra("h5").length() == 0){
            h5Title.setVisibility(View.GONE);
            h5Description.setVisibility(View.GONE);
            h5.setVisibility(View.GONE);
        }else {
            h5.setText(getIntent().getStringExtra("h5"));
        }

        h6Title = (TextView)findViewById(R.id.h6_title);
        h6Description = (TextView)findViewById(R.id.h6_description);
        h6 = (TextView)findViewById(R.id.h6);
        if (getIntent().getStringExtra("h6") == null || getIntent().getStringExtra("h6").length() == 0){
            h6Title.setVisibility(View.GONE);
            h6Description.setVisibility(View.GONE);
            h6.setVisibility(View.GONE);
        }else {
            h6.setText(getIntent().getStringExtra("h6"));
        }

        h7Title = (TextView)findViewById(R.id.h7_title);
        h7Description = (TextView)findViewById(R.id.h7_description);
        h7 = (TextView)findViewById(R.id.h7);
        if (getIntent().getStringExtra("h7") == null || getIntent().getStringExtra("h7").length() == 0){
            h7Title.setVisibility(View.GONE);
            h7Description.setVisibility(View.GONE);
            h7.setVisibility(View.GONE);
        }else {
            h7.setText(getIntent().getStringExtra("h7"));
        }

        h8Title = (TextView)findViewById(R.id.h8_title);
        h8Description = (TextView)findViewById(R.id.h8_description);
        h8 = (TextView)findViewById(R.id.h8);
        if (getIntent().getStringExtra("h8") == null || getIntent().getStringExtra("h8").length() == 0){
            h8Title.setVisibility(View.GONE);
            h8Description.setVisibility(View.GONE);
            h8.setVisibility(View.GONE);
        }else {
            h8.setText(getIntent().getStringExtra("h8"));
        }

        h9Title = (TextView)findViewById(R.id.h9_title);
        h9Description = (TextView)findViewById(R.id.h9_description);
        h9 = (TextView)findViewById(R.id.h9);
        if (getIntent().getStringExtra("h9") == null || getIntent().getStringExtra("h9").length() == 0){
            h9Title.setVisibility(View.GONE);
            h9Description.setVisibility(View.GONE);
            h9.setVisibility(View.GONE);
        }else {
            h9.setText(getIntent().getStringExtra("h9"));
        }

        h10Title = (TextView)findViewById(R.id.h10_title);
        h10Description = (TextView)findViewById(R.id.h10_description);
        h10 = (TextView)findViewById(R.id.h10);
        if (getIntent().getStringExtra("h10") == null || getIntent().getStringExtra("h10").length() == 0){
            h10Title.setVisibility(View.GONE);
            h10Description.setVisibility(View.GONE);
            h10.setVisibility(View.GONE);
        }else {
            h10.setText(getIntent().getStringExtra("h10"));
        }

    }


    public void goToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void showOptions(View view){
        PopupMenu menu = new PopupMenu(this, view);
        menu.setOnMenuItemClickListener(this);
        menu.inflate(R.menu.document_options_menu);
        menu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete:
                SharedPreferences preferences = getSharedPreferences("preference", MODE_PRIVATE);
                Gson gson = new Gson();
                String loadJson = preferences.getString("document_array", null);
                Type type = new TypeToken<ArrayList<Document>>() {}.getType();
                documents = gson.fromJson(loadJson, type);
                /*if (documents == null){
                    documents = new ArrayList<Document>();
                }*/
                documents.remove(documentIndex);
                SharedPreferences.Editor editor = preferences.edit();
                String saveJson = gson.toJson(documents);
                editor.putString("document_array", saveJson);
                editor.apply();

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }
}