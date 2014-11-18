package nl.npipf.tgh.time2learn;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.MessageFormat;
import java.util.Random;


public class Game extends Activity {

    TimeObject currentTime;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        refreshScreen();
        Spinner spinner = (Spinner) findViewById(R.id.spinnerRepString);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.time_repstring, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinnerNumber);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.time_numbers, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        Button butCheck = (Button) findViewById(R.id.butCheckAnswer);
        butCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickHandler();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public TimeObject randomTime(){
        int timeNumber = random.nextInt(48);
        TimeObject result = new TimeObject(0,0,"full0");
        //Don't mind this inefficient code, will be reworked as in Game5min.java
        switch (timeNumber){
            case 0:
                result = new TimeObject(0,0, "full0");
                break;
            case 1:
                result = new TimeObject(0, 15, "qtp0");
                break;
            case 2:
                result = new TimeObject(0, 30, "half1");
                break;
            case 3:
                result = new TimeObject(0, 45, "qtt1");
                break;
            case 4:
                result = new TimeObject(1, 0, "full1");
                break;
            case 5:
                result = new TimeObject(1, 15, "qtp1");
                break;
            case 6:
                result = new TimeObject(1, 30, "half2");
                break;
            case 7:
                result = new TimeObject(1, 45, "qtt2");
                break;
            case 8:
                result = new TimeObject(2, 0, "full2");
                break;
            case 9:
                result = new TimeObject(2, 15, "qtp2");
                break;
            case 10:
                result = new TimeObject(2, 30, "half3");
                break;
            case 11:
                result = new TimeObject(2, 45, "qtt3");
                break;
            case 12:
                result = new TimeObject(3, 0, "full3");
                break;
            case 13:
                result = new TimeObject(3, 15, "qtp3");
                break;
            case 14:
                result = new TimeObject(3, 30, "half4");
                break;
            case 15:
                result = new TimeObject(3, 45, "qtt4");
                break;
            case 16:
                result = new TimeObject(4, 0, "full4");
                break;
            case 17:
                result = new TimeObject(4, 15, "qtp4");
                break;
            case 18:
                result = new TimeObject(4, 30, "half5");
                break;
            case 19:
                result = new TimeObject(4, 45, "qtt5");
                break;
            case 20:
                result = new TimeObject(5, 0, "full5");
                break;
            case 21:
                result = new TimeObject(5, 15, "qtp5");
                break;
            case 22:
                result = new TimeObject(5, 30, "half6");
                break;
            case 23:
                result = new TimeObject(5, 45, "qtt6");
                break;
            case 24:
                result = new TimeObject(6, 0, "full6");
                break;
            case 25:
                result = new TimeObject(6, 15, "qtp6");
                break;
            case 26:
                result = new TimeObject(6, 30, "half7");
                break;
            case 27:
                result = new TimeObject(6, 45, "qtt7");
                break;
            case 28:
                result = new TimeObject(7, 0, "full7");
                break;
            case 29:
                result = new TimeObject(7, 15, "qtp7");
                break;
            case 30:
                result = new TimeObject(7, 30, "half8");
                break;
            case 31:
                result = new TimeObject(7, 45, "qtt8");
                break;
            case 32:
                result = new TimeObject(8, 0, "full8");
                break;
            case 33:
                result = new TimeObject(8, 15, "qtp8");
                break;
            case 34:
                result = new TimeObject(8, 30, "half9");
                break;
            case 35:
                result = new TimeObject(8, 45, "qtt9");
                break;
            case 36:
                result = new TimeObject(9, 0, "full9");
                break;
            case 37:
                result = new TimeObject(9, 15, "qtp9");
                break;
            case 38:
                result = new TimeObject(9, 30, "half10");
                break;
            case 39:
                result = new TimeObject(9, 45, "qtt10");
                break;
            case 40:
                result = new TimeObject(10, 0, "full10");
                break;
            case 41:
                result = new TimeObject(10, 15, "qtp10");
                break;
            case 42:
                result = new TimeObject(10, 30, "half11");
                break;
            case 43:
                result = new TimeObject(10, 45, "qtt11");
                break;
            case 44:
                result = new TimeObject(11, 0, "full11");
                break;
            case 45:
                result = new TimeObject(11, 15, "qtp11");
                break;
            case 46:
                result = new TimeObject(11, 30, "half12");
                break;
            case 47:
                result = new TimeObject(11, 45, "qtt12");
                break;
        }
        return result;
    }

    public void drawClock(){
        MyAnalogClock clock = (MyAnalogClock) findViewById(R.id.clockGame);
        currentTime = randomTime();
        Log.d("GameTAG:", MessageFormat.format("Hours: {0} Minutes: {1} String: {2}", currentTime.hours, currentTime.minutes, currentTime.stringRep));
        clock.setTime(currentTime.hours, currentTime.minutes, 0);
        clock.invalidate();
    }

    public void refreshScreen(){
        TextView txtScore = (TextView) findViewById(R.id.textCurScore);
        SharedPreferences prefs = getSharedPreferences("time_scores", 0);
        String score = prefs.getString("current_score", "0");
        txtScore.setText(this.getString(R.string.current_score) + " " + score);
        drawClock();
    }

    public void clickHandler(){
        Spinner spinNumber = (Spinner) findViewById(R.id.spinnerNumber);
        Spinner spinRep = (Spinner) findViewById(R.id.spinnerRepString);

        String hours = spinNumber.getSelectedItem().toString();
        String rep = spinRep.getSelectedItem().toString();
        String[] reps = getResources().getStringArray(R.array.time_repstring);
        String stringrep;
        String correctAnswer;
        if(rep.equals(reps[0]))
            stringrep = "full";
        else if(rep.equals(reps[1]))
            stringrep = "qtp";
        else if(rep.equals(reps[2]))
            stringrep = "half";
        else
            stringrep = "qtt";

        String answer = stringrep + hours;
        SharedPreferences prefs = getSharedPreferences("time_scores", 0);
        if(answer.equals(currentTime.stringRep)){
            Toast.makeText(getApplicationContext(), this.getString(R.string.gratz) , Toast.LENGTH_LONG).show();
            int score = Integer.parseInt(prefs.getString("current_score", "0")) + 1;
            prefs.edit().putString("current_score", Integer.toString(score)).apply();
            refreshScreen();
        } else{
            if(currentTime.stringRep.contains("full"))
                correctAnswer = reps[0] + " " + currentTime.hours;
            else if(currentTime.stringRep.contains("qtp"))
                correctAnswer = reps[1] + " " + currentTime.hours;
            else if(currentTime.stringRep.contains("half"))
                correctAnswer = reps[2] + " " + (currentTime.hours + 1);
            else
                correctAnswer = reps[3] + " " + (currentTime.hours + 1);


            Toast.makeText(getApplicationContext(), this.getString(R.string.lost) , Toast.LENGTH_LONG).show();
            int score = Integer.parseInt(prefs.getString("current_score", "0"));
            int highscore = Integer.parseInt(prefs.getString("highscore", "0"));
            prefs.edit().putString("current_score", "0").apply();
            if(score > highscore)
                prefs.edit().putString("highscore", Integer.toString(score)).apply();
            Intent intent = new Intent(getApplicationContext(), EndScreen.class);
            intent.putExtra("correct_answer", correctAnswer);
            refreshScreen();
            startActivity(intent);
        }
    }
}
