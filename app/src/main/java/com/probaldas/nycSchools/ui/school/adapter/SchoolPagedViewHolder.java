package com.probaldas.nycSchools.ui.school.adapter;

import androidx.recyclerview.widget.RecyclerView;

import com.probaldas.nycSchools.databinding.SchoolListItemBinding;

public class SchoolPagedViewHolder extends RecyclerView.ViewHolder {

    private SchoolListItemBinding itemBinding;

    SchoolPagedViewHolder(SchoolListItemBinding itemBinding) {
        super(itemBinding.getRoot());
        this.itemBinding = itemBinding;
    }

    void bind(SchoolViewModel schoolViewModel) {
        this.itemBinding.setViewModel(schoolViewModel);
    }

    public SchoolListItemBinding getItemBinding() {
        return itemBinding;
    }
}
