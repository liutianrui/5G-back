<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
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
          v-hasPermi="['asphalt:asphalt_concrete_collection:add']"
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
          v-hasPermi="['asphalt:asphalt_concrete_collection:edit']"
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
          v-hasPermi="['asphalt:asphalt_concrete_collection:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['asphalt:asphalt_concrete_collection:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <div id="barEcharts" style="height: 260px;"></div>

    <el-table v-loading="loading" :data="asphalt_concrete_collectionList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="数据ID" align="center" prop="id" />
      <el-table-column label="拌合站编号" align="center" prop="mixingStationCode" />
      <el-table-column label="设备编号" align="center" prop="equipmentNumber" />
      <el-table-column label="搅拌机名称" align="center" prop="mixingMachineName" />
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
      <el-table-column label="搅拌时长" align="center" prop="mixingDuration" />
      <el-table-column label="出料温度" align="center" prop="temperature" />
      <el-table-column label="油石比实际值" align="center" prop="asphaltAggregateRatioAct" />
      <el-table-column label="施工沥青用量" align="center" prop="asphaltAct" />
      <el-table-column label="矿粉百分比" align="center" prop="slagPowderActPct" />
      <el-table-column label="水泥百分比" align="center" prop="cement1ActPct" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['asphalt:asphalt_concrete_collection:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['asphalt:asphalt_concrete_collection:remove']"
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

    <!-- 添加或修改沥青混凝土收集对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目ID" prop="organizationId">
          <el-input v-model="form.organizationId" placeholder="请输入项目ID" />
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
        <el-form-item label="任务单" prop="taskNo">
          <el-input v-model="form.taskNo" placeholder="请输入任务单" />
        </el-form-item>
        <el-form-item label="盘重" prop="batchWeight">
          <el-input v-model="form.batchWeight" placeholder="请输入盘重" />
        </el-form-item>
        <el-form-item label="客户端编号" prop="clientNumber">
          <el-input v-model="form.clientNumber" placeholder="请输入客户端编号" />
        </el-form-item>
        <el-form-item label="使用部位,沥青混凝土的使用层位：1-上面层2-中面层3-下面层" prop="layerPosition">
          <el-input v-model="form.layerPosition" placeholder="请输入使用部位,沥青混凝土的使用层位：1-上面层2-中面层3-下面层" />
        </el-form-item>
        <el-form-item label="搅拌时长" prop="mixingDuration">
          <el-input v-model="form.mixingDuration" placeholder="请输入搅拌时长" />
        </el-form-item>
        <el-form-item label="出料温度" prop="temperature">
          <el-input v-model="form.temperature" placeholder="请输入出料温度" />
        </el-form-item>
        <el-form-item label="油石比实际值" prop="asphaltAggregateRatioAct">
          <el-input v-model="form.asphaltAggregateRatioAct" placeholder="请输入油石比实际值" />
        </el-form-item>
        <el-form-item label="施工沥青用量" prop="asphaltAct">
          <el-input v-model="form.asphaltAct" placeholder="请输入施工沥青用量" />
        </el-form-item>
        <el-form-item label="骨料1实际" prop="sand1Act">
          <el-input v-model="form.sand1Act" placeholder="请输入骨料1实际" />
        </el-form-item>
        <el-form-item label="骨料2实际" prop="sand2Act">
          <el-input v-model="form.sand2Act" placeholder="请输入骨料2实际" />
        </el-form-item>
        <el-form-item label="骨料3实际" prop="gravel1Act">
          <el-input v-model="form.gravel1Act" placeholder="请输入骨料3实际" />
        </el-form-item>
        <el-form-item label="骨料4实际" prop="gravel2Act">
          <el-input v-model="form.gravel2Act" placeholder="请输入骨料4实际" />
        </el-form-item>
        <el-form-item label="骨料5实际" prop="gravel3Act">
          <el-input v-model="form.gravel3Act" placeholder="请输入骨料5实际" />
        </el-form-item>
        <el-form-item label="骨料6实际" prop="gravel4Act">
          <el-input v-model="form.gravel4Act" placeholder="请输入骨料6实际" />
        </el-form-item>
        <el-form-item label="水泥实际" prop="cement1Act">
          <el-input v-model="form.cement1Act" placeholder="请输入水泥实际" />
        </el-form-item>
        <el-form-item label="再生料实际" prop="recycledMaterialAct">
          <el-input v-model="form.recycledMaterialAct" placeholder="请输入再生料实际" />
        </el-form-item>
        <el-form-item label="矿粉实际" prop="slagPowderAct">
          <el-input v-model="form.slagPowderAct" placeholder="请输入矿粉实际" />
        </el-form-item>
        <el-form-item label="油石比理论值" prop="asphaltAggregateRatioTheo">
          <el-input v-model="form.asphaltAggregateRatioTheo" placeholder="请输入油石比理论值" />
        </el-form-item>
        <el-form-item label="沥青目标" prop="asphaltTheo">
          <el-input v-model="form.asphaltTheo" placeholder="请输入沥青目标" />
        </el-form-item>
        <el-form-item label="骨料1目标" prop="sand1Theo">
          <el-input v-model="form.sand1Theo" placeholder="请输入骨料1目标" />
        </el-form-item>
        <el-form-item label="骨料2目标" prop="sand2Theo">
          <el-input v-model="form.sand2Theo" placeholder="请输入骨料2目标" />
        </el-form-item>
        <el-form-item label="骨料3目标" prop="gravel1Theo">
          <el-input v-model="form.gravel1Theo" placeholder="请输入骨料3目标" />
        </el-form-item>
        <el-form-item label="骨料4目标" prop="gravel2Theo">
          <el-input v-model="form.gravel2Theo" placeholder="请输入骨料4目标" />
        </el-form-item>
        <el-form-item label="骨料5目标" prop="gravel3Theo">
          <el-input v-model="form.gravel3Theo" placeholder="请输入骨料5目标" />
        </el-form-item>
        <el-form-item label="骨料6目标" prop="gravel4Theo">
          <el-input v-model="form.gravel4Theo" placeholder="请输入骨料6目标" />
        </el-form-item>
        <el-form-item label="矿粉目标" prop="slagPowderTheo">
          <el-input v-model="form.slagPowderTheo" placeholder="请输入矿粉目标" />
        </el-form-item>
        <el-form-item label="水泥目标" prop="cement1Theo">
          <el-input v-model="form.cement1Theo" placeholder="请输入水泥目标" />
        </el-form-item>
        <el-form-item label="再生料 目标" prop="recycledMaterialTheo">
          <el-input v-model="form.recycledMaterialTheo" placeholder="请输入再生料 目标" />
        </el-form-item>
        <el-form-item label="骨料1实际值的百分比" prop="sand1ActPct">
          <el-input v-model="form.sand1ActPct" placeholder="请输入骨料1实际值的百分比" />
        </el-form-item>
        <el-form-item label="骨料2实际值的百分比" prop="sand2ActPct">
          <el-input v-model="form.sand2ActPct" placeholder="请输入骨料2实际值的百分比" />
        </el-form-item>
        <el-form-item label="骨料3实际值的百分比" prop="gravel1ActPct">
          <el-input v-model="form.gravel1ActPct" placeholder="请输入骨料3实际值的百分比" />
        </el-form-item>
        <el-form-item label="骨料4实际值的百分比" prop="gravel2ActPct">
          <el-input v-model="form.gravel2ActPct" placeholder="请输入骨料4实际值的百分比" />
        </el-form-item>
        <el-form-item label="骨料5实际值的百分比" prop="gravel3ActPct">
          <el-input v-model="form.gravel3ActPct" placeholder="请输入骨料5实际值的百分比" />
        </el-form-item>
        <el-form-item label="骨料6实际值的百分比" prop="gravel4ActPct">
          <el-input v-model="form.gravel4ActPct" placeholder="请输入骨料6实际值的百分比" />
        </el-form-item>
        <el-form-item label="矿粉百分比" prop="slagPowderActPct">
          <el-input v-model="form.slagPowderActPct" placeholder="请输入矿粉百分比" />
        </el-form-item>
        <el-form-item label="水泥百分比" prop="cement1ActPct">
          <el-input v-model="form.cement1ActPct" placeholder="请输入水泥百分比" />
        </el-form-item>
        <el-form-item label="再生料百分比" prop="recycledMaterialActPct">
          <el-input v-model="form.recycledMaterialActPct" placeholder="请输入再生料百分比" />
        </el-form-item>
        <el-form-item label="${comment}" prop="insertDate">
          <el-date-picker clearable
            v-model="form.insertDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择${comment}">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="删除标识(0,未删除,1.已删除)" prop="isDeleted">
          <el-input v-model="form.isDeleted" placeholder="请输入删除标识(0,未删除,1.已删除)" />
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
import { listAsphalt_concrete_collection, getAsphalt_concrete_collection, delAsphalt_concrete_collection, addAsphalt_concrete_collection, updateAsphalt_concrete_collection,getEchartData } from "@/api/asphalt/asphalt_concrete_collection";
import * as echarts from 'echarts';
export default {
  name: "Asphalt_concrete_collection",
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
      // 沥青混凝土收集表格数据
      asphalt_concrete_collectionList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        equipmentNumber: null,
        mixingMachineName: null,
        dischargingTime: null,
        gatheringTime: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  mounted () {
    this.getList()
  },
  methods: {
    /** 查询沥青混凝土收集列表 */
    getList() {
      this.getEchartData()
      this.loading = true;
      listAsphalt_concrete_collection(this.queryParams).then(response => {
        this.asphalt_concrete_collectionList = response.rows;
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
      let legendDataTemp=[
        {name: '沥青', key: 'asphaltAct'},
        {name: '碎石(0-3)', key: 'sand1Act'},
        {name: '碎石(3-6)', key: 'sand2Act'},
        {name: '碎石(6-11)', key: 'gravel1Act'},
        {name: '碎石(11-16)', key: 'gravel2Act'},
        {name: '碎石(16-22)', key: 'gravel3Act'},
        {name: '碎石(22-32)', key: 'gravel4Act'},
        {name: '水泥', key: 'cement1Act'},
        {name: '再生料', key: 'recycledMaterialAct'},
        {name: '矿粉', key: 'slagPowderAct'}
      ]
      let legendData=[]
      let xAxisData=[]
      let yAxisDataTemp={
        gravel1Act: [],
        sand1Act: [],
        sand2Act: [],
        asphaltAct: [],
        cement1Act: [],
        gravel3Act: [],
        gravel2Act: [],
        gravel4Act: [],
        recycledMaterialAct: [],
        slagPowderAct: []
      }
      //asphaltAct:沥青 sand1Act:碎石(0-3) sand2Act:碎石(3-6) gravel1Act:碎石(6-11)  gravel2Act:碎石(11-16) gravel3Act:碎石(16-22)  gravel4Act:碎石(22-32) cement1Act:水泥  recycledMaterialAct:再生料 slagPowderAct:矿粉
      for (let item of data.data){
        xAxisData.push(item.dischargingTime)
        yAxisDataTemp.gravel1Act.push(item.gravel1Act)
        yAxisDataTemp.sand1Act.push(item.sand1Act)
        yAxisDataTemp.sand2Act.push(item.sand2Act)
        yAxisDataTemp.asphaltAct.push(item.asphaltAct)
        yAxisDataTemp.cement1Act.push(item.cement1Act)
        yAxisDataTemp.gravel3Act.push(item.gravel3Act)
        yAxisDataTemp.gravel2Act.push(item.gravel2Act)
        yAxisDataTemp.gravel4Act.push(item.gravel4Act)
        yAxisDataTemp.recycledMaterialAct.push(item.recycledMaterialAct)
        yAxisDataTemp.slagPowderAct.push(item.slagPowderAct)
      }
      let yAxisData=[]
      for(let item of legendDataTemp){
        legendData.push(item.name)
        yAxisData.push({
          name: item.name,
          type: 'bar',
          stack: '总量',
          barWidth: 30,
          data: yAxisDataTemp[item.key]
        })
      }
      let barEcharts = echarts.init(document.getElementById('barEcharts'))
      let option = {
        color: ['#4A79FF','#14D58A','#FFD264','#FF7683','#9F99FF','#56B5FF','#80EF98','#00DD00', '#5ED5D1', '#EEEE00', '#3FBB49', '#FF3333'],
        tooltip: {
          trigger: 'axis',
          axisPointer: {            // 坐标轴指示器，坐标轴触发有效
            type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
          }
        },
        legend: {
          data: legendData,
          orient: 'vertical',  //垂直显示
          y: 'center',    //延Y轴居中
          x: 'left' //居右显示
        },
        grid: {
          top: '28',
          left: '6%',
          right: '4%',
          bottom: '1%',
          containLabel: true
        },
        xAxis: [
          {
            type: 'category',
            data: xAxisData,
            axisLabel: {
              interval:0,
              rotate: 30
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '吨'
          }
        ],
        series: yAxisData
      };

      barEcharts.setOption(option)
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
        clientNumber: null,
        layerPosition: null,
        mixingDuration: null,
        temperature: null,
        asphaltAggregateRatioAct: null,
        asphaltAct: null,
        sand1Act: null,
        sand2Act: null,
        gravel1Act: null,
        gravel2Act: null,
        gravel3Act: null,
        gravel4Act: null,
        cement1Act: null,
        recycledMaterialAct: null,
        slagPowderAct: null,
        asphaltAggregateRatioTheo: null,
        asphaltTheo: null,
        sand1Theo: null,
        sand2Theo: null,
        gravel1Theo: null,
        gravel2Theo: null,
        gravel3Theo: null,
        gravel4Theo: null,
        slagPowderTheo: null,
        cement1Theo: null,
        recycledMaterialTheo: null,
        sand1ActPct: null,
        sand2ActPct: null,
        gravel1ActPct: null,
        gravel2ActPct: null,
        gravel3ActPct: null,
        gravel4ActPct: null,
        slagPowderActPct: null,
        cement1ActPct: null,
        recycledMaterialActPct: null,
        insertDate: null,
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
      this.title = "添加沥青混凝土收集";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getAsphalt_concrete_collection(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改沥青混凝土收集";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAsphalt_concrete_collection(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAsphalt_concrete_collection(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除沥青混凝土收集编号为"' + ids + '"的数据项？').then(function() {
        return delAsphalt_concrete_collection(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('asphalt/asphalt_concrete_collection/export', {
        ...this.queryParams
      }, `asphalt_concrete_collection_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
