<template>
    <div class="header-top">
        <div class="page-width clearfix">
            <div class="header-top__nav">
            </div>
            <div class="header-top__user">
                <div class="login-box">
                    <router-link to="/index" v-if="logined">{{this.form.username}}</router-link>
                    <a @click="LOGOUT()" v-if="logined">登出</a>
                    <router-link to="/login" v-if="!logined">登录</router-link>
                    <span></span>
                    <router-link to="/register" v-if="!logined">注册</router-link>
                </div>
                <div class="user-post">
                    <button @click="toUpload" class="link">投 稿</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Headertop",
        data() {
            return {
                form: {
                    username: window.localStorage.getItem("Loginedname"),
                    id:window.localStorage.getItem("UserId")
                },
                logined: false
            };
        },
        created:function(){
            if(this.form.username){
                this.logined=true;
            }
        },
        methods:{
            toUpload:function(){
                if(this.logined){
                    this.$router.push("/upload")
                }else{
                    this.$router.push("/login")
                }
            },
            LOGOUT(){
                this.$store.commit('LOGOUT');
                this.$router.push('/login')
            }
        }
    }
</script>

<style scoped>

</style>
