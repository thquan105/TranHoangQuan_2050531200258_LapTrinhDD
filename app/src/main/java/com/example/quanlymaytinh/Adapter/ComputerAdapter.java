package com.example.quanlymaytinh.Adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlymaytinh.ComputerActivity;
import com.example.quanlymaytinh.Model.Computer;
import com.example.quanlymaytinh.R;

import java.util.ArrayList;


public class ComputerAdapter extends RecyclerView.Adapter<ComputerAdapter.ViewHolder> {
    ArrayList<Computer> computerList;
    Context context;


    public ComputerAdapter(ArrayList<Computer> computerList, Context context) {
        this.computerList = computerList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_computer, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Computer com = computerList.get(position);
        if ( com == null)
        {
            return;
        }
        holder.maCom.setText(com.getMaComputer());
        holder.tenCom.setText(com.getTenComputer());
        holder.moTa.setText(com.getMoTa());
        holder.maCom.setText(com.getMaComputer());
    }

    @Override
    public int getItemCount() {
        return computerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tenCom;
        public TextView moTa;
        public TextView maCom;
        public Button btnDel,btnEdit;

        public ViewHolder(View itemView) {
                super(itemView);
                maCom = itemView.findViewById(R.id.maCom);
                tenCom = itemView.findViewById(R.id.tenCom);
                moTa = itemView.findViewById(R.id.moTa);
                btnDel = itemView.findViewById(R.id.btnDel);
                btnEdit = itemView.findViewById(R.id.btnEdit);


                //Xử lý khi nút Chi tiết được bấm
                btnDel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder alertDiaLog = new AlertDialog.Builder(view.getContext());
                        alertDiaLog.setTitle("Thông báo");
                        alertDiaLog.setMessage("Bạn có muốn xóa "+ tenCom.getText().toString().trim()+" ?"    );
                        alertDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ComputerActivity.dbHelper.QueryData("DELETE from tblComputer where maComputer ='"+maCom.getText().toString().trim()+"'");
                                ComputerActivity.arrayList = new ArrayList<Computer>();
                                Cursor cursor = ComputerActivity.dbHelper.GetData("Select * from tblComputer where maCategory = '"+ComputerActivity.maCa.trim() +"'");
                                while (cursor.moveToNext()){
                                    @SuppressLint("Range") String idC =cursor.getString(cursor.getColumnIndex("maComputer"));
                                    @SuppressLint("Range") String nameC = cursor.getString(cursor.getColumnIndex("tenComputer"));
                                    @SuppressLint("Range") String moTaC = cursor.getString(cursor.getColumnIndex("moTa"));
                                    @SuppressLint("Range") String idCategory = cursor.getString(cursor.getColumnIndex("maCategory"));

                                    ComputerActivity.arrayList.add(new Computer(idC,nameC,moTaC,idCategory));
                                }
                                ComputerActivity.computerAdapter = new ComputerAdapter(ComputerActivity.arrayList, view.getContext());
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL,false);
                                ComputerActivity.recyclerView.setAdapter(ComputerActivity.computerAdapter);
                                ComputerActivity.recyclerView.setLayoutManager(linearLayoutManager);
                            }
                        });
                        alertDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        alertDiaLog.show();
                    }
                });
                //Khi click vào sửa
                btnEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Dialog dialog = new Dialog(view.getContext());
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.setContentView(R.layout.dialog_computer);
                        dialog.show();
                        EditText tv1 = (EditText) dialog.findViewById(R.id.isIDCo);
                        EditText tv2 = (EditText) dialog.findViewById(R.id.isNameCo);
                        EditText tv3 = (EditText) dialog.findViewById(R.id.isMota);
                        EditText tv4 = (EditText) dialog.findViewById(R.id.isIDCate);
                        tv1.setText(maCom.getText().toString().trim());
                        tv2.setText(tenCom.getText().toString().trim());
                        tv3.setText(moTa.getText().toString().trim());
                        tv4.setVisibility(View.GONE);
                        Button btok = (Button) dialog.findViewById(R.id.btn_okCo);
                        Button btcancel = (Button) dialog.findViewById(R.id.btn_cancelCo);

                        btok.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ComputerActivity.dbHelper.QueryData("UPDATE tblComputer set maComputer = '"+tv1.getText().toString().trim()+ "',tenComputer='"+ tv2.getText().toString().trim()+ "',moTa='"+ tv3.getText().toString().trim()+"'  where maComputer ='"+maCom.getText().toString().trim()+"'");
                                ComputerActivity.arrayList = new ArrayList<Computer>();
                                Cursor cursor = ComputerActivity.dbHelper.GetData("Select * from tblComputer where maCategory = '"+ComputerActivity.maCa.trim() +"'");
                                while (cursor.moveToNext()){
                                    @SuppressLint("Range") String idC =cursor.getString(cursor.getColumnIndex("maComputer"));
                                    @SuppressLint("Range") String nameC = cursor.getString(cursor.getColumnIndex("tenComputer"));
                                    @SuppressLint("Range") String moTaC = cursor.getString(cursor.getColumnIndex("moTa"));
                                    @SuppressLint("Range") String idCategory = cursor.getString(cursor.getColumnIndex("maCategory"));
                                    ComputerActivity.arrayList.add(new Computer(idC,nameC,moTaC,idCategory));
                                }
                                ComputerActivity.computerAdapter = new ComputerAdapter(ComputerActivity.arrayList, view.getContext());
                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL,false);
                                ComputerActivity.recyclerView.setAdapter(ComputerActivity.computerAdapter);
                                ComputerActivity.recyclerView.setLayoutManager(linearLayoutManager);
                                dialog.dismiss();

                            }
                        });
                        btcancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.cancel();
                            }
                        });
                    }
                });
            }
        }
}
