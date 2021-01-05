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
                    url: "http://localhost:9090/music",
                    callback: success
                })
            },
            openvideo(url,id,thumb){
                let msg ={
                    url:url,
                    id:id,
                    thumb:thumb
                }
                this.$store.commit('active',msg);
                this.$router.push({path:'/play'})
            }
        },
    }
</script>
<style>
    @import "../assets/css/common.css";
    @import "../assets/css/index.css";
    @import "../assets/css/reset.css";
</style>