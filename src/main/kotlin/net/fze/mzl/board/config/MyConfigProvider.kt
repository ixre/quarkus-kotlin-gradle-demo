package net.fze.mzl.board.config

import com.moandjiezana.toml.Toml
import org.eclipse.microprofile.config.spi.ConfigSource
import java.io.File

class MyConfigProvider : ConfigSource {
    private var _toml: Toml? = null
    init{
//        var userDir = System.getenv("user.dir")
//        if(userDir.isNullOrEmpty())userDir = "./"
//        println("---"+userDir)
//        val fi = File(userDir + "app.conf")
//        this._toml = Toml().read(fi)
    }
    override fun getName(): String {
        return "default"
    }

    override fun getOrdinal(): Int {
        return 450
    }
    override fun getValue(propertyName: String?): String {
        return "abc"

//        println(this._toml == null)
//        return this._toml?.getString(propertyName)?:""
    }

    override fun getProperties(): MutableMap<String, String> {
        return mutableMapOf<String, String>()
        var mp = mutableMapOf<String, String>()
        this._toml!!.toMap().forEach {
            mp[it.key] = it.value.toString()
        }
        return mp
    }

}