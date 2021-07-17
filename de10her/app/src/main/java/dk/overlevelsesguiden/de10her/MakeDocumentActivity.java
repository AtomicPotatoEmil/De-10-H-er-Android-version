package dk.overlevelsesguiden.de10her;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
    private EditText h6Edit;
    private EditText h7Edit;
    private EditText h8Edit;
    private EditText h9Edit;
    private EditText h10Edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_document);

        titleEdit = (EditText) findViewById(R.id.document_id);

        h1Edit = (EditText) findViewById(R.id.h1_text);
        h2Edit = (EditText) findViewById(R.id.h2_text);
        h3Edit = (EditText) findViewById(R.id.h3_text);
        h4Edit = (EditText) findViewById(R.id.h4_text);
        h5Edit = (EditText) findViewById(R.id.h5_text);
        h6Edit = (EditText) findViewById(R.id.h6_text);
        h7Edit = (EditText) findViewById(R.id.h7_text);
        h8Edit = (EditText) findViewById(R.id.h8_text);
        h9Edit = (EditText) findViewById(R.id.h9_text);
        h10Edit = (EditText) findViewById(R.id.h10_text);
    }

    public void saveDocument(View view){
        if (titleEdit.getText().toString().length() != 0) {
            String [] hAnswers = {h1Edit.getText().toString(), h2Edit.getText().toString(), h3Edit.getText().toString(),
                                h4Edit.getText().toString(), h5Edit.getText().toString(), h6Edit.getText().toString(),
                                h7Edit.getText().toString(), h8Edit.getText().toString(), h9Edit.getText().toString(),
                                h10Edit.getText().toString()};
            for (String answer : hAnswers){
                if (answer.length() != 0){
                    Document doc = new Document();

                    doc.setTitle(titleEdit.getText().toString());

                    doc.setH1(h1Edit.getText().toString());
                    doc.setH2(h2Edit.getText().toString());
                    doc.setH3(h3Edit.getText().toString());
                    doc.setH4(h4Edit.getText().toString());
                    doc.setH5(h5Edit.getText().toString());
                    doc.setH6(h6Edit.getText().toString());
                    doc.setH7(h7Edit.getText().toString());
                    doc.setH8(h8Edit.getText().toString());
                    doc.setH9(h9Edit.getText().toString());
                    doc.setH10(h10Edit.getText().toString());

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
            }

        }

    }

    public void goToMainActivity(View view){
        Toast.makeText(this, titleEdit.getText().toString().length(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}