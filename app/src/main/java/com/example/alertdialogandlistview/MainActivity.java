package com.example.alertdialogandlistview;

import static com.example.alertdialogandlistview.R.id.btnAdd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.alertdialogandlistview.Adapters.SanPhamAdapter;
import com.example.alertdialogandlistview.Models.SanPham;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnExit;
    ListView lvSanPham;
    ArrayList<SanPham> listSanPham;
    SanPhamAdapter adapterItem;
    Button btnAddSP;
     ImageView imgAddLogoSP;
     public  String imgPath;

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
        Button btnAddSP = findViewById(R.id.btnAddSP);
        btnAddSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddSanPham();
            }
        });


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
    public  void  AddSanPham(){
        Dialog  dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.add_sanpham);
        dialog.setCanceledOnTouchOutside(false);
         imgAddLogoSP= dialog.findViewById(R.id.imgAddLogoSP);
         Button btnClickAddimg = dialog.findViewById(R.id.btnClickAddimg);
        btnClickAddimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                }
        });
        EditText edtName= dialog.findViewById(R.id.edtName);
        EditText edtMaSP= dialog.findViewById(R.id.edtMaSP);
        EditText edtGiaSP= dialog.findViewById(R.id.edtGiaSP);

        Button btnAdd = dialog.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Namesp = edtName.getText().toString().trim();
                String Masp = edtMaSP.getText().toString().trim();
//                Float Giasp = Float.parseFloat(edtGiaSP.getText().toString().trim());
                if (Namesp.equals("")|| Masp.equals("") ){
                  Toast.makeText(MainActivity.this,"nhập lại",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this,"add thành công",Toast.LENGTH_SHORT).show();
//                    listSanPham.add(new SanPham(Namesp,Masp,Giasp,imgPath));
                }

            }
        });
        Button btnExit = dialog.findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}