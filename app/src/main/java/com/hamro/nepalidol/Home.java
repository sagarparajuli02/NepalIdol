package com.hamro.nepalidol;


import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class Home extends android.app.Fragment {
    Button btn;
    ProgressDialog pd;
    int number=330000000;
    int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
    MaterialBetterSpinner spinner;
    customAdapterSpinner adapterSpinner;
    String[] names= {"Buddha Lama","Nishan Bhattarai","Pratap Das","Sagar Ale"};
    public Home() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle(R.string.app_name);

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner= (MaterialBetterSpinner)view.findViewById(R.id.spinner);
        adapterSpinner = new customAdapterSpinner(getActivity(),names);
        spinner.setAdapter(adapterSpinner);
        btn = (Button) view.findViewById(R.id.button) ;
        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String name= spinner.getText().toString();
                String numbr=Integer.toString(number);

                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.SEND_SMS},
                            MY_PERMISSIONS_REQUEST_SEND_SMS);

                }
                else{
                    SmsManager sms= SmsManager.getDefault();
                    switch (name){

                        case "Buddha Lama":
                            String sagar= "01";
                            sms.sendTextMessage(numbr,null,sagar,null,null);
                            SendMsg();
                            break;
                        case "Nishan Bhattarai":
                            String   ocean= "02";
                            sms.sendTextMessage(numbr,null,ocean,null,null);
                            SendMsg();
                            break;
                        default:
                            Toast.makeText(getActivity(), "Please select one", Toast.LENGTH_LONG).show();
                    }

                }

            }
           public void SendMsg(){
               final ProgressDialog pd = new ProgressDialog(getActivity());
               pd.setTitle("Sending Vote");
               pd.setMessage("Please wait.....");
               pd.setCancelable(false);
               pd.show();
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       pd.dismiss();
                   }
               },2000);
            }



        });

    }
}
