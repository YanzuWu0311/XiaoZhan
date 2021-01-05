<template>
  <div id="app">



  <div id="main" >
    <router-view></router-view>
  </div>

<footer_under/>


  </div>
</template>

<script>


 import footer_under from "@/components/footer";
export default {
  name: 'App',
 components: {
  footer_under,
 }
}
</script>

<style>
  @import "assets/css/common.css";
  @import "assets/css/index.css";
  @import "assets/css/reset.css";
#main {
  text-align: center;
}
</style>
