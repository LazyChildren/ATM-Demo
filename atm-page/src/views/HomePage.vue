<template>
  <div class="block">
    <el-row v-if="this.$store.state.isLogin">
      <el-col :span="5" :offset="3"
        ><el-button type="primary" plain @click="ruleForm.count = '',saveVisible=true">存款</el-button></el-col
      >
      <el-col :span="5" :offset="3"
        ><el-button type="primary" plain @click="ruleForm.count = '',dropVisible = true">取款</el-button></el-col
      >
      <el-col :span="5" :offset="3"
        ><el-button type="primary" plain @click="getVisible = true">查询余额</el-button></el-col
      >
      

      <el-dialog title="存款" :visible.sync="saveVisible" :width="formWidth">
  <el-form :model="ruleForm" :rules="rules"
        ref="ruleForm">
    <el-form-item label="金额" :label-width="formLabelWidth" prop="count">
      <el-input v-model="ruleForm.count" autocomplete="off"></el-input>
    </el-form-item>
    
  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button @click="saveVisible = false">取 消</el-button>
    <el-button type="primary" @click=save()>确 定</el-button>
  </div>
</el-dialog>
<el-dialog title="取款" :visible.sync="dropVisible" :width="formWidth">
  <el-form :model="ruleForm" :rules="rules"
        ref="ruleForm">
    <el-form-item label="金额" :label-width="formLabelWidth" prop="count">
      <el-input v-model="ruleForm.count" autocomplete="off"></el-input>
    </el-form-item>
    
  </el-form>
  <div slot="footer" class="dialog-footer">
    <el-button @click="dropVisible = false">取 消</el-button>
    <el-button type="primary" @click=drop()>确 定</el-button>
  </div>
</el-dialog>
<el-dialog title="余额" :visible.sync="getVisible" :width="formWidth">
  <span>您的余额为:{{this.$store.state.user.amount}}元</span>
  <div slot="footer" class="dialog-footer">
    <el-button type="primary" @click="getVisible = false">确 定</el-button>
  </div>
</el-dialog>
      
    </el-row>
   
      <el-row v-if="!this.$store.state.isLogin">
        <el-col :span="12"  :offset="6"> <span>欢迎来到中商银行ATM服务中心,请登录以进行下一步操作。</span></el-col>
      </el-row>
  </div>
</template>

<script>
export default {
  name: "homepage",
  data() {
    return {
      
      formLabelWidth: '90px',
      formWidth: '400px',
      saveVisible: false,
      dropVisible: false,
      getVisible: false,
      ruleForm:{
        count: '',

      },
      rules: {
        count:[{required:true, pattern: /^[1-9]\d*00$/, message: "需要是100的整数倍", trigger: "blur"}]
        
      },
    };
  },

  methods: {
    save(){
      this.$refs['ruleForm'].validate((valid) => {
        if (valid) {
          console.log('save');
      this.$axios.post('/ATM/save',this.ruleForm).then((res) => {
      //this.$store.commit("SET_USER", res.data.data.user);
      //this.$store.commit("SET_USERINFO", res.data.data.userinfo);
      console.log(res);
      this.$store.state.user = res.data.data;
      this.$message({
        type: 'success',
        message: '存款成功: ' + this.ruleForm.count + '元',
      })
      this.saveVisible = false;
      });
        }
        else
        {
          this.$message({
            type: 'error',
            message: '异常输入',
          })
        }
      })
      
          
    } ,
    
    drop(){
      this.$refs['ruleForm'].validate((valid) => {
        if (valid) {
          console.log('save');
      this.$axios.post('/ATM/drow',this.ruleForm).then((res) => {
      //this.$store.commit("SET_USER", res.data.data.user);
      //this.$store.commit("SET_USERINFO", res.data.data.userinfo);
      console.log(res);
      this.$store.state.user = res.data.data;
      this.$message({
        type: 'success',
        message: '取款成功: ' + this.ruleForm.count + '元',
      })
      this.dropVisible = false;
      
      });
        }
        else
        {
          this.$message({
            type: 'error',
            message: '异常输入',
          })
        }
      })
      
    },
    get(){
      
    }
  },
};
</script>


<style scoped>
.block {
  margin: 0 auto;
  margin-top: 50px;
  height: 200px;
  width: 60%;
  border-radius: 6px;
  background-color: rgba(255, 255, 255, 0.7);
}

.el-timeline {
  padding-top: 30px;
}

.el-card {
  margin-right: 50px;
}

.el-pagination {
  padding-bottom: 30px;
}

.el-row {
  padding-top: 50px;
}
</style>