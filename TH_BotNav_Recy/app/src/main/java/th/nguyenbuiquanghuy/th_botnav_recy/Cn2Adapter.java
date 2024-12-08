package th.nguyenbuiquanghuy.th_botnav_recy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Cn2Adapter extends RecyclerView.Adapter<Cn2Adapter.ItemCn2Holder> {
    Context context;
    ArrayList<Cn2> cn2ArrayList;

    public Cn2Adapter(Context context, ArrayList<Cn2> cn2ArrayList) {
        this.context = context;
        this.cn2ArrayList = cn2ArrayList;
    }

    @NonNull
    @Override
    public ItemCn2Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater cai_bom=LayoutInflater.from(context);
        View vItem=cai_bom.inflate(R.layout.cn2_items,parent,false);
        ItemCn2Holder holderCreated =new ItemCn2Holder(vItem);

        return holderCreated;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCn2Holder holder, int position) {
        Cn2 cn2=cn2ArrayList.get(position);
         String text=cn2.getText();
         String Anh=cn2.getImage();
         holder.textView.setText(text);

        String packedName=holder.itemView.getContext().getPackageName();
        int imageID=holder.itemView.getResources().getIdentifier(Anh,"mipmap",packedName);
        holder.imageView.setImageResource(imageID);
    }

    @Override
    public int getItemCount() {
        return cn2ArrayList.size();
    }

    class ItemCn2Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public ItemCn2Holder(@NonNull View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.img_cn2);
            textView=itemView.findViewById(R.id.tv_cn2);
        }
    }
}
