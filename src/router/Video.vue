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
        <div style="width:900px; margin:0 auto">
            <!--
            <video :src="videoSrc" :poster="videoImg" :autoplay="playStatus" height="421" width="700" :muted="muteStatus">
              your browser does not support the video tag
            </video>
            <button @click="playClick" :class="{hide: isPlay}">点击播放</button> -->
            <!--class="video-js vjs-default-skin vjs-big-play-centered" -->
            <video :preload="preload"
                   :poster="videoImg" :height="height" :width="width" align="center" :controls="controls"
                   :autoplay="autoplay">
                <source :src="this.form.videoSrc" type="video/mp4">
            </video>
            <div style="float: left">
                <div style="float: left">
                    <el-button icon="el-icon-thumb" @click="up()"><p>{{form.thumb}}</p></el-button>
                    <el-button icon="el-icon-s-release" @click="reports()"><p>举报</p></el-button>
                </div>
                <el-form v-if="reportWindow" ref="report" :rules="report.rules" :model="report.form"
                         class="report-form">
                    <el-form-item style="float:left;width:580px">
                        <el-input v-model="report.form.Msg"></el-input>
                    </el-form-item>
                </el-form>
                <el-button style="float:right" v-if="reportWindow" icon="el-icon-s-promotion" @click="submitForm('report')"><p>提交</p></el-button>
            </div>
        </div>
    </div>
</template>

<script>
    import headertop from "@/components/Headertop";
    import utils from "@/utils/utils";

    export default {
        name: 'Video',
        components: {headertop},
        data() {
            return {
                report: {
                    form: {
                        Msg: "",
                        videoId: window.localStorage.getItem('videoid'),
                        userId: window.localStorage.getItem("UserId")
                    },
                    rules: {
                        Msg: [
                            {required: true, message: "举报信息不能为空", trigger: 'blur'},
                            {min: 1, max: 255, message: "信息过长", trigger: 'blur'}
                        ]
                    }
                },
                videoImg: '20201210163052.png',
                reportWindow: false,
                form: {
                    username: window.localStorage.getItem("Loginedname"),
                    id: window.localStorage.getItem("UserId"),
                    videoSrc: window.localStorage.getItem('active'),
                    videoId: window.localStorage.getItem('videoid'),
                    thumb: window.localStorage.getItem('thumb')
                },
                playStatus: '',
                muteStatus: '',
                isMute: true,
                isPlay: false,
                width: '820', // 设置视频播放器的显示宽度（以像素为单位）
                height: '500', // 设置视频播放器的显示高度（以像素为单位）
                preload: 'auto', //  建议浏览器是否应在<video>加载元素后立即开始下载视频数据。
                controls: true, // 确定播放器是否具有用户可以与之交互的控件。没有控件，启动视频播放的唯一方法是使用autoplay属性或通过Player API。
                autoplay: ''
            }
        },
        methods: {
            up() {
                let success = (response) => {
                    if (response.data.code === 1) {
                        this.form.thumb = (parseInt(this.form.thumb) + 1).toString();
                        this.$alert("点赞成功");
                    } else {
                        this.$alert("不要重复点赞");
                    }
                }
                utils.axiosMethod({
                    method: "POST",
                    url: "http://localhost:9090/ThumbUp",
                    data: {
                        userId: this.form.id,
                        videoId: this.form.videoId
                    },
                    callback: success
                })
            },
            reports() {
                if(this.reportWindow===false) {
                    this.reportWindow = true;
                }else{
                    this.reportWindow = false;
                }
            },
            submitForm(formName) {
                this.$refs[formName].validate(valid => {
                    if (valid) {
                        console.log(valid);
                        let success = (response) => {
                            if (response.data.code === 0) {
                                this.$alert("提交失败");
                            } else {
                                this.$alert("提交成功");
                            }
                        }
                        utils.axiosMethod({
                            method: "POST",
                            url: "http://localhost:9090/Report",
                            data: this.report.form,
                            callback: success
                        })
                        // 通过的逻辑
                    } else {
                        console.log('验证失败');
                        return false;
                    }
                });
            },
        }

        // 自动播放属性,muted:静音播放
        // autoplay: 'muted',

    }


</script>

<style scoped>
    .report-form {
        width: 600px;
        margin-left:20px;
        border-radius: 20px; /* 圆角 */
        float: left
    }
</style>