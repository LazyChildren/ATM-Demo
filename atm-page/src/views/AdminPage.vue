<template>
    <div class="block">
        <el-table
      :data="users"
      style="width: 100%">
      <el-table-column
        prop="userid"
        label="id"
        width="150">
      </el-table-column>
      <el-table-column
        prop="username"
        label="用户名"
        width="150">
      </el-table-column>
      <el-table-column
        prop="password"
        label="密码"
        width="150">
      </el-table-column>
      <el-table-column
        prop="priority"
        label="身份"
        width="150">
      </el-table-column>
      <el-table-column
        prop="amount"
        label="余额"
        width="150">
      </el-table-column>
    </el-table>
    </div>
    
  </template>

  <script>
    export default {
        name: "adminpage",
      data() {
        return {
          users: [],
        };
      },
      created(){
        this.$axios.get('/ATM/admin/users').then((res) => {
    
        console.log(res.data);
        this.users = res.data.data
        
      })

    },
}
  </script>


<style scoped>
.block {
  margin: 0 auto;
  margin-top: 50px;
  height: auto;
  width: 750px;
  border-radius: 6px;
  background-color: rgba(255, 255, 255, 0.7);
  padding: 50px;
}
</style>