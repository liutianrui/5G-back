<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="拌合站编号" prop="mixingStationCode">
        <el-input
          v-model="queryParams.mixingStationCode"
          placeholder="请输入拌合站编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="设备编号" prop="equipmentNumber">
        <el-input
          v-model="queryParams.equipmentNumber"
          placeholder="请输入设备编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="搅拌机名称" prop="mixingMachineName">
        <el-input
          v-model="queryParams.mixingMachineName"
          placeholder="请输入搅拌机名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="施工地点" prop="constructionSite">
        <el-input
          v-model="queryParams.constructionSite"
          placeholder="请输入施工地点"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出料时间" prop="dischargingTime">
        <el-date-picker clearable
          v-model="queryParams.dischargingTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择出料时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="采集时间" prop="gatheringTime">
        <el-date-picker clearable
          v-model="queryParams.gatheringTime"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择采集时间">
        </el-date-picker>
      </el-form-item>
<!--      <el-form-item label="批次重量 每批次料的总重/吨" prop="batchWeight">-->
<!--        <el-input-->
<!--          v-model="queryParams.batchWeight"-->
<!--          placeholder="请输入批次重量 每批次料的总重/吨"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['cementstabilized:macadam:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['cementstabilized:macadam:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['cementstabilized:macadam:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['cementstabilized:macadam:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <div id="lineEcharts" style="height: 280px;"></div>


    <el-table v-loading="loading" :data="macadamList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
<!--      <el-table-column label="${comment}" align="center" prop="id" />-->
      <el-table-column label="拌合站编号" align="center" prop="mixingStationCode" />
      <el-table-column label="设备编号" align="center" prop="equipmentNumber" />
      <el-table-column label="搅拌机名称" align="center" prop="mixingMachineName" />
<!--      <el-table-column label="施工地点" align="center" prop="constructionSite" />-->
      <el-table-column label="出料时间" align="center" prop="dischargingTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.dischargingTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="采集时间" align="center" prop="gatheringTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.gatheringTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="任务单" align="center" prop="taskNo" />
      <el-table-column label="批次重量 每批次料的总重/吨" align="center" prop="batchWeight" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['cementstabilized:macadam:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['cementstabilized:macadam:remove']"
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

    <!-- 添加或修改水泥稳定碎石集料对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目ID " prop="organizationId">
          <el-input v-model="form.organizationId" placeholder="请输入项目ID " />
        </el-form-item>
        <el-form-item label="标段ID" prop="sectionId">
          <el-input v-model="form.sectionId" placeholder="请输入标段ID" />
        </el-form-item>
        <el-form-item label="拌合站编号" prop="mixingStationCode">
          <el-input v-model="form.mixingStationCode" placeholder="请输入拌合站编号" />
        </el-form-item>
        <el-form-item label="设备编号" prop="equipmentNumber">
          <el-input v-model="form.equipmentNumber" placeholder="请输入设备编号" />
        </el-form-item>
        <el-form-item label="搅拌机名称" prop="mixingMachineName">
          <el-input v-model="form.mixingMachineName" placeholder="请输入搅拌机名称" />
        </el-form-item>
        <el-form-item label="数据编号" prop="dataNumber">
          <el-input v-model="form.dataNumber" placeholder="请输入数据编号" />
        </el-form-item>
        <el-form-item label="工程名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入工程名称" />
        </el-form-item>
        <el-form-item label="施工地点" prop="constructionSite">
          <el-input v-model="form.constructionSite" placeholder="请输入施工地点" />
        </el-form-item>
        <el-form-item label="出料时间" prop="dischargingTime">
          <el-date-picker clearable
            v-model="form.dischargingTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择出料时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="采集时间" prop="gatheringTime">
          <el-date-picker clearable
            v-model="form.gatheringTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择采集时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="上传时间" prop="uploadTime">
          <el-date-picker clearable
            v-model="form.uploadTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择上传时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="${comment}" prop="proportionCode">
          <el-input v-model="form.proportionCode" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="超标等级" prop="excessState">
          <el-input v-model="form.excessState" placeholder="请输入超标等级" />
        </el-form-item>
        <el-form-item label="任务单" prop="taskNo">
          <el-input v-model="form.taskNo" placeholder="请输入任务单" />
        </el-form-item>
        <el-form-item label="批次重量 每批次料的总重/吨" prop="batchWeight">
          <el-input v-model="form.batchWeight" placeholder="请输入批次重量 每批次料的总重/吨" />
        </el-form-item>
        <el-form-item label="料1实际用量" prop="materialYield1">
          <el-input v-model="form.materialYield1" placeholder="请输入料1实际用量" />
        </el-form-item>
        <el-form-item label="料2实际用量" prop="materialYield2">
          <el-input v-model="form.materialYield2" placeholder="请输入料2实际用量" />
        </el-form-item>
        <el-form-item label="料3实际用量" prop="materialYield3">
          <el-input v-model="form.materialYield3" placeholder="请输入料3实际用量" />
        </el-form-item>
        <el-form-item label="料4实际用量" prop="materialYield4">
          <el-input v-model="form.materialYield4" placeholder="请输入料4实际用量" />
        </el-form-item>
        <el-form-item label="料5实际用量" prop="materialYield5">
          <el-input v-model="form.materialYield5" placeholder="请输入料5实际用量" />
        </el-form-item>
        <el-form-item label="料6实际用量" prop="materialYield6">
          <el-input v-model="form.materialYield6" placeholder="请输入料6实际用量" />
        </el-form-item>
        <el-form-item label="料7实际用量" prop="materialYield7">
          <el-input v-model="form.materialYield7" placeholder="请输入料7实际用量" />
        </el-form-item>
        <el-form-item label="料8实际用量" prop="materialYield8">
          <el-input v-model="form.materialYield8" placeholder="请输入料8实际用量" />
        </el-form-item>
        <el-form-item label="料9实际用量" prop="materialYield9">
          <el-input v-model="form.materialYield9" placeholder="请输入料9实际用量" />
        </el-form-item>
        <el-form-item label="料1给定" prop="materialGiven1">
          <el-input v-model="form.materialGiven1" placeholder="请输入料1给定" />
        </el-form-item>
        <el-form-item label="料2给定" prop="materialGiven2">
          <el-input v-model="form.materialGiven2" placeholder="请输入料2给定" />
        </el-form-item>
        <el-form-item label="料3给定" prop="materialGiven3">
          <el-input v-model="form.materialGiven3" placeholder="请输入料3给定" />
        </el-form-item>
        <el-form-item label="料4给定" prop="materialGiven4">
          <el-input v-model="form.materialGiven4" placeholder="请输入料4给定" />
        </el-form-item>
        <el-form-item label="料5给定" prop="materialGiven5">
          <el-input v-model="form.materialGiven5" placeholder="请输入料5给定" />
        </el-form-item>
        <el-form-item label="料6给定" prop="materialGiven6">
          <el-input v-model="form.materialGiven6" placeholder="请输入料6给定" />
        </el-form-item>
        <el-form-item label="料7给定" prop="materialGiven7">
          <el-input v-model="form.materialGiven7" placeholder="请输入料7给定" />
        </el-form-item>
        <el-form-item label="料8给定" prop="materialGiven8">
          <el-input v-model="form.materialGiven8" placeholder="请输入料8给定" />
        </el-form-item>
        <el-form-item label="料9给定" prop="materialGiven9">
          <el-input v-model="form.materialGiven9" placeholder="请输入料9给定" />
        </el-form-item>
        <el-form-item label="料1流量" prop="materialFlow1">
          <el-input v-model="form.materialFlow1" placeholder="请输入料1流量" />
        </el-form-item>
        <el-form-item label="料2流量" prop="materialFlow2">
          <el-input v-model="form.materialFlow2" placeholder="请输入料2流量" />
        </el-form-item>
        <el-form-item label="料3流量" prop="materialFlow3">
          <el-input v-model="form.materialFlow3" placeholder="请输入料3流量" />
        </el-form-item>
        <el-form-item label="料4流量" prop="materialFlow4">
          <el-input v-model="form.materialFlow4" placeholder="请输入料4流量" />
        </el-form-item>
        <el-form-item label="料5流量" prop="materialFlow5">
          <el-input v-model="form.materialFlow5" placeholder="请输入料5流量" />
        </el-form-item>
        <el-form-item label="料6流量" prop="materialFlow6">
          <el-input v-model="form.materialFlow6" placeholder="请输入料6流量" />
        </el-form-item>
        <el-form-item label="料7流量" prop="materialFlow7">
          <el-input v-model="form.materialFlow7" placeholder="请输入料7流量" />
        </el-form-item>
        <el-form-item label="料8流量" prop="materialFlow8">
          <el-input v-model="form.materialFlow8" placeholder="请输入料8流量" />
        </el-form-item>
        <el-form-item label="料9流量" prop="materialFlow9">
          <el-input v-model="form.materialFlow9" placeholder="请输入料9流量" />
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
import { listMacadam, getMacadam, delMacadam, addMacadam, updateMacadam, getEchartData } from "@/api/cementstabilized/macadam";
import * as echarts from 'echarts';

export default {
  name: "Macadam",
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
      // 水泥稳定碎石集料表格数据
      macadamList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        mixingStationCode: null,
        equipmentNumber: null,
        mixingMachineName: null,
        constructionSite: null,
        dischargingTime: null,
        gatheringTime: null,
        batchWeight: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        organizationId: [
          { required: true, message: "项目ID 不能为空", trigger: "blur" }
        ],
        sectionId: [
          { required: true, message: "标段ID不能为空", trigger: "blur" }
        ],
        mixingStationCode: [
          { required: true, message: "拌合站编号不能为空", trigger: "blur" }
        ],
        equipmentNumber: [
          { required: true, message: "设备编号不能为空", trigger: "blur" }
        ],
        mixingMachineName: [
          { required: true, message: "搅拌机名称不能为空", trigger: "blur" }
        ],
        dataNumber: [
          { required: true, message: "数据编号不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询水泥稳定碎石集料列表 */
    getList() {
      this.getEchartData()

      this.loading = true;
      listMacadam(this.queryParams).then(response => {
        this.macadamList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getEchartData(){
      getEchartData(this.queryParams).then((data)=>{
        this.initLineEchart(data)
      })
    },
    initLineEchart(data){
      let xAxisData=[]
      let yAxisData=[]
      for (let item of data.data){
        xAxisData.push(item.dischargingTime)
        yAxisData.push(item.batchWeight)
      }
      let lineEcharts = echarts.init(document.getElementById('lineEcharts'))
      let option = {
        title: {
          // text: '未来一周气温变化',
          // subtext: '纯属虚构'
        },
        tooltip: {
          trigger: 'axis'
        },
        toolbox: {
          show: true,
          feature: {
            //magicType: {type: ['line', 'bar']}
          }
        },
        grid: {
          left: '3%',
          right: '5%',
          bottom: '5%',
          containLabel: true
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: xAxisData
        },
        yAxis: {
          type: 'value',
          name:'吨',
          axisLabel: {
            formatter: '{value}'
          }
        },
        series: [
          {
            name: '水稳物料总重',
            type: 'line',
            data: yAxisData,
            markPoint: {
              data: [
                {type: 'max', name: '最大值'},
                {type: 'min', name: '最小值'}
              ]
            },
            markLine: {
              data: [
                {type: 'average', name: '平均值'}
              ]
            },
            itemStyle:{
              normal:{
                color:'#409EFF',
                borderColor:'#409EFF',  //拐点边框颜色
              }
            }
          }
        ]
      };

      lineEcharts.setOption(option)
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
        organizationId: null,
        sectionId: null,
        mixingStationCode: null,
        equipmentNumber: null,
        mixingMachineName: null,
        dataNumber: null,
        projectName: null,
        constructionSite: null,
        dischargingTime: null,
        gatheringTime: null,
        uploadTime: null,
        proportionCode: null,
        excessState: null,
        taskNo: null,
        batchWeight: null,
        materialYield1: null,
        materialYield2: null,
        materialYield3: null,
        materialYield4: null,
        materialYield5: null,
        materialYield6: null,
        materialYield7: null,
        materialYield8: null,
        materialYield9: null,
        materialGiven1: null,
        materialGiven2: null,
        materialGiven3: null,
        materialGiven4: null,
        materialGiven5: null,
        materialGiven6: null,
        materialGiven7: null,
        materialGiven8: null,
        materialGiven9: null,
        materialFlow1: null,
        materialFlow2: null,
        materialFlow3: null,
        materialFlow4: null,
        materialFlow5: null,
        materialFlow6: null,
        materialFlow7: null,
        materialFlow8: null,
        materialFlow9: null,
        insertTime: null,
        isDeleted: null
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
      this.title = "添加水泥稳定碎石集料";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMacadam(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改水泥稳定碎石集料";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMacadam(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMacadam(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除水泥稳定碎石集料编号为"' + ids + '"的数据项？').then(function() {
        return delMacadam(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('cementstabilized/macadam/export', {
        ...this.queryParams
      }, `macadam_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
