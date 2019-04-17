package ml.uncoded.yts.searchyoutube;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long lastBackPressTime=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tvMob=findViewById(R.id.tv_mobno);
        TextView tvCapture=findViewById(R.id.tv_capture);
        ImageView imageView=findViewById(R.id.imageView);
        Button btnLogout=findViewById(R.id.btn_logout);
        final SharedPrefrenceUser sharedPrefrenceUser=new SharedPrefrenceUser(MainActivity.this);
        tvMob.setText(sharedPrefrenceUser.getKeyPhone());
        tvCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ImgCaptureActivity.class));
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefrenceUser.logout();
                Toast.makeText(MainActivity.this, "User Logged out Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ImgCaptureActivity.class));
            }
        });

    }
    @Override
    public void onBackPressed() {
        Toast toast = Toast.makeText(this, "Press back again to close this app",Toast.LENGTH_SHORT);
        if (this.lastBackPressTime < System.currentTimeMillis() - 2000) {
            toast.show();
            this.lastBackPressTime = System.currentTimeMillis();
        } else {
            if (toast != null) {
                toast.cancel();
            }
            this.lastBackPressTime = 0;
            finishAffinity();
        }
    }
}
