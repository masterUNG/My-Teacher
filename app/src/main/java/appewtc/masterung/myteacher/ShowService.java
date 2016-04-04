package appewtc.masterung.myteacher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ShowService extends AppCompatActivity {

    //Explicit
    private TextView nameTextView, idTeacherTextView, positionTextView;
    private ImageView teacheerImageView, hub1ImageView, hub2ImageView, hub3ImageView;
    private String[] myResultStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_service);

        //Bind Widget
        bindWidget();

        //Receive Value From Intent
        myResultStrings = getIntent().getStringArrayExtra("Result");

        //Show View
        showView();

        //Check Status
        checkStatus();



    }   // Main Method

    public void clickGetLocation(View view) {
        startActivity(new Intent(ShowService.this, GetLocation.class));
    }


    private void checkStatus() {

        try {
            int intStatus = Integer.parseInt(myResultStrings[6]);

            if (intStatus == 1) {
                hub3ImageView.setVisibility(View.INVISIBLE);
            }


        } catch (Exception e) {
            int intStatus = 0;
        }

    }   // checkStatus

    private void showView() {

        //Show TextView
        nameTextView.setText(myResultStrings[3]);
        idTeacherTextView.setText("รหัสครู : " + myResultStrings[4]);
        positionTextView.setText("ตำแหน่ง : " + findPosition(myResultStrings[6]));

        //Show Image
        Picasso.with(this)
                .load(myResultStrings[5])
                .resize(150, 150).into(teacheerImageView);


    }   // showView

    private String findPosition(String myResultString) {

        String strPosition = null;
        int intResult = Integer.parseInt(myResultString);
        switch (intResult) {
            case 0:
                strPosition = "ครูที่ปรึกษา";
                break;
            case 1:
                strPosition = "ครูผู้สอน";
                break;
            default:
                strPosition = "ไม่รู้";
                break;
        }


        return strPosition;
    }

    private void bindWidget() {
        nameTextView = (TextView) findViewById(R.id.textView2);
        idTeacherTextView = (TextView) findViewById(R.id.textView3);
        positionTextView = (TextView) findViewById(R.id.textView4);
        teacheerImageView = (ImageView) findViewById(R.id.imageView2);
        hub1ImageView = (ImageView) findViewById(R.id.imageView3);
        hub2ImageView = (ImageView) findViewById(R.id.imageView4);
        hub3ImageView = (ImageView) findViewById(R.id.imageView5);
    }

}   // Main Class
