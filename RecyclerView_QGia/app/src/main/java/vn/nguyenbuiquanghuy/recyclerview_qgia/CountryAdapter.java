package vn.nguyenbuiquanghuy.recyclerview_qgia;

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

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ItemCountryHolder> {
    Context context;
    ArrayList<Country> listData;

    public CountryAdapter(Context context, ArrayList<Country> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ItemCountryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom=LayoutInflater.from(context);
        View vItem=cai_bom.inflate(R.layout.country_layout,parent,false);
        ItemCountryHolder holderCreated =new ItemCountryHolder(vItem);

        return holderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCountryHolder holder, int position) {
        //Lấy đối tượng hiển thị
        Country countryHienthi=listData.get(position);
        //Trích Thông tin
        String name =countryHienthi.getCountryName();
        String DS=countryHienthi.getCountryDS();
        String Anh=countryHienthi.getImageFileName();
        //Đặt vào các trường thông tin của holder
        holder.tvName.setText(name);
        holder.tvDS.setText(DS);
        //Đặt ảnh
         String packedName=holder.itemView.getContext().getPackageName();
         int imageID=holder.itemView.getResources().getIdentifier(Anh,"mipmap",packedName);
         holder.imageViewCountry.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ItemCountryHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvDS;
        ImageView imageViewCountry;

        public ItemCountryHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.textViewVN);
            tvDS=itemView.findViewById(R.id.textViewDSVN);
            imageViewCountry=itemView.findViewById(R.id.imageViewVN);
        }
    }
}
