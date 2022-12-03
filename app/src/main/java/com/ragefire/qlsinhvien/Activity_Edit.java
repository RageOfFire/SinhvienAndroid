package com.ragefire.qlsinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Activity_Edit extends AppCompatActivity {
    private EditText edtMaSV, edtHoten, edtEmail, edtsdt;
    private Button btnSave, btnExit;
    private RadioGroup rg_gioitinh;
    private RadioButton rbNam, rbNu;
    private int gioitinh;
    private SV_DAO svDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        anhxa();
        svDao=new SV_DAO(Activity_Edit.this);
        Intent intent=getIntent();
        final SinhVien sv=(SinhVien) intent.getSerializableExtra("DuLieu");
        // Lấy DL
        edtHoten.setText(sv.getHoten());
        edtEmail.setText(sv.getEmail());
        edtsdt.setText(String.valueOf(sv.getSdt()));
        if(sv.getGioitinh()==1){
            rbNam.setChecked(true);
            gioitinh=1;
        }else {
            rbNu.setChecked(true);
            gioitinh=0;
        }
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rg_gioitinh.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rbNam){
                    gioitinh=1;
                }else {
                    gioitinh=0;
                }
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv.setHoten(edtHoten.getText().toString());
                sv.setEmail(edtEmail.getText().toString());
                sv.setSdt(Integer.parseInt(edtsdt.getText().toString()));
                sv.setGioitinh(gioitinh);
                svDao.UpdateSV(sv);
            }
        });
    }

    private void anhxa() {
        edtMaSV=findViewById(R.id.edtMasv);
        edtHoten=findViewById(R.id.edtHoten);
        edtEmail=findViewById(R.id.edtEmail);
        edtsdt=findViewById(R.id.edtSDT);
        btnSave=findViewById(R.id.btnSave);
        btnExit=findViewById(R.id.btnExit);
        rg_gioitinh=findViewById(R.id.rg_gioitinh);
        rbNam=findViewById(R.id.rbNam);
        rbNu=findViewById(R.id.rbNu);
    }
}