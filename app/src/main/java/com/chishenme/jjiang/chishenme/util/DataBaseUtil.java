package com.chishenme.jjiang.chishenme.util;

import android.content.Context;
import com.chishenme.jjiang.chishenme.MyApp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/**
 * Created by A16343 on 2016/8/22.
 */
@SuppressWarnings("DefaultFileTemplate")
public class DataBaseUtil {
    /**
     * 将asset资源拷贝到指定路径的File中
     *
     * @param fileName
     */
    public static void copyAsset2File(String fileName) {
        Context context = MyApp.applicationContext();
        RandomAccessFile write = null;
        BufferedInputStream bis = null;
        InputStream is = null;

        File file = new File(getDataBaseName(fileName));
        try {
            boolean createFileSuccess;
            if (file.exists()) {
                file.delete();
                createFileSuccess = file.createNewFile();
            } else {
                createFileSuccess = file.createNewFile();
            }
            if (createFileSuccess) {
                write = new RandomAccessFile(file, "rwd");
                // 测试数据库
                is = context.getAssets().open(fileName);
                bis = new BufferedInputStream(is);
                byte[] buf = new byte[1024];
                while (bis.read(buf) != -1) {
                    write.write(buf);
                }
                write.close();
                bis.close();
                is.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (write != null) {
                    write.close();
                }
                if (bis != null) {
                    bis.close();
                }
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getDataBaseName(String file) {
        return MyApp.applicationContext().getDatabasePath(file).getAbsolutePath();
    }
}
