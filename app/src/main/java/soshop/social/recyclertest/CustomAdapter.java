package soshop.social.recyclertest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ninniez on 1/16/2015.
 */
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    //member of adapter class
    private String[] mDataSet;
    private Context mContext;


    //suitable constructor (depends on kinds of data set)

    // BEGIN_INCLUDE(recyclerViewSampleViewHolder)
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTextView;
        private Button mButton;


        public ViewHolder(View itemView) {
            super(itemView);

            mTextView = (TextView) itemView.findViewById(R.id.textView);
            mButton = (Button) itemView.findViewById(R.id.testButton);


        }

        public TextView getTextView() {
            return mTextView;
        }

        public Button getmButton() {
            return mButton;
        }


    }
    // END_INCLUDE(recyclerViewSampleViewHolder

    public CustomAdapter(String[] myDataSet, Context context){
        mDataSet = myDataSet;
        mContext = context;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        viewHolder.getTextView().setText(mDataSet[i]);

        viewHolder.getmButton().setText("Toast me! I'm at "+ i);
        viewHolder.getmButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Button " + i + " is clicked!", Toast.LENGTH_SHORT).show();
            }
        });

    }


    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}
