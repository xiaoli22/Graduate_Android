package com.example.graduate_android.fragmentadd;

import static com.example.graduate_android.bean.AddNormal.getDefaultAN;
import static com.example.graduate_android.bean.DialogBase.getDefaultDialogBase;
import static com.example.graduate_android.utils.DateTimeUtils.getCurrentDay;
import static com.example.graduate_android.utils.DateTimeUtils.getCurrentMonth;
import static com.example.graduate_android.utils.DateTimeUtils.getCurrentYear;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.assist.AssistStructure;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.graduate_android.R;
import com.example.graduate_android.adpater.AddAdapter;
import com.example.graduate_android.adpater.DialogBaseAdapter;
import com.example.graduate_android.bean.AddNormal;
import com.example.graduate_android.bean.DialogBase;
import com.example.graduate_android.databinding.CustomAddNormalBinding;
import com.example.graduate_android.databinding.FragmentOutcomeBinding;

import java.util.ArrayList;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OutcomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OutcomeFragment extends Fragment implements AdapterView.OnItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FragmentOutcomeBinding binding;
    private com.example.graduate_android.databinding.CustomAddNormalBinding binding1;

    String[] dataArray = {"现金账户", "支付宝", "微信钱包", "银行卡", "信用卡"};
    private ArrayList<DialogBase> alist;

    public OutcomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OutcomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OutcomeFragment newInstance(String param1, String param2) {
        OutcomeFragment fragment = new OutcomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentOutcomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        binding1 = CustomAddNormalBinding.inflate(inflater, container, false);

        //获得初始数据
        ArrayList<AddNormal> addNormals = getDefaultAN();
        //创建适配器
        AddAdapter addAdapter = new AddAdapter(getContext(), addNormals);
        //设置适配器
        binding.listViewOutcome.setAdapter(addAdapter);
        //设置监听器
        binding.listViewOutcome.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(getActivity(), "You click addOutcome" + position, Toast.LENGTH_SHORT).show();

        switch (position) {
            case 0:
                showAccountDialog(getContext(), view);
                break;
            case 1:
                showDatePickerDialog(getContext(), view);
                break;
            case 2:
                break;
            case 3:
                break;
        }


    }


    private void AccountDialog(Context context, View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setItems(dataArray, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // 处理选项点击事件,从ListView中的item（view，布局为customAddNormal），从中获取dataAN并且赋值
                TextView text = view.findViewById(R.id.dataAN);
                text.setText(dataArray[which]);

                dialog.dismiss(); // 关闭对话框
            }
        });
        builder.show(); // 显示对话框
    }


    //调用系统时间
    private void DateDialog(Context context, View view) {
        DatePickerDialog dialog = new DatePickerDialog(context, (DatePicker, year, month, dayOfMonth) -> {
            String date = String.format(Locale.CHINA, "%d-%d-%d", year, month + 1, dayOfMonth);
            TextView textView = view.findViewById(R.id.dataAN);
            textView.setText(date);
        }, getCurrentYear(), getCurrentMonth() - 1, getCurrentDay());
        dialog.show();
    }


    //提供给其他Fragment使用
    public void showDatePickerDialog(Context context, View view) {
        DateDialog(context, view);
    }

    //封装，然后给其他的Fragment使用
    public void showAccountDialog(Context context, View view) {
        AccountDialog(context, view);
    }
}