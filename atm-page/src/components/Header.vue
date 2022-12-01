<template>
  <div >
    <div class="top-head">
      <el-row>
      <el-col :span="2" :offset="4"
        > <el-link type="primary"  icon="el-icon-umbrella" @click="homepage()">主页</el-link>
        </el-col
      >
      <el-col :span="2" :offset="3" v-show="this.$store.state.isAdmin"><el-link type="primary" icon="el-icon-guide" @click="routerChange('/userlist')">用户列表</el-link></el-col>
     
      <el-col :span="2" :offset="3" v-show="this.$store.state.isLogin"><el-link type="success" icon="el-icon-user" @click="routerChange('/info')">{{this.$store.state.user.username}}</el-link></el-col>
      
      <el-col :span="2" :offset="8" v-show="!this.$store.state.isLogin"><el-link type="success" icon="el-icon-guide" @click="routerChange('/login')">登陆/注册</el-link></el-col>

      <el-col :span="2" :offset="3" v-show="this.$store.state.isLogin"><el-link type="danger" icon="el-icon-close" @click="logout">退出</el-link></el-col>
    </el-row>
      
     
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      drawer: false,
      direction: "ltr",
      circleUrl:
        "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      
    };
  },
  methods:{

    logout() {
      this.$axios.get("/ATM/logout").then(res => {
        console.log(res)
        this.$store.commit("LOG_OUT")
         this.$message({
          message: '退出成功',
          type: 'success'
        });
        this.$router.push("/login")

      })
    },
    wip(){
      this.$message({
          message: '功能开发中，敬请期待!',
        });
    },
    routerChange(name) {
      this.$router.push(name)
    },
    homepage(){
      if(this.$store.state.user.priority === 'cust')
        this.$router.push('/index')
      else
        this.$router.push('/admin')
    }
    
  },
  created() {
    this.$store.commit('refresh');
  }
};
</script>

<style scoped>

* {
  margin: 0px;
  padding: 0px;
}

.el-row {
  height: 100px;
  width: 100%;
  flex-wrap: wrap;
  position: absolute;
}

.top-head {
  height: 100px;
  width: auto;
  background-color: rgba(0, 0, 0, 0.7);
  z-index: -1;
}

.logo-image {
  height: 85px;
}

.el-icon-menu {

  padding-left: 20px;
}

.el-icon-menu:hover {
  cursor: pointer;
}


.demo-basic--circle {
  margin: 0 auto;
}


.bg-purple-dark {
  background: #99a9bf;
}


.grid-content {
  border-radius: 4px;
  min-height: 36px;
}

.el-col{
  padding-top: 40px;
}

.logo{
  padding-top: 0px;
}

</style>