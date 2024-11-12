package vn.nguyenbuiquanghuy.apps.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import vn.nguyenbuiquanghuy.apps.R;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ItemCountryHolder>{
    Context context;
    ArrayList<Country> lstCountry;

    public CountryAdapter(Context context, ArrayList<Country> lstCountry) {
        this.context = context;
        this.lstCountry = lstCountry;
    }

    @NonNull
    @Override
    public ItemCountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.country,parent,false);
        ItemCountryHolder countryHolder=new ItemCountryHolder(view);
        return countryHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ItemCountryHolder holder, int position) {
        // Lấy đối tượng hiển thị
        Country country=lstCountry.get(position);
        // Trích thông tin
        String name=country.getName();
        String caption=country.getCaption();
        String anh=country.getImageFile();

        holder.tvName.setText(name);
        holder.tvDS.setText(caption);
        // Đặt ảnh
        String packedName=holder.itemView.getContext().getPackageName();
        int imageID = holder.itemView.getResources().getIdentifier(anh,"mipmap",packedName);
        holder.imageViewCountry.setImageResource(imageID);

    }

    @Override
    public int getItemCount() {
        return lstCountry.size();
    }

    class ItemCountryHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvDS;
        ImageView imageViewCountry;
        public ItemCountryHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.textViewName);
            tvDS=itemView.findViewById(R.id.textViewDS);
            imageViewCountry=itemView.findViewById(R.id.imageViewVN);
        }
    }
}
