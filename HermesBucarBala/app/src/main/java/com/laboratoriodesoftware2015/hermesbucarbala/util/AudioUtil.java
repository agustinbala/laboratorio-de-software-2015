package com.laboratoriodesoftware2015.hermesbucarbala.util;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.widget.Toast;

import com.laboratoriodesoftware2015.hermesbucarbala.R;

import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by AGUSTIN.BALA on 13-12-15.
 */
public class AudioUtil {


    public static void reproduce(Context context ,String audio) {
        try {
            MediaPlayer m = new MediaPlayer();
            AssetFileDescriptor afd = context.getAssets().openFd(audio);
            m.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            m.prepare();
            m.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
