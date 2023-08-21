package com.sumit.pizzaapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BestSeller#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BestSeller extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BestSeller() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BestSeller.
     */
    // TODO: Rename and change types and number of parameters
    public static BestSeller newInstance(String param1, String param2) {
        BestSeller fragment = new BestSeller();
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

    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);

        List<Product> productList = new ArrayList<>();
        productList.add(new Product("The 4 Cheese Pizza","Cheese Overloaded pizza with 4 different varieties of cheese and 4 times the cheese of a normal pizza, including a spicy hit of Ghost Pepper flavoured Cheese","639","https://images.dominos.co.in/PIZ0171.jpg"));
        productList.add(new Product("Peppy Paneer","Flavorful trio of juicy paneer, crisp capsicum with spicy red paprika ","459","https://images.dominos.co.in/new_peppy_paneer.jpg"));
        productList.add(new Product("Farmhouse","Delightful combination of onion, capsicum, tomato & grilled mushroom","459","https://images.dominos.co.in/farmhouse.png"));


        ListView productListView = view.findViewById(R.id.product_lst_view);
        ProductAdapter productAdapter = new ProductAdapter(getActivity(),productList);
        productListView.setAdapter(productAdapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_best_seller, container, false);
    }
}