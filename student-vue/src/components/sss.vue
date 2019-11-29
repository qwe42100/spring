<template>
    <div id="add">
      <div v-for="(d,index) in counter" :key="index" >
        <input type="text" aria-placeholder="请输入内容"/>
      </div>
      <el-main type="primary" @click="add">主要按钮</el-main>
    </div>
</template>

<script>
    export default {
        name: "sss",
        el:'#app',
        data(){
            return{
                counter:[]
            }
        },
        methods:{
            add(){
                this.counter.push({})
            }
        }
    }
</script>

<style scoped>

</style>
