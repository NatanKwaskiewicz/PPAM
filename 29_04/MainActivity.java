package com.example.a29_04;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity {

    Integer[] images = {
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7,
            R.drawable.img8,
            R.drawable.img9,
            R.drawable.img10,
            R.drawable.img11,
            R.drawable.img12,
            R.drawable.img13,
            R.drawable.img14,
            R.drawable.img15,
            R.drawable.img16
    };

    public static class ImageDialog extends DialogFragment {
        private static final String ARG_RES_ID = "res_id";

        public static ImageDialog newInstance(int resId) {
            ImageDialog dialog = new ImageDialog();
            Bundle args = new Bundle();
            args.putInt(ARG_RES_ID, resId);
            dialog.setArguments(args);
            return dialog;
        }

        @Override
        public void onStart() {
            super.onStart();
            if (getDialog() != null && getDialog().getWindow() != null) {
                getDialog().getWindow().setLayout(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
            }
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater,
                                 @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            ImageView img = new ImageView(getContext());
            assert getArguments() != null;
            img.setImageResource(getArguments().getInt(ARG_RES_ID));
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            img.setAdjustViewBounds(true);
            return img;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LinearLayout linearLayout = findViewById(R.id.linearLayout);
        for (Integer image : images) {
            ImageView localView = new ImageView(this);
            localView.setLayoutParams(new ViewGroup.LayoutParams(700, 700));
            localView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            final Integer resId = image;
            localView.setImageResource(resId);

            localView.setOnClickListener(v -> ImageDialog.newInstance(resId).show(getSupportFragmentManager(), "image_dialog"));
            linearLayout.addView(localView);
        }
    }
}