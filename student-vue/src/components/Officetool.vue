<template>
  <el-main>
    <el-form :inline="true" :model="queryForm" class="demo-form-inline">
      <el-form-item label="名称">
        <el-input v-model="queryForm.name"></el-input>
      </el-form-item><br>
      <el-form-item label="描述">
        <el-input v-model="queryForm.description"></el-input>
      </el-form-item><br>
      <el-form-item label="采购日期">
        <div class="block">
          <el-date-picker
            v-model="queryForm.startDt"
            type="date"
            placeholder="选择日期"  dataformatas="yyyy-MM-dd">
          </el-date-picker>
        </div>
      </el-form-item><h6>至</h6>
      <el-form-item label="采购日期" >
        <div class="block">
          <el-date-picker
            v-model="queryForm.endDt"
            type="date"
            placeholder="选择日期" dataformatas="yyyy-MM-dd">
          </el-date-picker>
        </div>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>
  <el-table
    ref="multipleTable"
    :data="tableData"
    tooltip-effect="dark"
    style="width: 100%"
    @selection-change="handleSelectionChange">
    <el-table-column
      type="selection"
      width="55">
    </el-table-column>
    <el-table-column
      prop="name"
      label="办公用品名称"
      width="100">
    </el-table-column>
    <el-table-column
      prop="description"
      label="描述"
      width="100">
    </el-table-column>
    <el-table-column
      label="采购日期"
      prop="dt"
      width="100">
<!--      <template slot-scope="scope">{{scope.row.date}}</template>-->
    </el-table-column>
    <el-table-column
      prop="price"
      label="单价"
      width="100">
    </el-table-column>
    <el-table-column
      prop="num"
      label="数量"
      width="100">
    </el-table-column>
    <el-table-column
      prop="username"
      label="采购人"
      width="100">
    </el-table-column>
    <el-table-column
      prop="supplier"
      label="供应商"
      width="100">
    </el-table-column>
    <el-table-column
      prop="tname"
      label="分类名称"
      width="100">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="100">
      <template slot-scope="scope">
        <el-button @click="del(scope.row.id)" type="primary" size="small">删除</el-button>
        <el-button @click="update(scope.row.id)" type="primary" size="small">编辑</el-button>
      </template>
    </el-table-column>

  </el-table>
    <el-button type="primary" @click="add">添加</el-button>
    <el-button type="primary" @click="delAll">删除</el-button>
    <!-- 分页开始-->
    <el-pagination
      layout="prev, pager, next"
      @current-change="getPage"
      :page-count="pages">
    </el-pagination>
    <!-- 分页结束-->
    <el-dialog
      title="添加/编辑"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <span>
        <el-form ref="form" :model="saveForm" label-width="80px">
  <el-form-item label="名称">
    <el-input v-model="saveForm.name"></el-input>
  </el-form-item>
  <el-form-item label="采购日期">
    <div>
    <el-date-picker
      v-model="saveForm.dt"
      type="date"
      placeholder="选择日期" value-format="yyyy-MM-dd">
    </el-date-picker>
  </div>

  </el-form-item>
          <el-form-item label="数量">
    <el-input v-model="saveForm.num"></el-input>
  </el-form-item>
          <el-form-item label="供应商">
    <el-input v-model="saveForm.supplier"></el-input>
  </el-form-item>
          <el-form-item label="描述">
    <el-input v-model="saveForm.description"></el-input>
  </el-form-item>
          <el-form-item label="单价">
    <el-input v-model="saveForm.price"></el-input>
  </el-form-item>
          <el-form-item label="采购人">
    <el-input v-model="saveForm.username"></el-input>
  </el-form-item>
          <el-form-item label="分类">
   <template>
  <el-select v-model="saveForm.typeid" placeholder="请选择">
    <el-option
      v-for="item in typeList"
      :key="item.id"
      :label="item.tname"
      :value="item.id">
    </el-option>
  </el-select>
</template>
  </el-form-item>
      </el-form>
      </span>
      <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="save">确 定</el-button>
  </span>
    </el-dialog>
  </el-main>
</template>

<script>
  const axios = require("axios");
  const path="http://127.0.0.1/";
    export default {
        name: "Officetool",
        data() {
            return {
                tableData: [],
                multipleSelection: [],
                pages:0,
                queryForm:{
                    pageNo:1,
                    pageSize:5,
                },
                dialogVisible:false,
                saveForm:{},
                typeList:[],
                ids:null,
            }
        },

        methods: {
            delAll(){
                let self = this ;
                let ids = this.ids;
                if (ids==null){
                    this.$message("请选择删除的记录")
                    return;
                }
                this.$confirm('你确认要删除吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios({
                        url:path+"off/deleteById",
                        method:"get",
                        params:{ids:this.ids}
                    }).then(res=>{
                        self.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                        self.queryForm.pageNo=1;
                        self.getList();
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });



            },
            /* 添加开始*/
            save(){
                const self = this ;
                if (!Number.isInteger(new Number(this.saveForm.num).valueOf())){
                    this.$message("输入必须是数字");
                    return;
                }
                axios({
                    url:path+"off/insert",
                    method:"post",
                    data:this.saveForm
                }).then(res=>{
                    self.$message("添加成功！！！");
                    self.dialogVisible=false;
                    self.getList();
                })
            },
           /* 添加结束*/
            add(){
                this.dialogVisible=true;
                this.saveForm={};

            },
            /* 列表开始*/
            getList(){
              const self = this;
              axios({
                  url:path+"off/list",
                  method:"get",
                  params:this.queryForm
              }).then(res=>{
                  self.tableData = res.data.list;
                  self.pages = res.data.pages;
              } )
            },
            /* 列表结束*/

            /* 分页开始*/
            getPage(pageNo){
                this.queryForm.pageNo = pageNo;
                this.getList();
            },
            /* 分页结束*/

            /* 查询开始*/
            onSubmit(){
                this.queryForm.pageNo = 1;
              this.getList();
            },
            /* 查询结束*/

            /* 删除开始*/
            del(id){
                const self = this;
                axios({
                    url: path+"off/deleteById",
                    method:"get",
                    params:{ids:id}
                }).then(res=> {
                    this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消删除'
                        });
                    })
                    self.getList();
                })
            },
            /* 删除结束*/

            /* 修改开始*/
            update(id){
                const self = this;
                this.dialogVisible=true;
                axios({
                    url:path+"off/getById",
                    method:"get",
                    params:{id:id}
                }).then(res=>{
                    self.saveForm = res.data;
                    self.getList();
                })
            },
            /* 修改结束*/
            toggleSelection(rows) {
                if (rows) {
                    rows.forEach(row => {
                        this.$refs.multipleTable.toggleRowSelection(row);
                    });
                } else {
                    this.$refs.multipleTable.clearSelection();
                }
            },
            handleSelectionChange(rows) {
                let ids = null;
                rows.forEach(row =>{
                    if (ids==null){
                        ids = row.id;
                    }else{
                        ids =ids+","+row.id;
                    }
                })
                this.ids = ids;
                console.log(ids)
            },
            handleClose(done) {
                this.$confirm('确认关闭？')
                    .then(_ => {
                        done();
                    })
                    .catch(_ => {});
            }

        },
        //初始化
        created() {
            this.getList();
            const self = this;
            axios({
                url:path+"off/selectList",
                method:"get",
            }).then(res=>{
               self.typeList = res.data;
            })

        }
    }
</script>

<style scoped>

</style>
