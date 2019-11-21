package next.com.sampleapp.view.holiday;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import next.com.sampleapp.R;
import next.com.sampleapp.model.holiday.HolidayListResponse;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.MyViewHolder> {

    private List<HolidayListResponse.Datum> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView holidayName, holidayDate;

        public MyViewHolder(View view) {
            super(view);

            holidayName = view.findViewById(R.id.holiday_name);
            holidayDate = view.findViewById(R.id.holiday_date);

        }
    }


    public HolidayAdapter(List<HolidayListResponse.Datum> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holiday_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HolidayListResponse.Datum movie = moviesList.get(position);
        holder.holidayName.setText(movie.getHolidayInformation());
        holder.holidayDate.setText(movie.getHolidayDate());
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
