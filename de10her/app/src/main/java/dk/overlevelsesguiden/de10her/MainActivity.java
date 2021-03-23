package dk.overlevelsesguiden.de10her;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Document> documents;
    private LinearLayout savedDocumentsContainer;
    private View savedDocumentsView;

    /*
    View v;
    int[] someList;
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences loadPreferences = getSharedPreferences("preference", MODE_PRIVATE);
        Gson loadGson = new Gson();
        String loadJson = loadPreferences.getString("document_array", null);
        Type type = new TypeToken<ArrayList<Document>>() {}.getType();
        documents = loadGson.fromJson(loadJson, type);
        if (documents == null){
            documents = new ArrayList<Document>();
        }






        if (getIntent().getStringExtra("document")!= null){
            Gson gson = new Gson();
            documents.add(gson.fromJson(getIntent().getStringExtra("document"), Document.class));
            SharedPreferences savePreferences = getSharedPreferences("preference", MODE_PRIVATE);
            SharedPreferences.Editor editor = savePreferences.edit();
            Gson saveGson = new Gson();
            String saveJson = saveGson.toJson(documents);
            editor.putString("document_array",saveJson);
            editor.apply();
        }


        savedDocumentsContainer = (LinearLayout)findViewById(R.id.document_button_container);

        for (Document document : documents){
            savedDocumentsView = getLayoutInflater().inflate(R.layout.saved_documents_view, null, false);

            TextView titleView = (TextView) savedDocumentsView.findViewById(R.id.document_title);
            titleView.setText(document.getTitle());

            TextView dateView = (TextView) savedDocumentsView.findViewById(R.id.document_date);
            dateView.setText(document.getDate());

            TextView timeView = (TextView) savedDocumentsView.findViewById(R.id.document_time);
            timeView.setText(document.getTime());


            savedDocumentsContainer.addView(savedDocumentsView);
        }
        /*
        someList = new int[]{1, 2, 3, 4, 5};

        for (int number : someList) {

            v = getLayoutInflater().inflate(R.layout.saved_documents_view, null, false);
            TextView placeholderView = (TextView) v.findViewById(R.id.placeholder);
            placeholderView.setText("no longer placeholder");
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"index is: "+number, Toast.LENGTH_SHORT).show();

                }
            });
            savedDocumentsContainer.addView(v);
        }

         */
    }

    public void goToInfoActivity(View view){
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    public void goToMakeDocumentActivity(View view){
        Intent intent = new Intent(this, MakeDocumentActivity.class);
        startActivity(intent);
    }
}