
import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex)

const state = {
    // 登录状态为没登录
    logined: false,
    // 用户信息数据
    Loginedname: null,
    UserId: null,
    active: null,
    videoid:null,
    isActive:false,
    thumb:null
}

var mutations={
    LOGIN (state,user) {
        // 登录
        // 先让登录状态变为登录了
        // 若只是改变state里的值，在强制刷新后会丢失，数据添加到sessionStorage里
        localStorage.setItem("Loginedname", user.Loginedname)
        localStorage.setItem("UserId", user.UserId)
       localStorage.setItem("logined", true)
        state.Loginedname = user.Loginedname
        state.UserId = user.UserId
        state.logined = true
    },

    // 登出
    LOGOUT (state) {
        // 这个同理
        localStorage.removeItem("Loginedname")
        localStorage.removeItem("UserId")
        localStorage.removeItem("logined")
        state.Loginedname = ''
        state.UserId = ''
        state.logined = false
    },
    active(state,msg){
        if(!state.isActive) {
            localStorage.setItem("active", msg.url)
            localStorage.setItem("isActive",true)
            localStorage.setItem("videoid",msg.id)
            localStorage.setItem("thumb",msg.thumb)
            state.active=msg.id;
            state.videoid=msg.id;
            state.thumb=msg.thumb;
        }else{
            localStorage.removeItem("active");
            localStorage.removeItem("videoid")
            localStorage.setItem("active", msg.url)
            localStorage.setItem("videoid",msg.id)
            state.active=msg.url;
            state.videoid=msg.id;
            state.thumb=msg.thumb;
        }

    }
}
var getters={
    isLogin (state) {
        if (!state.logined) {
            state.logined=localStorage.getItem('logined');   //从sessionStorage中读取状态
            state.Loginedname=localStorage.getItem('Loginedname');
            state.UserId=localStorage.getItem('UserId');
        }
        return state.logined
    }
}
export default new Vuex.Store({
    getters,
    state,
    mutations
})
