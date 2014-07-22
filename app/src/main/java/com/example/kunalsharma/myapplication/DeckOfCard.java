package com.example.kunalsharma.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.example.kunalsharma.myapplication.adapter.GridAdapter;

import java.util.ArrayList;
import java.util.Collections;


public class DeckOfCard extends Activity {

    private GridView gridView;
    private EditText etSearch;
    private TextView tvspades;
    int firstTime = 0;

    private ArrayList<String> mlistCards;
    private GridAdapter  gridAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mlistCards = new ArrayList<String>();
        gridView = (GridView)findViewById(R.id.grid);
        etSearch = (EditText)findViewById(R.id.et_search);
        tvspades = (TextView)findViewById(R.id.tv_hearts);

        for (int i = 0;i<Cards.CardNumber.length;i++){
            mlistCards.add(Cards.CardNumber[i]);
        }
        shuffleArray(mlistCards);

        ((Button)findViewById(R.id.btn_shuffle)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shuffleArray(mlistCards);

            }
        });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ArrayList<String> searchedArray = new ArrayList<String>();
                String seartxt = etSearch.getText().toString();

                searchedArray.clear();
                for(int pos=0 ;pos<mlistCards.size();pos++){
                        if(mlistCards.get(pos).contains(seartxt)){
                            searchedArray.add(mlistCards.get(pos));
                        }
                }

//                Log.e("Kunal G",""+searchedArray.size());
                shuffleArray(searchedArray);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    /**
     * Get Shuffle the arraylist and list of arrays in Arraylist
     * @param arrayCards
     */
    private void shuffleArray(ArrayList<String> arrayCards){

        if(!(firstTime == 0)){
            Collections.shuffle(arrayCards);
        }else{
            firstTime++;
        }

        gridAdapter = new GridAdapter(this,arrayCards);
        gridView.setAdapter(gridAdapter);
        gridAdapter.notifyDataSetChanged();

        String positionOfSpades= "";
        for(int i=0;i<arrayCards.size() ;i++){
                if(arrayCards.get(i).toString().contains("hearts")){
                    positionOfSpades += i +", ";

                }
        }
        Log.e("Updated",""+positionOfSpades.length());
        positionOfSpades = positionOfSpades.substring(0,(positionOfSpades.length()-2));
        tvspades.setText(positionOfSpades);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}