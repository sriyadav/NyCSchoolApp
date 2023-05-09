package com.probaldas.nycSchools.ui.details;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProviders;

import com.probaldas.nycSchools.R;
import com.probaldas.nycSchools.databinding.SchoolDetailsFragmentBinding;
import com.probaldas.nycSchools.models.SchoolDetails;
import com.probaldas.nycSchools.ui.school.adapter.SchoolListPagedAdapter;

public class SchoolDetailsFragment extends DialogFragment {
    private static final String TAG = SchoolDetailsFragment.class.getSimpleName();
    private SchoolDetailsViewModel mViewModel;
    private SchoolDetailsFragmentBinding binding;

    public static SchoolDetailsFragment newInstance() {
        return new SchoolDetailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.school_details_fragment, container, false);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SchoolDetailsViewModel.class);

        if (getArguments() != null) {
            SchoolDetails schoolDetails = getArguments().getParcelable(SchoolListPagedAdapter.SCHOOL_DETAILS);
            binding.setSchoolDetails(schoolDetails);

            mViewModel.getSatScore(schoolDetails.getDbn()).observe(this, satScores -> {
                if (satScores == null) {
                    binding.satBodyCL.setVisibility(View.GONE);
                    binding.satNoResultBodyCL.setVisibility(View.VISIBLE);
                } else {
                    binding.setSatScores(satScores);
                    binding.satBodyCL.setVisibility(View.VISIBLE);
                    binding.satNoResultBodyCL.setVisibility(View.GONE);
                }
            });

            binding.phoneButton.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + schoolDetails.getPhoneNumber()));
                startActivity(intent);
            });

            binding.websiteButton.setOnClickListener(v -> {
                String website = "";
                if (schoolDetails.getWebsite().contains("http")) {
                    website = schoolDetails.getWebsite();
                } else {
                    website = "https://" + schoolDetails.getWebsite();
                }
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                startActivity(intent);
            });

            binding.emailButton.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{schoolDetails.getSchoolEmail()});
                startActivity(intent);
            });

            binding.mapButton.setOnClickListener(v -> {
                String uri = "geo:"
                        + schoolDetails.getLatitude() + ","
                        + schoolDetails.getLongitude() + "?q="
                        + schoolDetails.getSchoolName() + ", "
                        + schoolDetails.getPrimaryAddressLine1() + ", "
                        + schoolDetails.getCity() + ", "
                        + schoolDetails.getStateCode();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            });

            binding.closeButton.setOnClickListener(v -> {
                this.dismiss();
            });
        }

    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setLayout(width, height);
        }
    }
}
