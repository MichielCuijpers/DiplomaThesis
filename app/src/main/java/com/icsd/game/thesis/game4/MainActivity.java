package com.icsd.game.thesis.game4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.icsd.game.thesis.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
        private ArrayList<Button> letters;
        private Button s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        letters = new ArrayList<Button>();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.game4protype);
        s = (Button) findViewById(R.id.button24);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newf = s.getText().toString();

            }
        });
        ArrayList<String> phrases = new ArrayList<String>();
        ArrayList<String> similars = new ArrayList<String>();

        phrases.add("ΕΝΑ ΚΟΚΚΙΝΟ ΜΗΛΟ");
        phrases.add("ΔΙΑΝΝΟΙΑ");
        phrases.add("ΣΗΜΕΡΑ ΘΑ ΒΡΕΞΕΙ");
        phrases.add("ΑΥΡΙΟ ΔΕΝ ΘΑ ΒΡΕΞΕΙ");
        phrases.add("ΕΧΕΙ ΣΥΝΝΕΦΙΑ");
        phrases.add("Η ΘΑΛΑΣΣΑ ΕΙΝΑΙ ΗΡΕΜΗ");
        phrases.add("ΤΟ ΚΡΑΣΙ ΕΙΝΑΙ ΓΕΥΣΤΙΚΟ");
        phrases.add("ΟΜΟΡΦΟΣ ΣΚΥΛΟΣ");
        phrases.add("ΣΚΟΥΛΗΚΟΤΡΥΠΑ");
        phrases.add("ΕΝΑΣ ΑΛΕΞΙΠΤΩΤΙΣΤΗΣ");
        phrases.add("ΚΟΙΤΑ ΕΝΑ ΑΛΕΞΙΣΦΑΙΡΟ");
        phrases.add("ΜΠΡΟΥΤΖΙΝΟ ΑΓΑΛΜΑ");
        phrases.add("ΚΑΥΤΕΡΗ ΠΙΠΕΡΙΑ");
        phrases.add("ΦΑΣΟΛΑΔΑ ΤΡΟΜΕΡΗ");
        phrases.add("ΑΡΑΧΤΟΣ ΕΛΕΦΑΝΤΑΣ");
        phrases.add("ΜΙΑ ΚΙΤΡΙΝΗ ΜΠΕΚΑΤΣΑ");
        phrases.add("Ο ΡΟΦΟΣ ΕΣΚΑΣΕ");
        phrases.add("ΜΙΑ ΤΡΥΠΑ ΣΤΟ ΝΕΡΟ");

        similars.add("Η ΜΗΛΟΠΙΤΑ ΒΡΩΜΑΕΙ");
        similars.add("ΝΟΗΜΟΣΥΝΗ");
        similars.add("ΣΗΜΕΡΑ ΘΑ ΕΧΕΙ ΗΛΙΟ");
        similars.add("ΣΗΜΕΡΑ ΘΑ ΕΧΕΙ ΒΡΟΧΟΠΤΩΣΗ");
        similars.add("ΑΥΡΙΟ ΕΙΝΑΙ ΠΡΩΤΟΜΑΓΙΑ");
        similars.add("ΑΡΡΑΙΗ ΣΥΝΝΕΦΙΑ");
        similars.add("ΣΥΝΝΕΦΙΑΣΜΕΝΗ ΜΕΡΑ");
        similars.add("ΚΡΑΣΟΚΑΝΑΤΑ");
        similars.add("ΚΡΑΣΟΠΗΓΗ");
        similars.add("ΕΧΩ ΕΝΑ ΚΡΑΣΙ");
        similars.add("ΑΛΕΞΙΣΦΑΙΡΟ ΓΙΛΕΚΟ");
        similars.add("ΚΟΙΤΑ ΕΝΑ ΑΛΕΞΙΠΤΩΤΙΣΤΗ");
        similars.add("ΒΡΩΜΕΡΗ ΦΑΣΟΛΑΔΑ");
        similars.add("Ο ΦΟΡΟΣ ΕΠΕΣΕ");
        similars.add("ΤΡΥΠΟΥΛΑ ΤΟΥ ΝΕΡΟΥ");
        similars.add("ΜΑΛΑΓΑΝΑΣ ΜΠΡΑΤΣΑΡΑΣ");
        similars.add("ΠΗΓΑ ΣΤΗ ΜΗΛΟΚΟΠΗ");
        similars.add("ΚΛΕΙΣΤΟ ΠΕΡΙΠΤΕΡΟ");

        Occurs c = new Occurs();
        try {
            String tobeshuffled = c.PickPhrases(phrases);
            Character[] something = c.shuffleCharArray(tobeshuffled);
           /* for(int i = 0; i<something.length;i++)
            {
                String m = Character.toString(something[i]);
                //JButton nb = new JButton(m = Character.toString(something[i]));
                Button nb = findViewById(R.id.gramma);
                nb.setVisibility(View.INVISIBLE);
                nb.setText(m);
                letters.add(nb);


            }*/
           //Kwsta ama to deis  edw exo thema sto na valw ta koumpia sto view.. oi methodoi douleuoun. apla prospathw na to kanw dinamikA
            System.out.println("I swsti leksi : " + tobeshuffled);
            StringBuilder anakatemeni = new StringBuilder();
            for(int i = 0;i<something.length;i++)
            {
                anakatemeni.append(Character.toString(something[i]));
            }
            System.out.println("I anakatemeni : " + anakatemeni);

        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

    }

}
