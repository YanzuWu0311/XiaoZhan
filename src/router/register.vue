<template>

    <div class="login-container">

        <header>
            <div id="page_top">
                <div class="bg-wrap">
                    <div class="mask"></div>
                    <div class="back-blue"></div>
                </div>
                <headertop/>
                <div class="top-banner">
                    <img src="../assets/images/loginbanner.png" class="banner-l">
                </div>

            </div>

        </header>

        <el-form ref="form" :rules="rules" :model="form" label-width="80px" class="login-form">
            <el-form-item label="用户名" prop="username">
                <el-input v-model="form.username"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input v-model="form.password"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('form')">注册</el-button>
                <el-button type="primary" @click="toLogin()">去登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import headertop from "@/components/Headertop";
    import utils from "@/utils/utils";

    export default {
        components: {headertop},
        data() {
            return {
                form: {
                    username: "",
                    password: ""
                },
                rules: {
                    username: [
                        {required: true, message: "用户名不能为空", trigger: 'blur'},
                        {min: 3, max: 10, message: "用户名3-5位", trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: "密码不能为空", trigger: 'blur'},
                        {min: 3, max: 10, message: "密码3-5位", trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate(valid => {
                    // console.log(valid) 验证通过为true，有一个不通过就是false
                    if (valid) {
                        let success = (response) => {
                            if (response.data.code === 1) {
                                this.$alert("已有此用户");
                            } else {
                                this.$alert("注册成功");
                            }
                        }
                        utils.axiosMethod({
                            method: "POST",
                            url: "http://localhost:9090/register",
                            data: this.form,
                            callback: success
                        })
                    } else {
                        console.log('验证失败');
                        return false;
                    }
                });
            },
            toLogin() {
                this.$router.push('/login')
            }
        }
    };
</script>

<style acoped>
    @import "../assets/css/common.css";
    @import "../assets/css/index.css";
    @import "../assets/css/reset.css";

    .login-form {
        width: 350px;
        margin: 150px auto; /* 上下间距160px，左右自动居中*/
        background-color: rgba(255, 255, 255, .8); /* 透明背景色 */
        padding: 30px;
        border-radius: 20px; /* 圆角 */
    }

    /* 背景 */
    .login-container {
        width: 100%
    }

    .top-banner {
        background-color: rgb(0, 160, 216);
        width: 100%;
        height: 86px;
    }

    .banner-l {
        margin: 0 auto
    }
    .back-blue{
        position: absolute;
        top: -10px;
        width: 100%;
        height: 100px;
        background: rgb(0, 160, 216) no-repeat center -10px;;

        filter: blur(5px);
        -webkit-filter: blur(5px);
    }
</style> -->
