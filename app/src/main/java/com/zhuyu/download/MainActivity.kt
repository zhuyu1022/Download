package com.zhuyu.download

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zhuyu.downloadlibrary.DownloadDialog
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startBtn.onClick {

            val url = "http://gdown.baidu.com/data/wisegame/caf555e29862078f/wangyixinwen_1026.apk"

            val filename = url.substring(url.lastIndexOf("/") + 1)
            // 文件保存在应用关联缓存目录
            val filePath = getExternalFilesDir(null)?.absolutePath + "/" + filename
            val dowDialog = DownloadDialog.newInstance(url, filePath, true)
            dowDialog.setDownloadListener(object : DownloadDialog.DownloadSimpleListener {

                override fun onSuccess() {
                    toast("下载完成！")
                }

                override fun onError() {
                    toast("下载失败！")
                }
            })
            dowDialog.show(supportFragmentManager, "DownLoad")

        }
    }


}
