package com.fourteen.piao.app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class MainActivity extends Activity {

    private Button buttonNext = null;
    private Button buttonSampleVideo = null;
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private String str_tmp = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ImageView img= (ImageView) findViewById(R.id.imageView);


//        img.setImageResource(R.drawable.my_image);

//        String sUrl = "";
//        sUrl = "http://10.0.0.2/web/upload_files/1_1361325593_9134826.jpg";
//        sUrl = "http://edu-tms.com/maipiao.biz/web/upload_files/1_20140317160314_tcorc_jpg.bmp";
//        sUrl = "http://www.edu-tms.com/maipiao.biz/web/upload_files/sublime_control.png";


        try {

            buttonNext = (Button)findViewById(R.id.btnNext);
            buttonNext.setText( "Next" );
            buttonNext.setOnClickListener(new btnNextListener());

            System.out.println("me ...");
            buttonSampleVideo = (Button)findViewById(R.id.btnDemoVideo);
            buttonSampleVideo.setOnClickListener(new btnDemoVideoListener() );


            //--------------------------------------option start
//            DisplayImageOptions options = new DisplayImageOptions.Builder()
//                    .cacheInMemory(true).cacheOnDisc(true)
//                    .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
//                    .bitmapConfig(Bitmap.Config.RGB_565)// 防止内存溢出的，图片太多就这这个。还有其他设置 //如Bitmap.Config.ARGB_8888
//                    .showImageOnLoading(R.drawable.ic_launcher)   //默认图片
//                    .showImageForEmptyUri(R.drawable.ic_launcher)    //url爲空會显示该图片，自己放在drawable里面的
//                    .showImageOnFail(R.drawable.ic_launcher)// 加载失败显示的图片
//                    .displayer(new RoundedBitmapDisplayer(5))  //圆角，不需要请删除
//                    .build();
            //--------------------------------------option end

            //--------------------------------------config start
//            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
//                    this)
//                    .memoryCacheExtraOptions(480, 800)// 缓存在内存的图片的宽和高度
//                    //.discCacheExtraOptions(480, 800, Bitmap.CompressFormat.PNG, 70,null)//CompressFormat.PNG类型，70质量（0-100）
//                    .memoryCache(new WeakMemoryCache())
//                    .memoryCacheSize(2 * 1024 * 1024) //缓存到内存的最大数据
//                    .discCacheSize(50 * 1024 * 1024).  //缓存到文件的最大数据
//                            discCacheFileCount(1000)            //文件数量
//                    .defaultDisplayImageOptions(options).  //上面的options对象，一些属性配置
//                            build();
            //----------------------------------------config end
//            ImageLoader.getInstance().init(config); //初始化


//            ImageLoader.getInstance().displayImage(sUrl, img);
        } catch (Exception e) {
            str_tmp = e.getMessage();
            e.printStackTrace();
//            Log.d("debug info", e.getMessage());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

                // the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    //the button jump to next activity through this intent
    private class btnNextListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, NextActivity.class);
            MainActivity.this.startActivity(intent);
        }
    }

    private class btnDemoVideoListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            try {
                Intent intentDemoVideo = new Intent();
                intentDemoVideo.setClass(MainActivity.this, VideoPlayActivity.class);
//                MainActivity.this.startActivity(intentDemoVideo);
                startActivity(intentDemoVideo);
                MainActivity.this.finish();
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("debug info", e.getMessage());
            } finally {
            }
        }


    }


//    private void startImagePagerActivity(int position) {
//        Intent intent = new Intent(this, ImagePagerActivity.class);
//        intent.putExtra(Extra.IMAGES, imageUrls);
//        intent.putExtra(Extra.IMAGE_POSITION, position);
//        startActivity(intent);
//    }


}
