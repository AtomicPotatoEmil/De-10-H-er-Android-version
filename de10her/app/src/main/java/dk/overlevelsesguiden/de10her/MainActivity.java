package dk.overlevelsesguiden.de10her;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout savedDocumentsContainer;

    /*
    View v;
    int[] someList;
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        savedDocumentsContainer = (LinearLayout)findViewById(R.id.document_button_container);
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