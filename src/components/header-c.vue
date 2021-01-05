<template>
  <div class="header-c">
    <div class="page-width">
      <a href="#" id="header_logo"></a>
      <p id="header_title"></p>
      <div id="search" class="clearfix">
        <div class="search-rank">排行榜</div>
        <div class="search-box">
          <input type="text" class="text" placeholder="Search here...">
          <a href="#" class="btn"><i></i></a>
          <div class="search-history">
          </div>
        </div>
      </div>
    </div>
    <div class="header-title">哔哩哔哩 (゜-゜)つロ 干杯~</div>
  </div>
</template>

<script>
export default {
  name: "header-c",
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  @import "../assets/css/common.css";
  @import "../assets/css/index.css";
  @import "../assets/css/reset.css";
</style>
