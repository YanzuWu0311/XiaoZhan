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
            <h2>封禁名单</h2>
            <table>
                <tr>
                    <th style="width:200px;">用户编号</th>
                    <th style="width:200px;">用户名</th>
                </tr>
                <tr v-for="(user) in this.bannedList" :key="user.id">
                    <td>{{user.id}}</td>
                    <td>{{user.username}}</td>
                </tr>
            </table>
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
                bannedList:null
            }
        },
        created(){
            this.getBannedList();
        },
        methods: {
            getBannedList() {
                let success = (response) => {
                    this.bannedList = response.data;
                }
                utils.axiosMethod({
                    method: "GET",
                    url: "http://localhost:9090/bannedList",
                    callback: success
                })
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
    .template{
        background:#000
    }
</style>