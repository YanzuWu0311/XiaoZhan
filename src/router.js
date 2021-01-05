//引入vue
import Vue from 'vue';
//引入vue-router
import VueRouter from 'vue-router';
//第三方库需要use一下才能用
Vue.use(VueRouter)
//引用page1页面
import login  from './router/login.vue';
import register  from './router/register.vue';
import index  from './router/index.vue';
import userpage from './router/userpage';
import upload from "@/router/upload";
import animate from "@/router/animate";
import dance from "@/router/dance";
import guichu from "@/router/guichu";
import learn from "@/router/learn";
import music from "@/router/music";
import Science from "@/router/Science";
import Video from "@/router/Video";
import black from "@/router/black";
//定义routes路由的集合，数组类型
const routes=[
    {path:'/',redirect:'/index'},
    {path:'/login',component:login},
    {path:'/register',component:register},
    {path:'/index',component:index},
    {path:'/userpage',component:userpage},
    {path:'/upload',component:upload},
    {path:'/animate',component:animate},
    {path:'/guichu',component:guichu},
    {path:'/music',component:music},
    {path:'/Science',component:Science},
    {path:'/dance',component:dance},
    {path:'/learn',component:learn},
    {path:'/play',name:'play',component:Video},
    {path:'/black',component:black}
]

//实例化VueRouter并将routes添加进去
const router=new VueRouter({
//ES6简写，等于routes：routes
    routes
});

//抛出这个这个实例对象方便外部读取以及访问
export default router
