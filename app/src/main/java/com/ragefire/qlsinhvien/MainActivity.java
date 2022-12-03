package com.ragefire.qlsinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // khai báo các thành phần
    private EditText edtSearch;
    private Button btnSeach;
    private ListView lvsv;

    private List<SinhVien> SVList;
    private SVApdapter adapter;
    private SVDatabase db;
    private SV_DAO svdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa
        edtSearch=findViewById(R.id.Search);
        btnSeach=findViewById(R.id.btnSearch);
        lvsv=findViewById(R.id.lvsv);

        // Đổ DL
        SVList= new ArrayList<>();
        svdao=new SV_DAO(MainActivity.this);
        SVList=svdao.InfoSV();
        adapter=new SVApdapter(getApplicationContext(),SVList);
        lvsv.setAdapter(adapter);
        onResume();
        registerForContextMenu(lvsv);
        btnSeach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SVList= svdao.SearchSV(edtSearch.getText().toString());
                adapter=new SVApdapter(getApplicationContext(),SVList);
                lvsv.setAdapter(adapter);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_Them:{
                Intent intent=new Intent(MainActivity.this, Activity_Add.class);
                startActivity(intent);

                break;

            }
            case R.id.menu_Thoat:{
                finish();
            }
        }
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int vitri=info.position;
        SinhVien sv=SVList.get(vitri);
        switch (item.getItemId()){
            case R.id.menu_update:{
                Intent intent=new Intent(MainActivity.this, Activity_Edit.class);
                intent.putExtra("DuLieu", sv);
                startActivity(intent);
                break;
            }
            case R.id.menu_Delete:{
                svdao.DeleteSV(sv.getMasv());
                adapter.notifyDataSetChanged();
                onResume();
                break;
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SVList.clear();
        SVList.addAll(svdao.InfoSV());
        adapter.notifyDataSetChanged();
    }
}