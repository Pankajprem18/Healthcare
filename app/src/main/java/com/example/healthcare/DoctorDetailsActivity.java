package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] doctor_details1 =

            {
                    {"Doctor Name: Ankita Saste", "Hospital Address: Pimpri", "Exp : 5yrs", "Mobile No:98456*****", "600"},
                    {"Doctor Name: Prasad Pawar", "Hospital Address: Maharashratra", "Exp : 15yrs", "Mobile No:95456*****", "980"},
                    {"Doctor Name: Seema ❤️", "Hospital Address: Hazaribag", "Exp : 4yrs", "Mobile No:62036*****", "800"},
                    {"Doctor Name: Aman Raj Rana", "Hospital Address: Koderma", "Exp : 12yrs", "Mobile No:84345*****", "720"},
                    {"Doctor Name: Pankaj Prem", "Hospital Address: Giridih", "Exp : 8yrs", "Mobile No:7254071503", "940"}
            };
    private String[][] doctor_details2 =

            {
                    {"Doctor Name: Raman Yadav", "Hospital Address: Panjab", "Exp : 4yrs", "Mobile No:56456*****", "700"},
                    {"Doctor Name: Pawan Pawak", "Hospital Address: Delhi", "Exp : 3yrs", "Mobile No:78856*****", "680"},
                    {"Doctor Name: Meena Koyal", "Hospital Address: Rajdhanwar", "Exp : 3.5yrs", "Mobile No:91358*****", "650"},
                    {"Doctor Name: Rahul Mandal", "Hospital Address: Ranchi", "Exp : 2yrs", "Mobile No:84560*****", "230"},
                    {"Doctor Name: Shriyansh Suman", "Hospital Address: Deoghar", "Exp : 6yrs", "Mobile No:7456*****", "440"}
            };
    private String[][] doctor_details3 =

            {
                    {"Doctor Name: Ankita singade", "Hospital Address: Andheei", "Exp : 5.5yrs", "Mobile No:78456*****", "1000"},
                    {"Doctor Name: Prasad Pawar", "Hospital Address: Maharashratra", "Exp : 15yrs", "Mobile No:95456*****", "989"},
                    {"Doctor Name: Milan Mahto", "Hospital Address: Ramgrah", "Exp : 8yrs", "Mobile No:85745*****", "850"},
                    {"Doctor Name: Rahul Muskan", "Hospital Address: Koderma", "Exp : 2yrs", "Mobile No:84456*****", "700"},
                    {"Doctor Name: Harsh Rajput", "Hospital Address: Goa", "Exp : 6yrs", "Mobile No:87455*****", "870"}
            };
    private String[][] doctor_details4 =

            {
                    {"Doctor Name: See** ❤️ Pr**", "Hospital Address: Mumbai", "Exp : 25yrs", "Mobile No:6203671503", "1200"},
                    {"Doctor Name: Sagar singad", "Hospital Address: Bhopoal", "Exp : 10yrs", "Mobile No:745126*****", "990"},
                    {"Doctor Name: Shushil", "Hospital Address: Ranchi", "Exp : 18yrs", "Mobile No:62048*****", "200"},
                    {"Doctor Name: Shweta Rani", "Hospital Address: Jamshedpur", "Exp : 9yrs", "Mobile No:84425*****", "420"},
                    {"Doctor Name: Vivek Raj", "Hospital Address: Barkagaon", "Exp : 1yrs", "Mobile No:72780*****", "940"}
            };
    private String[][] doctor_details5 =

            {
                    {"Doctor Name: Manisha Singade", "Hospital Address: Mumbai", "Exp : 7.5yrs", "Mobile No:62456*****", "250"},
                    {"Doctor Name: Shivam Dube", "Hospital Address: Kolkata", "Exp : 5yrs", "Mobile No:95126*****", "453"},
                    {"Doctor Name: Sourabh Ganguli", "Hospital Address: Rajdhanwar", "Exp : 4.5yrs", "Mobile No:83036*****", "490"},
                    {"Doctor Name: Kumari Us** Rani", "Hospital Address: Uttar Pradesh", "Exp : 3yrs", "Mobile No:82185*****", "720"},
                    {"Doctor Name: Praveen Mandal", "Hospital Address: Karihari", "Exp : 5yrs", "Mobile No:624580****", "840"}
            };
    TextView tv;
    Button btn;

    String[][] doctor_details = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Dietcian") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
//            if(title.compareTo("Cardiologists")==0)
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons Fees:" + doctor_details[i][4] + "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);

            }
        });
    }
}

