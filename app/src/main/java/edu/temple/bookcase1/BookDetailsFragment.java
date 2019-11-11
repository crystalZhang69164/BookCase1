package edu.temple.bookcase1;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookDetailsFragment extends Fragment {


    public BookDetailsFragment() {
        // Required empty public constructor
    }

    TextView textView;
    final static String TITLE_KEY = "title";
    private String title;
    int position =0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_book_details, container, false);


        textView = view.findViewById(R.id.textViewDetails);


        Bundle bundle = getArguments();

        if(bundle != null){
            title = bundle.getString(TITLE_KEY);
            this.DisplayBook(title);
        }

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_book_details, container, false);
        return view;


    }
    //displays the book title
    public void DisplayBook(String title){

        //TextView textView;

        textView.setText(title);
        textView.setTextSize(20);

    }
    public static BookDetailsFragment newInstance(String title){

        BookDetailsFragment bookDetailsFragment = new BookDetailsFragment();

        Bundle bundle = new Bundle();


        bundle.putString(TITLE_KEY,title);
        bookDetailsFragment.setArguments(bundle);

        //Bundle bundle = new Bundle();

        //bundle.putStringArray(,books);

        //bookListFragment.setArguments(bundle);

        return bookDetailsFragment;
    }

}
