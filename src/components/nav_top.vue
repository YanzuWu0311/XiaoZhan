<template>
    <nav id="nav">
        <div class="page-width clearfix">
            <ul class="nav-list">
                <li class="item item-home">
                    <router-link to="/index" class="link">首页</router-link>
                </li>
                <li class="item">
                    <router-link to="/animate" class="link">
                        <div class="num"><i>{{numList[0]}}</i></div>
                        动画
                    </router-link>
                </li>
                <li class="item">
                    <router-link to="/music" class="link">
                        <div class="num"><i>{{numList[5]}}</i></div>
                        音乐
                    </router-link>
                </li>
                <li class="item">
                    <router-link to="/dance" class="link">
                        <div class="num"><i>{{numList[4]}}</i></div>
                        舞蹈
                    </router-link>
                </li>
                <li class="item">
                    <router-link to="/Science" class="link">
                        <div class="num"><i>{{numList[3]}}</i></div>
                        科技
                    </router-link>
                </li>
                <li class="item">
                    <router-link to="/learn" class="link">
                        <div class="num"><i>{{numList[1]}}</i></div>
                        学习
                    </router-link>
                </li>
                <li class="item">
                    <router-link to="/guichu" class="link">
                        <div class="num"><i>{{numList[2]}}</i></div>
                        鬼畜
                    </router-link>
                </li>

                <li class="item item-room">
                    <router-link to="/black" class="link">
                        小黑屋
                    </router-link>
                </li>
            </ul>
            <div class="nav-gif"><img src="../assets/images/cont/nav_img.gif" alt="求领养"></div>
        </div>
    </nav>
</template>

<script>

    import utils from "@/utils/utils";

    export default {
        name: "nav_top",
        data() {
            return {
                numList: []
            }
        },
        created() {
            this.getThumbsList();
        },
        methods: {
            getThumbsList() {
                let success = (response) => {
                    this.numList = response.data;
                }
                utils.axiosMethod({
                    method: "GET",
                    url: "http://localhost:9090/amount",
                    callback: success
                })
            }
        }
    }
</script>

<style scoped>

</style>
