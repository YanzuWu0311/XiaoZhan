import Vue from 'vue'
import App from './App.vue'
import router from './router.js'
import axios from 'axios'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import store from './utils/store';
import VuePreview from 'vue-preview';
import VideoPlayer from 'vue-video-player'
require('video.js/dist/video-js.css');
require('vue-video-player/src/custom-theme.css');
Vue.use(VideoPlayer)
Vue.use(VuePreview);

Vue.use(ElementUI);

Vue.config.productionTip = false;
Vue.http = Vue.prototype.$http = axios;
new Vue({
  router,
  store,
  render: h => h(App),
}).$mount('#app')
