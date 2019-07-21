package com.nanoboost.nanopay;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RequestForReplacement extends AppCompatActivity {

    TextView name;
    TextView orderno;
    TextView price;
    TextView dateofpurchase;
    TextView warranty;
    private Button proceed;
    private Spinner spinner1;
    private static final String[] reason = {"Defective Item", "Item Miscount", "Wrong Item"};
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_for_replacement);
        name = (TextView)findViewById(R.id.itemname);
        orderno = (TextView)findViewById(R.id.ordernumber);
        price = (TextView)findViewById(R.id.price);
        dateofpurchase = (TextView)findViewById(R.id.dateofpurchase);
        warranty = (TextView)findViewById(R.id.warrantyperiod);
        proceed = (Button)findViewById(R.id.btnProceed);
        viewBackpack();
        spinner1 = (Spinner)findViewById(R.id.reasonforreplace);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RequestForReplacement.this,
                android.R.layout.simple_spinner_item,reason);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        //requestForReplacement();

    }


    public void viewBackpack () {
        Cursor res = myDb.getData();
        if(res.getColumnCount() == 0) {
            //show message;
            return;
        }

        while(res.moveToNext()) {
            name.setText(res.getString(1));
            orderno.setText(res.getString(0));
            price.setText(res.getString(5));
            dateofpurchase.setText(res.getString(2));
            warranty.setText(res.getString(3));

        }
    }

 /*   public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }*/

}
