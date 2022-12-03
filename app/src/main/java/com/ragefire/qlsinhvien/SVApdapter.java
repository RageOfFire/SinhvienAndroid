package com.ragefire.qlsinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SVApdapter extends BaseAdapter {
    private Context context;
    private List<SinhVien> listSV;

    public SVApdapter(Context context, List<SinhVien> ListSV) {
        this.context = context;
        this.listSV = ListSV;
    }

    @Override
    public int getCount() {
        return listSV.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder viewHolder;
        if(convertView==null){
            viewHolder=new viewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.item_list,null);
            // ánh xạ
            viewHolder.masv=convertView.findViewById(R.id.tv_masv);
            viewHolder.hoten=convertView.findViewById(R.id.tv_hoten);
            viewHolder.email=convertView.findViewById(R.id.tv_email);
            viewHolder.sdt=convertView.findViewById(R.id.tv_sdt);
            viewHolder.gioitinh=convertView.findViewById(R.id.iv_gioitinh);
            convertView.setTag(viewHolder);

        }else {
            viewHolder=(viewHolder)convertView.getTag();
        }

        // Thiết lập giá trị
        SinhVien sv=listSV.get(position);
        viewHolder.masv.setText("Mã SV: "+sv.getMasv());
        viewHolder.hoten.setText("Họ tên: "+sv.getHoten());
        viewHolder.email.setText("Email: "+sv.getEmail());
        viewHolder.sdt.setText("SDT: "+sv.getSdt());
        if(sv.getGioitinh()==0){
            viewHolder.gioitinh.setImageResource(R.drawable.female_icon_);
        }else {
            viewHolder.gioitinh.setImageResource(R.drawable.male_icon_);
        }
        return convertView;
    }
    class viewHolder {
        //        chỉ khai báo các View chứa  trong item_list
        private ImageView gioitinh;
        private TextView masv, hoten, email, sdt;
    }
}
