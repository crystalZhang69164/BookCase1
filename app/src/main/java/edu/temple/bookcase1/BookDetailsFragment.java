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

    Book book;
    TextView textView;
    TextView titleView;
    TextView authorView;
    TextView publishedView;
    TextView URLView;

    final static String TITLE_KEY = "title";
    private String title;
    int position = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_book_details, container, false);


        textView = view.findViewById(R.id.textViewDetails);
        titleView = view.findViewById(R.id.titleView);
        authorView = view.findViewById(R.id.authorView);
        publishedView = view.findViewById(R.id.publishedView);
        URLView = view.findViewById(R.id.URLView);

        titleView.setText(book.getTitle());
        authorView.setText(book.getAuthor());
        publishedView.setText(book.getPublished());
        URLView.setText(book.getCoverURL());


        Bundle bundle = getArguments();

        if(bundle != null){
            title = bundle.getString(TITLE_KEY);
            this.DisplayBook(book);
        }

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_book_details, container, false);
        return view;


    }
    //displays the book title
    public void DisplayBook(Book book){

        //TextView textView;
        this.book = book;



        //sets the text for each textview
        titleView.setText(book.getTitle());
        authorView.setText(book.getAuthor());
        publishedView.setText(book.getPublished());
        URLView.setText(book.getCoverURL());


        textView.setText(title);
        textView.setTextSize(20);

    }
    public static BookDetailsFragment newInstance(Book book){

        BookDetailsFragment bookDetailsFragment = new BookDetailsFragment();

        Bundle bundle = new Bundle();


        bundle.putParcelable(TITLE_KEY,book);
        bookDetailsFragment.setArguments(bundle);

        //Bundle bundle = new Bundle();

        //bundle.putStringArray(,books);

        //bookListFragment.setArguments(bundle);

        return bookDetailsFragment;
    }

}
