<template>
    <div>
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
        <div style="margin:120px auto">
            <el-form class="upform" >
                <el-form-item required>
                    <el-input v-model="title" placeholder="请输入视频标题"  auto-complete="off" class="el-col-width" required></el-input>
                </el-form-item>
                <el-form-item>
                    <el-upload
                            style="display:inline-block"
                            :limit="1"
                            class="upload-demo"
                            ref="upload1"
                            accept=".png,.jpg"
                            :file-list="fileList"
                            :http-request="uploadImgFile"
                            :auto-upload="false"
                            action="">
                        <el-button slot="trigger" size="small" type="primary" plain>选取封面</el-button>
                    </el-upload>
                </el-form-item>
                <el-form-item>
                    <el-upload
                            style="display:inline-block"
                            :limit="1"
                            class="upload-demo"
                            ref="upload2"
                            accept=".mp4"
                            :file-list="fileList"
                            :http-request="uploadVideoFile"
                            :auto-upload="false" action="">
                        <el-button slot="trigger" size="small" type="primary" plain>选取视频</el-button>
                    </el-upload>
                </el-form-item>
                <el-form-item>
                    <el-select v-model="type" placeholder="请选择分区">
                        <el-option  v-for="item in options" :key="item.value" :label="item.label"
                                    :value="item.value"></el-option>
                    </el-select>

                </el-form-item>
                <el-button  size="block"  type="success" @click="submitUpload">提交</el-button>
            </el-form>
        </div>
    </div>
</template>
<script>
    import headertop from "@/components/Headertop";
    import utils from "@/utils/utils";

    export default {
        components: {headertop},
        data() {
            return {
                type:"",
                options:[
                    {label:"动画" ,value:'0'},
                    {label:"学习" ,value:'1'},
                    {label:"鬼畜" ,value:'2'},
                    {label:"科技" ,value:'3'},
                    {label:"舞蹈" ,value:'4'},
                    {label:"音乐" ,value:'5'},
                ],
                btnText:"点击上传视频",
                enableUploadBtn:false,
                title:"",
                fileList:null,
                username:window.localStorage.getItem("Loginedname"),
                fileData:new FormData()
            };
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate(valid => {
                    if (valid) {
                        // 通过的逻辑
                    } else {
                        console.log('验证失败');
                        return false;
                    }
                });
            },
            toRegister() {
                this.$router.push('/register')
            },
            submitUpload() {
                this.fileData.append("up",this.username);
                this.fileData.append("title",this.title);
                this.fileData.append("type",this.type);
                this.$refs.upload1.submit();
                this.$refs.upload2.submit();
                let success = (response) => {
                    if (response === "error") {
                        this.$alert("error");
                    } else {
                        this.$alert(response.data);
                    }
                };
                utils.axiosMethod({
                    method: "POST",
                    url: "http://localhost:9090/upload",
                    data: this.fileData,
                    callback: success
                })
            },
            uploadImgFile(param){
                var fileObj = param.file;
                // FormData 对象
                // 文件对象
                this.fileData.append("uploadimg", fileObj);
            },
            uploadVideoFile(param){
                var fileObj = param.file;
                // FormData 对象
                // 文件对象
                this.fileData.append("uploadvideo", fileObj);
            }

        }
    };
</script>

<style scoped>
    @import "../assets/css/common.css";
    @import "../assets/css/index.css";
    @import "../assets/css/reset.css";
    .upform{
        width: 500px;
        margin:0 auto;
    }
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

    .back-blue {
        position: absolute;
        top: -10px;
        width: 100%;
        height: 100px;
        background: rgb(0, 160, 216) no-repeat center -10px;;

        filter: blur(5px);
        -webkit-filter: blur(5px);
    }
</style> -->
