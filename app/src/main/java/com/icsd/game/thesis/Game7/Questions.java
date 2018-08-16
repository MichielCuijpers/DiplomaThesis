package com.icsd.game.thesis.Game7;

<<<<<<< HEAD
import android.util.Log;
=======
import com.icsd.game.thesis.R;
import com.icsd.game.thesis.commons.AppLan;
>>>>>>> a7a73f20e5b505c573c7415e0d50998ea902f6a9

import java.util.ArrayList;

public class Questions {
    private String question;
    private ArrayList<String> questions_kitchen;
    private ArrayList<String> questions_bathroom;
    private ArrayList<String> questions_dinroom;
    private String correct_answer;
    public Questions(){
        questions_kitchen = new ArrayList<String> ();
        questions_bathroom = new ArrayList<String> ();
        questions_dinroom = new ArrayList<String> ();
    }
    public Questions(String question,String correct_answer){
        this.question = question;
        this.correct_answer = correct_answer;
    }
    public void set_Questions(){
        questions_kitchen.add(AppLan.getAppContext().getResources().getString(R.string.ice));
        questions_kitchen.add(AppLan.getAppContext().getResources().getString(R.string.bread));
        questions_kitchen.add(AppLan.getAppContext().getResources().getString(R.string.kitchen_lights));
        questions_kitchen.add(AppLan.getAppContext().getResources().getString(R.string.bottle));
        questions_kitchen.add(AppLan.getAppContext().getResources().getString(R.string.cook));
        questions_kitchen.add(AppLan.getAppContext().getResources().getString(R.string.smoke));
        questions_bathroom.add(AppLan.getAppContext().getResources().getString(R.string.take_bath));
        questions_bathroom.add(AppLan.getAppContext().getResources().getString(R.string.hair));
        questions_bathroom.add(AppLan.getAppContext().getResources().getString(R.string.soap));
        questions_bathroom.add(AppLan.getAppContext().getResources().getString(R.string.bathroom_lights));
        questions_bathroom.add(AppLan.getAppContext().getResources().getString(R.string.wash));
        questions_dinroom.add(AppLan.getAppContext().getResources().getString(R.string.sit));
        questions_dinroom.add(AppLan.getAppContext().getResources().getString(R.string.din_lights));
        questions_dinroom.add(AppLan.getAppContext().getResources().getString(R.string.tv_din));
        questions_dinroom.add(AppLan.getAppContext().getResources().getString(R.string.music));
    }
    public String return_Questions(String type){
        if(type.equals("kitchen")){
            for(int i=0;i<questions_kitchen.size();i++){
                question = questions_kitchen.get(i);
            }
        }else if(type.equals("bathroom")){
            for(int i=0;i<questions_bathroom.size();i++){
                question = questions_bathroom.get(i);
            }
        }else if(type.equals("din")){
            for(int i=0;i<questions_dinroom.size();i++){
                question = questions_dinroom.get(i);
            }
        }
        else{
            question = "Questions Cache is out of bounds";
        }

        return question;
    }
    public String getCorrectAnswer(){
        return correct_answer;
    }
    public ArrayList <String> get_kitchen(){
        return questions_kitchen;
    }
    public ArrayList <String> get_bathroom(){
        return questions_bathroom;
    }
    public ArrayList <String> get_dinroom(){
        return questions_dinroom;
    }
    public boolean check_empty_list(ArrayList<String>questions){
        Boolean val;
        if(questions.isEmpty()){
           val=true;
        }else{
            val=false;
        }
        return val;
    }
    public String set_Correct_Answer(String question){
        if(question.equals("Can you store the ice somewhere?")){
            correct_answer = "fridge";
        }else if(question.equals("Please! bake some bread for breakfast")){
            correct_answer = "sands";
        }else if(question.equals("It is 08:00 AM! Turn on the lights please")){
            correct_answer = "lamp";
        }else if(question.equals("This water bottle is empty, please! refill it")){
            correct_answer = "wash";
        }else if(question.equals("I am hungry,cook something please")){
            correct_answer = "cook";
        }else if(question.equals("Can you get rid of the cigarette smoke?")){
            correct_answer = "smoke_cook";
        }else if(question.equals("You stink!Take a bath please")){
            correct_answer = "bubble";
        }else if(question.equals("Your hair do not look so good, take a look")){
            correct_answer = "mirror";
        }else if(question.equals("Give me a new soap please")){
            correct_answer = "soap";
        }else if(question.equals("Too dark in the bathroom, please do something")){
            correct_answer = "lamp_bath";
        }else if(question.equals("Wash your hands after cleaning in there")){
            correct_answer = "hands";
        }else if(question.equals("You must be tired,Please!Have a sit")){
            correct_answer = "sofa";
        }else if(question.equals("It is too dark in here, react please")){
            correct_answer = "din_lamp";
        }else if(question.equals("Can you switch it on the BBC?")){
            correct_answer = "TV";
        }else if(question.equals("I would like to listen to music!")){
            correct_answer = "sound";
        }
        //ellinika
        else if(question.equals("Μπορείς να αποθηκεύσεις κάπου τον πάγο;")){
            correct_answer = "sands";
        }
        else if(question.equals("Σε παρακαλώ! Φτιάξε λίγο ψωμί")){
            correct_answer = "sands";
        }else if(question.equals("Είναι 08:00 το βράδυ!Άναψε τα φώτα παρακαλώ")){
            correct_answer = "lamp";
        }else if(question.equals("Το μπουκάλι είναι άδειο,Παρακαλώ! Γεμισέ το")){
            correct_answer = "wash";
        }else if(question.equals("Πεινάω αρκετά!Μαγείρεψε κάτι αν μπορείς")){
            correct_answer = "cook";
        }else if(question.equals("Μπορείς να ξεφορτωθείς τον καπνό του τσιγάρου;")){
            correct_answer = "smoke_cook";
        }else if(question.equals("Μάλλον μυρίζεις!Κάνε ένα μπανάκι")){
            correct_answer = "bubble";
        }else if(question.equals("Τα μαλλιά σου δεν είναι πολύ καλά.Ρίξε μια ματιά")){
            correct_answer = "mirror";
        }else if(question.equals("Δώσε μου ένα καινούργιο αφρόλουτρο σε παρακαλώ")){
            correct_answer = "soap";
        }else if(question.equals("Είναι πολύ σκοτεινά, Ανάβεις το φως;")){
            correct_answer = "lamp_bath";
        }else if(question.equals("Πλύνε τα χέρια σου μετά το καθάρισμα εκεί μέσα")){
            correct_answer = "hands";
        }else if(question.equals("Δείχνεις κουρασμένος, Γιατί δεν κάθεσαι;")){
            correct_answer = "sofa";
        }else if(question.equals("Είναι πολύ σκοτεινά,κάνε κάτι")){
            correct_answer = "din_lamp";
        }else if(question.equals("Μπορείς να βάλεις το κανάλι στο BBC;")){
            correct_answer = "TV";
        }else if(question.equals("Θα ήθελα να ακούσω λίγο μουσική")){
            correct_answer = "sound";
        }
        return correct_answer;
    }
    public void delete_Question_used(String type,String question){
        if(type.equals("kitchen")){
            questions_kitchen.remove(question);
        }
        else if(type.equals("bathroom")){
            questions_bathroom.remove(question);
        }
        else if(type.equals("din")){
            questions_dinroom.remove(question);
        }
    }
}
