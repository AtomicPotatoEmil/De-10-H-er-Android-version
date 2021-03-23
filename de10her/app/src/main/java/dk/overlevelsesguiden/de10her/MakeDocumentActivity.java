package dk.overlevelsesguiden.de10her;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MakeDocumentActivity extends AppCompatActivity {

    private ArrayList<Document> documents;

    private EditText titleEdit;
    private EditText h1Edit;
    private EditText h2Edit;
    private EditText h3Edit;
    private EditText h4Edit;
    private EditText h5Edit;
    private EditText H6Edit;
    private EditText H7Edit;
    private EditText H8Edit;
    private EditText H9Edit;
    private EditText H10Edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_document);

    }

    public void saveDocument(View view){
        Document doc = new Document();

        titleEdit = (EditText)findViewById(R.id.document_id);
        doc.setTitle(titleEdit.getText().toString());

        Calendar date = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
        String dateString = dateFormat.format(date.getTime());
        doc.setDate(dateString);

        Calendar time = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String timeString = timeFormat.format(time.getTime());
        doc.setTime(timeString);


        Gson gson = new Gson();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("document", gson.toJson(doc));
        startActivity(intent);

    }

    public void goToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}