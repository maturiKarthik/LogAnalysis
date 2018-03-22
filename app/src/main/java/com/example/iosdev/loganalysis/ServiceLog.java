package com.example.iosdev.loganalysis;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by iosdev on 22/03/2018.
 * THIS CLASS EXTENDS THE SERVICE CLASS AND OVERTIDES THE METHEOD
 * ALSO KEPT IN MANIFEST
 */

public class ServiceLog extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {




                Log.d("service",""+LogUtils.readLogs());
               // Function to Create the files in directory ..
                getPublicAlbumStorageDir("Logs_APPXX","app_fast12.txt",LogUtils.readLogs());

        Toast.makeText(this,"FILE HAS BEEN WRITTTEN IN SERVICE",Toast.LENGTH_LONG).show();

        return super.onStartCommand(intent, flags, startId);

    }



    /**
     *
     *  getPublicAlbumStorageDir function
     *  will create and write the file in the directory you want ..
     */

    public File getPublicAlbumStorageDir(String dirName,String filename_ext,StringBuilder content) {

        /*
         * THE Environment.getExternalStorageDirectory() GET DIR(PIC/IMAGES..ETC)
         */
        File file_dir = new File(Environment.getExternalStorageDirectory(), dirName);
        if (!file_dir.mkdirs()) {
            Log.e("LOG_TAG", "Directory not created");
        }

        /*
         * Creates a File the Directory you want
         * THIS CREATES THE COMPLETE FILE PATH
         */
        File filepath = new File(file_dir,filename_ext);

        try{
            FileWriter fileWriter = new FileWriter(filepath);
            fileWriter.write(content.toString());
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }




        return file_dir;
    }



}


