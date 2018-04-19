package com.example.nguyenkhoahung.rentalroommanagement;

import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.nguyenkhoahung.rentalroommanagement.viewbinder.Id;
import com.example.nguyenkhoahung.rentalroommanagement.viewbinder.Layout;
@Layout(R.layout.activity_calculate_rent_money)
public class CalculateRentMoney extends BaseActivity {
    @Id(R.id.tvPreviousElectricNumber)
    private TextView tvPreviourElectricNumber;

    @Id(R.id.toolbar)
    private Toolbar toolbar;
    @Override
    protected void onInitView() {
        super.onInitView();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        findViewById(R.id.btnBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}
