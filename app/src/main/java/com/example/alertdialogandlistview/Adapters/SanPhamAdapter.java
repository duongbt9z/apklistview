package com.example.alertdialogandlistview.Adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.alertdialogandlistview.MainActivity;
import com.example.alertdialogandlistview.Models.SanPham;
import com.example.alertdialogandlistview.R;

import java.util.ArrayList;

public class SanPhamAdapter extends ArrayAdapter<SanPham> {
    Activity context;
    int resource;
    ArrayList<SanPham> listSanPham;
    public  SanPhamAdapter(Activity context, int resource , ArrayList<SanPham> ListSP){
        super(context,resource);
        this.context = context;
        this.resource = resource;
        this.listSanPham= ListSP;
    }

    @Override
    public int getCount() {
        return listSanPham.size();
    }

    @NonNull
    @Override
    public View getView(int position,@NonNull View convertView,@NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = this.context.getLayoutInflater();
        View customView = layoutInflater.inflate(resource, null);
        ImageView imgLogo = customView.findViewById(R.id.imgLogo);
        TextView tvID = customView.findViewById(R.id.tvID);
        TextView tvName = customView.findViewById(R.id.tvName);
        TextView tvPrice = customView.findViewById(R.id.tvPrice);
        Button btnView = customView.findViewById(R.id.btnView);
        Button btnDelete = customView.findViewById(R.id.btnDelete);
        SanPham sp = this.listSanPham.get(position);
        tvID.setText("Mã SP: "+sp.getMaSP());
        tvName.setText("Tên SP:"+sp.getTenSP());
        tvPrice.setText("Giá SP: "+sp.getGiaSP() + " VNĐ");
        Uri uri = Uri.parse(sp.getLogoSP());
        imgLogo.setImageURI(uri);
        //show view Sản phẩm
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kq = "Mã SP: "+sp.getMaSP()+"\n"
                        +"Tên SP:"+sp.getTenSP()+"\n"+"Giá SP: "+sp.getGiaSP();
                Toast.makeText(context, kq, Toast.LENGTH_SHORT).show();
            }
        });

        // xóa sản phẩm

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Xóa Sản Phẩm");
                builder.setMessage("Bạn có thật sự muốn xóa sản phẩm");
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setPositiveButton("CÓ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listSanPham.remove(sp);
                        notifyDataSetChanged();
                    }
                });
                builder.create().show();
            }
        });
        return customView;
    }

}
