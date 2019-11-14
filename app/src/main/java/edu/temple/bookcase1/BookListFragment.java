package edu.temple.bookcase1;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BookListFragment extends Fragment {


    public BookListFragment() {
        // Required empty public constructor
    }



    final static String BOOK_KEY = "books";
    private ArrayList<Book> books;
    Context parent;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Bundle bundle = getArguments();
        if(bundle != null){
            books = bundle.getParcelableArrayList(BOOK_KEY);
        }
    }

    public void onAttach(Context context) {

        super.onAttach(context);

        if(context instanceof  BookSelectedInterface){
            parent = context;
        }
        else{
            throw new RuntimeException();
        }


    }

    //incomplete
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_book_list, container, false);

        //ListView listView = (ListView) view.findViewById(R.id.listViewBooks);

        ListView listView = view.findViewById(R.id.listViewBooks);

        //ArrayAdapter adapter =  new ArrayAdapter(this.getContext(), R.layout.book_item, books );

        //listView.setAdapter(adapter);
        listView.setAdapter(new ArrayAdapter<>(parent,android.R.layout.simple_list_item_1, books));
        //listView.setAdapter(new ArrayAdapter<>(Context), );

        //the onclick listener for the list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            //the title of the books at index position
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((BookSelectedInterface) BookListFragment.this.parent).bookSelected(books.get(position));
            }
        });
        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_book_list, container, false);
    }
    //create an instance of the booklist fragment
    public static BookListFragment newInstance(ArrayList<Book> books){
        BookListFragment bookListFragment = new BookListFragment();
        Bundle bundle = new Bundle();

        bundle.putParcelableArrayList(BOOK_KEY,books);

        bookListFragment.setArguments(bundle);

        return bookListFragment;
    }


    interface BookSelectedInterface {
        void bookSelected(Book book);
    }


}
