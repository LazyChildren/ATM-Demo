<template>
  <div id="app" >
   <div class="background"></div>
   <div>
    <el-container>
      <el-header v-show="$route.meta.showheader" style="height: 100px"><Header/></el-header>
      <el-main> 
    <router-view/>
      </el-main>
    </el-container>
   </div>
    
    
  </div>
  
</template>

<script>
import Header from './components/Header.vue'



export default {
  name: "app",
  components: { Header},
  data() {
    return {
      bgurl: "https://www.z4a.net/images/2022/08/22/illust_65261833_20200924_234507.jpg",
    };
  },
  watch: {
    // 监听 $route 属性的变化
    $route(newValue) {
      console.log(newValue)
      this.$store.state.user = JSON.parse(sessionStorage.getItem('user'))
    },
  },
  created(){
    var ur = JSON.parse(sessionStorage.getItem('user'))
    if(ur === '')
    {
      this.$store.state.isLogin = false
      this.$router.push('/login')
    }
    else
    {
      this.$store.state.isLogin = true
      this.$store.state.user = ur
      if(ur.priority === 'cust')
      this.$router.push('/index')
      else
        this.$router.push('/admin')


    }
  }
};
</script>


<style scoped>
* {
  margin: 0px;
  padding: 0px;
}

.app{
  margin: 0px;
  padding: 0px;
  width: auto;
}

.el-main{
  margin-top: 30px;
  margin: 0px;
}

.el-footer{
  margin-top: 10px;
}


.background{
    width: 100%;
    height: 100%;
    position: fixed;
    filter: blur(5px);
    z-index: -1;
    margin: 0;
    padding: 0;
	border:0;
    background-size: cover;
    transform: scale(1.1);
    position: left 10%;
    background-image: url('https://www.z4a.net/images/2022/08/22/illust_65261833_20200924_234507.jpg');
    
 }
</style>

