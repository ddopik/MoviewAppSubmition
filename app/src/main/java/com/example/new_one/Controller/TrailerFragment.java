package com.example.new_one.Controller;

import android.app.Fragment;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.new_one.HelperClasses.ReviewsAdapter;
import com.example.new_one.HelperClasses.TrailerAdapter;
import com.example.new_one.Model.MoviesReviews;
import com.example.new_one.Model.MoviesTrailer;
import com.example.new_one.Model.RealmContract;
import com.example.new_one.R;

import io.realm.RealmList;
public class TrailerFragment extends DialogFragment {

    int movieId;

    RealmList<MoviesReviews> listTrailvData;
    View fragmentView;
    ListView trailListView;

    RealmList<MoviesTrailer> listTrailData;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);// retain this fragment so fragment won't lost instaned data
        setHasOptionsMenu(true);
        Log.e("TrailerFragmentMenu--->", "onCreateTrailerFragmentCalled");
        getDialog().setTitle("Trailers");
        fragmentView = inflater.inflate(R.layout.trailer_dialog_fragment_view, container, false);
        trailListView = (ListView) fragmentView.findViewById(R.id.trailersList);



        setMovieId(getArguments().getInt("MovieId"));
        RealmContract myRealm = new RealmContract(getActivity());
        setListTrailData(myRealm.getTrailQuery(getMovieId()));
        RealmList<MoviesTrailer>  l=this.listTrailData;
        TrailerAdapter trailAdapter=new TrailerAdapter(getActivity(),getListTrailersData());
        trailListView.setAdapter(trailAdapter);

        trailListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
//                arg0 is your AdapterView, typically a ListView. arg2 is the position in the ListView. You can get

                ///ListView
                AdapterView<?> parent2=parent;
                //LinearLayout
                ListView myListView = ((ListView) parent);
                TextView myTextView=(TextView) myListView.getChildAt(position).findViewById(R.id.TrailContentLink);
                String itemTexts =myTextView.getText().toString();
                Toast.makeText(getActivity(),itemTexts,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(itemTexts)));

            }
        });

        return fragmentView;
    }





//    public View getViewByPosition(int pos, ListView listView) {
//        final int firstListItemPosition = listView.getFirstVisiblePosition();
//        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;
//
//        if (pos < firstListItemPosition || pos > lastListItemPosition ) {
//            return listView.getAdapter().getView(pos, null, listView);
//        } else {
//            final int childIndex = pos - firstListItemPosition;
//            return listView.getChildAt(childIndex);
//        }
//    }



    public RealmList<MoviesTrailer> getListTrailData() {
        return listTrailData;
    }

    public void setListTrailData(RealmList<MoviesTrailer> listTrailData) {
        this.listTrailData = listTrailData;
    }
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public RealmList<MoviesTrailer> getListTrailersData() {
        return listTrailData;
    }



    public View getFragmentView() {
        return fragmentView;
    }

    public void setFragmentView(View fragmentView) {
        this.fragmentView = fragmentView;
    }

    public ListView getTrailListView() {
        return trailListView;
    }

    public void setTrailListView(ListView revListView) {
        this.trailListView = revListView;
    }





}
