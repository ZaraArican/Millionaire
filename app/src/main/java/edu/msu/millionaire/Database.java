package edu.msu.millionaire;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class Database extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
    }//datatbase of flags, that are in res drawable
    Integer[] flags={
R.drawable.brazil,
            R.drawable.canada,
            R.drawable.egypt,
            R.drawable.germany,
            R.drawable.greece,
            R.drawable.iran,
            R.drawable.israel,
            R.drawable.mexico,
            R.drawable.southkorea,
            R.drawable.turkey
    };
//are the answers to each flag name
    String[] answers={
"brazil",
            "canada",
            "egypt",
            "germany",
            "greece",
            "iran",
            "israel",
            "mexico",
            "southkorea",
            "turkey",

    };
}
