package com.ragefire.qlsinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Activity_Add extends AppCompatActivity {

    private EditText edtMaSV, edtHoten, edtEmail, edtsdt;
    private Button btnThem, btnThoat;
    private RadioGroup rg_gioitinh;
    private int gioitinh=1;
    private SV_DAO svDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        anhxa();
        svDao=new SV_DAO(Activity_Add.this);
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

        // bắt sự kiện cho btnThem
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String masv=edtMaSV.getText().toString();
                String hoten=edtHoten.getText().toString();
                String email=edtEmail.getText().toString();
                int sdt=Integer.parseInt(edtsdt.getText().toString());
                SinhVien sv=new SinhVien(masv,hoten,email,gioitinh,sdt);
                svDao.AddSV(sv);
            }
        });

        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void anhxa() {
        edtMaSV=findViewById(R.id.edtMasv);
        edtHoten=findViewById(R.id.edtHoten);
        edtEmail=findViewById(R.id.edtEmail);
        edtsdt=findViewById(R.id.edtSDT);
        btnThem=findViewById(R.id.btnThem);
        btnThoat=findViewById(R.id.btnThoat);
        rg_gioitinh=findViewById(R.id.rg_gioitinh);


    }
}