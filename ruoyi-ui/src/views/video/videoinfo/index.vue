<template>
  <div class="app-container">
<!--    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">-->
<!--      <el-form-item label="视频名称" prop="videoName">-->
<!--        <el-input-->
<!--          v-model="queryParams.videoName"-->
<!--          placeholder="请输入视频名称"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="设备序列号" prop="deviceSerial">-->
<!--        <el-input-->
<!--          v-model="queryParams.deviceSerial"-->
<!--          placeholder="请输入设备序列号"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="通道号" prop="channelNo">-->
<!--        <el-input-->
<!--          v-model="queryParams.channelNo"-->
<!--          placeholder="请输入通道号"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item>-->
<!--        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>-->
<!--        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>-->
<!--      </el-form-item>-->
<!--    </el-form>-->

<!--    <el-row :gutter="10" class="mb8">-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="primary"-->
<!--          plain-->
<!--          icon="el-icon-plus"-->
<!--          size="mini"-->
<!--          @click="handleAdd"-->
<!--          v-hasPermi="['video:videoinfo:add']"-->
<!--        >新增</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="success"-->
<!--          plain-->
<!--          icon="el-icon-edit"-->
<!--          size="mini"-->
<!--          :disabled="single"-->
<!--          @click="handleUpdate"-->
<!--          v-hasPermi="['video:videoinfo:edit']"-->
<!--        >修改</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="danger"-->
<!--          plain-->
<!--          icon="el-icon-delete"-->
<!--          size="mini"-->
<!--          :disabled="multiple"-->
<!--          @click="handleDelete"-->
<!--          v-hasPermi="['video:videoinfo:remove']"-->
<!--        >删除</el-button>-->
<!--      </el-col>-->
<!--      <el-col :span="1.5">-->
<!--        <el-button-->
<!--          type="warning"-->
<!--          plain-->
<!--          icon="el-icon-download"-->
<!--          size="mini"-->
<!--          @click="handleExport"-->
<!--          v-hasPermi="['video:videoinfo:export']"-->
<!--        >导出</el-button>-->
<!--      </el-col>-->
<!--      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>-->
<!--    </el-row>-->
    <el-container style="height: 850px; border: 1px solid #eee">
    <el-aside width="20%" style="background-color: rgb(238, 241, 246)">
      <el-menu :default-openeds="['0']" default-active="0">

        <el-menu-item @click="changeVideo(item.channelNo)" v-for="(item,i) in this.dataList"
                      :index="i.toString()">{{item.videoName}}
        </el-menu-item>
      </el-menu>
    </el-aside>

    <el-container style="width: 79%">
      <el-main>
        <iframe :src="videoUrl"
                width="99%"
                height="830px"
                id="ysopen"
                allowfullscreen
        >
        </iframe>
      </el-main>
    </el-container>
    </el-container>

    <el-table v-loading="loading" :data="videoinfoList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="视频名称" align="center" prop="videoName" />
      <el-table-column label="设备序列号" align="center" prop="deviceSerial" />
      <el-table-column label="通道号" align="center" prop="channelNo" />
      <el-table-column label="验证码" align="center" prop="vilidCode" />
<!--      <el-table-column label="访问令牌" align="center" prop="accessToken" />-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['video:videoinfo:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['video:videoinfo:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改视频监控信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="主键" prop="id">
          <el-input v-model="form.id" placeholder="请输入主键" />
        </el-form-item>
        <el-form-item label="视频名称" prop="videoName">
          <el-input v-model="form.videoName" placeholder="请输入视频名称" />
        </el-form-item>
        <el-form-item label="设备序列号" prop="deviceSerial">
          <el-input v-model="form.deviceSerial" placeholder="请输入设备序列号" />
        </el-form-item>
        <el-form-item label="通道号" prop="channelNo">
          <el-input v-model="form.channelNo" placeholder="请输入通道号" />
        </el-form-item>
        <el-form-item label="验证码" prop="vilidCode">
          <el-input v-model="form.vilidCode" placeholder="请输入验证码" />
        </el-form-item>
        <el-form-item label="访问令牌" prop="accessToken">
          <el-input v-model="form.accessToken" placeholder="请输入访问令牌" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listVideoinfo, getVideoinfo, delVideoinfo, addVideoinfo, updateVideoinfo } from "@/api/video/videoinfo";
import axios from 'axios'
import qs from 'qs'
export default {
  name: "Videoinfo",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 视频监控信息表格数据
      videoinfoList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        videoName: null,
        deviceSerial: null,
        channelNo: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      dataList: [],
      videoUrl: '',
      accessToken:'',//at.1x4a2uvf2uk6sklq2znp97va5goxktcm-54w28tj34d-1sysifv-lmd8zgz5q
      appKey: '9a7d8e7ef02a4d3a8c58addf966398f5',
      appSecret: '18099467c55168a9b9062d5711c96c07'
    };
  },
  created() {
    this.getList();
    this.initData()
  },
  methods: {
    /** 查询视频监控信息列表 */
    getList() {
      this.loading = true;
      listVideoinfo(this.queryParams).then(response => {
        this.videoinfoList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    async initData(){
      await this.getAccessToken()
      this.getDataList()
    },
    getDataList() {
      this.videoUrl = 'https://open.ys7.com/ezopen/h5/iframe_se?url=ezopen://MGYIFN@open.ys7.com/E18614501/1.live&autoplay=0&accessToken='+this.accessToken+'&templete=2'
      list().then((data) => {
        this.dataList = data
      }).catch((err) => {
        // util.$message.showInfo2(err)
      })
    },
    //切换通道
    changeVideo(channelNo) {
      this.videoUrl = 'https://open.ys7.com/ezopen/h5/iframe_se?url=ezopen://MGYIFN@open.ys7.com/E18614501/' +
        channelNo + '.live&autoplay=0&accessToken='+ this.accessToken+'&templete=2'
    },
    async getAccessToken(){
      let accessTokenUrl='http://open.ys7.com/api/lapp/token/get'
      let params={
        appKey: this.appKey,
        appSecret: this.appSecret
      }
      if (!this.Cookies.get('accessToken')) {
        await axios.post(accessTokenUrl,qs.stringify(params))
          .then(({data}) => {
            if (data.code==='200'){
              this.accessToken=data.data.accessToken
              this.Cookies.set('accessToken',this.accessToken, {
                expires: 6,
              })
            }
          })
          .catch(err => {
            console.log(err);
          });
      }else {
        this.accessToken=this.Cookies.get('accessToken')
      }
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        videoName: null,
        deviceSerial: null,
        channelNo: null,
        vilidCode: null,
        accessToken: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加视频监控信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getVideoinfo(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改视频监控信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateVideoinfo(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addVideoinfo(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除视频监控信息编号为"' + ids + '"的数据项？').then(function() {
        return delVideoinfo(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('video/videoinfo/export', {
        ...this.queryParams
      }, `videoinfo_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
<style>
.el-header {
  background-color: #B3C0D1;
  color: #606266;
  line-height: 60px;
}

.el-aside {
  color: #606266;
}

.el-main {
  padding: 0px;
}
</style>
