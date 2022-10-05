<template>
  <div class="footer">
    <el-row>
      <el-col :span="3" ><el-link type="info" icon="el-icon-s-promotion" :underline="false">关于我们</el-link></el-col>
      <el-col :span="3" ><el-link type="info" icon="el-icon-suitcase"  :underline="false">商务合作</el-link></el-col>
      <el-col :span="3" ><el-link type="info" icon="el-icon-s-custom"  :underline="false" >在线客服</el-link></el-col>
      <el-col :span="5" ><el-link type="info" icon="el-icon-phone-outline"  :underline="false" >156-7115-1238</el-link></el-col>
      <el-col :span="5" ><el-link type="info" icon="el-icon-chat-round"  :underline="false" >1204694006@qq.com</el-link></el-col>
      
    </el-row>

      


  </div>
</template>

<script>
export default {
 
};
</script>

<style scoped>


.footer{
    height: 60px;
    width: 60%;
    background-color: rgba(0,0, 0, 0.3);
    margin: 0 auto;
    border-radius: 6px;
}



.el-col {
    margin-top: 15px;
    margin-left: 22px;

}

</style>