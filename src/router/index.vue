<template>
    <div>
        <header id="header">
            <div id="page_top">
                <div class="bg-wrap">
                    <div class="bg"></div>
                    <div class="mask"></div>
                </div>
                <headertop/>
            </div>
            <header-c/>
        </header>
        <nav_top/>

        <ul style="margin:0 auto;width:1000px ">
            <li v-for="(thumb) in this.thumbsList" :key='thumb' style="margin:20px;float: left">
                <el-image
                        style="width: 200px; height: 120px"
                        :src="thumb.cover"
                        @click="openvideo(thumb.file,thumb.id,thumb.thumbs)"
                >
                </el-image>
                <p>{{thumb.title}}</p>

            </li>
        </ul>

    </div>
</template>
<script>
    import nav_top from "@/components/nav_top";
    import headertop from "@/components/Headertop";
    import HeaderC from "@/components/header-c";
    import utils from "@/utils/utils";

    export default {
        data() {
            return {
                thumbsList: []
            }
        },
        components: {
            HeaderC,
            headertop,
            nav_top,
        },
        created() {
            this.getThumbsList();
        },
        methods: {
            getThumbsList() {
                let success = (response) => {
                    this.thumbsList = response.data;
                }
                utils.axiosMethod({
                    method: "GET",
                    url: "http://localhost:9090/allvideo",
                    callback: success
                })
            },

            openvideo(url, id, thumb) {
                let msg = {
                    url: url,
                    id: id,
                    thumb: thumb
                }
                this.$store.commit('active', msg);
                this.$router.push({path: '/play'})
            },
            formatSeconds(value) {
                var secondTime = parseInt(value);// 秒
                var minuteTime = 0;// 分
                var hourTime = 0;// 小时
                if (secondTime > 60) {//如果秒数大于60，将秒数转换成整数
                    //获取分钟，除以60取整数，得到整数分钟
                    minuteTime = parseInt(secondTime / 60);
                    //获取秒数，秒数取佘，得到整数秒数
                    secondTime = parseInt(secondTime % 60);
                    //如果分钟大于60，将分钟转换成小时
                    if (minuteTime > 60) {
                        //获取小时，获取分钟除以60，得到整数小时
                        hourTime = parseInt(minuteTime / 60);
                        //获取小时后取佘的分，获取分钟除以60取佘的分
                        minuteTime = parseInt(minuteTime % 60);
                    }
                }
                var result = "" + parseInt(secondTime) + "秒";

                if (minuteTime > 0) {
                    result = "" + parseInt(minuteTime) + "分" + result;
                }
                if (hourTime > 0) {
                    result = "" + parseInt(hourTime) + "小时" + result;
                }
                return result;
            }

        },
    }
</script>
<style>
    @import "../assets/css/common.css";
    @import "../assets/css/index.css";
    @import "../assets/css/reset.css";
</style>

