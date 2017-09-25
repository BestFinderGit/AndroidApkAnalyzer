package sk.styk.martin.apkanalyzer.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import sk.styk.martin.apkanalyzer.R;
import sk.styk.martin.apkanalyzer.model.detail.ContentProviderData;
import sk.styk.martin.apkanalyzer.view.DetailListItemView;

/**
 * Created by Martin Styk on 07.07.2017.
 */
public class ProviderListAdapter extends RecyclerView.Adapter<ProviderListAdapter.ViewHolder> {

    private final List<ContentProviderData> items;

    public ProviderListAdapter(@NonNull List<ContentProviderData> items) {
        super();
        setHasStableIds(true);
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_provider_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        ContentProviderData data = items.get(position);
        holder.name.setText(data.getName());
        holder.authority.setValue(data.getAuthority());
        holder.readPermission.setValue(data.getReadPermission());
        holder.writePermission.setValue(data.getWritePermission());
        holder.exported.setValue(data.isExported());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name;
        final DetailListItemView authority;
        final DetailListItemView readPermission;
        final DetailListItemView writePermission;
        final DetailListItemView exported;


        ViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.item_provider_name);
            authority = (DetailListItemView) v.findViewById(R.id.item_provider_authority);
            readPermission = (DetailListItemView) v.findViewById(R.id.item_provider_read_permission);
            writePermission = (DetailListItemView) v.findViewById(R.id.item_provider_write_permission);
            exported = (DetailListItemView) v.findViewById(R.id.item_provider_exported);
        }
    }
}