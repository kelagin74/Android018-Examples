package com.luxoft.training.dev018.androidexamples.layouts;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luxoft.training.dev018.androidexamples.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RelativeContactItemFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RelativeContactItemFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RelativeContactItemFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_HEAD_TEXT = "head_text";
    private static final String ARG_SMALL_TEXT = "small_text";
    private static final String ARG_TIME = "time_text";

    // TODO: Rename and change types of parameters
    private String mHeadText;
    private String mSmallText;
    private String mTime;

    TextView tvHeaderText;
    TextView tvSmallText;
    TextView tvTimeText;

    //private OnFragmentInteractionListener mListener;

    public RelativeContactItemFragment() {
        // Required empty public constructor
    }

     public static RelativeContactItemFragment newInstance(String headText, String smallText, String time) {
        RelativeContactItemFragment fragment = new RelativeContactItemFragment();
        Bundle args = new Bundle();
        args.putString(ARG_HEAD_TEXT, headText);
        args.putString(ARG_SMALL_TEXT, smallText);
        args.putString(ARG_TIME, time);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mHeadText = getArguments().getString(ARG_HEAD_TEXT);
            mSmallText = getArguments().getString(ARG_SMALL_TEXT);
            mTime = getArguments().getString(ARG_TIME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_relative_contact_item, container, false);

        tvHeaderText = (TextView) v.findViewById(R.id.HeadText);
        tvSmallText =  (TextView) v.findViewById(R.id.SmallText);
        tvTimeText =   (TextView) v.findViewById(R.id.Time);

        tvHeaderText.setText(mHeadText);
        tvSmallText.setText(mSmallText);
        tvTimeText.setText(mTime);

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
