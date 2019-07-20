package com.nanoboost.nanopay;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private List<ProductInterface> products;

    public HomeFragment() {
        // Required empty public constructor
    }

    public Boolean isSeller;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
    public void onClick(View v) {
        OnPendingItemPressed(v);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override

    public void onStart() {
        super.onStart();
        
        products = getAvailableProducts();
        CardView[] cardViews = new CardView[4];
        for(int i=0; i<4; i++) {
            String buttonID = "CardView" + (i+1);
            int resID = getResources().getIdentifier(buttonID, "id", getActivity().getApplicationContext().getPackageName());
            cardViews[i] = ((CardView) getView().findViewById(resID));
            cardViews[i].setOnClickListener(this);
            modifyView(cardViews[i], i);
        }
    }



    public void OnPendingItemPressed(View view) {
        Fragment newFragment = new ProductDetailsFragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack if needed
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    private void modifyView(View cardView, int index) {
        ProductInterface product = products.get(index);
        ImageView imageView = cardView.findViewWithTag("0");
        int resourceID = getResources().getIdentifier(product.imageName(), "drawable", this.getContext().getPackageName());
        imageView.setImageResource(resourceID);
        TextView titleView = cardView.findViewWithTag("1");
        titleView.setText(product.productName());
        TextView dealView = cardView.findViewWithTag("2");
        dealView.setText(product.buyerName());
        TextView priceView = cardView.findViewWithTag("3");
        priceView.setText(product.priceString());
        cardView.setTag(index);
    }

    private ArrayList <ProductInterface> getAvailableProducts() {
        ArrayList<ProductInterface> availableProducts = new ArrayList<ProductInterface>();
        availableProducts.add(new MockProduct("Watch", "watch", "₱100,000", 24, "Nomi Cortez", 0));
        availableProducts.add(new MockProduct("Backpack", "backpack", "₱1,000", 12, "Reuben Mercado", 0));
        availableProducts.add(new MockProduct("iPhone", "iphone", "₱32,000", 32, "Vanjelyn Roque", 0));
        availableProducts.add(new MockProduct("Speaker", "speaker", "₱15,000", 55, "Juls Andrada", 0));

        return availableProducts;
    }
}
