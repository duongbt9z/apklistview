package com.example.alertdialogandlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.alertdialogandlistview.Adapters.SanPhamAdapter;
import com.example.alertdialogandlistview.Models.SanPham;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnCLose;
    ListView lvSanPham;
    ArrayList<SanPham> listSanPham;
    SanPhamAdapter adapterItem;
    Button btnAddSP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvSanPham = findViewById(R.id.lvSanPham);
        listSanPham = new ArrayList<>();
        listSanPham.add(new SanPham("sp001","coca",1500,"android.resource://com.example.alertdialogandlistview/drawable/coca"));
        listSanPham.add(new SanPham("sp002","pespi",1500,"android.resource://com.example.alertdialogandlistview/drawable/pepsi"));
        listSanPham.add(new SanPham("sp003","Giải khát",1500,"android.resource://com.example.alertdialogandlistview/drawable/softdrink"));
        adapterItem = new SanPhamAdapter(MainActivity.this, R.layout.lv_sanpham,listSanPham);
        lvSanPham.setAdapter(adapterItem);



//    protected  void showCLoseDialog(){
//        AlertDialog.Builder buider = new AlertDialog.Builder(MainActivity.this);
//        buider.setTitle("Thoát ứng dụng");
//        buider.setMessage("Bạn Thật Sự muốn thoát");
//        buider.setPositiveButton("có", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                finish();
//            }
//        });
//        buider.setNegativeButton("hủy", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.cancel();
//            }
//        });
//        buider.create().show();
//    }
    }


}