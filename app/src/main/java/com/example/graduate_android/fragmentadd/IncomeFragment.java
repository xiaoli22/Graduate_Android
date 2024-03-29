package com.example.graduate_android.fragmentadd;

import static com.example.graduate_android.bean.AddNormal.getDefaultAN;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.graduate_android.R;
import com.example.graduate_android.adpater.AddAdapter;
import com.example.graduate_android.bean.AddNormal;
import com.example.graduate_android.databinding.FragmentIncomeBinding;
import com.example.graduate_android.databinding.FragmentOutcomeBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IncomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IncomeFragment extends Fragment implements AdapterView.OnItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    FragmentIncomeBinding binding;

    public IncomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InComeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static IncomeFragment newInstance(String param1, String param2) {
        IncomeFragment fragment = new IncomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentIncomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        //获得初始数据
        ArrayList<AddNormal> addNormals = getDefaultAN();
        //创建适配器
        AddAdapter addAdapter = new AddAdapter(getContext(), addNormals);
        //设置适配器
        binding.listViewIncome.setAdapter(addAdapter);
        //设置监听器
        binding.listViewIncome.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //获取点击的item
//        Toast.makeText(getActivity(), "You click addIncome", Toast.LENGTH_SHORT).show();
        OutcomeFragment outcomeFragment = new OutcomeFragment();
        switch (position) {
            case 0:
                outcomeFragment.showAccountDialog(getContext(), view);
                break;
            case 1:
                outcomeFragment.showDatePickerDialog(getContext(), view);
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}