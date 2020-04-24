package net.fze.mzl.board

import io.quarkus.runtime.Application
//import javax.ws.rs.ApplicationPath

//@ApplicationPath("/")
class Main:Application(){
    override fun doStart(args: Array<out String>?) {
        println("[ App][ Log]: app started")
    }

    override fun doStop() {
        println("[ App][ Log]: app stopped")
    }
    override fun getName(): String {
        return "main";
    }
}