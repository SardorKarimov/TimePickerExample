package rohit.com.timepickerexample;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity /*implements TimePickerDialog.OnTimeSetListener */{
EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.gettime);
        final Calendar now2=Calendar.getInstance();
        et1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now= Calendar.getInstance();
                TimePickerDialog dialog=TimePickerDialog.newInstance(new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {
                        String AM_PM;
                        int hour = 0;
                        if(hourOfDay>12)
                        {
                            hour=hourOfDay-12;
                            AM_PM="PM";
                        }
                        else if(hourOfDay==0)
                        {
                            hour=12;
                            AM_PM="AM";
                        }
                        else if(hourOfDay==12)
                        {
                            hour=12;
                            AM_PM="PM";

                        }
                        else {
                            hour=hourOfDay;
                            AM_PM="AM";
                        }

                        String hourString = hour < 10 ? "0"+hour : ""+hour;
                        String minuteString = minute < 10 ? "0"+minute : ""+minute;
                        String time = hourString+":"+minuteString+"\t"+AM_PM;
                        et1.setText(time);

                    }
                }, now.get(Calendar.HOUR_OF_DAY), now.get(Calendar.MINUTE), false);

                dialog.setMinTime(now2.get(Calendar.HOUR_OF_DAY),now2.get(Calendar.MINUTE),now2.get(Calendar.SECOND));
                dialog.show(getFragmentManager(), "TimePickerDialog");
                dialog.setTitle("Select Time");
                dialog.setAccentColor(Color.parseColor("#9C27B0"));
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        dialog.dismiss();
                    }
                });
            }


        });

    }

   /* @Override
    protected void onResume() {
        super.onResume();
        TimePickerDialog dialog = (TimePickerDialog) getFragmentManager().findFragmentByTag("TimePickerDialog");
        if(dialog!=null)
        {
            dialog.setOnTimeSetListener(this);
        }

    }*/

    /*@Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {


        Toast.makeText(MainActivity.this,String.valueOf(hourOfDay),Toast.LENGTH_LONG).show();
        String AM_PM;
        int hour = 0;
     if(hourOfDay>12)
     {
         hour=hourOfDay-12;
         AM_PM="PM";
     }
     else if(hourOfDay==0)
     {
         hour=12;
         AM_PM="AM";
     }
     else if(hourOfDay==12)
     {
         hour=12;
         AM_PM="PM";

     }
      else {
         hour=hourOfDay;
         AM_PM="AM";
     }

        String hourString = hour < 10 ? "0"+hour : ""+hour;
        String minuteString = minute < 10 ? "0"+minute : ""+minute;
        String time = hourString+":"+minuteString+"\t"+AM_PM;
        et1.setText(time);

    }*/
}
